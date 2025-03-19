package com.hospital.restful_generate.utils;

import org.reflections.Reflections;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

/**
 * 提取 Controller 方法参数及嵌套字段信息，并转换为 JSON 字符串的工具类
 */
public class ControllerParameterExtractor {

    /**
     * 扫描指定包下的 Controller，并提取其方法参数及嵌套字段信息
     *
     * @param baseControllerPackage 要扫描的 controller 包路径
     * @param projectBasePackage    项目包前缀，用于判断是否递归提取嵌套字段
     * @return List&lt;ControllerInfo&gt; 返回封装好的 Controller 信息集合
     */
    public static List<ControllerInfo> extractControllerParameters(String baseControllerPackage, String projectBasePackage) {
        List<ControllerInfo> controllerInfoList = new ArrayList<>();

        // 利用 Reflections 库扫描指定包下的类
        Reflections reflections = new Reflections(baseControllerPackage);

        // 获取所有被 @RestController 和 @Controller 注解的类
        Set<Class<?>> controllers = new HashSet<>();
        controllers.addAll(reflections.getTypesAnnotatedWith(RestController.class));
        controllers.addAll(reflections.getTypesAnnotatedWith(Controller.class));

        // 遍历每个 controller 类
        for (Class<?> controller : controllers) {
            // 只保留简单类名，例如 CHospitalbedsController
            ControllerInfo controllerInfo = new ControllerInfo(controller.getSimpleName());
            List<MethodInfo> methodInfoList = new ArrayList<>();

            // 遍历 controller 类中所有方法
            for (Method method : controller.getDeclaredMethods()) {
                MethodInfo methodInfo = new MethodInfo(method.getName());
                List<ParameterInfo> parameterInfoList = new ArrayList<>();

                // 遍历方法的参数
                for (Parameter parameter : method.getParameters()) {
                    // 使用 getSimpleName() 只保留简单类型名
                    ParameterInfo parameterInfo = new ParameterInfo(parameter.getName(), parameter.getType().getSimpleName());
                    // 如果参数类型属于项目包，则递归提取其内部字段信息
                    if (parameter.getType().getName().startsWith(projectBasePackage)) {
                        Set<Class<?>> visited = new HashSet<>();
                        List<FieldInfo> fieldInfos = extractNestedFields(parameter.getType(), projectBasePackage, visited);
                        parameterInfo.setFields(fieldInfos);
                    }
                    parameterInfoList.add(parameterInfo);
                }
                methodInfo.setParameters(parameterInfoList);
                methodInfoList.add(methodInfo);
            }
            controllerInfo.setMethods(methodInfoList);
            controllerInfoList.add(controllerInfo);
        }
        return controllerInfoList;
    }

    /**
     * 递归提取对象的字段信息
     *
     * @param clazz              当前要提取字段的类
     * @param projectBasePackage 项目包前缀，用于判断是否继续递归
     * @param visited            用于避免重复递归
     * @return List&lt;FieldInfo&gt; 返回当前类中所有字段的信息集合
     */
    private static List<FieldInfo> extractNestedFields(Class<?> clazz, String projectBasePackage, Set<Class<?>> visited) {
        List<FieldInfo> fieldInfos = new ArrayList<>();
        // 避免无限递归
        if (visited.contains(clazz)) {
            return fieldInfos;
        }
        visited.add(clazz);

        // 如果当前类不在项目包中，则停止递归
        if (!clazz.getName().startsWith(projectBasePackage)) {
            return fieldInfos;
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // 使用 getSimpleName() 只保留简单类名
            FieldInfo fieldInfo = new FieldInfo(field.getName(), field.getType().getSimpleName());
            // 对于非基本类型且非 Java 内置类，并且属于项目包的字段，继续递归提取
            if (!field.getType().isPrimitive() &&
                    !field.getType().getName().startsWith("java.") &&
                    field.getType().getName().startsWith(projectBasePackage)) {
                List<FieldInfo> nestedFields = extractNestedFields(field.getType(), projectBasePackage, visited);
                fieldInfo.setNestedFields(nestedFields);
            }
            fieldInfos.add(fieldInfo);
        }
        return fieldInfos;
    }

    // ------------------- JSON 转换方法 -------------------

    /**
     * 将提取到的 Controller 信息转换为 JSON 字符串
     *
     * @param controllers 提取到的 Controller 信息列表
     * @return JSON 字符串
     */
    public static String convertControllersToJson(List<ControllerInfo> controllers) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < controllers.size(); i++) {
            ControllerInfo controller = controllers.get(i);
            sb.append("\"").append(controller.getName()).append("\":");
            sb.append(convertMethodsToJson(controller.getMethods()));
            if (i < controllers.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * 将方法信息列表转换为 JSON 字符串
     *
     * @param methods 方法信息列表
     * @return JSON 字符串
     */
    private static String convertMethodsToJson(List<MethodInfo> methods) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < methods.size(); i++) {
            MethodInfo method = methods.get(i);
            sb.append("\"").append(method.getName()).append("\":");
            sb.append(convertParametersToJson(method.getParameters()));
            if (i < methods.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * 将参数信息列表转换为 JSON 字符串
     *
     * @param parameters 参数信息列表
     * @return JSON 字符串
     */
    private static String convertParametersToJson(List<ParameterInfo> parameters) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < parameters.size(); i++) {
            ParameterInfo parameter = parameters.get(i);
            sb.append("\"").append(parameter.getName()).append("\":");
            // 如果有嵌套字段，则构建对象 {"type": "类型", "fields": { ... } }
            if (parameter.getFields() != null && !parameter.getFields().isEmpty()) {
                sb.append("{");
                sb.append("\"type\":\"").append(parameter.getType()).append("\",");
                sb.append("\"fields\":");
                sb.append(convertFieldsToJson(parameter.getFields()));
                sb.append("}");
            } else {
                // 没有嵌套字段，直接输出类型字符串
                sb.append("\"").append(parameter.getType()).append("\"");
            }
            if (i < parameters.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * 将字段信息列表转换为 JSON 字符串（支持递归嵌套字段）
     *
     * @param fields 字段信息列表
     * @return JSON 字符串
     */
    private static String convertFieldsToJson(List<FieldInfo> fields) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < fields.size(); i++) {
            FieldInfo field = fields.get(i);
            sb.append("\"").append(field.getName()).append("\":");
            // 如果有嵌套字段，则构建对象 {"type": "类型", "fields": { ... } }
            if (field.getNestedFields() != null && !field.getNestedFields().isEmpty()) {
                sb.append("{");
                sb.append("\"type\":\"").append(field.getType()).append("\",");
                sb.append("\"fields\":");
                sb.append(convertFieldsToJson(field.getNestedFields()));
                sb.append("}");
            } else {
                // 没有嵌套字段，直接输出类型字符串
                sb.append("\"").append(field.getType()).append("\"");
            }
            if (i < fields.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // ------------------- 数据模型类 -------------------

    /**
     * 封装 Controller 信息
     */
    public static class ControllerInfo {
        private String name;
        private List<MethodInfo> methods;

        public ControllerInfo(String name) {
            this.name = name;
            this.methods = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public List<MethodInfo> getMethods() {
            return methods;
        }

        public void setMethods(List<MethodInfo> methods) {
            this.methods = methods;
        }

        @Override
        public String toString() {
            return "ControllerInfo{" +
                    "name='" + name + '\'' +
                    ", methods=" + methods +
                    '}';
        }
    }

    /**
     * 封装方法信息
     */
    public static class MethodInfo {
        private String name;
        private List<ParameterInfo> parameters;

        public MethodInfo(String name) {
            this.name = name;
            this.parameters = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public List<ParameterInfo> getParameters() {
            return parameters;
        }

        public void setParameters(List<ParameterInfo> parameters) {
            this.parameters = parameters;
        }

        @Override
        public String toString() {
            return "MethodInfo{" +
                    "name='" + name + '\'' +
                    ", parameters=" + parameters +
                    '}';
        }
    }

    /**
     * 封装方法参数信息
     */
    public static class ParameterInfo {
        private String name;
        private String type;
        private List<FieldInfo> fields;

        public ParameterInfo(String name, String type) {
            this.name = name;
            this.type = type;
            this.fields = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public List<FieldInfo> getFields() {
            return fields;
        }

        public void setFields(List<FieldInfo> fields) {
            this.fields = fields;
        }

        @Override
        public String toString() {
            return "ParameterInfo{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", fields=" + fields +
                    '}';
        }
    }

    /**
     * 封装字段信息
     */
    public static class FieldInfo {
        private String name;
        private String type;
        private List<FieldInfo> nestedFields;

        public FieldInfo(String name, String type) {
            this.name = name;
            this.type = type;
            this.nestedFields = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public List<FieldInfo> getNestedFields() {
            return nestedFields;
        }

        public void setNestedFields(List<FieldInfo> nestedFields) {
            this.nestedFields = nestedFields;
        }

        @Override
        public String toString() {
            return "FieldInfo{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", nestedFields=" + nestedFields +
                    '}';
        }
    }

    /**
     * 将 JSON 字符串解析为根层 Map&lt;String, String&gt;
     * key 为顶层的控制器名称，value 为对应控制器对象的 JSON 字符串
     *
     * @param jsonString 原始 JSON 字符串
     * @return Map&lt;String, String&gt; 根层键值对
     */
    public static Map<String, String> parseRootJsonToMap(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> rootMap;
        Map<String, String> resultMap = new HashMap<>();

        try {
            // 解析 JSON 字符串为 Map<String, Object>
            rootMap = mapper.readValue(jsonString, Map.class);
            // 遍历顶层键值对
            for (Map.Entry<String, Object> entry : rootMap.entrySet()) {
                // 将 value 对象再次转换为 JSON 字符串
                String valueJson = mapper.writeValueAsString(entry.getValue());
                resultMap.put(entry.getKey(), valueJson);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    public static String getControllerParametersJson(String baseControllerPackage,String projectBasePackage){
        List<ControllerInfo> controllers = extractControllerParameters(baseControllerPackage, projectBasePackage);
        String jsonResult = convertControllersToJson(controllers);
        return jsonResult;
    }

    // ------------------- 示例入口 -------------------
    public static void main(String[] args) {
        // 示例：扫描指定包下的 Controller，
        // 提取 Controller 参数信息并转换成 JSON 字符串格式打印
        String baseControllerPackage = "com.hospital.restful.modules.contractor.controller";
        String projectBasePackage = "com.hospital";
        List<ControllerInfo> controllers = extractControllerParameters(baseControllerPackage, projectBasePackage);
        String jsonResult = convertControllersToJson(controllers);
        System.out.println(jsonResult);
    }
}

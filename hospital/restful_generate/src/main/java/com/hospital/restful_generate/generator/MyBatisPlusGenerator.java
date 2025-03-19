package com.hospital.restful_generate.generator;


import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.nio.file.Paths;
import java.util.*;



import com.hospital.restful.domain.IndexStatistics;



import com.hospital.restful_generate.config.MyBatisPlusConfig;
import com.hospital.restful_generate.mapper.IndexStatisticsMapper;
import com.hospital.restful_generate.utils.PropsUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

/**
 * MyBatisPlus代码生成器
 * Created by macro on 2020/8/20.
 */
public class MyBatisPlusGenerator {
    static Map<String,String> orderMap = null;
    public static void main(String[] args) {
        Props props = PropsUtils.getProps("generator.properties");
        generator(props,
                "standard",
                "standard",
                'S'
        );
//        generator(props,
//                "reader",
//                "reader",
//                'R'
//        );
//        generatorContractor(props,
//                "contractor",
//                "contractor",
//                'C'
//        );
    }

    private static Map<String,String> getOrderString(String schema,String indexName){
        List<IndexStatistics> list = null;
        try {
            // 获取 SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = MyBatisPlusConfig.getSqlSessionFactory();

            // 获取 SqlSession 并执行查询
            try (SqlSession session = sqlSessionFactory.openSession()) {
                IndexStatisticsMapper mapper = session.getMapper(IndexStatisticsMapper.class);
                list = mapper.getIndexStatistics(schema, indexName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String,String> result = new HashMap<>();
        for (IndexStatistics item:list) {
            result.put(item.getTableName(),item.getColumnName()+" "+(item.getCollation().equals("A")?"ASC":"DESC"));
        }
        return result;
    }

    private static void generatorContractor(Props props,
                                  String output_moduleName,
                                  String input_tempDir,
                                  char sign
    ){
        if(orderMap == null) orderMap = getOrderString(props.getStr("mysql.schema"),props.getStr("mysql.index"));
        List tables = readListFromYaml("generator.yml","mysql.contractor.generatorList");
        Map<String, List<String>> excludeField = loadConfigByAttrPath("generator.yml","mysql.contractor.generatorDtoExcludeField");
        FastAutoGenerator.create(props.getStr("dataSource.url"), props.getStr("dataSource.username"), props.getStr("dataSource.password"))
                .globalConfig(builder -> builder
                        .author("MF")
                        .outputDir(Paths.get(System.getProperty("user.dir")) + "/RESTful/src/main/java")
                        .commentDate("yyyy-MM-dd")
                        .disableOpenDir()
                )
                .packageConfig(builder -> builder
                        .parent(props.getStr("package.base"))
                        .entity("dto")
                        .service("service")
                        .controller("controller")
                        .moduleName(output_moduleName)
                )
                .strategyConfig(builder -> builder
                        .addInclude(tables)
                        .serviceBuilder()
                        .formatServiceFileName(sign+"%sService")
                        .formatServiceImplFileName(sign+"%sServiceImpl")
                        .controllerBuilder()
                        .formatFileName(sign+"%sController")
                        .entityBuilder()
                        .formatFileName(sign+"%sParam")
                )
                .templateEngine(new VelocityTemplateEngine())
                .injectionConfig(builder -> {
                    // 向模板传递自定义参数
                    Map<String, Object> customMap = new HashMap<>();
                    customMap.put("orderMap", orderMap); // 添加自定义参数
                    customMap.put("excludeField",excludeField);
                    builder.customMap(customMap);
                })
                .templateConfig(builder ->{
                    builder.disable(TemplateType.ENTITY,TemplateType.MAPPER,TemplateType.XML);
                    builder.controller("/templates/"+input_tempDir+"/controller.java.vm") // 设置Controller模板路径
                            .service("/templates/"+input_tempDir+"/service.java.vm") // 设置Service模板路径
                            .serviceImpl("/templates/"+input_tempDir+"/serviceImpl.java.vm") // 设置ServiceImpl模板路径
                            .entity("/templates/" + input_tempDir + "/param.java.vm");
                })
                .execute();
    }
    private static void generator(Props props,
                                  String output_moduleName,
                                  String input_tempDir,
                                  char sign
                                  ){
        if(orderMap == null) orderMap = getOrderString(props.getStr("mysql.schema"),props.getStr("mysql.index"));
        List tables = readListFromYaml("generator.yml","mysql.generatorList");
        FastAutoGenerator.create(props.getStr("dataSource.url"), props.getStr("dataSource.username"), props.getStr("dataSource.password"))
                .globalConfig(builder -> builder
                        .author("MF")
                        .outputDir(Paths.get(System.getProperty("user.dir")) + "/RESTful/src/main/java")
                        .commentDate("yyyy-MM-dd")
                        .disableOpenDir()
                )
                .packageConfig(builder -> builder
                        .parent(props.getStr("package.base"))
                        .service("service")
                        .controller("controller")
                        .moduleName(output_moduleName)
                )
                .strategyConfig(builder -> builder
                                .addInclude(tables)
                                .serviceBuilder()
                                .formatServiceFileName(sign+"%sService")
                                .formatServiceImplFileName(sign+"%sServiceImpl")
                                .controllerBuilder()
                                .formatFileName(sign+"%sController")
                )
                .templateEngine(new VelocityTemplateEngine())
                .injectionConfig(builder -> {
                    // 向模板传递自定义参数
                    Map<String, Object> customMap = new HashMap<>();
                    customMap.put("orderMap", orderMap); // 添加自定义参数
                    builder.customMap(customMap);
                })
                .templateConfig(builder ->{
                    builder.disable(TemplateType.ENTITY,TemplateType.MAPPER,TemplateType.XML);
                    builder.controller("/templates/"+input_tempDir+"/controller.java.vm") // 设置Controller模板路径
                            .service("/templates/"+input_tempDir+"/service.java.vm") // 设置Service模板路径
                            .serviceImpl("/templates/"+input_tempDir+"/serviceImpl.java.vm"); // 设置ServiceImpl模板路径
                })
                .execute();
    }

    /**
     * 读取控制台内容信息
     */
    private static String scanner(String tip) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println(("请输入" + tip + "："));
        if (scanner.hasNext()) {
            String next = scanner.next();
            if (StrUtil.isNotEmpty(next)) {
                return next;
            }
        }
        throw new Exception("请输入正确的" + tip + "！");
    }

    /**
     * 读取指定 YAML 文件中指定路径的集合
     *
     * @param fileName YAML 文件名
     * @param ListPath     YAML 文件中的路径（以点分隔）
     * @return 指定路径的集合
     */
    public static List<Map<String, Object>> readListFromYaml(String fileName, String ListPath) {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        Yaml yaml = new Yaml(options);
        try (InputStream inputStream =  MyBatisPlusGenerator.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                System.out.println("YAML file not found");
                return null;
            }
            Map<String, Object> obj = yaml.load(inputStream);
            String[] keys = ListPath.split("\\.");

            for (int i = 0; i < keys.length; i++) {
                String key = keys[i];
                Object value = obj.get(key);

                if (value instanceof Map) {
                    obj = (Map<String, Object>) value;
                } else if (value instanceof List) {
                    // 如果已经到达路径的最后一个键，且值是一个列表，则返回该列表
                    if (i == keys.length - 1) {
                        return (List<Map<String, Object>>) value;
                    } else {
                        // 否则，抛出异常或进行其他处理
                        throw new IllegalArgumentException("Unexpected List encountered at: " + key);
                    }
                } else {
                    // 处理其他可能的类型，或抛出异常
                    throw new IllegalArgumentException("Unexpected value type at: " + key);
                }
            }
            // 如果遍历完所有键，返回结果
            return (List<Map<String, Object>>) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 根据传入的 attrPath，从指定的 yml 文件中读取配置，并返回 Map<String, List<String>> 格式的数据
     *
     * 示例 YML 文件内容：
     * mysql:
     *   contractor:
     *     generatorDtoExcludeField:
     *       key: [value1, value2]
     *
     * @param ymlFilePath yml 文件在 classpath 下的路径，例如 "generator.yml"
     * @param attrPath    嵌套路径，例如 "mysql.contractor.generatorDtoExcludeField"
     * @return 返回解析后的配置，如果不存在则返回空 Map
     */
    public static Map<String, List<String>> loadConfigByAttrPath(String ymlFilePath, String attrPath) {
        Yaml yaml = new Yaml();
        Map<String, List<String>> result = new HashMap<>();
        try (InputStream in = MyBatisPlusGenerator.class.getClassLoader().getResourceAsStream(ymlFilePath)) {
            if (in == null) {
                throw new RuntimeException("未找到 yml 文件：" + ymlFilePath);
            }
            // 将 yml 文件解析为 Map
            Map<String, Object> data = yaml.load(in);
            if (data == null) {
                return result;
            }
            // 根据 attrPath 获取嵌套属性值
            Object fieldObj = getNestedValue(data, attrPath);
            if (fieldObj instanceof Map) {
                Map<?, ?> fieldMap = (Map<?, ?>) fieldObj;
                // 遍历所有键值对
                for (Map.Entry<?, ?> entry : fieldMap.entrySet()) {
                    String key = entry.getKey().toString();
                    Object value = entry.getValue();
                    List<String> list = new ArrayList<>();
                    if (value instanceof List) {
                        // 如果已经是 List，直接转换
                        for (Object item : (List<?>) value) {
                            list.add(item.toString());
                        }
                    } else if (value instanceof String) {
                        // 如果是字符串形式，例如 "[value1, value2]"，则去除中括号并按逗号拆分
                        String s = ((String) value).trim();
                        if (s.startsWith("[") && s.endsWith("]")) {
                            s = s.substring(1, s.length() - 1);
                        }
                        String[] parts = s.split(",");
                        for (String part : parts) {
                            list.add(part.trim());
                        }
                    }
                    result.put(key, list);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("加载 yml 配置失败", e);
        }
        return result;
    }

    /**
     * 根据点分隔的路径，在 Map 中递归查找对应的属性值
     *
     * @param data     配置 Map
     * @param attrPath 点分隔的路径，如 "mysql.contractor.generatorDtoExcludeField"
     * @return 如果路径存在则返回对应的值，否则返回 null
     */
    @SuppressWarnings("unchecked")
    private static Object getNestedValue(Map<String, Object> data, String attrPath) {
        String[] keys = attrPath.split("\\.");
        Object current = data;
        for (String key : keys) {
            if (current instanceof Map) {
                current = ((Map<String, Object>) current).get(key);
            } else {
                return null;
            }
        }
        return current;
    }

}
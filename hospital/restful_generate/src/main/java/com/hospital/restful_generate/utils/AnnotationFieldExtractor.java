package com.hospital.restful_generate.utils;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.util.*;

public class AnnotationFieldExtractor {
    public static Map<String,List<String>> getFieldName(String basePackage){
        String packageName = basePackage;
        List<Class<?>> classes = null;
        try {
            classes = getClasses(packageName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Map<String,List<String>> result = new HashMap<>();
        for (Class<?> clazz : classes) {
            List<String> annotatedFields = getAnnotatedFieldNames(clazz);
            if (!annotatedFields.isEmpty()) {
                result.put(clazz.getSimpleName(),annotatedFields);
            }
        }
        return result;
    }

    // 获取指定包下的所有类
    private static List<Class<?>> getClasses(String packageName) throws IOException, ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(path);
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            File directory = new File(resource.getFile());
            if (directory.exists()) {
                File[] files = directory.listFiles((dir, name) -> name.endsWith(".class"));
                if (files != null) {
                    for (File file : files) {
                        String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                        classes.add(Class.forName(className));
                    }
                }
            }
        }
        return classes;
    }

    // 获取被特定 @Field 注解标注的字段名称
    private static List<String> getAnnotatedFieldNames(Class<?> clazz) {
        List<String> fieldNames = new ArrayList<>();
        java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
        for (java.lang.reflect.Field field : fields) {
            Field fieldAnnotation = field.getAnnotation(Field.class);
            if (fieldAnnotation != null &&
                    "ik_max_word".equals(fieldAnnotation.analyzer()) &&
                    FieldType.Text.equals(fieldAnnotation.type())) {
                fieldNames.add(field.getName());
            }
        }
        return fieldNames;
    }
}


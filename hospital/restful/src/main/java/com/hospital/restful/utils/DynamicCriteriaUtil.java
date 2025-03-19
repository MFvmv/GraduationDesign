package com.hospital.restful.utils;
import java.lang.reflect.Method;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DynamicCriteriaUtil{

    /**
     * 动态调用 Criteria 的方法，自动转换参数类型。
     *
     * @param criteria   Criteria 对象
     * @param methodName 要调用的方法名，例如 "andCategoryEqualTo"
     * @param value      传入的值（待转换）
     */
    public static void invokeAndConvert(Object criteria, String methodName, Object value) {
        try {
            // 遍历查找方法，匹配方法名和参数个数
            Method targetMethod = null;
            for (Method method : criteria.getClass().getMethods()) {
                if (method.getName().equals(methodName) && method.getParameterCount() == 1) {
                    targetMethod = method;
                    break;
                }
            }

            if (targetMethod == null) {
                throw new IllegalArgumentException("No matching method found for name: " + methodName);
            }

            // 获取方法的参数类型
            Class<?> paramType = targetMethod.getParameterTypes()[0];

            // 将 value 转换为目标类型
            Object convertedValue = convertValue(value, paramType);

            // 调用方法
            targetMethod.invoke(criteria, convertedValue);

        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke method: " + methodName, e);
        }
    }

    /**
     * 将 value 转换为目标类型
     *
     * @param value     原始值
     * @param targetType 目标类型
     * @return 转换后的值
     */
    private static Object convertValue(Object value, Class<?> targetType) {
        if (value == null) {
            return null; // 如果 value 是 null，直接返回
        }

        if (targetType.isInstance(value)) {
            return value; // 如果类型已经匹配，无需转换
        }

        // 根据目标类型进行强制转换
        if (targetType == String.class) {
            return value.toString();
        } else if (targetType == Integer.class || targetType == int.class) {
            return Integer.parseInt(value.toString());
        } else if (targetType == Long.class || targetType == long.class) {
            return Long.parseLong(value.toString());
        } else if (targetType == Double.class || targetType == double.class) {
            return Double.parseDouble(value.toString());
        } else if (targetType == Float.class || targetType == float.class) {
            return Float.parseFloat(value.toString());
        } else if (targetType == Boolean.class || targetType == boolean.class) {
            return Boolean.parseBoolean(value.toString());
        } else if (targetType == Date.class) {
            // 假设输入的日期字符串格式为 "yyyy-MM-dd"，也可以支持其他格式
            String dateFormat = "yyyy-MM-dd";
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                return sdf.parse(value.toString());
            } catch (ParseException e) {
                throw new IllegalArgumentException("Failed to parse Date: " + value + " using format: " + dateFormat, e);
            }
        }
        else {
                throw new IllegalArgumentException("Unsupported parameter type: " + targetType.getName());
        }
    }
}

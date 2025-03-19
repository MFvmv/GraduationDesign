package com.hospital.restful.utils;
import java.lang.reflect.Method;

public class ReflectionUtils {

    /**
     * 判断指定类中是否存在名称为 methodName，参数类型为 parameterTypes 的方法
     *
     * @param clazz          要检测的类
     * @param methodName     方法名
     * @param parameterTypes 方法参数类型（可选）
     * @return 如果存在返回 true，否则返回 false
     */
    public static boolean hasMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        try {
            clazz.getMethod(methodName, parameterTypes);
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    /**
     * 利用反射调用对象的方法
     *
     * @param object         目标对象
     * @param methodName     方法名称
     * @param parameterTypes 方法参数类型（可选）
     * @param args           方法参数值
     * @return 方法返回值，调用失败返回 null
     */
    public static Object callMethod(Object object, String methodName, Class<?>[] parameterTypes, Object[] args) {
        try {
            Method method = object.getClass().getMethod(methodName, parameterTypes);
            return method.invoke(object, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 如果目标对象中存在指定方法（方法名称数组中的任意一个），则调用该方法；
     * 否则打印提示信息并抛出异常。
     *
     * @param object         目标对象
     * @param methodNames    方法名称数组
     * @param parameterTypes 方法参数类型（可选），如果没有参数建议传入 new Class<?>[] {}
     * @param args           方法参数值
     * @return 如果方法存在，则返回调用结果
     * @throws RuntimeException 如果数组中所有方法都不存在，则抛出异常
     */
    public static Object callIfExists(Object object, String[] methodNames, Class<?>[] parameterTypes, Object[] args) {
        for (String methodName : methodNames) {
            if (hasMethod(object.getClass(), methodName, parameterTypes)) {
                return callMethod(object, methodName, parameterTypes, args);
            }
        }
        String message = "方法 " + java.util.Arrays.toString(methodNames) + " 在 " + object.getClass().getName() + " 中不存在";
        System.out.println(message);
        throw new RuntimeException(message);
    }


    // 测试代码
    public static void main(String[] args) {
        TestClass test = new TestClass();

        // 判断并调用 sayHello 方法
        if (hasMethod(TestClass.class, "sayHello", String.class)) {
            Object result = callMethod(test, "sayHello", new Class<?>[]{String.class}, new Object[]{"Reflection"});
            System.out.println("调用结果: " + result);
        }

        // 尝试调用一个不存在的方法
        callIfExists(test,new String[]{"nonExistentMethod"}, new Class<?>[]{}, new Object[]{});
    }
}

// 用于测试的类
class TestClass {
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}

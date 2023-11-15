package io.github.cuilan.tom.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * grpc对象字段拷贝
 *
 * @author zhangyan
 * @since 2021/12/14
 */
public class GrpcBeanCopyUtils {

    /**
     * get方法前缀
     */
    private static final String GET_METHOD_PREFIX = "get";

    /**
     * set方法前缀
     */
    private static final String SET_METHOD_PREFIX = "set";

    /**
     * grpc 字段拷贝
     *
     * @param source grpc源对象
     * @param target 目标对象
     * @throws IllegalAccessException    禁止访问异常
     * @throws InvocationTargetException 方法或构造器调用异常
     */
    public static void grpcBeanCopy(Object source, Object target) throws IllegalAccessException, InvocationTargetException {
        Field[] targetFields = target.getClass().getDeclaredFields();
        Method[] sourceMethods = source.getClass().getMethods();
        Method[] targetMethods = target.getClass().getMethods();
        for (Field targetField : targetFields) {
            String lowPrefix = targetField.getName().substring(0, 1);
            String subStr = targetField.getName().substring(1);
            String getMethodName = GET_METHOD_PREFIX + lowPrefix.toUpperCase() + subStr;
            String setMethodName = SET_METHOD_PREFIX + lowPrefix.toUpperCase() + subStr;
            for (Method targetMethod : targetMethods) {
                if (targetMethod.getName().equals(setMethodName)) {
                    for (Method sourceMethod : sourceMethods) {
                        if (sourceMethod.getName().equals(getMethodName)) {
                            targetMethod.invoke(target, sourceMethod.invoke(source));
                            break;
                        }
                    }
                }
            }
        }
    }
}

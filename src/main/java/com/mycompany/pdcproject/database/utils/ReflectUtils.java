package com.mycompany.pdcproject.database.utils;

import java.lang.reflect.Method;

/**
 * 封装了反射常用的操作
 *
 * @author Arthur
 *
 */
public class ReflectUtils {

    /**
     * 调用obj对象对应属性fieldName的get方法
     *
     * @param fieldName
     * @param obj
     * @return
     */
    public static Object invokeGet(String fieldName, Object obj) {
        try {
            Method m = obj.getClass().getDeclaredMethod("get" + StringUtils.firstChar2UpperCase(fieldName), null);
            return m.invoke(obj, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 调用obj对象对应属性columnName的set方法,参数为columnValue
     *
     * @param obj
     * @param columnName
     * @param columnValue
     */
    public static void invokeSet(Object obj, String columnName, Object columnValue) {
        Method m;
        try {
            m = obj.getClass().getDeclaredMethod("set" + StringUtils.firstChar2UpperCase(columnName),
                    columnValue.getClass());
            m.invoke(obj, columnValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

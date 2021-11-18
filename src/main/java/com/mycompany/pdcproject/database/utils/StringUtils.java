package com.mycompany.pdcproject.database.utils;

/**
 * 封装了字符串常用的操作
 *
 * @author Arthur
 *
 */
public class StringUtils {

    /**
     * 将目标字符串首字母变为大写，其余字母全部转为小写
     *
     * @param str 目标字符串
     * @return 首字母变为大写的字符串
     */
    public static String first2Upper(String str) {
        return str.toUpperCase().substring(0, 1) + str.substring(1).toLowerCase();
    }
}

package com.qkjt.qkkt.common.utils;

import java.util.Random;

import org.apache.commons.lang.StringUtils;


public class StringUtil extends StringUtils {

    private static final String letterChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


    /**
     * 参数为返回随机数的长度
     *
     * @param length 需要生成的字符串长度
     * @return
     */
    public static String generateString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(letterChar.charAt(random.nextInt(letterChar.length())));
        }
        return sb.toString();
    }

    /**
     * 将字符串型的json数据转换为List<map>返回
     *
     * @return
     */
//    public static List<Map> getMapFromJsonString(String jsonString) {
//        List<Map> list = JsonUtil.getListMapFromJsonString(jsonString);
//        return list;
//    }

    public static boolean isNullOrEmpty(String value) {
        if (value != null)
            return value.length() == 0;
        return true;
    }

    public static String getPathFileName(String filePath, boolean... includeType) {
        if (isNullOrEmpty(filePath))
            return null;
        int i = filePath.lastIndexOf("\\");
        if (i == -1) {
            i = filePath.lastIndexOf("/");
        }
        int j = filePath.lastIndexOf(".");
        if (i == -1 || j == -1)
            return null;
        if (includeType.length > 0) {
            return filePath.substring(i + 1);
        }
        return filePath.substring(i + 1, j);
    }

    public static boolean isIn(String substring, String[] source) {
        if (source == null || source.length == 0) {
            return false;
        }
        for (int i = 0; i < source.length; i++) {
            String aSource = source[i];
            if (aSource.equals(substring)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 去除前后空格，如果为空则返回空字符串
     * @param value
     * @return
     */
    public static String getStringValue(String value) {
        if (null == value || "".equals(value.trim()))
            return "";
        return value.trim();
    }
}

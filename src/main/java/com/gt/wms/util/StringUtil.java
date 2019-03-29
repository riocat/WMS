package com.gt.wms.util;

/**
 * Created by rio on 2019/3/25.
 */
public class StringUtil {

    public static boolean isNotEmpty(String value) {
        return value == null ? false : !"".equals(value);
    }

    public static boolean checkStringEquals(String str1, String str2) {
        if (str1 == str2)
            return true;

        if (str1 != null)
            return str1.equals(str2);

        if (str2 != null)
            return str2.equals(str1);

        return false;
    }
}

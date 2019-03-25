package com.gt.wms.util;

/**
 * Created by rio on 2019/3/25.
 */
public class StringUtil {

    public static boolean isNotEmpty(String value) {
        return value == null ? false : !"".equals(value);
    }
}

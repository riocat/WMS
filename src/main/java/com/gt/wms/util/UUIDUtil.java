package com.gt.wms.util;

import java.util.UUID;

/**
 * Created by rio on 2019/3/22.
 */
public class UUIDUtil {

    public synchronized static String get36UUID() {
        String targetValue = UUID.randomUUID().toString();
        System.out.println(targetValue);
        return "";
    }

    public synchronized static String get32UUID() {
        String targetValue = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(targetValue);
        return "";
    }

    public static void main(String[] args) {
        get36UUID();
        get32UUID();
    }
}

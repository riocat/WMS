package com.gt.wms.util;

import java.util.UUID;

/**
 * Created by rio on 2019/3/22.
 */
public class UUIDUtil {

    public synchronized static String get36UUID() {
        return UUID.randomUUID().toString();
    }

    public synchronized static String get32UUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        get36UUID();
        get32UUID();
    }
}

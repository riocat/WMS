package com.gt.wms.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ASUS on 2017/6/1.
 */
public class DateUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    public static String getDateString() {
        String result = sdf.format(new Date());
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        DateUtil.getDateString();
    }
}

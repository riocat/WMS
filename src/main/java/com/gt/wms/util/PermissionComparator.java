package com.gt.wms.util;

import com.gt.wms.Entity.Permission;

import java.util.Comparator;

/**
 * Created by rio on 2019/3/27.
 */
public class PermissionComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Permission p1 = (Permission) o1;
        Permission p2 = (Permission) o2;
        return p1.getOrder() - p2.getOrder();
    }
}

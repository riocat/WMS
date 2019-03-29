package com.gt.wms.Dao;

import com.gt.wms.Entity.Permission;

import java.util.List;
import java.util.Map;

/**
 * Created by rio on 2019/3/28.
 */
public interface PermissionDao {

    List<Permission> getPagePermissionList(Map parMap);

    int getPageNum(Map parMap);

    int uniqueCheck(Permission permission);
}

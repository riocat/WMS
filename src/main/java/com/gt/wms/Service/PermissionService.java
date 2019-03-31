package com.gt.wms.Service;

import com.gt.wms.Entity.Permission;

import java.util.List;
import java.util.Map;

/**
 * Created by rio on 2019/3/28.
 */
public interface PermissionService {

    List<Permission> getAllPermissionList(Map parMap);

    int getPageNum(Map parMap);

    boolean uniqueCheck(Permission permission);

    List<Permission> getLevelPermissionList(List<Permission> base);

    List<Permission> getAllLevelPermissionList();
}

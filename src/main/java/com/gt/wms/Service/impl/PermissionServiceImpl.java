package com.gt.wms.Service.impl;

import com.gt.wms.Dao.PermissionDao;
import com.gt.wms.Entity.Permission;
import com.gt.wms.Service.PermissionService;
import com.gt.wms.util.SettingValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by rio on 2019/3/28.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> getPagePermissionList(Map parMap) {
        return permissionDao.getPagePermissionList(parMap);
    }

    @Override
    public int getPageNum(Map parMap) {
        return permissionDao.getPageNum(parMap);
    }

    @Override
    public boolean uniqueCheck(Permission permission){
        return permissionDao.uniqueCheck(permission)>=1?false:true;
    }
}

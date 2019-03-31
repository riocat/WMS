package com.gt.wms.Service.impl;

import com.gt.wms.Dao.RoleDao;
import com.gt.wms.Entity.Permission;
import com.gt.wms.Entity.User;
import com.gt.wms.Service.PermissionService;
import com.gt.wms.Service.RoleService;
import com.gt.wms.util.PermissionComparator;
import com.gt.wms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by rio on 2019/3/26.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionService permissionService;

    @Override
    public List<Permission> getMenuByRole(User puser) {
        List<Permission> base = roleDao.getMenuByRole(puser);
        List<Permission> targetList = permissionService.getLevelPermissionList(base);
        return targetList;
    }

    public static void main(String[] args) {
        List keys = new ArrayList();
        keys.add(2);
        keys.add(1);
        keys.add(4);
        keys.add(3);

        Collections.sort(keys);

        System.out.println(keys.toArray());

        Collections.reverse(keys);

        System.out.println(keys.toArray());
    }

}

package com.gt.wms.Dao;

import com.gt.wms.Entity.Permission;
import com.gt.wms.Entity.User;

import java.util.List;

/**
 * Created by rio on 2019/3/26.
 */
public interface RoleDao {

    List<Permission> getMenuByRole(User puser);
}

package com.gt.wms.Service;

import com.gt.wms.Entity.Permission;
import com.gt.wms.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rio on 2019/3/26.
 */
public interface RoleService {

    List<Permission> getMenuByRole(User puser);
}

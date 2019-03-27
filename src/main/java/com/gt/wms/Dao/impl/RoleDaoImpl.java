package com.gt.wms.Dao.impl;

import com.gt.wms.Dao.RoleDao;
import com.gt.wms.Entity.Permission;
import com.gt.wms.Entity.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rio on 2019/3/26.
 */
@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<Permission> getMenuByRole(User puser) {
        List<String> list = sqlSession.selectList("getUserRoleIds", puser);
        if (list.size() > 0)
            return sqlSession.selectList("getPermissionsByRole", list);
        return new ArrayList<Permission>();
    }
}

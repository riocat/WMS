package com.gt.wms.Dao.impl;

import com.gt.wms.Dao.PermissionDao;
import com.gt.wms.Entity.Permission;
import com.gt.wms.util.SettingValue;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by rio on 2019/3/28.
 */
@Repository
public class PermissionDaoImpl implements PermissionDao {

    @Autowired
    private SqlSessionTemplate sqlSession;


    @Autowired
    private SettingValue setting;

    @Override
    public List<Permission> getPagePermissionList(Map parMap) {
        List<Permission> permissions = null;
        if ("MSSQL".equals(setting.dbtype)) {
            permissions = sqlSession.selectList("getPagePermissionListMS", parMap);
        }
        return permissions;
    }

    @Override
    public int getPageNum(Map parMap) {
        return sqlSession.selectOne("getPageNum", parMap);
    }

    @Override
    public int uniqueCheck(Permission permission) {
        return sqlSession.selectOne("uniqueCheck", permission);
    }
}

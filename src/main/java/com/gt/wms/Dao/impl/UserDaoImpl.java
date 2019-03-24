package com.gt.wms.Dao.impl;

import com.gt.wms.Entity.User;
import com.gt.wms.util.SettingValue;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gt.wms.Dao.UserDao;

import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Autowired
    private SettingValue setting;

    public User getUserByName(String name) {
        return sqlSession.selectOne("getUserByName", name);
    }

    @Override
    public int regester(User user) {
        return sqlSession.update("regester", user);
    }

    @Override
    public int addUser(User user) {
        return sqlSession.insert("addUser", user);
    }

    @Override
    public List<User> getPageUserList(Map parMap) {
        List<User> users = null;
        if("MSSQL".equals(setting.dbtype)){
            users = sqlSession.selectList("getPageUserListMS", parMap);
        }
        return users;
    }

    @Override
    public int getPageNum(Map parMap) {
        int num = 0;
        if("MSSQL".equals(setting.dbtype)){
            num = sqlSession.selectOne("getPageNumMS", parMap);
        }
        return num;
    }

}

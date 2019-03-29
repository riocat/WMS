package com.gt.wms.Dao.impl;

import com.gt.wms.Entity.User;
import com.gt.wms.util.SettingValue;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gt.wms.Dao.UserDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Autowired
    private SettingValue setting;

    public User getUserByLoginid(String name) {
        return sqlSession.selectOne("getUserByLoginid", name);
    }

    @Override
    public int regester(User user) {
        return sqlSession.update("regester", user);
    }

    @Override
    public int addUser(User user) {
        int rows = 0;
        if ("MSSQL".equals(setting.dbtype)) {
            rows = sqlSession.insert("addUserMS", user);
        }
        return rows;
    }

    @Override
    public List<User> getPageUserList(Map parMap) {
        List<User> users = new ArrayList();
        if ("MSSQL".equals(setting.dbtype)) {
            users = sqlSession.selectList("getPageUserListMS", parMap);
        }
        return users;
    }

    @Override
    public int getPageNum(Map parMap) {
        int num = 0;
        if ("MSSQL".equals(setting.dbtype)) {
            num = sqlSession.selectOne("getPageNumMS", parMap);
        }
        return num;
    }

    @Override
    public int deleteUserById(User user) {
        int rows = 0;
        if ("MSSQL".equals(setting.dbtype)) {
            rows = sqlSession.delete("deleteUserByIdMS", user);
        }
        return rows;
    }

    @Override
    public User getUserById(String id) {
        User user = null;
        if ("MSSQL".equals(setting.dbtype)) {
            user = sqlSession.selectOne("getUserByIdMS", id);
        }
        return user;
    }

    @Override
    public int updateUser(User puser) {
        int rows = 0;
        if ("MSSQL".equals(setting.dbtype)) {
            rows = sqlSession.insert("updateUserMS", puser);
        }
        return rows;
    }

    @Override
    public int uniqueCheck(User puser) {
        return sqlSession.selectOne("uniqueCheck", puser);
    }

}

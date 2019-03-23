package com.gt.wms.Dao.impl;

import com.gt.wms.Entity.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gt.wms.Dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

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

}

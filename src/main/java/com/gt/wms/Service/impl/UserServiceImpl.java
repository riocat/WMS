package com.gt.wms.Service.impl;

import com.gt.wms.Dao.UserDao;
import com.gt.wms.Entity.User;
import com.gt.wms.Service.UserService;
import com.gt.wms.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserByLoginid(String name) {
        User user = null;
        user = userDao.getUserByLoginid(name);
        return user;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int regester(User user) throws Exception {
        int j = userDao.regester(user);
        return j;
    }

    @Override
    public int addUser(User user) throws Exception {
        user.setId(UUIDUtil.get36UUID());
        return userDao.addUser(user);
    }

    @Override
    public List<User> getPageUserList(Map parMap) {
        return userDao.getPageUserList(parMap);
    }

    @Override
    public int getPageNum(Map parMap) {
        int num = userDao.getPageNum(parMap);
        if (num == 0)
            return 1;
        int pageSize = (int) parMap.get("pageSize");
        return num % pageSize == 0 ? num / pageSize : (num / pageSize + 1);
    }

    @Override
    public int deleteUserById(User user) {
        return userDao.deleteUserById(user);
    }

    @Override
    public User getUserById(String id) {
        return userDao.getUserById(id);
    }

    @Override
    public int updateUser(User puser) {
        return userDao.updateUser(puser);
    }

    @Override
    public boolean uniqueCheck(User puser){
        return userDao.uniqueCheck(puser)>=1?false:true;
    }

}

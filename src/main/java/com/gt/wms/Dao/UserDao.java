package com.gt.wms.Dao;

import com.gt.wms.Entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

	User getUserByLoginid(String name);
	
	int regester(User user);

	int addUser(User user);

	List<User> getPageUserList(Map parMap);

	int getPageNum(Map parMap);

	int deleteUserById(User user);

	User getUserById(String id);

	int updateUser(User puser);

	int uniqueCheck(User puser);
}

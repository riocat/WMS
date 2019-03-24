package com.gt.wms.Dao;

import com.gt.wms.Entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

	User getUserByName(String name);
	
	int regester(User user);

	int addUser(User user);

	List<User> getPageUserList(Map parMap);

	int getPageNum(Map parMap);
}

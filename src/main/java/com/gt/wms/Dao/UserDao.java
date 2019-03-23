package com.gt.wms.Dao;

import com.gt.wms.Entity.User;

public interface UserDao {

	User getUserByName(String name);
	
	int regester(User user);

	int addUser(User user);
}

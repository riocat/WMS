package com.gt.wms.Dao;

import com.gt.wms.Entity.User;

public interface UserDao {

	public User getUserByName(String name);
	
	public int regester(User user);
}

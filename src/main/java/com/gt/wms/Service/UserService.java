package com.gt.wms.Service;

import com.gt.wms.Entity.User;

public interface UserService {

	public User getUserByName(String name);
	
	public int regester(User user) throws Exception;

	public int addUser(User user) throws Exception;

}

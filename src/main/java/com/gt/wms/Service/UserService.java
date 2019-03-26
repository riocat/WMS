package com.gt.wms.Service;

import com.gt.wms.Entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

	public User getUserByName(String name);
	
	public int regester(User user) throws Exception;

	public int addUser(User user) throws Exception;

	List<User> getPageUserList(Map parMap);

	int getPageNum(Map parMap);

	int deleteUserById(User user);

	User getUserById(String id);

	int updateUser(User puser);

	boolean uniqueCheck(User puser);
}

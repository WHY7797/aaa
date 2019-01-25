package com.dao;

import com.beans.UserInfo;

public interface UserDao {
	
	public UserInfo login(String userName,String password);
	
	public boolean addUser(UserInfo userInfo);

}

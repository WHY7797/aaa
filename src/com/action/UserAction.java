package com.action;

import com.beans.UserInfo;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.opensymphony.xwork2.ActionContext;

public class UserAction {
	
	private UserInfo user;
	
	public String login(){
		UserDao userDao=new UserDaoImpl();
		UserInfo userInfo=userDao.login(user.getUserName(), user.getPassword());
		if(userInfo!=null){
			return "loginSucc";
		}else{
			return "loginErr";
		}
	}
	
	public String addUser(){
		UserDao userDao=new UserDaoImpl();
		boolean b=userDao.addUser(user);
		if(b){
			ActionContext.getContext().put("msg", "注册成功!");
		}else{
			ActionContext.getContext().put("msg", "注册失败!");
		}
		return "addUser";
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	
	
}

package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.beans.UserInfo;
import com.dao.UserDao;
import com.util.DBUtil;

public class UserDaoImpl implements UserDao {

	public UserInfo login(String userName, String password) {
		Connection conn=null;
		PreparedStatement stm=null;
		ResultSet rs=null;
		UserInfo user=null;
		try{
			conn=DBUtil.getConn();
			String sql="select * from userinfo where userName=? and password=?";
			stm=conn.prepareStatement(sql);
			stm.setString(1, userName);
			stm.setString(2, password);
			rs=stm.executeQuery();
			if(rs.next()){
				user=new UserInfo();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, conn, stm);
		}
		return user;
	}

	public boolean addUser(UserInfo userInfo) {
		Connection conn=null;
		PreparedStatement stm=null;
		try{
			conn=DBUtil.getConn();
			String sql="insert into userinfo(userName,password,email) values(?,?,?)";
			stm=conn.prepareStatement(sql);
			stm.setString(1, userInfo.getUserName());
			stm.setString(2, userInfo.getPassword());
			stm.setString(3, userInfo.getEmail());
			int result=stm.executeUpdate();
			if(result>0){
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(null, conn, stm);
		}
		return false;
	}

}

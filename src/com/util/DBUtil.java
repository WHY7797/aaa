package com.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	private DBUtil(){}
	private static DataSource dataSource;
	
	static{
		try {
			dataSource=new ComboPooledDataSource("mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//取连接
	public static Connection getConn(){
		Connection conn=null;
		try {
			 conn=dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭资源
	public static void close(ResultSet rs,Connection conn,Statement stm){
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(stm!=null){
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}


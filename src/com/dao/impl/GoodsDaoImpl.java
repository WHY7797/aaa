package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.GoodsInfo;
import com.dao.GoodsDao;
import com.util.DBUtil;

public class GoodsDaoImpl implements GoodsDao {

	public List<GoodsInfo> queryAllGoods(){
		Connection conn=null;
		PreparedStatement stm=null;
		ResultSet rs=null;
		List<GoodsInfo> gList=new ArrayList<GoodsInfo>();
		try{
			conn=DBUtil.getConn();
			String sql="select * from goodsinfo";
			stm=conn.prepareStatement(sql);
			rs=stm.executeQuery();
			while(rs.next()){
				GoodsInfo g=new GoodsInfo();
				g.setId(rs.getInt("id"));
				g.setGoodsName(rs.getString("goodsName"));
				g.setNum(rs.getInt("num"));
				g.setUnit(rs.getString("unit"));
				gList.add(g);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, conn, stm);
		}
		return gList;
	}

}

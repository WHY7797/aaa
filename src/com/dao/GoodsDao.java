package com.dao;

import java.util.List;

import com.beans.GoodsInfo;

public interface GoodsDao {
	public List<GoodsInfo> queryAllGoods();
}

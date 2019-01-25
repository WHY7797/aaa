package com.action;

import java.util.List;

import com.beans.GoodsInfo;
import com.dao.GoodsDao;
import com.dao.impl.GoodsDaoImpl;
import com.opensymphony.xwork2.ActionContext;

public class GoodsAction {
	
	private GoodsInfo goods;
	
	public String queryAllGoods(){
		GoodsDao goodsDao=new GoodsDaoImpl();
		List<GoodsInfo> gList=goodsDao.queryAllGoods();
		ActionContext.getContext().put("gList", gList);
		return "queryAllGoods";
	}
	
	

	public void setGoods(GoodsInfo goods) {
		this.goods = goods;
	}

	public GoodsInfo getGoods() {
		return goods;
	}

	
	
	
}

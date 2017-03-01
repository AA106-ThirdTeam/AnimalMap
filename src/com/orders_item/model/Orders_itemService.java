package com.orders_item.model;

import java.util.List;
import java.util.Map;

import com.product.model.ProductVO;

public class Orders_itemService {
	private Orders_item_interface dao;
	
	public Orders_itemService() {
		dao = new Orders_itemDAO();
	}
//Insert
	
	
	
	
	

	
	public List<Orders_itemVO> getAll() {
		return dao.getAll();
	}


}

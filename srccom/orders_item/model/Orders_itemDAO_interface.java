package com.orders_item.model;

import java.util.* 

public interface Orders_itemDAO_interface {
	public void insert(Orders_itemVO orders_itemVO);
	public void update(Orders_itemVO orders_itemVO);
	public void delete(Integer empno);
	public Orders_itemVO findByPrimaryKey(Integer empno);
	public List<Orders_itemVO> getAll();
}
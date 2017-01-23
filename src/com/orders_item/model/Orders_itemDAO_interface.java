package com.orders_item.model;

import java.util.*; 

public interface Orders_itemDAO_interface {
	public void insert(Orders_itemVO orders_itemVO);
	public void update(Orders_itemVO orders_itemVO);
	public void delete1(Integer orders_no);
	public Orders_itemVO findByPrimaryKey1(Integer orders_no);
	public void delete2(Integer product_no);
	public Orders_itemVO findByPrimaryKey2(Integer product_no);
	public List<Orders_itemVO> getAll();
}
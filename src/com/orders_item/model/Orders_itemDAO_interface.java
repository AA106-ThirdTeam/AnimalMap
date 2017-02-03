package com.orders_item.model;

import java.util.*; 

public interface Orders_itemDAO_interface {
	public void insert(Orders_itemVO orders_itemVO);
	public void update(Orders_itemVO orders_itemVO);
    public void delete_By_orders_no(String orders_no);
	public Orders_itemVO findByPrimaryKey_By_orders_no(String orders_no);
    public void delete_By_product_no(String product_no);
	public Orders_itemVO findByPrimaryKey_By_product_no(String product_no);
	public List<Orders_itemVO> getAll();
}
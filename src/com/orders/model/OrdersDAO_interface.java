package com.orders.model;

import java.util.*; 

public interface OrdersDAO_interface {
	public void insert(OrdersVO ordersVO);
	public void update(OrdersVO ordersVO);
    public void delete(String orders_no);
	public OrdersVO findByPrimaryKey(String orders_no);
	public List<OrdersVO> getAll();
}
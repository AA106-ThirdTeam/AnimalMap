package com.orders.model;

import java.util.* 

public interface OrdersDAO_interface {
	public void insert(OrdersVO ordersVO);
	public void update(OrdersVO ordersVO);
	public void delete(Integer empno);
	public OrdersVO findByPrimaryKey(Integer empno);
	public List<OrdersVO> getAll();
}
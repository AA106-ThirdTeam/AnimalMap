package com.orders.model;

import java.util.*;

import com.orders_item.model.Orders_itemVO;

public interface OrdersDAO_interface {
		public void insert(OrdersVO ordersVO);
		public void update(OrdersVO ordersVO);
		public void delete(String orders_no);
		public OrdersVO findByPrimaryKey(String orders_no);
		public List<OrdersVO> getAll();
		//查詢某訂單的所有細項
		public Set<Orders_itemVO> getOrders_itemByOrders_no(String orders_no);
		
		//同時新增訂單與訂單明細
		public void insertWithOrders_item(OrdersVO ordersVO , List<Orders_itemVO> list);
	
}

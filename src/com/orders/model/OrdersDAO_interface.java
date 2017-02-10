package com.orders.model;

import java.util.*; 

public interface OrdersDAO_interface {
	public void insert(OrdersVO ordersVO);
	public void update(OrdersVO ordersVO);
    public void delete(String orders_no);
	public OrdersVO findByPrimaryKey(String orders_no);
	public List<OrdersVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<OrdersVO> getAll(Map<String, String[]> map);

    //查詢某訂單的會員編號(一對多)(回傳 Set)
    public Set<OrdersVO> getOrderssByMem_Id(String mem_Id);
}

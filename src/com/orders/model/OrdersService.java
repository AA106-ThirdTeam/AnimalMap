package com.orders.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.orders_item.model.Orders_itemVO;
import com.product.model.ProductVO;

public class OrdersService {
	private OrdersDAO_interface dao;
	
	public OrdersService(){
		dao = new OrdersDAO();
	}
//Insert
	public OrdersVO addOrders(String mem_id,String orders_receiver,
			String post_no,String post_adp_city,String post_town,
			String post_road,String orders_phone,Integer collect_mode_no,
			java.sql.Date orders_date,java.sql.Date orders_ship_date,
			Integer orders_total,Integer orders_status,Integer orders_credit){
		
		OrdersVO ordersVO = new OrdersVO();
		ordersVO.setMem_id(mem_id);
		ordersVO.setOrders_receiver(orders_receiver);
		ordersVO.setPost_no(post_no);
		ordersVO.setPost_adp_city(post_adp_city);
		ordersVO.setPost_town(post_town);
		ordersVO.setPost_road(post_road);
		ordersVO.setOrders_phone(orders_phone);
		ordersVO.setCollect_mode_no(collect_mode_no);
		ordersVO.setOrders_date(orders_date);
		ordersVO.setOrders_ship_date(orders_ship_date);
		ordersVO.setOrders_total(orders_total);
		ordersVO.setOrders_status(orders_status);
		ordersVO.setOrders_credit(orders_credit);
		dao.insert(ordersVO);
		
		return ordersVO;
	}
//Update
	public OrdersVO updateProduct(String orders_no,String mem_id,String orders_receiver,
			String post_no,String post_adp_city,String post_town,
			String post_road,String orders_phone,Integer collect_mode_no,
			java.sql.Date orders_date,java.sql.Date orders_ship_date,
			Integer orders_total,Integer orders_status,Integer orders_credit){
		
		
		OrdersVO ordersVO = new OrdersVO();
		ordersVO.setOrders_no(orders_no);
		ordersVO.setMem_id(mem_id);
		ordersVO.setOrders_receiver(orders_receiver);
		ordersVO.setPost_no(post_no);
		ordersVO.setPost_adp_city(post_adp_city);
		ordersVO.setPost_town(post_town);
		ordersVO.setPost_road(post_road);
		ordersVO.setOrders_phone(orders_phone);
		ordersVO.setCollect_mode_no(collect_mode_no);
		ordersVO.setOrders_date(orders_date);
		ordersVO.setOrders_ship_date(orders_ship_date);
		ordersVO.setOrders_total(orders_total);
		ordersVO.setOrders_status(orders_status);
		ordersVO.setOrders_credit(orders_credit);
		dao.update(ordersVO);
		
		return ordersVO;

	}
	
	public void deleteOrders(String orders_no) {
		dao.delete(orders_no);
	}

	public OrdersVO getOneOrders(String orders_no) {
		return dao.findByPrimaryKey(orders_no);
	}

	public Set<Orders_itemVO> getOrders_itemByOrders_no(String orders_no){
		return dao.getOrders_itemByOrders_no(orders_no);
	}
	public List<OrdersVO> getAll() {
		return dao.getAll();
	}


}

package com.orders.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:訂單<br>
 *	英文:orders<br>
 */ 
public class OrdersService{
	private OrdersDAO_interface dao; 

	public OrdersService(){
		dao = new OrdersDAO();
	}

	//====以下是insert方法====
	public OrdersVO addOrders(String mem_Id,String orders_receiver,String post_no,String post_adp_city,String post_town,String post_road,Integer orders_phone,Integer collect_mode_no,java.sql.Date orders_date,java.sql.Date orders_ship_date,Integer orders_total,Integer orders_status,Integer orders_credit){
		OrdersVO ordersVO = new OrdersVO();

		ordersVO.setMem_Id(mem_Id);
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

	//====以下是update方法====
	public OrdersVO updateOrders(String orders_no,String mem_Id,String orders_receiver,String post_no,String post_adp_city,String post_town,String post_road,Integer orders_phone,Integer collect_mode_no,java.sql.Date orders_date,java.sql.Date orders_ship_date,Integer orders_total,Integer orders_status,Integer orders_credit){

		OrdersVO ordersVO = new OrdersVO();

		ordersVO.setOrders_no(orders_no);
		ordersVO.setMem_Id(mem_Id);
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

	//====以下是delete方法====
	public void deleteOrders(String  orders_no){
		dao.delete(orders_no);
	}

	//====以下是getOne方法====
	public OrdersVO getOneOrders(String  orders_no){
		return dao.findByPrimaryKey(orders_no);
	}

	//====以下是getAll方法====
	public List<OrdersVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<OrdersVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<OrdersVO> getOrderssByMem_Id(String mem_Id) {
        return dao.getOrderssByMem_Id(mem_Id);
    }
}

package com.orders.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class OrdersVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String orders_no; 
	private	String mem_Id; 
	private	String orders_receiver; 
	private	String post_no; 
	private	String post_adp_city; 
	private	String post_town; 
	private	String post_road; 
	private	Integer orders_phone; 
	private	Integer collect_mode_no; 
	private	Date orders_date; 
	private	Date orders_ship_date; 
	private	Integer orders_total; 
	private	Integer orders_status; 
	private	Integer orders_credit; 
	public	String getOrders_no() { 
		return this.orders_no;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	String getOrders_receiver() { 
		return this.orders_receiver;
	} 
	public	String getPost_no() { 
		return this.post_no;
	} 
	public	String getPost_adp_city() { 
		return this.post_adp_city;
	} 
	public	String getPost_town() { 
		return this.post_town;
	} 
	public	String getPost_road() { 
		return this.post_road;
	} 
	public	Integer getOrders_phone() { 
		return this.orders_phone;
	} 
	public	Integer getCollect_mode_no() { 
		return this.collect_mode_no;
	} 
	public	Date getOrders_date() { 
		return this.orders_date;
	} 
	public	Date getOrders_ship_date() { 
		return this.orders_ship_date;
	} 
	public	Integer getOrders_total() { 
		return this.orders_total;
	} 
	public	Integer getOrders_status() { 
		return this.orders_status;
	} 
	public	Integer getOrders_credit() { 
		return this.orders_credit;
	} 
	public	void setOrders_no(String aOrders_no) { 
		this.orders_no = aOrders_no; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setOrders_receiver(String aOrders_receiver) { 
		this.orders_receiver = aOrders_receiver; 
	} 
 
	public	void setPost_no(String aPost_no) { 
		this.post_no = aPost_no; 
	} 
 
	public	void setPost_adp_city(String aPost_adp_city) { 
		this.post_adp_city = aPost_adp_city; 
	} 
 
	public	void setPost_town(String aPost_town) { 
		this.post_town = aPost_town; 
	} 
 
	public	void setPost_road(String aPost_road) { 
		this.post_road = aPost_road; 
	} 
 
	public	void setOrders_phone(Integer aOrders_phone) { 
		this.orders_phone = aOrders_phone; 
	} 
 
	public	void setCollect_mode_no(Integer aCollect_mode_no) { 
		this.collect_mode_no = aCollect_mode_no; 
	} 
 
	public	void setOrders_date(Date aOrders_date) { 
		this.orders_date = aOrders_date; 
	} 
 
	public	void setOrders_ship_date(Date aOrders_ship_date) { 
		this.orders_ship_date = aOrders_ship_date; 
	} 
 
	public	void setOrders_total(Integer aOrders_total) { 
		this.orders_total = aOrders_total; 
	} 
 
	public	void setOrders_status(Integer aOrders_status) { 
		this.orders_status = aOrders_status; 
	} 
 
	public	void setOrders_credit(Integer aOrders_credit) { 
		this.orders_credit = aOrders_credit; 
	} 
 
}
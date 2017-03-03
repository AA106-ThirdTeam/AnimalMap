package com.orders.model;

import java.sql.Date;


public class OrdersVO implements java.io.Serializable{
	
	private String orders_no;
	private String mem_id;
	private String orders_receiver;
	private String post_no;
	private String post_adp_city;
	private String post_town;
	private String post_road;
	private String orders_phone;
	private Integer collect_mode_no;
	private Date orders_date;
	private Date orders_ship_date;
	private Integer orders_total;
	private Integer orders_status;
	private Integer orders_credit;

	public String getOrders_no() {
		return orders_no;
	}
	public void setOrders_no(String orders_no) {
		this.orders_no = orders_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getOrders_receiver() {
		return orders_receiver;
	}
	public void setOrders_receiver(String orders_receiver) {
		this.orders_receiver = orders_receiver;
	}
	public String getPost_no() {
		return post_no;
	}
	public void setPost_no(String post_no) {
		this.post_no = post_no;
	}
	public String getPost_adp_city() {
		return post_adp_city;
	}
	public void setPost_adp_city(String post_adp_city) {
		this.post_adp_city = post_adp_city;
	}
	public String getPost_town() {
		return post_town;
	}
	public void setPost_town(String post_town) {
		this.post_town = post_town;
	}
	public String getPost_road() {
		return post_road;
	}
	public void setPost_road(String post_road) {
		this.post_road = post_road;
	}
	public String getOrders_phone() {
		return orders_phone;
	}
	public void setOrders_phone(String orders_phone) {
		this.orders_phone = orders_phone;
	}
	public Integer getCollect_mode_no() {
		return collect_mode_no;
	}
	public void setCollect_mode_no(Integer collect_mode_no) {
		this.collect_mode_no = collect_mode_no;
	}
	public Date getOrders_date() {
		return orders_date;
	}
	public void setOrders_date(Date orders_date) {
		this.orders_date = orders_date;
	}
	public Date getOrders_ship_date() {
		return orders_ship_date;
	}
	public void setOrders_ship_date(Date orders_ship_date) {
		this.orders_ship_date = orders_ship_date;
	}
	public Integer getOrders_total() {
		return orders_total;
	}
	public void setOrders_total(Integer orders_total) {
		this.orders_total = orders_total;
	}
	public Integer getOrders_status() {
		return orders_status;
	}
	public void setOrders_status(Integer orders_status) {
		this.orders_status = orders_status;
	}
	public Integer getOrders_credit() {
		return orders_credit;
	}
	public void setOrders_credit(Integer orders_credit) {
		this.orders_credit = orders_credit;
	}

}

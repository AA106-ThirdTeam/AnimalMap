package com.orders.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:訂單<br>
 *	英文:orders<br>
 */ 
public class OrdersVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'訂單編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String orders_no; 
 
	/** 
 	*	欄位名稱:'會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:10<br>
	*	限制條件:NOT NULL FK<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'收件人 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String orders_receiver; 
 
	/** 
 	*	欄位名稱:'郵遞區號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:5<br>
	*	限制條件:<br>
 	*/ 
	private	String post_no; 
 
	/** 
 	*	欄位名稱:'縣市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String post_adp_city; 
 
	/** 
 	*	欄位名稱:'鄉鎮 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String post_town; 
 
	/** 
 	*	欄位名稱:'路 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String post_road; 
 
	/** 
 	*	欄位名稱:'收件人電話 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:10<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	Integer orders_phone; 
 
	/** 
 	*	欄位名稱:'付款方式 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:1<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	Integer collect_mode_no; 
 
	/** 
 	*	欄位名稱:'下單日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	Date orders_date; 
 
	/** 
 	*	欄位名稱:'出貨日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date orders_ship_date; 
 
	/** 
 	*	欄位名稱:'總金額 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:16<br>
	*	限制條件:<br>
 	*/ 
	private	Integer orders_total; 
 
	/** 
 	*	欄位名稱:'處理狀態 | PS: 1處理中2.已完成'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	Integer orders_status; 
 
	/** 
 	*	欄位名稱:'信用卡卡號 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:16<br>
	*	限制條件:<br>
 	*/ 
	private	Integer orders_credit; 
 
	/** 
 	*	欄位名稱:'訂單編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getOrders_no() { 
		return this.orders_no;
	} 
	/** 
 	*	欄位名稱:'會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:10<br>
	*	限制條件:NOT NULL FK<br>
 	*/ 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	/** 
 	*	欄位名稱:'收件人 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getOrders_receiver() { 
		return this.orders_receiver;
	} 
	/** 
 	*	欄位名稱:'郵遞區號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:5<br>
	*	限制條件:<br>
 	*/ 
	public	String getPost_no() { 
		return this.post_no;
	} 
	/** 
 	*	欄位名稱:'縣市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getPost_adp_city() { 
		return this.post_adp_city;
	} 
	/** 
 	*	欄位名稱:'鄉鎮 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getPost_town() { 
		return this.post_town;
	} 
	/** 
 	*	欄位名稱:'路 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getPost_road() { 
		return this.post_road;
	} 
	/** 
 	*	欄位名稱:'收件人電話 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:10<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	Integer getOrders_phone() { 
		return this.orders_phone;
	} 
	/** 
 	*	欄位名稱:'付款方式 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:1<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	Integer getCollect_mode_no() { 
		return this.collect_mode_no;
	} 
	/** 
 	*	欄位名稱:'下單日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	Date getOrders_date() { 
		return this.orders_date;
	} 
	/** 
 	*	欄位名稱:'出貨日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getOrders_ship_date() { 
		return this.orders_ship_date;
	} 
	/** 
 	*	欄位名稱:'總金額 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:16<br>
	*	限制條件:<br>
 	*/ 
	public	Integer getOrders_total() { 
		return this.orders_total;
	} 
	/** 
 	*	欄位名稱:'處理狀態 | PS: 1處理中2.已完成'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	Integer getOrders_status() { 
		return this.orders_status;
	} 
	/** 
 	*	欄位名稱:'信用卡卡號 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:16<br>
	*	限制條件:<br>
 	*/ 
	public	Integer getOrders_credit() { 
		return this.orders_credit;
	} 
	/** 
 	*	欄位名稱:'訂單編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setOrders_no(String aOrders_no) { 
		this.orders_no = aOrders_no; 
	} 
 
	/** 
 	*	欄位名稱:'會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:10<br>
	*	限制條件:NOT NULL FK<br>
 	*/ 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	/** 
 	*	欄位名稱:'收件人 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setOrders_receiver(String aOrders_receiver) { 
		this.orders_receiver = aOrders_receiver; 
	} 
 
	/** 
 	*	欄位名稱:'郵遞區號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:5<br>
	*	限制條件:<br>
 	*/ 
	public	void setPost_no(String aPost_no) { 
		this.post_no = aPost_no; 
	} 
 
	/** 
 	*	欄位名稱:'縣市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setPost_adp_city(String aPost_adp_city) { 
		this.post_adp_city = aPost_adp_city; 
	} 
 
	/** 
 	*	欄位名稱:'鄉鎮 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setPost_town(String aPost_town) { 
		this.post_town = aPost_town; 
	} 
 
	/** 
 	*	欄位名稱:'路 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setPost_road(String aPost_road) { 
		this.post_road = aPost_road; 
	} 
 
	/** 
 	*	欄位名稱:'收件人電話 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:10<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setOrders_phone(Integer aOrders_phone) { 
		this.orders_phone = aOrders_phone; 
	} 
 
	/** 
 	*	欄位名稱:'付款方式 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:1<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setCollect_mode_no(Integer aCollect_mode_no) { 
		this.collect_mode_no = aCollect_mode_no; 
	} 
 
	/** 
 	*	欄位名稱:'下單日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setOrders_date(Date aOrders_date) { 
		this.orders_date = aOrders_date; 
	} 
 
	/** 
 	*	欄位名稱:'出貨日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setOrders_ship_date(Date aOrders_ship_date) { 
		this.orders_ship_date = aOrders_ship_date; 
	} 
 
	/** 
 	*	欄位名稱:'總金額 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:16<br>
	*	限制條件:<br>
 	*/ 
	public	void setOrders_total(Integer aOrders_total) { 
		this.orders_total = aOrders_total; 
	} 
 
	/** 
 	*	欄位名稱:'處理狀態 | PS: 1處理中2.已完成'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setOrders_status(Integer aOrders_status) { 
		this.orders_status = aOrders_status; 
	} 
 
	/** 
 	*	欄位名稱:'信用卡卡號 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:16<br>
	*	限制條件:<br>
 	*/ 
	public	void setOrders_credit(Integer aOrders_credit) { 
		this.orders_credit = aOrders_credit; 
	} 
 
}
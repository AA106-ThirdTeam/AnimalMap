package com.orders_item.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	訂單明細<br>
 *	英文:orders_item<br>
 */ 
public class Orders_itemVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'訂單編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK FK<br>
 	*/ 
	private	String orders_no; 
 
	/** 
 	*	欄位名稱:'商品編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK FK<br>
 	*/ 
	private	String product_no; 
 
	/** 
 	*	欄位名稱:'訂購數量 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:<br>
 	*/ 
	private	Integer commodities_amout; 
 
	/** 
 	*	欄位名稱:'商品售價 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:<br>
 	*/ 
	private	Integer selling_price; 
 
	/** 
 	*	欄位名稱:'訂單編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK FK<br>
 	*/ 
	public	String getOrders_no() { 
		return this.orders_no;
	} 
	/** 
 	*	欄位名稱:'商品編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK FK<br>
 	*/ 
	public	String getProduct_no() { 
		return this.product_no;
	} 
	/** 
 	*	欄位名稱:'訂購數量 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:<br>
 	*/ 
	public	Integer getCommodities_amout() { 
		return this.commodities_amout;
	} 
	/** 
 	*	欄位名稱:'商品售價 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:<br>
 	*/ 
	public	Integer getSelling_price() { 
		return this.selling_price;
	} 
	/** 
 	*	欄位名稱:'訂單編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK FK<br>
 	*/ 
	public	void setOrders_no(String aOrders_no) { 
		this.orders_no = aOrders_no; 
	} 
 
	/** 
 	*	欄位名稱:'商品編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK FK<br>
 	*/ 
	public	void setProduct_no(String aProduct_no) { 
		this.product_no = aProduct_no; 
	} 
 
	/** 
 	*	欄位名稱:'訂購數量 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:<br>
 	*/ 
	public	void setCommodities_amout(Integer aCommodities_amout) { 
		this.commodities_amout = aCommodities_amout; 
	} 
 
	/** 
 	*	欄位名稱:'商品售價 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:<br>
 	*/ 
	public	void setSelling_price(Integer aSelling_price) { 
		this.selling_price = aSelling_price; 
	} 
 
}
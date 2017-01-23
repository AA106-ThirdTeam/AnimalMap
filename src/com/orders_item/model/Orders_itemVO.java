package com.orders_item.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class Orders_itemVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String orders_no; 
	private	String product_no; 
	private	Integer commodities_amout; 
	private	Integer selling_price; 
	public	String getOrders_no() { 
		return this.orders_no;
	} 
	public	String getProduct_no() { 
		return this.product_no;
	} 
	public	Integer getCommodities_amout() { 
		return this.commodities_amout;
	} 
	public	Integer getSelling_price() { 
		return this.selling_price;
	} 
	public	void setOrders_no(String aOrders_no) { 
		this.orders_no = aOrders_no; 
	} 
 
	public	void setProduct_no(String aProduct_no) { 
		this.product_no = aProduct_no; 
	} 
 
	public	void setCommodities_amout(Integer aCommodities_amout) { 
		this.commodities_amout = aCommodities_amout; 
	} 
 
	public	void setSelling_price(Integer aSelling_price) { 
		this.selling_price = aSelling_price; 
	} 
 
}
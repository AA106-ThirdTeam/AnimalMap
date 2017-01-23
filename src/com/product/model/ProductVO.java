package com.product.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class ProductVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String product_no; 
	private	String product_name; 
	private	String product_introduction; 
	private	Integer product_price; 
	private	Integer product_stock; 
	private	byte[] product_picture_large; 
	private	byte[] product_picture_small; 
	private	Integer product_status; 
	private	Date product_create_date; 
	private	String product_info; 
	private	Integer product_kind_no; 
	public	String getProduct_no() { 
		return this.product_no;
	} 
	public	String getProduct_name() { 
		return this.product_name;
	} 
	public	String getProduct_introduction() { 
		return this.product_introduction;
	} 
	public	Integer getProduct_price() { 
		return this.product_price;
	} 
	public	Integer getProduct_stock() { 
		return this.product_stock;
	} 
	public	byte[] getProduct_picture_large() { 
		return this.product_picture_large;
	} 
	public	byte[] getProduct_picture_small() { 
		return this.product_picture_small;
	} 
	public	Integer getProduct_status() { 
		return this.product_status;
	} 
	public	Date getProduct_create_date() { 
		return this.product_create_date;
	} 
	public	String getProduct_info() { 
		return this.product_info;
	} 
	public	Integer getProduct_kind_no() { 
		return this.product_kind_no;
	} 
	public	void setProduct_no(String aProduct_no) { 
		this.product_no = aProduct_no; 
	} 
 
	public	void setProduct_name(String aProduct_name) { 
		this.product_name = aProduct_name; 
	} 
 
	public	void setProduct_introduction(String aProduct_introduction) { 
		this.product_introduction = aProduct_introduction; 
	} 
 
	public	void setProduct_price(Integer aProduct_price) { 
		this.product_price = aProduct_price; 
	} 
 
	public	void setProduct_stock(Integer aProduct_stock) { 
		this.product_stock = aProduct_stock; 
	} 
 
	public	void setProduct_picture_large(byte[] aProduct_picture_large) { 
		this.product_picture_large = aProduct_picture_large; 
	} 
 
	public	void setProduct_picture_small(byte[] aProduct_picture_small) { 
		this.product_picture_small = aProduct_picture_small; 
	} 
 
	public	void setProduct_status(Integer aProduct_status) { 
		this.product_status = aProduct_status; 
	} 
 
	public	void setProduct_create_date(Date aProduct_create_date) { 
		this.product_create_date = aProduct_create_date; 
	} 
 
	public	void setProduct_info(String aProduct_info) { 
		this.product_info = aProduct_info; 
	} 
 
	public	void setProduct_kind_no(Integer aProduct_kind_no) { 
		this.product_kind_no = aProduct_kind_no; 
	} 
 
}
package com.product_kind.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:商品類別<br>
 *	英文:product_kind<br>
 */ 
public class Product_kindVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String product_kind_no; 
	private	String product_kind_name; 
	public	String getProduct_kind_no() { 
		return this.product_kind_no;
	} 
	public	String getProduct_kind_name() { 
		return this.product_kind_name;
	} 
	public	void setProduct_kind_no(String aProduct_kind_no) { 
		this.product_kind_no = aProduct_kind_no; 
	} 
 
	public	void setProduct_kind_name(String aProduct_kind_name) { 
		this.product_kind_name = aProduct_kind_name; 
	} 
 
}
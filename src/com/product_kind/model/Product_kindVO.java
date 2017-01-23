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
	/** 
 	*	欄位名稱:'商品類別編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:5<br>
	*	限制條件:PK<br>
 	*/ 
	private	String product_kind_no; 
 
	/** 
 	*	欄位名稱:'商品類別名稱 | PS: NOT NULL'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:10<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String product_kind_name; 
 
	/** 
 	*	欄位名稱:'商品類別編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:5<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getProduct_kind_no() { 
		return this.product_kind_no;
	} 
	/** 
 	*	欄位名稱:'商品類別名稱 | PS: NOT NULL'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:10<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getProduct_kind_name() { 
		return this.product_kind_name;
	} 
	/** 
 	*	欄位名稱:'商品類別編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:5<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setProduct_kind_no(String aProduct_kind_no) { 
		this.product_kind_no = aProduct_kind_no; 
	} 
 
	/** 
 	*	欄位名稱:'商品類別名稱 | PS: NOT NULL'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:10<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setProduct_kind_name(String aProduct_kind_name) { 
		this.product_kind_name = aProduct_kind_name; 
	} 
 
}
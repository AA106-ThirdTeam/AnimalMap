package com.product.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	商品<br>
 *	英文:product<br>
 */ 
public class ProductVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'商品編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String product_no; 
 
	/** 
 	*	欄位名稱:'商品名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String product_name; 
 
	/** 
 	*	欄位名稱:'商品簡介 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	private	String product_introduction; 
 
	/** 
 	*	欄位名稱:'商品價格 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	Integer product_price; 
 
	/** 
 	*	欄位名稱:'商品庫存量 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	Integer product_stock; 
 
	/** 
 	*	欄位名稱:'商品圖片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	byte[] product_picture_large; 
 
	/** 
 	*	欄位名稱:'商品圖片（縮圖） | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	byte[] product_picture_small; 
 
	/** 
 	*	欄位名稱:'商品上下架狀態 | PS: 1.上架2.下架'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	Integer product_status; 
 
	/** 
 	*	欄位名稱:'商品建立日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	Date product_create_date; 
 
	/** 
 	*	欄位名稱:'商品資訊 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	private	String product_info; 
 
	/** 
 	*	欄位名稱:'商品類別編號 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	Integer product_kind_no; 
 
	/** 
 	*	欄位名稱:'商品編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getProduct_no() { 
		return this.product_no;
	} 
	/** 
 	*	欄位名稱:'商品名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getProduct_name() { 
		return this.product_name;
	} 
	/** 
 	*	欄位名稱:'商品簡介 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	public	String getProduct_introduction() { 
		return this.product_introduction;
	} 
	/** 
 	*	欄位名稱:'商品價格 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	Integer getProduct_price() { 
		return this.product_price;
	} 
	/** 
 	*	欄位名稱:'商品庫存量 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	Integer getProduct_stock() { 
		return this.product_stock;
	} 
	/** 
 	*	欄位名稱:'商品圖片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	byte[] getProduct_picture_large() { 
		return this.product_picture_large;
	} 
	/** 
 	*	欄位名稱:'商品圖片（縮圖） | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	byte[] getProduct_picture_small() { 
		return this.product_picture_small;
	} 
	/** 
 	*	欄位名稱:'商品上下架狀態 | PS: 1.上架2.下架'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	Integer getProduct_status() { 
		return this.product_status;
	} 
	/** 
 	*	欄位名稱:'商品建立日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	Date getProduct_create_date() { 
		return this.product_create_date;
	} 
	/** 
 	*	欄位名稱:'商品資訊 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	public	String getProduct_info() { 
		return this.product_info;
	} 
	/** 
 	*	欄位名稱:'商品類別編號 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	Integer getProduct_kind_no() { 
		return this.product_kind_no;
	} 
	/** 
 	*	欄位名稱:'商品編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setProduct_no(String aProduct_no) { 
		this.product_no = aProduct_no; 
	} 
 
	/** 
 	*	欄位名稱:'商品名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setProduct_name(String aProduct_name) { 
		this.product_name = aProduct_name; 
	} 
 
	/** 
 	*	欄位名稱:'商品簡介 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	public	void setProduct_introduction(String aProduct_introduction) { 
		this.product_introduction = aProduct_introduction; 
	} 
 
	/** 
 	*	欄位名稱:'商品價格 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setProduct_price(Integer aProduct_price) { 
		this.product_price = aProduct_price; 
	} 
 
	/** 
 	*	欄位名稱:'商品庫存量 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setProduct_stock(Integer aProduct_stock) { 
		this.product_stock = aProduct_stock; 
	} 
 
	/** 
 	*	欄位名稱:'商品圖片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setProduct_picture_large(byte[] aProduct_picture_large) { 
		this.product_picture_large = aProduct_picture_large; 
	} 
 
	/** 
 	*	欄位名稱:'商品圖片（縮圖） | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setProduct_picture_small(byte[] aProduct_picture_small) { 
		this.product_picture_small = aProduct_picture_small; 
	} 
 
	/** 
 	*	欄位名稱:'商品上下架狀態 | PS: 1.上架2.下架'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setProduct_status(Integer aProduct_status) { 
		this.product_status = aProduct_status; 
	} 
 
	/** 
 	*	欄位名稱:'商品建立日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setProduct_create_date(Date aProduct_create_date) { 
		this.product_create_date = aProduct_create_date; 
	} 
 
	/** 
 	*	欄位名稱:'商品資訊 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	public	void setProduct_info(String aProduct_info) { 
		this.product_info = aProduct_info; 
	} 
 
	/** 
 	*	欄位名稱:'商品類別編號 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setProduct_kind_no(Integer aProduct_kind_no) { 
		this.product_kind_no = aProduct_kind_no; 
	} 
 
}
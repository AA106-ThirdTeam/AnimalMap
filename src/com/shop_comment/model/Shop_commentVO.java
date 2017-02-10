package com.shop_comment.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	商家留言<br>
 *	英文:shop_comment<br>
 */ 
public class Shop_commentVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'診所留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String shopComment_Id; 
 
	/** 
 	*	欄位名稱:'發送會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String shopComment_MemId; 
 
	/** 
 	*	欄位名稱:'商店編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String shopComment_ShopId; 
 
	/** 
 	*	欄位名稱:'發送內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	private	String shopComment_content; 
 
	/** 
 	*	欄位名稱:'發送時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date shopComment_SendTime; 
 
	/** 
 	*	欄位名稱:'診所留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getShopComment_Id() { 
		return this.shopComment_Id;
	} 
	/** 
 	*	欄位名稱:'發送會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getShopComment_MemId() { 
		return this.shopComment_MemId;
	} 
	/** 
 	*	欄位名稱:'商店編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getShopComment_ShopId() { 
		return this.shopComment_ShopId;
	} 
	/** 
 	*	欄位名稱:'發送內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	public	String getShopComment_content() { 
		return this.shopComment_content;
	} 
	/** 
 	*	欄位名稱:'發送時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getShopComment_SendTime() { 
		return this.shopComment_SendTime;
	} 
	/** 
 	*	欄位名稱:'診所留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setShopComment_Id(String aShopComment_Id) { 
		this.shopComment_Id = aShopComment_Id; 
	} 
 
	/** 
 	*	欄位名稱:'發送會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setShopComment_MemId(String aShopComment_MemId) { 
		this.shopComment_MemId = aShopComment_MemId; 
	} 
 
	/** 
 	*	欄位名稱:'商店編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setShopComment_ShopId(String aShopComment_ShopId) { 
		this.shopComment_ShopId = aShopComment_ShopId; 
	} 
 
	/** 
 	*	欄位名稱:'發送內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	public	void setShopComment_content(String aShopComment_content) { 
		this.shopComment_content = aShopComment_content; 
	} 
 
	/** 
 	*	欄位名稱:'發送時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setShopComment_SendTime(Date aShopComment_SendTime) { 
		this.shopComment_SendTime = aShopComment_SendTime; 
	} 
 
}
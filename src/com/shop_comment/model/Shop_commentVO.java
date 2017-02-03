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
	private	String shopComm_Id; 
 
	/** 
 	*	欄位名稱:'發送會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String shopComm_MemId; 
 
	/** 
 	*	欄位名稱:'商店編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String shopComm_ShopId; 
 
	/** 
 	*	欄位名稱:'發送內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	private	String shopComm_content; 
 
	/** 
 	*	欄位名稱:'發送時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date shopComm_SendTime; 
 
	/** 
 	*	欄位名稱:'診所留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getShopComm_Id() { 
		return this.shopComm_Id;
	} 
	/** 
 	*	欄位名稱:'發送會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getShopComm_MemId() { 
		return this.shopComm_MemId;
	} 
	/** 
 	*	欄位名稱:'商店編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getShopComm_ShopId() { 
		return this.shopComm_ShopId;
	} 
	/** 
 	*	欄位名稱:'發送內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	public	String getShopComm_content() { 
		return this.shopComm_content;
	} 
	/** 
 	*	欄位名稱:'發送時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getShopComm_SendTime() { 
		return this.shopComm_SendTime;
	} 
	/** 
 	*	欄位名稱:'診所留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setShopComm_Id(String aShopComm_Id) { 
		this.shopComm_Id = aShopComm_Id; 
	} 
 
	/** 
 	*	欄位名稱:'發送會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setShopComm_MemId(String aShopComm_MemId) { 
		this.shopComm_MemId = aShopComm_MemId; 
	} 
 
	/** 
 	*	欄位名稱:'商店編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setShopComm_ShopId(String aShopComm_ShopId) { 
		this.shopComm_ShopId = aShopComm_ShopId; 
	} 
 
	/** 
 	*	欄位名稱:'發送內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	public	void setShopComm_content(String aShopComm_content) { 
		this.shopComm_content = aShopComm_content; 
	} 
 
	/** 
 	*	欄位名稱:'發送時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setShopComm_SendTime(Date aShopComm_SendTime) { 
		this.shopComm_SendTime = aShopComm_SendTime; 
	} 
 
}
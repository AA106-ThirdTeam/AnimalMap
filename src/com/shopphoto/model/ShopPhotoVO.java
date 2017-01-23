package com.shopphoto.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:商家相片<br>
 *	英文:shopPhoto<br>
 */ 
public class ShopPhotoVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'相片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String shopPhoto_Id; 
 
	/** 
 	*	欄位名稱:'商家編號(相片擁有商家) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String shopPhoto_ShopId; 
 
	/** 
 	*	欄位名稱:'相片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	byte[] shopPhoto_photo; 
 
	/** 
 	*	欄位名稱:'是否為大頭貼相片 | PS: 0為否，1為是'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String isDisp_shopPhoto; 
 
	/** 
 	*	欄位名稱:'相片名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:<br>
 	*/ 
	private	String shopPhoto_name; 
 
	/** 
 	*	欄位名稱:'相片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	private	String shopPhoto_extent; 
 
	/** 
 	*	欄位名稱:'相片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getShopPhoto_Id() { 
		return this.shopPhoto_Id;
	} 
	/** 
 	*	欄位名稱:'商家編號(相片擁有商家) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getShopPhoto_ShopId() { 
		return this.shopPhoto_ShopId;
	} 
	/** 
 	*	欄位名稱:'相片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	byte[] getShopPhoto_photo() { 
		return this.shopPhoto_photo;
	} 
	/** 
 	*	欄位名稱:'是否為大頭貼相片 | PS: 0為否，1為是'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getIsDisp_shopPhoto() { 
		return this.isDisp_shopPhoto;
	} 
	/** 
 	*	欄位名稱:'相片名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:<br>
 	*/ 
	public	String getShopPhoto_name() { 
		return this.shopPhoto_name;
	} 
	/** 
 	*	欄位名稱:'相片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	String getShopPhoto_extent() { 
		return this.shopPhoto_extent;
	} 
	/** 
 	*	欄位名稱:'相片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setShopPhoto_Id(String aShopPhoto_Id) { 
		this.shopPhoto_Id = aShopPhoto_Id; 
	} 
 
	/** 
 	*	欄位名稱:'商家編號(相片擁有商家) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setShopPhoto_ShopId(String aShopPhoto_ShopId) { 
		this.shopPhoto_ShopId = aShopPhoto_ShopId; 
	} 
 
	/** 
 	*	欄位名稱:'相片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setShopPhoto_photo(byte[] aShopPhoto_photo) { 
		this.shopPhoto_photo = aShopPhoto_photo; 
	} 
 
	/** 
 	*	欄位名稱:'是否為大頭貼相片 | PS: 0為否，1為是'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setIsDisp_shopPhoto(String aIsDisp_shopPhoto) { 
		this.isDisp_shopPhoto = aIsDisp_shopPhoto; 
	} 
 
	/** 
 	*	欄位名稱:'相片名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:<br>
 	*/ 
	public	void setShopPhoto_name(String aShopPhoto_name) { 
		this.shopPhoto_name = aShopPhoto_name; 
	} 
 
	/** 
 	*	欄位名稱:'相片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	void setShopPhoto_extent(String aShopPhoto_extent) { 
		this.shopPhoto_extent = aShopPhoto_extent; 
	} 
 
}
package com.petshop.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	寵物商店<br>
 *	英文:petShop<br>
 */ 
public class PetShopVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'商家編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String shop_Id; 
 
	/** 
 	*	欄位名稱:'會員編號(負責人) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String shop_MemId; 
 
	/** 
 	*	欄位名稱:'商家名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String shop_name; 
 
	/** 
 	*	欄位名稱:'縣/市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String shop_city; 
 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	private	String shop_town; 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	private	String shop_road; 
 
	/** 
 	*	欄位名稱:'評價 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:30<br>
	*	限制條件:<br>
 	*/ 
	private	Integer shop_Eval; 
 
	/** 
 	*	欄位名稱:'URL | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:100<br>
	*	限制條件:<br>
 	*/ 
	private	String shop_URL; 
 
	/** 
 	*	欄位名稱:'開始營業時間 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	private	String shop_StartTime; 
 
	/** 
 	*	欄位名稱:'結束營業時間 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	private	String shop_EndTime; 
 
	/** 
 	*	欄位名稱:'電話 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	private	String shop_Tel; 
 
	/** 
 	*	欄位名稱:'商家敘述 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	private	String shop_Desc; 
 
	/** 
 	*	欄位名稱:'商家經度座標 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double shop_Long; 
 
	/** 
 	*	欄位名稱:'商家緯度座標 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double shop_Lat; 
 
	/** 
 	*	欄位名稱:'建立時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date shop_CreateTime; 
 
	/** 
 	*	欄位名稱:'物件顯示狀態 | PS: 1.顯示0.不顯示'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	String shop_visible; 
 
	/** 
 	*	欄位名稱:'商家編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getShop_Id() { 
		return this.shop_Id;
	} 
	/** 
 	*	欄位名稱:'會員編號(負責人) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getShop_MemId() { 
		return this.shop_MemId;
	} 
	/** 
 	*	欄位名稱:'商家名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getShop_name() { 
		return this.shop_name;
	} 
	/** 
 	*	欄位名稱:'縣/市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getShop_city() { 
		return this.shop_city;
	} 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	String getShop_town() { 
		return this.shop_town;
	} 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	String getShop_road() { 
		return this.shop_road;
	} 
	/** 
 	*	欄位名稱:'評價 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:30<br>
	*	限制條件:<br>
 	*/ 
	public	Integer getShop_Eval() { 
		return this.shop_Eval;
	} 
	/** 
 	*	欄位名稱:'URL | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:100<br>
	*	限制條件:<br>
 	*/ 
	public	String getShop_URL() { 
		return this.shop_URL;
	} 
	/** 
 	*	欄位名稱:'開始營業時間 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	String getShop_StartTime() { 
		return this.shop_StartTime;
	} 
	/** 
 	*	欄位名稱:'結束營業時間 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	String getShop_EndTime() { 
		return this.shop_EndTime;
	} 
	/** 
 	*	欄位名稱:'電話 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	String getShop_Tel() { 
		return this.shop_Tel;
	} 
	/** 
 	*	欄位名稱:'商家敘述 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	String getShop_Desc() { 
		return this.shop_Desc;
	} 
	/** 
 	*	欄位名稱:'商家經度座標 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getShop_Long() { 
		return this.shop_Long;
	} 
	/** 
 	*	欄位名稱:'商家緯度座標 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getShop_Lat() { 
		return this.shop_Lat;
	} 
	/** 
 	*	欄位名稱:'建立時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getShop_CreateTime() { 
		return this.shop_CreateTime;
	} 
	/** 
 	*	欄位名稱:'物件顯示狀態 | PS: 1.顯示0.不顯示'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	String getShop_visible() { 
		return this.shop_visible;
	} 
	/** 
 	*	欄位名稱:'商家編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setShop_Id(String aShop_Id) { 
		this.shop_Id = aShop_Id; 
	} 
 
	/** 
 	*	欄位名稱:'會員編號(負責人) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setShop_MemId(String aShop_MemId) { 
		this.shop_MemId = aShop_MemId; 
	} 
 
	/** 
 	*	欄位名稱:'商家名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setShop_name(String aShop_name) { 
		this.shop_name = aShop_name; 
	} 
 
	/** 
 	*	欄位名稱:'縣/市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setShop_city(String aShop_city) { 
		this.shop_city = aShop_city; 
	} 
 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	void setShop_town(String aShop_town) { 
		this.shop_town = aShop_town; 
	} 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	void setShop_road(String aShop_road) { 
		this.shop_road = aShop_road; 
	} 
 
	/** 
 	*	欄位名稱:'評價 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:30<br>
	*	限制條件:<br>
 	*/ 
	public	void setShop_Eval(Integer aShop_Eval) { 
		this.shop_Eval = aShop_Eval; 
	} 
 
	/** 
 	*	欄位名稱:'URL | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:100<br>
	*	限制條件:<br>
 	*/ 
	public	void setShop_URL(String aShop_URL) { 
		this.shop_URL = aShop_URL; 
	} 
 
	/** 
 	*	欄位名稱:'開始營業時間 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	void setShop_StartTime(String aShop_StartTime) { 
		this.shop_StartTime = aShop_StartTime; 
	} 
 
	/** 
 	*	欄位名稱:'結束營業時間 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	void setShop_EndTime(String aShop_EndTime) { 
		this.shop_EndTime = aShop_EndTime; 
	} 
 
	/** 
 	*	欄位名稱:'電話 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	void setShop_Tel(String aShop_Tel) { 
		this.shop_Tel = aShop_Tel; 
	} 
 
	/** 
 	*	欄位名稱:'商家敘述 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	void setShop_Desc(String aShop_Desc) { 
		this.shop_Desc = aShop_Desc; 
	} 
 
	/** 
 	*	欄位名稱:'商家經度座標 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setShop_Long(Double aShop_Long) { 
		this.shop_Long = aShop_Long; 
	} 
 
	/** 
 	*	欄位名稱:'商家緯度座標 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setShop_Lat(Double aShop_Lat) { 
		this.shop_Lat = aShop_Lat; 
	} 
 
	/** 
 	*	欄位名稱:'建立時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setShop_CreateTime(Date aShop_CreateTime) { 
		this.shop_CreateTime = aShop_CreateTime; 
	} 
 
	/** 
 	*	欄位名稱:'物件顯示狀態 | PS: 1.顯示0.不顯示'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setShop_visible(String aShop_visible) { 
		this.shop_visible = aShop_visible; 
	} 
 
}
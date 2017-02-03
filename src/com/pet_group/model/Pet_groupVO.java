package com.pet_group.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	揪團<br>
 *	英文:pet_group<br>
 */ 
public class Pet_groupVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'活動編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String grp_Id; 
 
	/** 
 	*	欄位名稱:'會員編號(負責人) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String grp_MemId; 
 
	/** 
 	*	欄位名稱:'名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String grp_name; 
 
	/** 
 	*	欄位名稱:'縣/市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String grp_city; 
 
	/** 
 	*	欄位名稱:'鄉鎮市區道路 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String grp_Addr; 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	private	String grp_road; 
 
	/** 
 	*	欄位名稱:'開始時間 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String grp_StartTime; 
 
	/** 
 	*	欄位名稱:'結束時間 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String grp_EndTime; 
 
	/** 
 	*	欄位名稱:'揪團敘述 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	private	String grp_Desc; 
 
	/** 
 	*	欄位名稱:'商家經度座標 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double grp_Long; 
 
	/** 
 	*	欄位名稱:'商家緯度座標 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double grp_Lat; 
 
	/** 
 	*	欄位名稱:'建立時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date grp_CreateTime; 
 
	/** 
 	*	欄位名稱:'物件顯示狀態 | PS: 1.顯示0.不顯示'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	String grp_visible; 
 
	/** 
 	*	欄位名稱:' | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	byte[] grp_photo; 
 
	/** 
 	*	欄位名稱:'活動編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getGrp_Id() { 
		return this.grp_Id;
	} 
	/** 
 	*	欄位名稱:'會員編號(負責人) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getGrp_MemId() { 
		return this.grp_MemId;
	} 
	/** 
 	*	欄位名稱:'名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getGrp_name() { 
		return this.grp_name;
	} 
	/** 
 	*	欄位名稱:'縣/市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getGrp_city() { 
		return this.grp_city;
	} 
	/** 
 	*	欄位名稱:'鄉鎮市區道路 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getGrp_Addr() { 
		return this.grp_Addr;
	} 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	String getGrp_road() { 
		return this.grp_road;
	} 
	/** 
 	*	欄位名稱:'開始時間 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getGrp_StartTime() { 
		return this.grp_StartTime;
	} 
	/** 
 	*	欄位名稱:'結束時間 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getGrp_EndTime() { 
		return this.grp_EndTime;
	} 
	/** 
 	*	欄位名稱:'揪團敘述 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	String getGrp_Desc() { 
		return this.grp_Desc;
	} 
	/** 
 	*	欄位名稱:'商家經度座標 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getGrp_Long() { 
		return this.grp_Long;
	} 
	/** 
 	*	欄位名稱:'商家緯度座標 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getGrp_Lat() { 
		return this.grp_Lat;
	} 
	/** 
 	*	欄位名稱:'建立時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getGrp_CreateTime() { 
		return this.grp_CreateTime;
	} 
	/** 
 	*	欄位名稱:'物件顯示狀態 | PS: 1.顯示0.不顯示'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	String getGrp_visible() { 
		return this.grp_visible;
	} 
	/** 
 	*	欄位名稱:' | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	byte[] getGrp_photo() { 
		return this.grp_photo;
	} 
	/** 
 	*	欄位名稱:'活動編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setGrp_Id(String aGrp_Id) { 
		this.grp_Id = aGrp_Id; 
	} 
 
	/** 
 	*	欄位名稱:'會員編號(負責人) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setGrp_MemId(String aGrp_MemId) { 
		this.grp_MemId = aGrp_MemId; 
	} 
 
	/** 
 	*	欄位名稱:'名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setGrp_name(String aGrp_name) { 
		this.grp_name = aGrp_name; 
	} 
 
	/** 
 	*	欄位名稱:'縣/市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setGrp_city(String aGrp_city) { 
		this.grp_city = aGrp_city; 
	} 
 
	/** 
 	*	欄位名稱:'鄉鎮市區道路 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setGrp_Addr(String aGrp_Addr) { 
		this.grp_Addr = aGrp_Addr; 
	} 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	void setGrp_road(String aGrp_road) { 
		this.grp_road = aGrp_road; 
	} 
 
	/** 
 	*	欄位名稱:'開始時間 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setGrp_StartTime(String aGrp_StartTime) { 
		this.grp_StartTime = aGrp_StartTime; 
	} 
 
	/** 
 	*	欄位名稱:'結束時間 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setGrp_EndTime(String aGrp_EndTime) { 
		this.grp_EndTime = aGrp_EndTime; 
	} 
 
	/** 
 	*	欄位名稱:'揪團敘述 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	void setGrp_Desc(String aGrp_Desc) { 
		this.grp_Desc = aGrp_Desc; 
	} 
 
	/** 
 	*	欄位名稱:'商家經度座標 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setGrp_Long(Double aGrp_Long) { 
		this.grp_Long = aGrp_Long; 
	} 
 
	/** 
 	*	欄位名稱:'商家緯度座標 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setGrp_Lat(Double aGrp_Lat) { 
		this.grp_Lat = aGrp_Lat; 
	} 
 
	/** 
 	*	欄位名稱:'建立時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setGrp_CreateTime(Date aGrp_CreateTime) { 
		this.grp_CreateTime = aGrp_CreateTime; 
	} 
 
	/** 
 	*	欄位名稱:'物件顯示狀態 | PS: 1.顯示0.不顯示'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setGrp_visible(String aGrp_visible) { 
		this.grp_visible = aGrp_visible; 
	} 
 
	/** 
 	*	欄位名稱:' | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setGrp_photo(byte[] aGrp_photo) { 
		this.grp_photo = aGrp_photo; 
	} 
 
}
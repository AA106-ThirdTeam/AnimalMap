package com.vet_hospital.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:診所<br>
 *	英文:vet_hospital<br>
 */ 
public class Vet_hospitalVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'診所編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String hos_Id; 
 
	/** 
 	*	欄位名稱:'會員編號(負責人) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'診所名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String hos_name; 
 
	/** 
 	*	欄位名稱:'縣/市 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	private	String hos_city; 
 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	private	String hos_town; 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	private	String hos_road; 
 
	/** 
 	*	欄位名稱:'評價 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:30<br>
	*	限制條件:<br>
 	*/ 
	private	Integer hos_Eval; 
 
	/** 
 	*	欄位名稱:'URL | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:100<br>
	*	限制條件:<br>
 	*/ 
	private	String hos_URL; 
 
	/** 
 	*	欄位名稱:'開始營業時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date hos_StartTime; 
 
	/** 
 	*	欄位名稱:'結束營業時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date hos_EndTime; 
 
	/** 
 	*	欄位名稱:'電話 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	private	String hos_Tel; 
 
	/** 
 	*	欄位名稱:'診所敘述 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	private	String hos_Desc; 
 
	/** 
 	*	欄位名稱:'診所經度座標 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double hos_Long; 
 
	/** 
 	*	欄位名稱:'診所緯度座標 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double hos_Lat; 
 
	/** 
 	*	欄位名稱:'建立時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date hos_CreateTime; 
 
	/** 
 	*	欄位名稱:'物件顯示狀態 | PS: 1.顯示0.不顯示'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	String hos_visible; 
 
	/** 
 	*	欄位名稱:'診所編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getHos_Id() { 
		return this.hos_Id;
	} 
	/** 
 	*	欄位名稱:'會員編號(負責人) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	/** 
 	*	欄位名稱:'診所名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getHos_name() { 
		return this.hos_name;
	} 
	/** 
 	*	欄位名稱:'縣/市 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	String getHos_city() { 
		return this.hos_city;
	} 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	String getHos_town() { 
		return this.hos_town;
	} 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	String getHos_road() { 
		return this.hos_road;
	} 
	/** 
 	*	欄位名稱:'評價 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:30<br>
	*	限制條件:<br>
 	*/ 
	public	Integer getHos_Eval() { 
		return this.hos_Eval;
	} 
	/** 
 	*	欄位名稱:'URL | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:100<br>
	*	限制條件:<br>
 	*/ 
	public	String getHos_URL() { 
		return this.hos_URL;
	} 
	/** 
 	*	欄位名稱:'開始營業時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getHos_StartTime() { 
		return this.hos_StartTime;
	} 
	/** 
 	*	欄位名稱:'結束營業時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getHos_EndTime() { 
		return this.hos_EndTime;
	} 
	/** 
 	*	欄位名稱:'電話 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	String getHos_Tel() { 
		return this.hos_Tel;
	} 
	/** 
 	*	欄位名稱:'診所敘述 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	String getHos_Desc() { 
		return this.hos_Desc;
	} 
	/** 
 	*	欄位名稱:'診所經度座標 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getHos_Long() { 
		return this.hos_Long;
	} 
	/** 
 	*	欄位名稱:'診所緯度座標 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getHos_Lat() { 
		return this.hos_Lat;
	} 
	/** 
 	*	欄位名稱:'建立時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getHos_CreateTime() { 
		return this.hos_CreateTime;
	} 
	/** 
 	*	欄位名稱:'物件顯示狀態 | PS: 1.顯示0.不顯示'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	String getHos_visible() { 
		return this.hos_visible;
	} 
	/** 
 	*	欄位名稱:'診所編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setHos_Id(String aHos_Id) { 
		this.hos_Id = aHos_Id; 
	} 
 
	/** 
 	*	欄位名稱:'會員編號(負責人) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	/** 
 	*	欄位名稱:'診所名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setHos_name(String aHos_name) { 
		this.hos_name = aHos_name; 
	} 
 
	/** 
 	*	欄位名稱:'縣/市 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	void setHos_city(String aHos_city) { 
		this.hos_city = aHos_city; 
	} 
 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	void setHos_town(String aHos_town) { 
		this.hos_town = aHos_town; 
	} 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	void setHos_road(String aHos_road) { 
		this.hos_road = aHos_road; 
	} 
 
	/** 
 	*	欄位名稱:'評價 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:30<br>
	*	限制條件:<br>
 	*/ 
	public	void setHos_Eval(Integer aHos_Eval) { 
		this.hos_Eval = aHos_Eval; 
	} 
 
	/** 
 	*	欄位名稱:'URL | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:100<br>
	*	限制條件:<br>
 	*/ 
	public	void setHos_URL(String aHos_URL) { 
		this.hos_URL = aHos_URL; 
	} 
 
	/** 
 	*	欄位名稱:'開始營業時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setHos_StartTime(Date aHos_StartTime) { 
		this.hos_StartTime = aHos_StartTime; 
	} 
 
	/** 
 	*	欄位名稱:'結束營業時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setHos_EndTime(Date aHos_EndTime) { 
		this.hos_EndTime = aHos_EndTime; 
	} 
 
	/** 
 	*	欄位名稱:'電話 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	void setHos_Tel(String aHos_Tel) { 
		this.hos_Tel = aHos_Tel; 
	} 
 
	/** 
 	*	欄位名稱:'診所敘述 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	void setHos_Desc(String aHos_Desc) { 
		this.hos_Desc = aHos_Desc; 
	} 
 
	/** 
 	*	欄位名稱:'診所經度座標 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setHos_Long(Double aHos_Long) { 
		this.hos_Long = aHos_Long; 
	} 
 
	/** 
 	*	欄位名稱:'診所緯度座標 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setHos_Lat(Double aHos_Lat) { 
		this.hos_Lat = aHos_Lat; 
	} 
 
	/** 
 	*	欄位名稱:'建立時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setHos_CreateTime(Date aHos_CreateTime) { 
		this.hos_CreateTime = aHos_CreateTime; 
	} 
 
	/** 
 	*	欄位名稱:'物件顯示狀態 | PS: 1.顯示0.不顯示'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setHos_visible(String aHos_visible) { 
		this.hos_visible = aHos_visible; 
	} 
 
}
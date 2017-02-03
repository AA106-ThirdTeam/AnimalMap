package com.stray_ani.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	社區流浪動物<br>
 *	英文:stray_Ani<br>
 */ 
public class Stray_AniVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'社區動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String stray_Ani_Id; 
 
	/** 
 	*	欄位名稱:'發布者會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'流浪動物名字 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:16<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String stray_Ani_name; 
 
	/** 
 	*	欄位名稱:'流浪動物種類 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String stray_Ani_type; 
 
	/** 
 	*	欄位名稱:'流浪性別 | PS: M.公F.母'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3<br>
	*	限制條件:<br>
 	*/ 
	private	String stray_Ani_gender; 
 
	/** 
 	*	欄位名稱:'流浪動物健康狀況 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:<br>
 	*/ 
	private	String stray_Ani_heal; 
 
	/** 
 	*	欄位名稱:'流浪動物疫苗接踵 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:<br>
 	*/ 
	private	String stray_Ani_Vac; 
 
	/** 
 	*	欄位名稱:'流浪動物毛色 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	private	String stray_Ani_color; 
 
	/** 
 	*	欄位名稱:'流浪動物體型 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	private	String stray_Ani_body; 
 
	/** 
 	*	欄位名稱:'流浪動物年齡 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:2<br>
	*	限制條件:<br>
 	*/ 
	private	String stray_Ani_age; 
 
	/** 
 	*	欄位名稱:'流浪動物節育 | PS: 1.已節育0.未節育'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	String stray_Ani_Neu; 
 
	/** 
 	*	欄位名稱:'流浪動物晶片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:<br>
 	*/ 
	private	String stray_Ani_chip; 
 
	/** 
 	*	欄位名稱:'流浪動物發現時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date stray_Ani_date; 
 
	/** 
 	*	欄位名稱:'流浪動物物件狀態 | PS: 1.顯示0.不顯示'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	String stray_Ani_status; 
 
	/** 
 	*	欄位名稱:'流浪動物建立時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date stray_Ani_CreDate; 
 
	/** 
 	*	欄位名稱:'流浪出沒地點經度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double stray_Ani_FinLat; 
 
	/** 
 	*	欄位名稱:'流浪出沒地點緯度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double stray_Ani_FinLon; 
 
	/** 
 	*	欄位名稱:'縣/市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String stray_Ani_city; 
 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String stray_Ani_town; 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String stray_Ani_road; 
 
	/** 
 	*	欄位名稱:'社區動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getStray_Ani_Id() { 
		return this.stray_Ani_Id;
	} 
	/** 
 	*	欄位名稱:'發布者會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	/** 
 	*	欄位名稱:'流浪動物名字 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:16<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getStray_Ani_name() { 
		return this.stray_Ani_name;
	} 
	/** 
 	*	欄位名稱:'流浪動物種類 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getStray_Ani_type() { 
		return this.stray_Ani_type;
	} 
	/** 
 	*	欄位名稱:'流浪性別 | PS: M.公F.母'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3<br>
	*	限制條件:<br>
 	*/ 
	public	String getStray_Ani_gender() { 
		return this.stray_Ani_gender;
	} 
	/** 
 	*	欄位名稱:'流浪動物健康狀況 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:<br>
 	*/ 
	public	String getStray_Ani_heal() { 
		return this.stray_Ani_heal;
	} 
	/** 
 	*	欄位名稱:'流浪動物疫苗接踵 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:<br>
 	*/ 
	public	String getStray_Ani_Vac() { 
		return this.stray_Ani_Vac;
	} 
	/** 
 	*	欄位名稱:'流浪動物毛色 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	String getStray_Ani_color() { 
		return this.stray_Ani_color;
	} 
	/** 
 	*	欄位名稱:'流浪動物體型 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	String getStray_Ani_body() { 
		return this.stray_Ani_body;
	} 
	/** 
 	*	欄位名稱:'流浪動物年齡 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:2<br>
	*	限制條件:<br>
 	*/ 
	public	String getStray_Ani_age() { 
		return this.stray_Ani_age;
	} 
	/** 
 	*	欄位名稱:'流浪動物節育 | PS: 1.已節育0.未節育'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	String getStray_Ani_Neu() { 
		return this.stray_Ani_Neu;
	} 
	/** 
 	*	欄位名稱:'流浪動物晶片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:<br>
 	*/ 
	public	String getStray_Ani_chip() { 
		return this.stray_Ani_chip;
	} 
	/** 
 	*	欄位名稱:'流浪動物發現時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getStray_Ani_date() { 
		return this.stray_Ani_date;
	} 
	/** 
 	*	欄位名稱:'流浪動物物件狀態 | PS: 1.顯示0.不顯示'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	String getStray_Ani_status() { 
		return this.stray_Ani_status;
	} 
	/** 
 	*	欄位名稱:'流浪動物建立時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getStray_Ani_CreDate() { 
		return this.stray_Ani_CreDate;
	} 
	/** 
 	*	欄位名稱:'流浪出沒地點經度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getStray_Ani_FinLat() { 
		return this.stray_Ani_FinLat;
	} 
	/** 
 	*	欄位名稱:'流浪出沒地點緯度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getStray_Ani_FinLon() { 
		return this.stray_Ani_FinLon;
	} 
	/** 
 	*	欄位名稱:'縣/市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getStray_Ani_city() { 
		return this.stray_Ani_city;
	} 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getStray_Ani_town() { 
		return this.stray_Ani_town;
	} 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getStray_Ani_road() { 
		return this.stray_Ani_road;
	} 
	/** 
 	*	欄位名稱:'社區動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setStray_Ani_Id(String aStray_Ani_Id) { 
		this.stray_Ani_Id = aStray_Ani_Id; 
	} 
 
	/** 
 	*	欄位名稱:'發布者會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	/** 
 	*	欄位名稱:'流浪動物名字 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:16<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setStray_Ani_name(String aStray_Ani_name) { 
		this.stray_Ani_name = aStray_Ani_name; 
	} 
 
	/** 
 	*	欄位名稱:'流浪動物種類 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setStray_Ani_type(String aStray_Ani_type) { 
		this.stray_Ani_type = aStray_Ani_type; 
	} 
 
	/** 
 	*	欄位名稱:'流浪性別 | PS: M.公F.母'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3<br>
	*	限制條件:<br>
 	*/ 
	public	void setStray_Ani_gender(String aStray_Ani_gender) { 
		this.stray_Ani_gender = aStray_Ani_gender; 
	} 
 
	/** 
 	*	欄位名稱:'流浪動物健康狀況 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:<br>
 	*/ 
	public	void setStray_Ani_heal(String aStray_Ani_heal) { 
		this.stray_Ani_heal = aStray_Ani_heal; 
	} 
 
	/** 
 	*	欄位名稱:'流浪動物疫苗接踵 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:<br>
 	*/ 
	public	void setStray_Ani_Vac(String aStray_Ani_Vac) { 
		this.stray_Ani_Vac = aStray_Ani_Vac; 
	} 
 
	/** 
 	*	欄位名稱:'流浪動物毛色 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	void setStray_Ani_color(String aStray_Ani_color) { 
		this.stray_Ani_color = aStray_Ani_color; 
	} 
 
	/** 
 	*	欄位名稱:'流浪動物體型 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	void setStray_Ani_body(String aStray_Ani_body) { 
		this.stray_Ani_body = aStray_Ani_body; 
	} 
 
	/** 
 	*	欄位名稱:'流浪動物年齡 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:2<br>
	*	限制條件:<br>
 	*/ 
	public	void setStray_Ani_age(String aStray_Ani_age) { 
		this.stray_Ani_age = aStray_Ani_age; 
	} 
 
	/** 
 	*	欄位名稱:'流浪動物節育 | PS: 1.已節育0.未節育'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setStray_Ani_Neu(String aStray_Ani_Neu) { 
		this.stray_Ani_Neu = aStray_Ani_Neu; 
	} 
 
	/** 
 	*	欄位名稱:'流浪動物晶片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:<br>
 	*/ 
	public	void setStray_Ani_chip(String aStray_Ani_chip) { 
		this.stray_Ani_chip = aStray_Ani_chip; 
	} 
 
	/** 
 	*	欄位名稱:'流浪動物發現時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setStray_Ani_date(Date aStray_Ani_date) { 
		this.stray_Ani_date = aStray_Ani_date; 
	} 
 
	/** 
 	*	欄位名稱:'流浪動物物件狀態 | PS: 1.顯示0.不顯示'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setStray_Ani_status(String aStray_Ani_status) { 
		this.stray_Ani_status = aStray_Ani_status; 
	} 
 
	/** 
 	*	欄位名稱:'流浪動物建立時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setStray_Ani_CreDate(Date aStray_Ani_CreDate) { 
		this.stray_Ani_CreDate = aStray_Ani_CreDate; 
	} 
 
	/** 
 	*	欄位名稱:'流浪出沒地點經度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setStray_Ani_FinLat(Double aStray_Ani_FinLat) { 
		this.stray_Ani_FinLat = aStray_Ani_FinLat; 
	} 
 
	/** 
 	*	欄位名稱:'流浪出沒地點緯度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setStray_Ani_FinLon(Double aStray_Ani_FinLon) { 
		this.stray_Ani_FinLon = aStray_Ani_FinLon; 
	} 
 
	/** 
 	*	欄位名稱:'縣/市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setStray_Ani_city(String aStray_Ani_city) { 
		this.stray_Ani_city = aStray_Ani_city; 
	} 
 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setStray_Ani_town(String aStray_Ani_town) { 
		this.stray_Ani_town = aStray_Ani_town; 
	} 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setStray_Ani_road(String aStray_Ani_road) { 
		this.stray_Ani_road = aStray_Ani_road; 
	} 
 
}
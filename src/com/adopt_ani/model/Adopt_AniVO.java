package com.adopt_ani.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:送養動物<br>
 *	英文:adopt_Ani<br>
 */ 
public class Adopt_AniVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'送養動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String adopt_Ani_Id; 
 
	/** 
 	*	欄位名稱:'發布者會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'送養動物名字 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:16<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String adopt_Ani_name; 
 
	/** 
 	*	欄位名稱:'送養動物動物種類 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String adopt_Ani_type; 
 
	/** 
 	*	欄位名稱:'送養動物性別 | PS: M.公F.母'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3<br>
	*	限制條件:<br>
 	*/ 
	private	String adopt_Ani_gender; 
 
	/** 
 	*	欄位名稱:'送養動物健康狀況 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:<br>
 	*/ 
	private	String adopt_Ani_heal; 
 
	/** 
 	*	欄位名稱:'送養動物疫苗接踵 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:<br>
 	*/ 
	private	String adopt_Ani_Vac; 
 
	/** 
 	*	欄位名稱:'送養動物毛色 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	private	String adopt_Ani_color; 
 
	/** 
 	*	欄位名稱:'送養動物體型 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	private	String adopt_Ani_body; 
 
	/** 
 	*	欄位名稱:'送養動物年齡 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:2<br>
	*	限制條件:<br>
 	*/ 
	private	String adopt_Ani_age; 
 
	/** 
 	*	欄位名稱:'送養動物節育 | PS: 1.已節育0.未節育'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	String adopt_Ani_Neu; 
 
	/** 
 	*	欄位名稱:'送養動物晶片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:<br>
 	*/ 
	private	String adopt_Ani_chip; 
 
	/** 
 	*	欄位名稱:'送養時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date adopt_Ani_date; 
 
	/** 
 	*	欄位名稱:'送養動物物件狀態 | PS: 1.顯示0.不顯示'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	String adopt_Ani_status; 
 
	/** 
 	*	欄位名稱:'送養動物建立時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date adopt_Ani_CreDate; 
 
	/** 
 	*	欄位名稱:'送養地點經度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double adopt_Ani_FinLat; 
 
	/** 
 	*	欄位名稱:'送養地點緯度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double adopt_Ani_FinLon; 
 
	/** 
 	*	欄位名稱:'縣/市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String adopt_Ani_city; 
 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String adopt_Ani_town; 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String adopt_Ani_road; 
 
	/** 
 	*	欄位名稱:'送養動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getAdopt_Ani_Id() { 
		return this.adopt_Ani_Id;
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
 	*	欄位名稱:'送養動物名字 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:16<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getAdopt_Ani_name() { 
		return this.adopt_Ani_name;
	} 
	/** 
 	*	欄位名稱:'送養動物動物種類 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getAdopt_Ani_type() { 
		return this.adopt_Ani_type;
	} 
	/** 
 	*	欄位名稱:'送養動物性別 | PS: M.公F.母'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3<br>
	*	限制條件:<br>
 	*/ 
	public	String getAdopt_Ani_gender() { 
		return this.adopt_Ani_gender;
	} 
	/** 
 	*	欄位名稱:'送養動物健康狀況 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:<br>
 	*/ 
	public	String getAdopt_Ani_heal() { 
		return this.adopt_Ani_heal;
	} 
	/** 
 	*	欄位名稱:'送養動物疫苗接踵 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:<br>
 	*/ 
	public	String getAdopt_Ani_Vac() { 
		return this.adopt_Ani_Vac;
	} 
	/** 
 	*	欄位名稱:'送養動物毛色 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	String getAdopt_Ani_color() { 
		return this.adopt_Ani_color;
	} 
	/** 
 	*	欄位名稱:'送養動物體型 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	String getAdopt_Ani_body() { 
		return this.adopt_Ani_body;
	} 
	/** 
 	*	欄位名稱:'送養動物年齡 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:2<br>
	*	限制條件:<br>
 	*/ 
	public	String getAdopt_Ani_age() { 
		return this.adopt_Ani_age;
	} 
	/** 
 	*	欄位名稱:'送養動物節育 | PS: 1.已節育0.未節育'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	String getAdopt_Ani_Neu() { 
		return this.adopt_Ani_Neu;
	} 
	/** 
 	*	欄位名稱:'送養動物晶片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:<br>
 	*/ 
	public	String getAdopt_Ani_chip() { 
		return this.adopt_Ani_chip;
	} 
	/** 
 	*	欄位名稱:'送養時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getAdopt_Ani_date() { 
		return this.adopt_Ani_date;
	} 
	/** 
 	*	欄位名稱:'送養動物物件狀態 | PS: 1.顯示0.不顯示'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	String getAdopt_Ani_status() { 
		return this.adopt_Ani_status;
	} 
	/** 
 	*	欄位名稱:'送養動物建立時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getAdopt_Ani_CreDate() { 
		return this.adopt_Ani_CreDate;
	} 
	/** 
 	*	欄位名稱:'送養地點經度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getAdopt_Ani_FinLat() { 
		return this.adopt_Ani_FinLat;
	} 
	/** 
 	*	欄位名稱:'送養地點緯度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getAdopt_Ani_FinLon() { 
		return this.adopt_Ani_FinLon;
	} 
	/** 
 	*	欄位名稱:'縣/市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getAdopt_Ani_city() { 
		return this.adopt_Ani_city;
	} 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getAdopt_Ani_town() { 
		return this.adopt_Ani_town;
	} 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getAdopt_Ani_road() { 
		return this.adopt_Ani_road;
	} 
	/** 
 	*	欄位名稱:'送養動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setAdopt_Ani_Id(String aAdopt_Ani_Id) { 
		this.adopt_Ani_Id = aAdopt_Ani_Id; 
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
 	*	欄位名稱:'送養動物名字 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:16<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setAdopt_Ani_name(String aAdopt_Ani_name) { 
		this.adopt_Ani_name = aAdopt_Ani_name; 
	} 
 
	/** 
 	*	欄位名稱:'送養動物動物種類 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setAdopt_Ani_type(String aAdopt_Ani_type) { 
		this.adopt_Ani_type = aAdopt_Ani_type; 
	} 
 
	/** 
 	*	欄位名稱:'送養動物性別 | PS: M.公F.母'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdopt_Ani_gender(String aAdopt_Ani_gender) { 
		this.adopt_Ani_gender = aAdopt_Ani_gender; 
	} 
 
	/** 
 	*	欄位名稱:'送養動物健康狀況 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdopt_Ani_heal(String aAdopt_Ani_heal) { 
		this.adopt_Ani_heal = aAdopt_Ani_heal; 
	} 
 
	/** 
 	*	欄位名稱:'送養動物疫苗接踵 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdopt_Ani_Vac(String aAdopt_Ani_Vac) { 
		this.adopt_Ani_Vac = aAdopt_Ani_Vac; 
	} 
 
	/** 
 	*	欄位名稱:'送養動物毛色 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdopt_Ani_color(String aAdopt_Ani_color) { 
		this.adopt_Ani_color = aAdopt_Ani_color; 
	} 
 
	/** 
 	*	欄位名稱:'送養動物體型 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdopt_Ani_body(String aAdopt_Ani_body) { 
		this.adopt_Ani_body = aAdopt_Ani_body; 
	} 
 
	/** 
 	*	欄位名稱:'送養動物年齡 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:2<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdopt_Ani_age(String aAdopt_Ani_age) { 
		this.adopt_Ani_age = aAdopt_Ani_age; 
	} 
 
	/** 
 	*	欄位名稱:'送養動物節育 | PS: 1.已節育0.未節育'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdopt_Ani_Neu(String aAdopt_Ani_Neu) { 
		this.adopt_Ani_Neu = aAdopt_Ani_Neu; 
	} 
 
	/** 
 	*	欄位名稱:'送養動物晶片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdopt_Ani_chip(String aAdopt_Ani_chip) { 
		this.adopt_Ani_chip = aAdopt_Ani_chip; 
	} 
 
	/** 
 	*	欄位名稱:'送養時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdopt_Ani_date(Date aAdopt_Ani_date) { 
		this.adopt_Ani_date = aAdopt_Ani_date; 
	} 
 
	/** 
 	*	欄位名稱:'送養動物物件狀態 | PS: 1.顯示0.不顯示'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdopt_Ani_status(String aAdopt_Ani_status) { 
		this.adopt_Ani_status = aAdopt_Ani_status; 
	} 
 
	/** 
 	*	欄位名稱:'送養動物建立時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdopt_Ani_CreDate(Date aAdopt_Ani_CreDate) { 
		this.adopt_Ani_CreDate = aAdopt_Ani_CreDate; 
	} 
 
	/** 
 	*	欄位名稱:'送養地點經度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdopt_Ani_FinLat(Double aAdopt_Ani_FinLat) { 
		this.adopt_Ani_FinLat = aAdopt_Ani_FinLat; 
	} 
 
	/** 
 	*	欄位名稱:'送養地點緯度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdopt_Ani_FinLon(Double aAdopt_Ani_FinLon) { 
		this.adopt_Ani_FinLon = aAdopt_Ani_FinLon; 
	} 
 
	/** 
 	*	欄位名稱:'縣/市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setAdopt_Ani_city(String aAdopt_Ani_city) { 
		this.adopt_Ani_city = aAdopt_Ani_city; 
	} 
 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setAdopt_Ani_town(String aAdopt_Ani_town) { 
		this.adopt_Ani_town = aAdopt_Ani_town; 
	} 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setAdopt_Ani_road(String aAdopt_Ani_road) { 
		this.adopt_Ani_road = aAdopt_Ani_road; 
	} 
 
}
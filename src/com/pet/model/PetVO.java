package com.pet.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:自家寵物<br>
 *	英文:pet<br>
 */ 
public class PetVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'寵物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String pet_Id; 
 
	/** 
 	*	欄位名稱:'主人會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'寵物名字 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:16<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String pet_name; 
 
	/** 
 	*	欄位名稱:'寵物種類 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String pet_type; 
 
	/** 
 	*	欄位名稱:'寵物性別 | PS: M.公F.母'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3<br>
	*	限制條件:<br>
 	*/ 
	private	String pet_gender; 
 
	/** 
 	*	欄位名稱:'寵物健康狀況 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:<br>
 	*/ 
	private	String pet_heal; 
 
	/** 
 	*	欄位名稱:'寵物疫苗接踵 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:<br>
 	*/ 
	private	String pet_Vac; 
 
	/** 
 	*	欄位名稱:'寵物毛色 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	private	String pet_color; 
 
	/** 
 	*	欄位名稱:'寵物體型 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	private	String pet_body; 
 
	/** 
 	*	欄位名稱:'寵物年齡 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:2<br>
	*	限制條件:<br>
 	*/ 
	private	String pet_age; 
 
	/** 
 	*	欄位名稱:'寵物節育 | PS: 1.已節育0.未節育'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	String pet_Neu; 
 
	/** 
 	*	欄位名稱:'寵物晶片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:<br>
 	*/ 
	private	String pet_chip; 
 
	/** 
 	*	欄位名稱:'寵物生日 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date pet_birth; 
 
	/** 
 	*	欄位名稱:'寵物物件狀態 | PS: 1.顯示0.不顯示'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	String pet_status; 
 
	/** 
 	*	欄位名稱:'寵物建立時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date pet_CreDATE; 
 
	/** 
 	*	欄位名稱:'縣市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	private	String pet_city; 
 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	private	String pet_town; 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	private	String pet_road; 
 
	/** 
 	*	欄位名稱:'送養地點經度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double pet_FinLat; 
 
	/** 
 	*	欄位名稱:'送養地點緯度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double pet_FinLon; 
 
	/** 
 	*	欄位名稱:'寵物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getPet_Id() { 
		return this.pet_Id;
	} 
	/** 
 	*	欄位名稱:'主人會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	/** 
 	*	欄位名稱:'寵物名字 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:16<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getPet_name() { 
		return this.pet_name;
	} 
	/** 
 	*	欄位名稱:'寵物種類 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getPet_type() { 
		return this.pet_type;
	} 
	/** 
 	*	欄位名稱:'寵物性別 | PS: M.公F.母'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3<br>
	*	限制條件:<br>
 	*/ 
	public	String getPet_gender() { 
		return this.pet_gender;
	} 
	/** 
 	*	欄位名稱:'寵物健康狀況 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:<br>
 	*/ 
	public	String getPet_heal() { 
		return this.pet_heal;
	} 
	/** 
 	*	欄位名稱:'寵物疫苗接踵 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:<br>
 	*/ 
	public	String getPet_Vac() { 
		return this.pet_Vac;
	} 
	/** 
 	*	欄位名稱:'寵物毛色 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	String getPet_color() { 
		return this.pet_color;
	} 
	/** 
 	*	欄位名稱:'寵物體型 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	String getPet_body() { 
		return this.pet_body;
	} 
	/** 
 	*	欄位名稱:'寵物年齡 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:2<br>
	*	限制條件:<br>
 	*/ 
	public	String getPet_age() { 
		return this.pet_age;
	} 
	/** 
 	*	欄位名稱:'寵物節育 | PS: 1.已節育0.未節育'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	String getPet_Neu() { 
		return this.pet_Neu;
	} 
	/** 
 	*	欄位名稱:'寵物晶片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:<br>
 	*/ 
	public	String getPet_chip() { 
		return this.pet_chip;
	} 
	/** 
 	*	欄位名稱:'寵物生日 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getPet_birth() { 
		return this.pet_birth;
	} 
	/** 
 	*	欄位名稱:'寵物物件狀態 | PS: 1.顯示0.不顯示'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	String getPet_status() { 
		return this.pet_status;
	} 
	/** 
 	*	欄位名稱:'寵物建立時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getPet_CreDATE() { 
		return this.pet_CreDATE;
	} 
	/** 
 	*	欄位名稱:'縣市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	public	String getPet_city() { 
		return this.pet_city;
	} 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	public	String getPet_town() { 
		return this.pet_town;
	} 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	String getPet_road() { 
		return this.pet_road;
	} 
	/** 
 	*	欄位名稱:'送養地點經度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getPet_FinLat() { 
		return this.pet_FinLat;
	} 
	/** 
 	*	欄位名稱:'送養地點緯度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getPet_FinLon() { 
		return this.pet_FinLon;
	} 
	/** 
 	*	欄位名稱:'寵物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setPet_Id(String aPet_Id) { 
		this.pet_Id = aPet_Id; 
	} 
 
	/** 
 	*	欄位名稱:'主人會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	/** 
 	*	欄位名稱:'寵物名字 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:16<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setPet_name(String aPet_name) { 
		this.pet_name = aPet_name; 
	} 
 
	/** 
 	*	欄位名稱:'寵物種類 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setPet_type(String aPet_type) { 
		this.pet_type = aPet_type; 
	} 
 
	/** 
 	*	欄位名稱:'寵物性別 | PS: M.公F.母'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_gender(String aPet_gender) { 
		this.pet_gender = aPet_gender; 
	} 
 
	/** 
 	*	欄位名稱:'寵物健康狀況 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_heal(String aPet_heal) { 
		this.pet_heal = aPet_heal; 
	} 
 
	/** 
 	*	欄位名稱:'寵物疫苗接踵 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_Vac(String aPet_Vac) { 
		this.pet_Vac = aPet_Vac; 
	} 
 
	/** 
 	*	欄位名稱:'寵物毛色 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_color(String aPet_color) { 
		this.pet_color = aPet_color; 
	} 
 
	/** 
 	*	欄位名稱:'寵物體型 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_body(String aPet_body) { 
		this.pet_body = aPet_body; 
	} 
 
	/** 
 	*	欄位名稱:'寵物年齡 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:2<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_age(String aPet_age) { 
		this.pet_age = aPet_age; 
	} 
 
	/** 
 	*	欄位名稱:'寵物節育 | PS: 1.已節育0.未節育'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_Neu(String aPet_Neu) { 
		this.pet_Neu = aPet_Neu; 
	} 
 
	/** 
 	*	欄位名稱:'寵物晶片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_chip(String aPet_chip) { 
		this.pet_chip = aPet_chip; 
	} 
 
	/** 
 	*	欄位名稱:'寵物生日 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_birth(Date aPet_birth) { 
		this.pet_birth = aPet_birth; 
	} 
 
	/** 
 	*	欄位名稱:'寵物物件狀態 | PS: 1.顯示0.不顯示'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_status(String aPet_status) { 
		this.pet_status = aPet_status; 
	} 
 
	/** 
 	*	欄位名稱:'寵物建立時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_CreDATE(Date aPet_CreDATE) { 
		this.pet_CreDATE = aPet_CreDATE; 
	} 
 
	/** 
 	*	欄位名稱:'縣市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_city(String aPet_city) { 
		this.pet_city = aPet_city; 
	} 
 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_town(String aPet_town) { 
		this.pet_town = aPet_town; 
	} 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_road(String aPet_road) { 
		this.pet_road = aPet_road; 
	} 
 
	/** 
 	*	欄位名稱:'送養地點經度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_FinLat(Double aPet_FinLat) { 
		this.pet_FinLat = aPet_FinLat; 
	} 
 
	/** 
 	*	欄位名稱:'送養地點緯度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_FinLon(Double aPet_FinLon) { 
		this.pet_FinLon = aPet_FinLon; 
	} 
 
}
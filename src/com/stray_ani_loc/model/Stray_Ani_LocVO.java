package com.stray_ani_loc.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	社區流浪動物出沒範圍<br>
 *	英文:stray_Ani_Loc<br>
 */ 
public class Stray_Ani_LocVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'流浪動物出沒編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String str_Ani_Loc_No; 
 
	/** 
 	*	欄位名稱:'社區動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
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
 	*	欄位名稱:'送養地點經度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double str_Ani_LocLat; 
 
	/** 
 	*	欄位名稱:'送養地點緯度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double str_Ani_LocLon; 
 
	/** 
 	*	欄位名稱:'流浪動物出沒編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getStr_Ani_Loc_No() { 
		return this.str_Ani_Loc_No;
	} 
	/** 
 	*	欄位名稱:'社區動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
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
 	*	欄位名稱:'送養地點經度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getStr_Ani_LocLat() { 
		return this.str_Ani_LocLat;
	} 
	/** 
 	*	欄位名稱:'送養地點緯度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getStr_Ani_LocLon() { 
		return this.str_Ani_LocLon;
	} 
	/** 
 	*	欄位名稱:'流浪動物出沒編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setStr_Ani_Loc_No(String aStr_Ani_Loc_No) { 
		this.str_Ani_Loc_No = aStr_Ani_Loc_No; 
	} 
 
	/** 
 	*	欄位名稱:'社區動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
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
 	*	欄位名稱:'送養地點經度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setStr_Ani_LocLat(Double aStr_Ani_LocLat) { 
		this.str_Ani_LocLat = aStr_Ani_LocLat; 
	} 
 
	/** 
 	*	欄位名稱:'送養地點緯度 | PS: google map經緯度'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setStr_Ani_LocLon(Double aStr_Ani_LocLon) { 
		this.str_Ani_LocLon = aStr_Ani_LocLon; 
	} 
 
}
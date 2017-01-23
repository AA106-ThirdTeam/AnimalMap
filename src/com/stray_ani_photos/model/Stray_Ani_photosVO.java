package com.stray_ani_photos.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:社區流浪動物相簿<br>
 *	英文:stray_Ani_photos<br>
 */ 
public class Stray_Ani_photosVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'相片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String str_Ani_Pic_No; 
 
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
 	*	欄位名稱:'流浪動物相片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	byte[] stray_Ani_Pic; 
 
	/** 
 	*	欄位名稱:'相片檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:24<br>
	*	限制條件:<br>
 	*/ 
	private	String stray_Pic_name; 
 
	/** 
 	*	欄位名稱:'相片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:5<br>
	*	限制條件:<br>
 	*/ 
	private	String stray_Pic_extent; 
 
	/** 
 	*	欄位名稱:'相片發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date stray_Pic_time; 
 
	/** 
 	*	欄位名稱:'相片類型 | PS: 0:一般,1:大頭貼'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	String stray_Pic_type; 
 
	/** 
 	*	欄位名稱:'相片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getStr_Ani_Pic_No() { 
		return this.str_Ani_Pic_No;
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
 	*	欄位名稱:'流浪動物相片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	byte[] getStray_Ani_Pic() { 
		return this.stray_Ani_Pic;
	} 
	/** 
 	*	欄位名稱:'相片檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:24<br>
	*	限制條件:<br>
 	*/ 
	public	String getStray_Pic_name() { 
		return this.stray_Pic_name;
	} 
	/** 
 	*	欄位名稱:'相片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:5<br>
	*	限制條件:<br>
 	*/ 
	public	String getStray_Pic_extent() { 
		return this.stray_Pic_extent;
	} 
	/** 
 	*	欄位名稱:'相片發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getStray_Pic_time() { 
		return this.stray_Pic_time;
	} 
	/** 
 	*	欄位名稱:'相片類型 | PS: 0:一般,1:大頭貼'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	String getStray_Pic_type() { 
		return this.stray_Pic_type;
	} 
	/** 
 	*	欄位名稱:'相片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setStr_Ani_Pic_No(String aStr_Ani_Pic_No) { 
		this.str_Ani_Pic_No = aStr_Ani_Pic_No; 
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
 	*	欄位名稱:'流浪動物相片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setStray_Ani_Pic(byte[] aStray_Ani_Pic) { 
		this.stray_Ani_Pic = aStray_Ani_Pic; 
	} 
 
	/** 
 	*	欄位名稱:'相片檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:24<br>
	*	限制條件:<br>
 	*/ 
	public	void setStray_Pic_name(String aStray_Pic_name) { 
		this.stray_Pic_name = aStray_Pic_name; 
	} 
 
	/** 
 	*	欄位名稱:'相片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:5<br>
	*	限制條件:<br>
 	*/ 
	public	void setStray_Pic_extent(String aStray_Pic_extent) { 
		this.stray_Pic_extent = aStray_Pic_extent; 
	} 
 
	/** 
 	*	欄位名稱:'相片發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setStray_Pic_time(Date aStray_Pic_time) { 
		this.stray_Pic_time = aStray_Pic_time; 
	} 
 
	/** 
 	*	欄位名稱:'相片類型 | PS: 0:一般,1:大頭貼'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setStray_Pic_type(String aStray_Pic_type) { 
		this.stray_Pic_type = aStray_Pic_type; 
	} 
 
}
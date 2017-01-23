package com.adopt_ani_photos.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:送養動物相簿<br>
 *	英文:adopt_Ani_photos<br>
 */ 
public class Adopt_Ani_photosVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'送養動物相片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String ado_Ani_Pic_No; 
 
	/** 
 	*	欄位名稱:'送養動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
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
 	*	欄位名稱:'送養動物相片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	byte[] ado_Ani_Pic; 
 
	/** 
 	*	欄位名稱:'寵物相片檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:24<br>
	*	限制條件:<br>
 	*/ 
	private	String ado_Pic_name; 
 
	/** 
 	*	欄位名稱:'寵物相片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:5<br>
	*	限制條件:<br>
 	*/ 
	private	String ado_Pic_extent; 
 
	/** 
 	*	欄位名稱:'發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date ado_Pic_time; 
 
	/** 
 	*	欄位名稱:'相片類型 | PS: 0:一般,1:大頭貼'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	String ado_Pic_type; 
 
	/** 
 	*	欄位名稱:'送養動物相片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getAdo_Ani_Pic_No() { 
		return this.ado_Ani_Pic_No;
	} 
	/** 
 	*	欄位名稱:'送養動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
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
 	*	欄位名稱:'送養動物相片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	byte[] getAdo_Ani_Pic() { 
		return this.ado_Ani_Pic;
	} 
	/** 
 	*	欄位名稱:'寵物相片檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:24<br>
	*	限制條件:<br>
 	*/ 
	public	String getAdo_Pic_name() { 
		return this.ado_Pic_name;
	} 
	/** 
 	*	欄位名稱:'寵物相片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:5<br>
	*	限制條件:<br>
 	*/ 
	public	String getAdo_Pic_extent() { 
		return this.ado_Pic_extent;
	} 
	/** 
 	*	欄位名稱:'發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getAdo_Pic_time() { 
		return this.ado_Pic_time;
	} 
	/** 
 	*	欄位名稱:'相片類型 | PS: 0:一般,1:大頭貼'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	String getAdo_Pic_type() { 
		return this.ado_Pic_type;
	} 
	/** 
 	*	欄位名稱:'送養動物相片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setAdo_Ani_Pic_No(String aAdo_Ani_Pic_No) { 
		this.ado_Ani_Pic_No = aAdo_Ani_Pic_No; 
	} 
 
	/** 
 	*	欄位名稱:'送養動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
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
 	*	欄位名稱:'送養動物相片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setAdo_Ani_Pic(byte[] aAdo_Ani_Pic) { 
		this.ado_Ani_Pic = aAdo_Ani_Pic; 
	} 
 
	/** 
 	*	欄位名稱:'寵物相片檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:24<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdo_Pic_name(String aAdo_Pic_name) { 
		this.ado_Pic_name = aAdo_Pic_name; 
	} 
 
	/** 
 	*	欄位名稱:'寵物相片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:5<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdo_Pic_extent(String aAdo_Pic_extent) { 
		this.ado_Pic_extent = aAdo_Pic_extent; 
	} 
 
	/** 
 	*	欄位名稱:'發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdo_Pic_time(Date aAdo_Pic_time) { 
		this.ado_Pic_time = aAdo_Pic_time; 
	} 
 
	/** 
 	*	欄位名稱:'相片類型 | PS: 0:一般,1:大頭貼'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdo_Pic_type(String aAdo_Pic_type) { 
		this.ado_Pic_type = aAdo_Pic_type; 
	} 
 
}
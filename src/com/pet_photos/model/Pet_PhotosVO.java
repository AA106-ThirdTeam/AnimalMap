package com.pet_photos.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	自家寵物相簿<br>
 *	英文:pet_Photos<br>
 */ 
public class Pet_PhotosVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'寵物相片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String pet_Pic_No; 
 
	/** 
 	*	欄位名稱:'寵物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String pet_Id; 
 
	/** 
 	*	欄位名稱:'發布者會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'寵物相片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	byte[] pet_Pic; 
 
	/** 
 	*	欄位名稱:'寵物相片檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:24<br>
	*	限制條件:<br>
 	*/ 
	private	String pet_Pic_name; 
 
	/** 
 	*	欄位名稱:'寵物相片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:5<br>
	*	限制條件:<br>
 	*/ 
	private	String pet_Pic_extent; 
 
	/** 
 	*	欄位名稱:'發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date pet_Pic_time; 
 
	/** 
 	*	欄位名稱:'相片類型 | PS: 0:一般,1:大頭貼'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	String pet_Pic_type; 
 
	/** 
 	*	欄位名稱:'寵物相片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getPet_Pic_No() { 
		return this.pet_Pic_No;
	} 
	/** 
 	*	欄位名稱:'寵物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getPet_Id() { 
		return this.pet_Id;
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
 	*	欄位名稱:'寵物相片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	byte[] getPet_Pic() { 
		return this.pet_Pic;
	} 
	/** 
 	*	欄位名稱:'寵物相片檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:24<br>
	*	限制條件:<br>
 	*/ 
	public	String getPet_Pic_name() { 
		return this.pet_Pic_name;
	} 
	/** 
 	*	欄位名稱:'寵物相片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:5<br>
	*	限制條件:<br>
 	*/ 
	public	String getPet_Pic_extent() { 
		return this.pet_Pic_extent;
	} 
	/** 
 	*	欄位名稱:'發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getPet_Pic_time() { 
		return this.pet_Pic_time;
	} 
	/** 
 	*	欄位名稱:'相片類型 | PS: 0:一般,1:大頭貼'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	String getPet_Pic_type() { 
		return this.pet_Pic_type;
	} 
	/** 
 	*	欄位名稱:'寵物相片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setPet_Pic_No(String aPet_Pic_No) { 
		this.pet_Pic_No = aPet_Pic_No; 
	} 
 
	/** 
 	*	欄位名稱:'寵物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setPet_Id(String aPet_Id) { 
		this.pet_Id = aPet_Id; 
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
 	*	欄位名稱:'寵物相片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setPet_Pic(byte[] aPet_Pic) { 
		this.pet_Pic = aPet_Pic; 
	} 
 
	/** 
 	*	欄位名稱:'寵物相片檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:24<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_Pic_name(String aPet_Pic_name) { 
		this.pet_Pic_name = aPet_Pic_name; 
	} 
 
	/** 
 	*	欄位名稱:'寵物相片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:5<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_Pic_extent(String aPet_Pic_extent) { 
		this.pet_Pic_extent = aPet_Pic_extent; 
	} 
 
	/** 
 	*	欄位名稱:'發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_Pic_time(Date aPet_Pic_time) { 
		this.pet_Pic_time = aPet_Pic_time; 
	} 
 
	/** 
 	*	欄位名稱:'相片類型 | PS: 0:一般,1:大頭貼'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setPet_Pic_type(String aPet_Pic_type) { 
		this.pet_Pic_type = aPet_Pic_type; 
	} 
 
}
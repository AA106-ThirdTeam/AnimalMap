package com.hosphoto.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	診所相片<br>
 *	英文:hosPhoto<br>
 */ 
public class HosPhotoVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'相片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String hosPhoto_Id; 
 
	/** 
 	*	欄位名稱:'診所編號(相片擁有診所) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String hosPhoto_HosId; 
 
	/** 
 	*	欄位名稱:'相片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	byte[] hosPhoto_photo; 
 
	/** 
 	*	欄位名稱:'是否為大頭貼相片 | PS: 0為否，1為是'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String isDisp_HosPhoto; 
 
	/** 
 	*	欄位名稱:'相片名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:<br>
 	*/ 
	private	String hosPhoto_name; 
 
	/** 
 	*	欄位名稱:'相片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:16<br>
	*	限制條件:<br>
 	*/ 
	private	String hosPhoto_extent; 
 
	/** 
 	*	欄位名稱:'相片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getHosPhoto_Id() { 
		return this.hosPhoto_Id;
	} 
	/** 
 	*	欄位名稱:'診所編號(相片擁有診所) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getHosPhoto_HosId() { 
		return this.hosPhoto_HosId;
	} 
	/** 
 	*	欄位名稱:'相片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	byte[] getHosPhoto_photo() { 
		return this.hosPhoto_photo;
	} 
	/** 
 	*	欄位名稱:'是否為大頭貼相片 | PS: 0為否，1為是'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getIsDisp_HosPhoto() { 
		return this.isDisp_HosPhoto;
	} 
	/** 
 	*	欄位名稱:'相片名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:<br>
 	*/ 
	public	String getHosPhoto_name() { 
		return this.hosPhoto_name;
	} 
	/** 
 	*	欄位名稱:'相片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:16<br>
	*	限制條件:<br>
 	*/ 
	public	String getHosPhoto_extent() { 
		return this.hosPhoto_extent;
	} 
	/** 
 	*	欄位名稱:'相片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setHosPhoto_Id(String aHosPhoto_Id) { 
		this.hosPhoto_Id = aHosPhoto_Id; 
	} 
 
	/** 
 	*	欄位名稱:'診所編號(相片擁有診所) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setHosPhoto_HosId(String aHosPhoto_HosId) { 
		this.hosPhoto_HosId = aHosPhoto_HosId; 
	} 
 
	/** 
 	*	欄位名稱:'相片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setHosPhoto_photo(byte[] aHosPhoto_photo) { 
		this.hosPhoto_photo = aHosPhoto_photo; 
	} 
 
	/** 
 	*	欄位名稱:'是否為大頭貼相片 | PS: 0為否，1為是'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setIsDisp_HosPhoto(String aIsDisp_HosPhoto) { 
		this.isDisp_HosPhoto = aIsDisp_HosPhoto; 
	} 
 
	/** 
 	*	欄位名稱:'相片名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:<br>
 	*/ 
	public	void setHosPhoto_name(String aHosPhoto_name) { 
		this.hosPhoto_name = aHosPhoto_name; 
	} 
 
	/** 
 	*	欄位名稱:'相片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:16<br>
	*	限制條件:<br>
 	*/ 
	public	void setHosPhoto_extent(String aHosPhoto_extent) { 
		this.hosPhoto_extent = aHosPhoto_extent; 
	} 
 
}
package com.anihome_photos.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:動物之家相簿<br>
 *	英文:aniHome_Photos<br>
 */ 
public class AniHome_PhotosVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'相片編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String aniHome_Photos_Id; 
 
	/** 
 	*	欄位名稱:'動物之家編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	private	String aniHome_Id; 
 
	/** 
 	*	欄位名稱:'動物之家照片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	byte[] aniHome_Photos_pic; 
 
	/** 
 	*	欄位名稱:'相片編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getAniHome_Photos_Id() { 
		return this.aniHome_Photos_Id;
	} 
	/** 
 	*	欄位名稱:'動物之家編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	String getAniHome_Id() { 
		return this.aniHome_Id;
	} 
	/** 
 	*	欄位名稱:'動物之家照片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	byte[] getAniHome_Photos_pic() { 
		return this.aniHome_Photos_pic;
	} 
	/** 
 	*	欄位名稱:'相片編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setAniHome_Photos_Id(String aAniHome_Photos_Id) { 
		this.aniHome_Photos_Id = aAniHome_Photos_Id; 
	} 
 
	/** 
 	*	欄位名稱:'動物之家編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	void setAniHome_Id(String aAniHome_Id) { 
		this.aniHome_Id = aAniHome_Id; 
	} 
 
	/** 
 	*	欄位名稱:'動物之家照片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setAniHome_Photos_pic(byte[] aAniHome_Photos_pic) { 
		this.aniHome_Photos_pic = aAniHome_Photos_pic; 
	} 
 
}
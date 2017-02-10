package com.second_prodphotos.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	二手商品相簿<br>
 *	英文:second_ProdPhotos<br>
 */ 
public class Second_ProdPhotosVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'二手商品相簿編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String second_ProdPhotos_Id; 
 
	/** 
 	*	欄位名稱:'二手商品編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL FK<br>
 	*/ 
	private	String second_Prod_Id; 
 
	/** 
 	*	欄位名稱:'二手商品相簿編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getSecond_ProdPhotos_Id() { 
		return this.second_ProdPhotos_Id;
	} 
	/** 
 	*	欄位名稱:'二手商品編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL FK<br>
 	*/ 
	public	String getSecond_Prod_Id() { 
		return this.second_Prod_Id;
	} 
	/** 
 	*	欄位名稱:'二手商品相簿編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setSecond_ProdPhotos_Id(String aSecond_ProdPhotos_Id) { 
		this.second_ProdPhotos_Id = aSecond_ProdPhotos_Id; 
	} 
 
	/** 
 	*	欄位名稱:'二手商品編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL FK<br>
 	*/ 
	public	void setSecond_Prod_Id(String aSecond_Prod_Id) { 
		this.second_Prod_Id = aSecond_Prod_Id; 
	} 
 
}
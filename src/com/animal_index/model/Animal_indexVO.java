package com.animal_index.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	動物圖鑑<br>
 *	英文:animal_index<br>
 */ 
public class Animal_indexVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'圖鑑編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String animal_No; 
 
	/** 
 	*	欄位名稱:'圖鑑敘述 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	private	String animal_detail; 
 
	/** 
 	*	欄位名稱:'圖鑑類別 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:2<br>
	*	限制條件:<br>
 	*/ 
	private	String animal_class; 
 
	/** 
 	*	欄位名稱:'圖鑑類別照片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:2<br>
	*	限制條件:<br>
 	*/ 
	private	String animal_class_No; 
 
	/** 
 	*	欄位名稱:'圖鑑編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getAnimal_No() { 
		return this.animal_No;
	} 
	/** 
 	*	欄位名稱:'圖鑑敘述 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	public	String getAnimal_detail() { 
		return this.animal_detail;
	} 
	/** 
 	*	欄位名稱:'圖鑑類別 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:2<br>
	*	限制條件:<br>
 	*/ 
	public	String getAnimal_class() { 
		return this.animal_class;
	} 
	/** 
 	*	欄位名稱:'圖鑑類別照片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:2<br>
	*	限制條件:<br>
 	*/ 
	public	String getAnimal_class_No() { 
		return this.animal_class_No;
	} 
	/** 
 	*	欄位名稱:'圖鑑編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setAnimal_No(String aAnimal_No) { 
		this.animal_No = aAnimal_No; 
	} 
 
	/** 
 	*	欄位名稱:'圖鑑敘述 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	public	void setAnimal_detail(String aAnimal_detail) { 
		this.animal_detail = aAnimal_detail; 
	} 
 
	/** 
 	*	欄位名稱:'圖鑑類別 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:2<br>
	*	限制條件:<br>
 	*/ 
	public	void setAnimal_class(String aAnimal_class) { 
		this.animal_class = aAnimal_class; 
	} 
 
	/** 
 	*	欄位名稱:'圖鑑類別照片編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:2<br>
	*	限制條件:<br>
 	*/ 
	public	void setAnimal_class_No(String aAnimal_class_No) { 
		this.animal_class_No = aAnimal_class_No; 
	} 
 
}
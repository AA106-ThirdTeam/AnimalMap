package com.purview.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:權限<br>
 *	英文:purview<br>
 */ 
public class PurviewVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'權限編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String purview_No; 
 
	/** 
 	*	欄位名稱:'權限名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	private	String pruview_name; 
 
	/** 
 	*	欄位名稱:'權限編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getPurview_No() { 
		return this.purview_No;
	} 
	/** 
 	*	欄位名稱:'權限名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	String getPruview_name() { 
		return this.pruview_name;
	} 
	/** 
 	*	欄位名稱:'權限編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setPurview_No(String aPurview_No) { 
		this.purview_No = aPurview_No; 
	} 
 
	/** 
 	*	欄位名稱:'權限名稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	void setPruview_name(String aPruview_name) { 
		this.pruview_name = aPruview_name; 
	} 
 
}
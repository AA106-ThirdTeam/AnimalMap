package com.emp_purview.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	員工權限<br>
 *	英文:emp_purview<br>
 */ 
public class Emp_purviewVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'員工編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK FK<br>
 	*/ 
	private	String emp_No; 
 
	/** 
 	*	欄位名稱:'權限編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK FK<br>
 	*/ 
	private	String purview_No; 
 
	/** 
 	*	欄位名稱:'員工編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK FK<br>
 	*/ 
	public	String getEmp_No() { 
		return this.emp_No;
	} 
	/** 
 	*	欄位名稱:'權限編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK FK<br>
 	*/ 
	public	String getPurview_No() { 
		return this.purview_No;
	} 
	/** 
 	*	欄位名稱:'員工編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK FK<br>
 	*/ 
	public	void setEmp_No(String aEmp_No) { 
		this.emp_No = aEmp_No; 
	} 
 
	/** 
 	*	欄位名稱:'權限編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK FK<br>
 	*/ 
	public	void setPurview_No(String aPurview_No) { 
		this.purview_No = aPurview_No; 
	} 
 
}
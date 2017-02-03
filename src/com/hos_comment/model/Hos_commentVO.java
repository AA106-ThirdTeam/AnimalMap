package com.hos_comment.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	診所留言<br>
 *	英文:hos_comment<br>
 */ 
public class Hos_commentVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'診所留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String hosComm_Id; 
 
	/** 
 	*	欄位名稱:'發送會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String hosComm_MemId; 
 
	/** 
 	*	欄位名稱:'診所編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String hosComm_HosId; 
 
	/** 
 	*	欄位名稱:'發送內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String hosComm_content; 
 
	/** 
 	*	欄位名稱:'發送時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	Date hosComm_SendTime; 
 
	/** 
 	*	欄位名稱:'診所留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getHosComm_Id() { 
		return this.hosComm_Id;
	} 
	/** 
 	*	欄位名稱:'發送會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getHosComm_MemId() { 
		return this.hosComm_MemId;
	} 
	/** 
 	*	欄位名稱:'診所編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getHosComm_HosId() { 
		return this.hosComm_HosId;
	} 
	/** 
 	*	欄位名稱:'發送內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getHosComm_content() { 
		return this.hosComm_content;
	} 
	/** 
 	*	欄位名稱:'發送時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	Date getHosComm_SendTime() { 
		return this.hosComm_SendTime;
	} 
	/** 
 	*	欄位名稱:'診所留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setHosComm_Id(String aHosComm_Id) { 
		this.hosComm_Id = aHosComm_Id; 
	} 
 
	/** 
 	*	欄位名稱:'發送會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setHosComm_MemId(String aHosComm_MemId) { 
		this.hosComm_MemId = aHosComm_MemId; 
	} 
 
	/** 
 	*	欄位名稱:'診所編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setHosComm_HosId(String aHosComm_HosId) { 
		this.hosComm_HosId = aHosComm_HosId; 
	} 
 
	/** 
 	*	欄位名稱:'發送內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setHosComm_content(String aHosComm_content) { 
		this.hosComm_content = aHosComm_content; 
	} 
 
	/** 
 	*	欄位名稱:'發送時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setHosComm_SendTime(Date aHosComm_SendTime) { 
		this.hosComm_SendTime = aHosComm_SendTime; 
	} 
 
}
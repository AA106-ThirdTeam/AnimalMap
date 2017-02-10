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
	private	String hosComment_Id; 
 
	/** 
 	*	欄位名稱:'發送會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String hosComment_MemId; 
 
	/** 
 	*	欄位名稱:'診所編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String hosComment_HosId; 
 
	/** 
 	*	欄位名稱:'發送內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String hosComment_content; 
 
	/** 
 	*	欄位名稱:'發送時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	Date hosComment_SendTime; 
 
	/** 
 	*	欄位名稱:'診所留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getHosComment_Id() { 
		return this.hosComment_Id;
	} 
	/** 
 	*	欄位名稱:'發送會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getHosComment_MemId() { 
		return this.hosComment_MemId;
	} 
	/** 
 	*	欄位名稱:'診所編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getHosComment_HosId() { 
		return this.hosComment_HosId;
	} 
	/** 
 	*	欄位名稱:'發送內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getHosComment_content() { 
		return this.hosComment_content;
	} 
	/** 
 	*	欄位名稱:'發送時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	Date getHosComment_SendTime() { 
		return this.hosComment_SendTime;
	} 
	/** 
 	*	欄位名稱:'診所留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setHosComment_Id(String aHosComment_Id) { 
		this.hosComment_Id = aHosComment_Id; 
	} 
 
	/** 
 	*	欄位名稱:'發送會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setHosComment_MemId(String aHosComment_MemId) { 
		this.hosComment_MemId = aHosComment_MemId; 
	} 
 
	/** 
 	*	欄位名稱:'診所編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setHosComment_HosId(String aHosComment_HosId) { 
		this.hosComment_HosId = aHosComment_HosId; 
	} 
 
	/** 
 	*	欄位名稱:'發送內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setHosComment_content(String aHosComment_content) { 
		this.hosComment_content = aHosComment_content; 
	} 
 
	/** 
 	*	欄位名稱:'發送時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setHosComment_SendTime(Date aHosComment_SendTime) { 
		this.hosComment_SendTime = aHosComment_SendTime; 
	} 
 
}
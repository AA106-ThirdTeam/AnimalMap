package com.grp_comment.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	揪團留言<br>
 *	英文:grp_comment<br>
 */ 
public class Grp_commentVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'揪團留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String grpComment_Id; 
 
	/** 
 	*	欄位名稱:'發送會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String grpComment_MemId; 
 
	/** 
 	*	欄位名稱:'揪團編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL(FK)<br>
 	*/ 
	private	String grpComment_GrpId; 
 
	/** 
 	*	欄位名稱:'發送內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	private	String grpComment_content; 
 
	/** 
 	*	欄位名稱:'發送時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date grpComment_SendTime; 
 
	/** 
 	*	欄位名稱:'揪團留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getGrpComment_Id() { 
		return this.grpComment_Id;
	} 
	/** 
 	*	欄位名稱:'發送會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getGrpComment_MemId() { 
		return this.grpComment_MemId;
	} 
	/** 
 	*	欄位名稱:'揪團編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL(FK)<br>
 	*/ 
	public	String getGrpComment_GrpId() { 
		return this.grpComment_GrpId;
	} 
	/** 
 	*	欄位名稱:'發送內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	public	String getGrpComment_content() { 
		return this.grpComment_content;
	} 
	/** 
 	*	欄位名稱:'發送時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getGrpComment_SendTime() { 
		return this.grpComment_SendTime;
	} 
	/** 
 	*	欄位名稱:'揪團留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setGrpComment_Id(String aGrpComment_Id) { 
		this.grpComment_Id = aGrpComment_Id; 
	} 
 
	/** 
 	*	欄位名稱:'發送會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setGrpComment_MemId(String aGrpComment_MemId) { 
		this.grpComment_MemId = aGrpComment_MemId; 
	} 
 
	/** 
 	*	欄位名稱:'揪團編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL(FK)<br>
 	*/ 
	public	void setGrpComment_GrpId(String aGrpComment_GrpId) { 
		this.grpComment_GrpId = aGrpComment_GrpId; 
	} 
 
	/** 
 	*	欄位名稱:'發送內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	public	void setGrpComment_content(String aGrpComment_content) { 
		this.grpComment_content = aGrpComment_content; 
	} 
 
	/** 
 	*	欄位名稱:'發送時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setGrpComment_SendTime(Date aGrpComment_SendTime) { 
		this.grpComment_SendTime = aGrpComment_SendTime; 
	} 
 
}
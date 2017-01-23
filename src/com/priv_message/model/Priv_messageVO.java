package com.priv_message.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:私人訊息<br>
 *	英文:priv_message<br>
 */ 
public class Priv_messageVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'訊息編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String privMes_Id; 
 
	/** 
 	*	欄位名稱:'發送會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String privMesSend_MemId; 
 
	/** 
 	*	欄位名稱:'接收會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String privMesRec_MemId; 
 
	/** 
 	*	欄位名稱:'訊息內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	private	String privMes_content; 
 
	/** 
 	*	欄位名稱:'發送時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date privMes_SendTime; 
 
	/** 
 	*	欄位名稱:'訊息類別 | PS: 0:交友邀請; 1:揪團邀請; 2:後端訊息'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String privMes_type; 
 
	/** 
 	*	欄位名稱:'訊息編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getPrivMes_Id() { 
		return this.privMes_Id;
	} 
	/** 
 	*	欄位名稱:'發送會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getPrivMesSend_MemId() { 
		return this.privMesSend_MemId;
	} 
	/** 
 	*	欄位名稱:'接收會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getPrivMesRec_MemId() { 
		return this.privMesRec_MemId;
	} 
	/** 
 	*	欄位名稱:'訊息內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	public	String getPrivMes_content() { 
		return this.privMes_content;
	} 
	/** 
 	*	欄位名稱:'發送時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getPrivMes_SendTime() { 
		return this.privMes_SendTime;
	} 
	/** 
 	*	欄位名稱:'訊息類別 | PS: 0:交友邀請; 1:揪團邀請; 2:後端訊息'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getPrivMes_type() { 
		return this.privMes_type;
	} 
	/** 
 	*	欄位名稱:'訊息編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setPrivMes_Id(String aPrivMes_Id) { 
		this.privMes_Id = aPrivMes_Id; 
	} 
 
	/** 
 	*	欄位名稱:'發送會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setPrivMesSend_MemId(String aPrivMesSend_MemId) { 
		this.privMesSend_MemId = aPrivMesSend_MemId; 
	} 
 
	/** 
 	*	欄位名稱:'接收會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setPrivMesRec_MemId(String aPrivMesRec_MemId) { 
		this.privMesRec_MemId = aPrivMesRec_MemId; 
	} 
 
	/** 
 	*	欄位名稱:'訊息內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:<br>
 	*/ 
	public	void setPrivMes_content(String aPrivMes_content) { 
		this.privMes_content = aPrivMes_content; 
	} 
 
	/** 
 	*	欄位名稱:'發送時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setPrivMes_SendTime(Date aPrivMes_SendTime) { 
		this.privMes_SendTime = aPrivMes_SendTime; 
	} 
 
	/** 
 	*	欄位名稱:'訊息類別 | PS: 0:交友邀請; 1:揪團邀請; 2:後端訊息'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setPrivMes_type(String aPrivMes_type) { 
		this.privMes_type = aPrivMes_type; 
	} 
 
}
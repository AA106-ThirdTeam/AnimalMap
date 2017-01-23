package com.offimsg.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:公告訊息<br>
 *	英文:offiMsg<br>
 */ 
public class OffiMsgVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'訊息編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String offiMsg_Id; 
 
	/** 
 	*	欄位名稱:'發布員工編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String offiMsg_empId; 
 
	/** 
 	*	欄位名稱:'訊息標題 | PS: 標題上限字數-30個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:90<br>
	*	限制條件:<br>
 	*/ 
	private	String offiMsg_Title; 
 
	/** 
 	*	欄位名稱:'訊息內容 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	private	String offiMsg_Content; 
 
	/** 
 	*	欄位名稱:'訊息發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date offiMsg_Date; 
 
	/** 
 	*	欄位名稱:'訊息編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getOffiMsg_Id() { 
		return this.offiMsg_Id;
	} 
	/** 
 	*	欄位名稱:'發布員工編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getOffiMsg_empId() { 
		return this.offiMsg_empId;
	} 
	/** 
 	*	欄位名稱:'訊息標題 | PS: 標題上限字數-30個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:90<br>
	*	限制條件:<br>
 	*/ 
	public	String getOffiMsg_Title() { 
		return this.offiMsg_Title;
	} 
	/** 
 	*	欄位名稱:'訊息內容 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	String getOffiMsg_Content() { 
		return this.offiMsg_Content;
	} 
	/** 
 	*	欄位名稱:'訊息發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getOffiMsg_Date() { 
		return this.offiMsg_Date;
	} 
	/** 
 	*	欄位名稱:'訊息編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setOffiMsg_Id(String aOffiMsg_Id) { 
		this.offiMsg_Id = aOffiMsg_Id; 
	} 
 
	/** 
 	*	欄位名稱:'發布員工編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setOffiMsg_empId(String aOffiMsg_empId) { 
		this.offiMsg_empId = aOffiMsg_empId; 
	} 
 
	/** 
 	*	欄位名稱:'訊息標題 | PS: 標題上限字數-30個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:90<br>
	*	限制條件:<br>
 	*/ 
	public	void setOffiMsg_Title(String aOffiMsg_Title) { 
		this.offiMsg_Title = aOffiMsg_Title; 
	} 
 
	/** 
 	*	欄位名稱:'訊息內容 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	void setOffiMsg_Content(String aOffiMsg_Content) { 
		this.offiMsg_Content = aOffiMsg_Content; 
	} 
 
	/** 
 	*	欄位名稱:'訊息發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setOffiMsg_Date(Date aOffiMsg_Date) { 
		this.offiMsg_Date = aOffiMsg_Date; 
	} 
 
}
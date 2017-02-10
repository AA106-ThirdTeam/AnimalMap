package com.emg_h_msg.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	緊急求救留言<br>
 *	英文:emg_H_Msg<br>
 */ 
public class Emg_H_MsgVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'緊急求救留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String emg_H_Msg_Id; 
 
	/** 
 	*	欄位名稱:'留言會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'求救編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	private	String emg_H_Id; 
 
	/** 
 	*	欄位名稱:'發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date emg_H_Msg_start; 
 
	/** 
 	*	欄位名稱:'留言內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String emg_H_Msg_content; 
 
	/** 
 	*	欄位名稱:'緊急求救留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getEmg_H_Msg_Id() { 
		return this.emg_H_Msg_Id;
	} 
	/** 
 	*	欄位名稱:'留言會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	/** 
 	*	欄位名稱:'求救編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	String getEmg_H_Id() { 
		return this.emg_H_Id;
	} 
	/** 
 	*	欄位名稱:'發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getEmg_H_Msg_start() { 
		return this.emg_H_Msg_start;
	} 
	/** 
 	*	欄位名稱:'留言內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getEmg_H_Msg_content() { 
		return this.emg_H_Msg_content;
	} 
	/** 
 	*	欄位名稱:'緊急求救留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setEmg_H_Msg_Id(String aEmg_H_Msg_Id) { 
		this.emg_H_Msg_Id = aEmg_H_Msg_Id; 
	} 
 
	/** 
 	*	欄位名稱:'留言會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	/** 
 	*	欄位名稱:'求救編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	void setEmg_H_Id(String aEmg_H_Id) { 
		this.emg_H_Id = aEmg_H_Id; 
	} 
 
	/** 
 	*	欄位名稱:'發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setEmg_H_Msg_start(Date aEmg_H_Msg_start) { 
		this.emg_H_Msg_start = aEmg_H_Msg_start; 
	} 
 
	/** 
 	*	欄位名稱:'留言內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setEmg_H_Msg_content(String aEmg_H_Msg_content) { 
		this.emg_H_Msg_content = aEmg_H_Msg_content; 
	} 
 
}
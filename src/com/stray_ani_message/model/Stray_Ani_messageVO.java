package com.stray_ani_message.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	社區流浪動物留言<br>
 *	英文:stray_Ani_message<br>
 */ 
public class Stray_Ani_messageVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'流浪動物留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String str_Ani_Mes_No; 
 
	/** 
 	*	欄位名稱:'社區動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String stray_Ani_Id; 
 
	/** 
 	*	欄位名稱:'發布者會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date str_Ani_Mes_time; 
 
	/** 
 	*	欄位名稱:'流浪動物留言 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String str_Ani_Mes; 
 
	/** 
 	*	欄位名稱:'流浪動物留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getStr_Ani_Mes_No() { 
		return this.str_Ani_Mes_No;
	} 
	/** 
 	*	欄位名稱:'社區動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getStray_Ani_Id() { 
		return this.stray_Ani_Id;
	} 
	/** 
 	*	欄位名稱:'發布者會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	/** 
 	*	欄位名稱:'發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getStr_Ani_Mes_time() { 
		return this.str_Ani_Mes_time;
	} 
	/** 
 	*	欄位名稱:'流浪動物留言 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getStr_Ani_Mes() { 
		return this.str_Ani_Mes;
	} 
	/** 
 	*	欄位名稱:'流浪動物留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setStr_Ani_Mes_No(String aStr_Ani_Mes_No) { 
		this.str_Ani_Mes_No = aStr_Ani_Mes_No; 
	} 
 
	/** 
 	*	欄位名稱:'社區動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setStray_Ani_Id(String aStray_Ani_Id) { 
		this.stray_Ani_Id = aStray_Ani_Id; 
	} 
 
	/** 
 	*	欄位名稱:'發布者會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	/** 
 	*	欄位名稱:'發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setStr_Ani_Mes_time(Date aStr_Ani_Mes_time) { 
		this.str_Ani_Mes_time = aStr_Ani_Mes_time; 
	} 
 
	/** 
 	*	欄位名稱:'流浪動物留言 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:300<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setStr_Ani_Mes(String aStr_Ani_Mes) { 
		this.str_Ani_Mes = aStr_Ani_Mes; 
	} 
 
}
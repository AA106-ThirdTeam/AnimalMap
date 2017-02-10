package com.adopt_ani_message.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	送養動物留言<br>
 *	英文:adopt_Ani_message<br>
 */ 
public class Adopt_Ani_messageVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'送養動物留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String ado_Ani_Mes_No; 
 
	/** 
 	*	欄位名稱:'社區動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String adopt_Ani_Id; 
 
	/** 
 	*	欄位名稱:'送養動物會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'送養動物留言 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:100<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String ado_Ani_Mes; 
 
	/** 
 	*	欄位名稱:'發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date ado_Ani_Mes_time; 
 
	/** 
 	*	欄位名稱:'送養動物留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getAdo_Ani_Mes_No() { 
		return this.ado_Ani_Mes_No;
	} 
	/** 
 	*	欄位名稱:'社區動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getAdopt_Ani_Id() { 
		return this.adopt_Ani_Id;
	} 
	/** 
 	*	欄位名稱:'送養動物會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	/** 
 	*	欄位名稱:'送養動物留言 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:100<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getAdo_Ani_Mes() { 
		return this.ado_Ani_Mes;
	} 
	/** 
 	*	欄位名稱:'發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getAdo_Ani_Mes_time() { 
		return this.ado_Ani_Mes_time;
	} 
	/** 
 	*	欄位名稱:'送養動物留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setAdo_Ani_Mes_No(String aAdo_Ani_Mes_No) { 
		this.ado_Ani_Mes_No = aAdo_Ani_Mes_No; 
	} 
 
	/** 
 	*	欄位名稱:'社區動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setAdopt_Ani_Id(String aAdopt_Ani_Id) { 
		this.adopt_Ani_Id = aAdopt_Ani_Id; 
	} 
 
	/** 
 	*	欄位名稱:'送養動物會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	/** 
 	*	欄位名稱:'送養動物留言 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:100<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setAdo_Ani_Mes(String aAdo_Ani_Mes) { 
		this.ado_Ani_Mes = aAdo_Ani_Mes; 
	} 
 
	/** 
 	*	欄位名稱:'發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdo_Ani_Mes_time(Date aAdo_Ani_Mes_time) { 
		this.ado_Ani_Mes_time = aAdo_Ani_Mes_time; 
	} 
 
}
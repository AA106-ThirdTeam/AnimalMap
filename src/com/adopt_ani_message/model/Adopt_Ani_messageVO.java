package com.adopt_ani_message.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:送養動物留言<br>
 *	英文:adopt_Ani_message<br>
 */ 
public class Adopt_Ani_messageVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String ado_Ani_Mes_No; 
	private	String adopt_Ani_Id; 
	private	String mem_Id; 
	private	String ado_Ani_Mes; 
	private	Date ado_Ani_Mes_time; 
	public	String getAdo_Ani_Mes_No() { 
		return this.ado_Ani_Mes_No;
	} 
	public	String getAdopt_Ani_Id() { 
		return this.adopt_Ani_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	String getAdo_Ani_Mes() { 
		return this.ado_Ani_Mes;
	} 
	public	Date getAdo_Ani_Mes_time() { 
		return this.ado_Ani_Mes_time;
	} 
	public	void setAdo_Ani_Mes_No(String aAdo_Ani_Mes_No) { 
		this.ado_Ani_Mes_No = aAdo_Ani_Mes_No; 
	} 
 
	public	void setAdopt_Ani_Id(String aAdopt_Ani_Id) { 
		this.adopt_Ani_Id = aAdopt_Ani_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setAdo_Ani_Mes(String aAdo_Ani_Mes) { 
		this.ado_Ani_Mes = aAdo_Ani_Mes; 
	} 
 
	public	void setAdo_Ani_Mes_time(Date aAdo_Ani_Mes_time) { 
		this.ado_Ani_Mes_time = aAdo_Ani_Mes_time; 
	} 
 
}
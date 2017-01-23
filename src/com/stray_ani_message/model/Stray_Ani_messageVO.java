package com.stray_ani_message.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class Stray_Ani_messageVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String str_Ani_Mes_No; 
	private	String stray_Ani_Id; 
	private	String mem_Id; 
	private	Date str_Ani_Mes_time; 
	private	String str_Ani_Mes; 
	public	String getStr_Ani_Mes_No() { 
		return this.str_Ani_Mes_No;
	} 
	public	String getStray_Ani_Id() { 
		return this.stray_Ani_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	Date getStr_Ani_Mes_time() { 
		return this.str_Ani_Mes_time;
	} 
	public	String getStr_Ani_Mes() { 
		return this.str_Ani_Mes;
	} 
	public	void setStr_Ani_Mes_No(String aStr_Ani_Mes_No) { 
		this.str_Ani_Mes_No = aStr_Ani_Mes_No; 
	} 
 
	public	void setStray_Ani_Id(String aStray_Ani_Id) { 
		this.stray_Ani_Id = aStray_Ani_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setStr_Ani_Mes_time(Date aStr_Ani_Mes_time) { 
		this.str_Ani_Mes_time = aStr_Ani_Mes_time; 
	} 
 
	public	void setStr_Ani_Mes(String aStr_Ani_Mes) { 
		this.str_Ani_Mes = aStr_Ani_Mes; 
	} 
 
}
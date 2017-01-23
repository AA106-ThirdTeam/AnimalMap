package com.pet_message.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:自家寵物留言<br>
 *	英文:pet_Message<br>
 */ 
public class Pet_MessageVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String pet_Mes_No; 
	private	String pet_Id; 
	private	String mem_Id; 
	private	String pet_Mes; 
	private	Date pet_Mes_time; 
	public	String getPet_Mes_No() { 
		return this.pet_Mes_No;
	} 
	public	String getPet_Id() { 
		return this.pet_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	String getPet_Mes() { 
		return this.pet_Mes;
	} 
	public	Date getPet_Mes_time() { 
		return this.pet_Mes_time;
	} 
	public	void setPet_Mes_No(String aPet_Mes_No) { 
		this.pet_Mes_No = aPet_Mes_No; 
	} 
 
	public	void setPet_Id(String aPet_Id) { 
		this.pet_Id = aPet_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setPet_Mes(String aPet_Mes) { 
		this.pet_Mes = aPet_Mes; 
	} 
 
	public	void setPet_Mes_time(Date aPet_Mes_time) { 
		this.pet_Mes_time = aPet_Mes_time; 
	} 
 
}
package com.charge.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class ChargeVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String charge_no; 
	private	String mem_Id; 
	private	Integer charge_NUMBER; 
	private	Integer pay; 
	private	Date applytime; 
	public	String getCharge_no() { 
		return this.charge_no;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	Integer getCharge_NUMBER() { 
		return this.charge_NUMBER;
	} 
	public	Integer getPay() { 
		return this.pay;
	} 
	public	Date getApplytime() { 
		return this.applytime;
	} 
	public	void setCharge_no(String aCharge_no) { 
		this.charge_no = aCharge_no; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setCharge_NUMBER(Integer aCharge_NUMBER) { 
		this.charge_NUMBER = aCharge_NUMBER; 
	} 
 
	public	void setPay(Integer aPay) { 
		this.pay = aPay; 
	} 
 
	public	void setApplytime(Date aApplytime) { 
		this.applytime = aApplytime; 
	} 
 
}
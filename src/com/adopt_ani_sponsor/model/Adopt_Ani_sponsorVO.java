package com.adopt_ani_sponsor.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class Adopt_Ani_sponsorVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String ado_Ani_Spo_No; 
	private	String adopt_Ani_Id; 
	private	String mem_Id; 
	private	Integer ado_Ani_Spo_money; 
	private	String adoAniSpoMat; 
	public	String getAdo_Ani_Spo_No() { 
		return this.ado_Ani_Spo_No;
	} 
	public	String getAdopt_Ani_Id() { 
		return this.adopt_Ani_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	Integer getAdo_Ani_Spo_money() { 
		return this.ado_Ani_Spo_money;
	} 
	public	String getAdoAniSpoMat() { 
		return this.adoAniSpoMat;
	} 
	public	void setAdo_Ani_Spo_No(String aAdo_Ani_Spo_No) { 
		this.ado_Ani_Spo_No = aAdo_Ani_Spo_No; 
	} 
 
	public	void setAdopt_Ani_Id(String aAdopt_Ani_Id) { 
		this.adopt_Ani_Id = aAdopt_Ani_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setAdo_Ani_Spo_money(Integer aAdo_Ani_Spo_money) { 
		this.ado_Ani_Spo_money = aAdo_Ani_Spo_money; 
	} 
 
	public	void setAdoAniSpoMat(String aAdoAniSpoMat) { 
		this.adoAniSpoMat = aAdoAniSpoMat; 
	} 
 
}
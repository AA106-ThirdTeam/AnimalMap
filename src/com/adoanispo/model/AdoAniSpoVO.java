package com.adoanispo.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:送養動物領養人<br>
 *	英文:adoAniSpo<br>
 */ 
public class AdoAniSpoVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String adoAniSpoNo; 
	private	String adoAniSpoAniId; 
	private	String adoAniSpomem_Id; 
	private	Integer adoAniSpoMoney; 
	private	String adoAniSpoMat; 
	public	String getAdoAniSpoNo() { 
		return this.adoAniSpoNo;
	} 
	public	String getAdoAniSpoAniId() { 
		return this.adoAniSpoAniId;
	} 
	public	String getAdoAniSpomem_Id() { 
		return this.adoAniSpomem_Id;
	} 
	public	Integer getAdoAniSpoMoney() { 
		return this.adoAniSpoMoney;
	} 
	public	String getAdoAniSpoMat() { 
		return this.adoAniSpoMat;
	} 
	public	void setAdoAniSpoNo(String aAdoAniSpoNo) { 
		this.adoAniSpoNo = aAdoAniSpoNo; 
	} 
 
	public	void setAdoAniSpoAniId(String aAdoAniSpoAniId) { 
		this.adoAniSpoAniId = aAdoAniSpoAniId; 
	} 
 
	public	void setAdoAniSpomem_Id(String aAdoAniSpomem_Id) { 
		this.adoAniSpomem_Id = aAdoAniSpomem_Id; 
	} 
 
	public	void setAdoAniSpoMoney(Integer aAdoAniSpoMoney) { 
		this.adoAniSpoMoney = aAdoAniSpoMoney; 
	} 
 
	public	void setAdoAniSpoMat(String aAdoAniSpoMat) { 
		this.adoAniSpoMat = aAdoAniSpoMat; 
	} 
 
}
package com.adopt_ani_sponsor.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:送養動物贊助<br>
 *	英文:adopt_Ani_sponsor<br>
 */ 
public class Adopt_Ani_sponsorVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'送養動物贊助編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String ado_Ani_Spo_No; 
 
	/** 
 	*	欄位名稱:'送養動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String adopt_Ani_Id; 
 
	/** 
 	*	欄位名稱:'贊助者會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'贊助送養動物金額 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:<br>
 	*/ 
	private	Integer ado_Ani_Spo_money; 
 
	/** 
 	*	欄位名稱:'贊助送養動物物資 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:<br>
 	*/ 
	private	String adoAniSpoMat; 
 
	/** 
 	*	欄位名稱:'送養動物贊助編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getAdo_Ani_Spo_No() { 
		return this.ado_Ani_Spo_No;
	} 
	/** 
 	*	欄位名稱:'送養動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getAdopt_Ani_Id() { 
		return this.adopt_Ani_Id;
	} 
	/** 
 	*	欄位名稱:'贊助者會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	/** 
 	*	欄位名稱:'贊助送養動物金額 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:<br>
 	*/ 
	public	Integer getAdo_Ani_Spo_money() { 
		return this.ado_Ani_Spo_money;
	} 
	/** 
 	*	欄位名稱:'贊助送養動物物資 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:<br>
 	*/ 
	public	String getAdoAniSpoMat() { 
		return this.adoAniSpoMat;
	} 
	/** 
 	*	欄位名稱:'送養動物贊助編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setAdo_Ani_Spo_No(String aAdo_Ani_Spo_No) { 
		this.ado_Ani_Spo_No = aAdo_Ani_Spo_No; 
	} 
 
	/** 
 	*	欄位名稱:'送養動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setAdopt_Ani_Id(String aAdopt_Ani_Id) { 
		this.adopt_Ani_Id = aAdopt_Ani_Id; 
	} 
 
	/** 
 	*	欄位名稱:'贊助者會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	/** 
 	*	欄位名稱:'贊助送養動物金額 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdo_Ani_Spo_money(Integer aAdo_Ani_Spo_money) { 
		this.ado_Ani_Spo_money = aAdo_Ani_Spo_money; 
	} 
 
	/** 
 	*	欄位名稱:'贊助送養動物物資 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdoAniSpoMat(String aAdoAniSpoMat) { 
		this.adoAniSpoMat = aAdoAniSpoMat; 
	} 
 
}
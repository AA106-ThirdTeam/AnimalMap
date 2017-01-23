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
	/** 
 	*	欄位名稱:'送養動物贊助編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String adoAniSpoNo; 
 
	/** 
 	*	欄位名稱:'送養動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String adoAniSpoAniId; 
 
	/** 
 	*	欄位名稱:'贊助者會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String adoAniSpomem_Id; 
 
	/** 
 	*	欄位名稱:'贊助送養動物金額 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:<br>
 	*/ 
	private	Integer adoAniSpoMoney; 
 
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
	public	String getAdoAniSpoNo() { 
		return this.adoAniSpoNo;
	} 
	/** 
 	*	欄位名稱:'送養動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getAdoAniSpoAniId() { 
		return this.adoAniSpoAniId;
	} 
	/** 
 	*	欄位名稱:'贊助者會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getAdoAniSpomem_Id() { 
		return this.adoAniSpomem_Id;
	} 
	/** 
 	*	欄位名稱:'贊助送養動物金額 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:<br>
 	*/ 
	public	Integer getAdoAniSpoMoney() { 
		return this.adoAniSpoMoney;
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
	public	void setAdoAniSpoNo(String aAdoAniSpoNo) { 
		this.adoAniSpoNo = aAdoAniSpoNo; 
	} 
 
	/** 
 	*	欄位名稱:'送養動物編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setAdoAniSpoAniId(String aAdoAniSpoAniId) { 
		this.adoAniSpoAniId = aAdoAniSpoAniId; 
	} 
 
	/** 
 	*	欄位名稱:'贊助者會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setAdoAniSpomem_Id(String aAdoAniSpomem_Id) { 
		this.adoAniSpomem_Id = aAdoAniSpomem_Id; 
	} 
 
	/** 
 	*	欄位名稱:'贊助送養動物金額 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdoAniSpoMoney(Integer aAdoAniSpoMoney) { 
		this.adoAniSpoMoney = aAdoAniSpoMoney; 
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
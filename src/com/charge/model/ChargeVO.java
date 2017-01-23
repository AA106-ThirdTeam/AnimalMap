package com.charge.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:儲值<br>
 *	英文:charge<br>
 */ 
public class ChargeVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'儲值編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String charge_no; 
 
	/** 
 	*	欄位名稱:'會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'儲值金額 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	Integer charge_NUMBER; 
 
	/** 
 	*	欄位名稱:'付款方式 | PS: 1.ATM 2.超商'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	Integer pay; 
 
	/** 
 	*	欄位名稱:'儲值時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	Date applytime; 
 
	/** 
 	*	欄位名稱:'儲值編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getCharge_no() { 
		return this.charge_no;
	} 
	/** 
 	*	欄位名稱:'會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	/** 
 	*	欄位名稱:'儲值金額 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	Integer getCharge_NUMBER() { 
		return this.charge_NUMBER;
	} 
	/** 
 	*	欄位名稱:'付款方式 | PS: 1.ATM 2.超商'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	Integer getPay() { 
		return this.pay;
	} 
	/** 
 	*	欄位名稱:'儲值時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	Date getApplytime() { 
		return this.applytime;
	} 
	/** 
 	*	欄位名稱:'儲值編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setCharge_no(String aCharge_no) { 
		this.charge_no = aCharge_no; 
	} 
 
	/** 
 	*	欄位名稱:'會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	/** 
 	*	欄位名稱:'儲值金額 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:15<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setCharge_NUMBER(Integer aCharge_NUMBER) { 
		this.charge_NUMBER = aCharge_NUMBER; 
	} 
 
	/** 
 	*	欄位名稱:'付款方式 | PS: 1.ATM 2.超商'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setPay(Integer aPay) { 
		this.pay = aPay; 
	} 
 
	/** 
 	*	欄位名稱:'儲值時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setApplytime(Date aApplytime) { 
		this.applytime = aApplytime; 
	} 
 
}
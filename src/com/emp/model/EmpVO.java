package com.emp.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:員工<br>
 *	英文:emp<br>
 */ 
public class EmpVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'員工編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String emp_No; 
 
	/** 
 	*	欄位名稱:'員工姓名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String emp_name; 
 
	/** 
 	*	欄位名稱:'員工密碼 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String emp_Pw; 
 
	/** 
 	*	欄位名稱:'員工信箱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:UNIQUE<br>
 	*/ 
	private	String emp_email; 
 
	/** 
 	*	欄位名稱:'員工身分證 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:UNIQUE<br>
 	*/ 
	private	String emp_Id; 
 
	/** 
 	*	欄位名稱:'員工出生年月日 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date emp_birthday; 
 
	/** 
 	*	欄位名稱:'員工電話 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:<br>
 	*/ 
	private	String emp_phone; 
 
	/** 
 	*	欄位名稱:'員工地址 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:100<br>
	*	限制條件:<br>
 	*/ 
	private	String emp_address; 
 
	/** 
 	*	欄位名稱:'員工狀態 | PS: 1:在職 0: 離職'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	String emp_status; 
 
	/** 
 	*	欄位名稱:'員工照片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	byte[] emp_picture; 
 
	/** 
 	*	欄位名稱:'員工照片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:10<br>
	*	限制條件:<br>
 	*/ 
	private	String emp_Pic_format; 
 
	/** 
 	*	欄位名稱:'雇用日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	Date emp_hiredate; 
 
	/** 
 	*	欄位名稱:'離職日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date emp_firedate; 
 
	/** 
 	*	欄位名稱:'員工編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getEmp_No() { 
		return this.emp_No;
	} 
	/** 
 	*	欄位名稱:'員工姓名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getEmp_name() { 
		return this.emp_name;
	} 
	/** 
 	*	欄位名稱:'員工密碼 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getEmp_Pw() { 
		return this.emp_Pw;
	} 
	/** 
 	*	欄位名稱:'員工信箱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:UNIQUE<br>
 	*/ 
	public	String getEmp_email() { 
		return this.emp_email;
	} 
	/** 
 	*	欄位名稱:'員工身分證 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:UNIQUE<br>
 	*/ 
	public	String getEmp_Id() { 
		return this.emp_Id;
	} 
	/** 
 	*	欄位名稱:'員工出生年月日 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getEmp_birthday() { 
		return this.emp_birthday;
	} 
	/** 
 	*	欄位名稱:'員工電話 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:<br>
 	*/ 
	public	String getEmp_phone() { 
		return this.emp_phone;
	} 
	/** 
 	*	欄位名稱:'員工地址 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:100<br>
	*	限制條件:<br>
 	*/ 
	public	String getEmp_address() { 
		return this.emp_address;
	} 
	/** 
 	*	欄位名稱:'員工狀態 | PS: 1:在職 0: 離職'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	String getEmp_status() { 
		return this.emp_status;
	} 
	/** 
 	*	欄位名稱:'員工照片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	byte[] getEmp_picture() { 
		return this.emp_picture;
	} 
	/** 
 	*	欄位名稱:'員工照片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:10<br>
	*	限制條件:<br>
 	*/ 
	public	String getEmp_Pic_format() { 
		return this.emp_Pic_format;
	} 
	/** 
 	*	欄位名稱:'雇用日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	Date getEmp_hiredate() { 
		return this.emp_hiredate;
	} 
	/** 
 	*	欄位名稱:'離職日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getEmp_firedate() { 
		return this.emp_firedate;
	} 
	/** 
 	*	欄位名稱:'員工編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setEmp_No(String aEmp_No) { 
		this.emp_No = aEmp_No; 
	} 
 
	/** 
 	*	欄位名稱:'員工姓名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setEmp_name(String aEmp_name) { 
		this.emp_name = aEmp_name; 
	} 
 
	/** 
 	*	欄位名稱:'員工密碼 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setEmp_Pw(String aEmp_Pw) { 
		this.emp_Pw = aEmp_Pw; 
	} 
 
	/** 
 	*	欄位名稱:'員工信箱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:UNIQUE<br>
 	*/ 
	public	void setEmp_email(String aEmp_email) { 
		this.emp_email = aEmp_email; 
	} 
 
	/** 
 	*	欄位名稱:'員工身分證 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:UNIQUE<br>
 	*/ 
	public	void setEmp_Id(String aEmp_Id) { 
		this.emp_Id = aEmp_Id; 
	} 
 
	/** 
 	*	欄位名稱:'員工出生年月日 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setEmp_birthday(Date aEmp_birthday) { 
		this.emp_birthday = aEmp_birthday; 
	} 
 
	/** 
 	*	欄位名稱:'員工電話 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:15<br>
	*	限制條件:<br>
 	*/ 
	public	void setEmp_phone(String aEmp_phone) { 
		this.emp_phone = aEmp_phone; 
	} 
 
	/** 
 	*	欄位名稱:'員工地址 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:100<br>
	*	限制條件:<br>
 	*/ 
	public	void setEmp_address(String aEmp_address) { 
		this.emp_address = aEmp_address; 
	} 
 
	/** 
 	*	欄位名稱:'員工狀態 | PS: 1:在職 0: 離職'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setEmp_status(String aEmp_status) { 
		this.emp_status = aEmp_status; 
	} 
 
	/** 
 	*	欄位名稱:'員工照片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setEmp_picture(byte[] aEmp_picture) { 
		this.emp_picture = aEmp_picture; 
	} 
 
	/** 
 	*	欄位名稱:'員工照片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:10<br>
	*	限制條件:<br>
 	*/ 
	public	void setEmp_Pic_format(String aEmp_Pic_format) { 
		this.emp_Pic_format = aEmp_Pic_format; 
	} 
 
	/** 
 	*	欄位名稱:'雇用日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setEmp_hiredate(Date aEmp_hiredate) { 
		this.emp_hiredate = aEmp_hiredate; 
	} 
 
	/** 
 	*	欄位名稱:'離職日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setEmp_firedate(Date aEmp_firedate) { 
		this.emp_firedate = aEmp_firedate; 
	} 
 
}
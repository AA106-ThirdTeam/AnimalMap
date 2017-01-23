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
	private	String emp_No; 
	private	String emp_name; 
	private	String emp_Pw; 
	private	String emp_email; 
	private	String emp_Id; 
	private	Date emp_birthday; 
	private	String emp_phone; 
	private	String emp_address; 
	private	String emp_status; 
	private	byte[] emp_picture; 
	private	String emp_Pic_format; 
	private	Date emp_hiredate; 
	private	Date emp_firedate; 
	public	String getEmp_No() { 
		return this.emp_No;
	} 
	public	String getEmp_name() { 
		return this.emp_name;
	} 
	public	String getEmp_Pw() { 
		return this.emp_Pw;
	} 
	public	String getEmp_email() { 
		return this.emp_email;
	} 
	public	String getEmp_Id() { 
		return this.emp_Id;
	} 
	public	Date getEmp_birthday() { 
		return this.emp_birthday;
	} 
	public	String getEmp_phone() { 
		return this.emp_phone;
	} 
	public	String getEmp_address() { 
		return this.emp_address;
	} 
	public	String getEmp_status() { 
		return this.emp_status;
	} 
	public	byte[] getEmp_picture() { 
		return this.emp_picture;
	} 
	public	String getEmp_Pic_format() { 
		return this.emp_Pic_format;
	} 
	public	Date getEmp_hiredate() { 
		return this.emp_hiredate;
	} 
	public	Date getEmp_firedate() { 
		return this.emp_firedate;
	} 
	public	void setEmp_No(String aEmp_No) { 
		this.emp_No = aEmp_No; 
	} 
 
	public	void setEmp_name(String aEmp_name) { 
		this.emp_name = aEmp_name; 
	} 
 
	public	void setEmp_Pw(String aEmp_Pw) { 
		this.emp_Pw = aEmp_Pw; 
	} 
 
	public	void setEmp_email(String aEmp_email) { 
		this.emp_email = aEmp_email; 
	} 
 
	public	void setEmp_Id(String aEmp_Id) { 
		this.emp_Id = aEmp_Id; 
	} 
 
	public	void setEmp_birthday(Date aEmp_birthday) { 
		this.emp_birthday = aEmp_birthday; 
	} 
 
	public	void setEmp_phone(String aEmp_phone) { 
		this.emp_phone = aEmp_phone; 
	} 
 
	public	void setEmp_address(String aEmp_address) { 
		this.emp_address = aEmp_address; 
	} 
 
	public	void setEmp_status(String aEmp_status) { 
		this.emp_status = aEmp_status; 
	} 
 
	public	void setEmp_picture(byte[] aEmp_picture) { 
		this.emp_picture = aEmp_picture; 
	} 
 
	public	void setEmp_Pic_format(String aEmp_Pic_format) { 
		this.emp_Pic_format = aEmp_Pic_format; 
	} 
 
	public	void setEmp_hiredate(Date aEmp_hiredate) { 
		this.emp_hiredate = aEmp_hiredate; 
	} 
 
	public	void setEmp_firedate(Date aEmp_firedate) { 
		this.emp_firedate = aEmp_firedate; 
	} 
 
}
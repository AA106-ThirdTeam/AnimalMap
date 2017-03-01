package com.emp.model;

import java.sql.Date;

public class EmpVO implements java.io.Serializable {

	private String emp_No;
	private String emp_name;
	private String emp_Pw;
	private String emp_email;
	private String emp_Id;
	private Date emp_birthday;
	private String emp_phone;
	private String emp_address;
	private String emp_status;
	private byte[] emp_picture;
	private String emp_Pic_format;
	private Date emp_hiredate;
	private Date emp_firedate;
	
	
	public String getEmp_No() {
		return emp_No;
	}
	public void setEmp_No(String emp_No) {
		this.emp_No = emp_No;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_Pw() {
		return emp_Pw;
	}
	public void setEmp_Pw(String emp_Pw) {
		this.emp_Pw = emp_Pw;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public String getEmp_Id() {
		return emp_Id;
	}
	public void setEmp_Id(String emp_Id) {
		this.emp_Id = emp_Id;
	}
	public Date getEmp_birthday() {
		return emp_birthday;
	}
	public void setEmp_birthday(Date emp_birthday) {
		this.emp_birthday = emp_birthday;
	}
	public String getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
	public String getEmp_address() {
		return emp_address;
	}
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
	public String getEmp_status() {
		return emp_status;
	}
	public void setEmp_status(String emp_status) {
		this.emp_status = emp_status;
	}
	public byte[] getEmp_picture() {
		return emp_picture;
	}
	public void setEmp_picture(byte[] emp_picture) {
		this.emp_picture = emp_picture;
	}
	public String getEmp_Pic_format() {
		return emp_Pic_format;
	}
	public void setEmp_Pic_format(String emp_Pic_format) {
		this.emp_Pic_format = emp_Pic_format;
	}
	public Date getEmp_hiredate() {
		return emp_hiredate;
	}
	public void setEmp_hiredate(Date emp_hiredate) {
		this.emp_hiredate = emp_hiredate;
	}
	public Date getEmp_firedate() {
		return emp_firedate;
	}
	public void setEmp_firedate(Date emp_firedate) {
		this.emp_firedate = emp_firedate;
	}

	
}

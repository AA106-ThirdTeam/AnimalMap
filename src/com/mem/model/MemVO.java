package com.mem.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class MemVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String mem_Id; 
	private	String mem_account; 
	private	String mem_Psw; 
	private	String mem_nick_name; 
	private	String mem_name; 
	private	String mem_gender; 
	private	String mem_Tw_Id; 
	private	Date mem_birth_date; 
	private	String mem_phone; 
	private	String mem_Intro; 
	private	byte[] mem_profile; 
	private	String mem_black_list; 
	private	String mem_permission; 
	private	String mem_setting; 
	private	Integer mem_balance; 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	String getMem_account() { 
		return this.mem_account;
	} 
	public	String getMem_Psw() { 
		return this.mem_Psw;
	} 
	public	String getMem_nick_name() { 
		return this.mem_nick_name;
	} 
	public	String getMem_name() { 
		return this.mem_name;
	} 
	public	String getMem_gender() { 
		return this.mem_gender;
	} 
	public	String getMem_Tw_Id() { 
		return this.mem_Tw_Id;
	} 
	public	Date getMem_birth_date() { 
		return this.mem_birth_date;
	} 
	public	String getMem_phone() { 
		return this.mem_phone;
	} 
	public	String getMem_Intro() { 
		return this.mem_Intro;
	} 
	public	byte[] getMem_profile() { 
		return this.mem_profile;
	} 
	public	String getMem_black_list() { 
		return this.mem_black_list;
	} 
	public	String getMem_permission() { 
		return this.mem_permission;
	} 
	public	String getMem_setting() { 
		return this.mem_setting;
	} 
	public	Integer getMem_balance() { 
		return this.mem_balance;
	} 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setMem_account(String aMem_account) { 
		this.mem_account = aMem_account; 
	} 
 
	public	void setMem_Psw(String aMem_Psw) { 
		this.mem_Psw = aMem_Psw; 
	} 
 
	public	void setMem_nick_name(String aMem_nick_name) { 
		this.mem_nick_name = aMem_nick_name; 
	} 
 
	public	void setMem_name(String aMem_name) { 
		this.mem_name = aMem_name; 
	} 
 
	public	void setMem_gender(String aMem_gender) { 
		this.mem_gender = aMem_gender; 
	} 
 
	public	void setMem_Tw_Id(String aMem_Tw_Id) { 
		this.mem_Tw_Id = aMem_Tw_Id; 
	} 
 
	public	void setMem_birth_date(Date aMem_birth_date) { 
		this.mem_birth_date = aMem_birth_date; 
	} 
 
	public	void setMem_phone(String aMem_phone) { 
		this.mem_phone = aMem_phone; 
	} 
 
	public	void setMem_Intro(String aMem_Intro) { 
		this.mem_Intro = aMem_Intro; 
	} 
 
	public	void setMem_profile(byte[] aMem_profile) { 
		this.mem_profile = aMem_profile; 
	} 
 
	public	void setMem_black_list(String aMem_black_list) { 
		this.mem_black_list = aMem_black_list; 
	} 
 
	public	void setMem_permission(String aMem_permission) { 
		this.mem_permission = aMem_permission; 
	} 
 
	public	void setMem_setting(String aMem_setting) { 
		this.mem_setting = aMem_setting; 
	} 
 
	public	void setMem_balance(Integer aMem_balance) { 
		this.mem_balance = aMem_balance; 
	} 
 
}
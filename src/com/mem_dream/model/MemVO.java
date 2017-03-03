package com.mem_dream.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	一般會員<br>
 *	英文:mem<br>
 */ 
public class MemVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'會員編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'帳號 | PS: 電子信箱就是帳號'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String mem_account; 
 
	/** 
 	*	欄位名稱:'密碼 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String mem_Psw; 
 
	/** 
 	*	欄位名稱:'會員暱稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String mem_nick_name; 
 
	/** 
 	*	欄位名稱:'姓名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:40<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String mem_name; 
 
	/** 
 	*	欄位名稱:'性別 | PS: M.男F.女'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String mem_gender; 
 
	/** 
 	*	欄位名稱:'身份證字號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:10<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String mem_Tw_Id; 
 
	/** 
 	*	欄位名稱:'出生年月日 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	Date mem_birth_date; 
 
	/** 
 	*	欄位名稱:'手機 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String mem_phone; 
 
	/** 
 	*	欄位名稱:'個人簡介 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:150<br>
	*	限制條件:<br>
 	*/ 
	private	String mem_Intro; 
 
	/** 
 	*	欄位名稱:'大頭照 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	String mem_profile; 
 
	/** 
 	*	欄位名稱:'黑名單 | PS: 0.非黑名單1.黑名單'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	String mem_black_list; 
 
	/** 
 	*	欄位名稱:'權限 | PS: 1.一般 2.志工 3.店家'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	String mem_permission; 
 
	/** 
 	*	欄位名稱:'偏好設定 | PS: 0.流浪動物 1.領養活動 2.揪團 3.緊急求救 4.店家 5.二手 6.自家寵物'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:<br>
 	*/ 
	private	String mem_setting; 
 
	/** 
 	*	欄位名稱:'餘額 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:10<br>
	*	限制條件:<br>
 	*/ 
	private	Integer mem_balance; 
 
	/** 
 	*	欄位名稱:'會員編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	/** 
 	*	欄位名稱:'帳號 | PS: 電子信箱就是帳號'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getMem_account() { 
		return this.mem_account;
	} 
	/** 
 	*	欄位名稱:'密碼 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getMem_Psw() { 
		return this.mem_Psw;
	} 
	/** 
 	*	欄位名稱:'會員暱稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getMem_nick_name() { 
		return this.mem_nick_name;
	} 
	/** 
 	*	欄位名稱:'姓名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:40<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getMem_name() { 
		return this.mem_name;
	} 
	/** 
 	*	欄位名稱:'性別 | PS: M.男F.女'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getMem_gender() { 
		return this.mem_gender;
	} 
	/** 
 	*	欄位名稱:'身份證字號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:10<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getMem_Tw_Id() { 
		return this.mem_Tw_Id;
	} 
	/** 
 	*	欄位名稱:'出生年月日 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	Date getMem_birth_date() { 
		return this.mem_birth_date;
	} 
	/** 
 	*	欄位名稱:'手機 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getMem_phone() { 
		return this.mem_phone;
	} 
	/** 
 	*	欄位名稱:'個人簡介 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:150<br>
	*	限制條件:<br>
 	*/ 
	public	String getMem_Intro() { 
		return this.mem_Intro;
	} 
	/** 
 	*	欄位名稱:'大頭照 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	String getMem_profile() { 
		return this.mem_profile;
	} 
	/** 
 	*	欄位名稱:'黑名單 | PS: 0.非黑名單1.黑名單'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	String getMem_black_list() { 
		return this.mem_black_list;
	} 
	/** 
 	*	欄位名稱:'權限 | PS: 1.一般 2.志工 3.店家'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	String getMem_permission() { 
		return this.mem_permission;
	} 
	/** 
 	*	欄位名稱:'偏好設定 | PS: 0.流浪動物 1.領養活動 2.揪團 3.緊急求救 4.店家 5.二手 6.自家寵物'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:<br>
 	*/ 
	public	String getMem_setting() { 
		return this.mem_setting;
	} 
	/** 
 	*	欄位名稱:'餘額 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:10<br>
	*	限制條件:<br>
 	*/ 
	public	Integer getMem_balance() { 
		return this.mem_balance;
	} 
	/** 
 	*	欄位名稱:'會員編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	/** 
 	*	欄位名稱:'帳號 | PS: 電子信箱就是帳號'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setMem_account(String aMem_account) { 
		this.mem_account = aMem_account; 
	} 
 
	/** 
 	*	欄位名稱:'密碼 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setMem_Psw(String aMem_Psw) { 
		this.mem_Psw = aMem_Psw; 
	} 
 
	/** 
 	*	欄位名稱:'會員暱稱 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:60<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setMem_nick_name(String aMem_nick_name) { 
		this.mem_nick_name = aMem_nick_name; 
	} 
 
	/** 
 	*	欄位名稱:'姓名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:40<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setMem_name(String aMem_name) { 
		this.mem_name = aMem_name; 
	} 
 
	/** 
 	*	欄位名稱:'性別 | PS: M.男F.女'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setMem_gender(String aMem_gender) { 
		this.mem_gender = aMem_gender; 
	} 
 
	/** 
 	*	欄位名稱:'身份證字號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:10<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setMem_Tw_Id(String aMem_Tw_Id) { 
		this.mem_Tw_Id = aMem_Tw_Id; 
	} 
 
	/** 
 	*	欄位名稱:'出生年月日 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setMem_birth_date(Date aMem_birth_date) { 
		this.mem_birth_date = aMem_birth_date; 
	} 
 
	/** 
 	*	欄位名稱:'手機 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setMem_phone(String aMem_phone) { 
		this.mem_phone = aMem_phone; 
	} 
 
	/** 
 	*	欄位名稱:'個人簡介 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:150<br>
	*	限制條件:<br>
 	*/ 
	public	void setMem_Intro(String aMem_Intro) { 
		this.mem_Intro = aMem_Intro; 
	} 
 
	/** 
 	*	欄位名稱:'大頭照 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setMem_profile(String aMem_profile) { 
		this.mem_profile = aMem_profile; 
	} 
 
	/** 
 	*	欄位名稱:'黑名單 | PS: 0.非黑名單1.黑名單'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setMem_black_list(String aMem_black_list) { 
		this.mem_black_list = aMem_black_list; 
	} 
 
	/** 
 	*	欄位名稱:'權限 | PS: 1.一般 2.志工 3.店家'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setMem_permission(String aMem_permission) { 
		this.mem_permission = aMem_permission; 
	} 
 
	/** 
 	*	欄位名稱:'偏好設定 | PS: 0.流浪動物 1.領養活動 2.揪團 3.緊急求救 4.店家 5.二手 6.自家寵物'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:30<br>
	*	限制條件:<br>
 	*/ 
	public	void setMem_setting(String aMem_setting) { 
		this.mem_setting = aMem_setting; 
	} 
 
	/** 
 	*	欄位名稱:'餘額 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:10<br>
	*	限制條件:<br>
 	*/ 
	public	void setMem_balance(Integer aMem_balance) { 
		this.mem_balance = aMem_balance; 
	} 
 
}
package com.stray_ani.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:社區流浪動物<br>
 *	英文:stray_Ani<br>
 */ 
public class Stray_AniVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String stray_Ani_Id; 
	private	String mem_Id; 
	private	String stray_Ani_name; 
	private	String stray_Ani_type; 
	private	String stray_Ani_gender; 
	private	String stray_Ani_heal; 
	private	String stray_Ani_Vac; 
	private	String stray_Ani_color; 
	private	String stray_Ani_body; 
	private	String stray_Ani_age; 
	private	String stray_Ani_Neu; 
	private	String stray_Ani_chip; 
	private	Date stray_Ani_date; 
	private	String stray_Ani_status; 
	private	Date stray_Ani_CreDate; 
	private	Double stray_Ani_FinLat; 
	private	Double stray_Ani_FinLon; 
	private	String stray_Ani_city; 
	private	String stray_Ani_town; 
	private	String stray_Ani_road; 
	public	String getStray_Ani_Id() { 
		return this.stray_Ani_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	String getStray_Ani_name() { 
		return this.stray_Ani_name;
	} 
	public	String getStray_Ani_type() { 
		return this.stray_Ani_type;
	} 
	public	String getStray_Ani_gender() { 
		return this.stray_Ani_gender;
	} 
	public	String getStray_Ani_heal() { 
		return this.stray_Ani_heal;
	} 
	public	String getStray_Ani_Vac() { 
		return this.stray_Ani_Vac;
	} 
	public	String getStray_Ani_color() { 
		return this.stray_Ani_color;
	} 
	public	String getStray_Ani_body() { 
		return this.stray_Ani_body;
	} 
	public	String getStray_Ani_age() { 
		return this.stray_Ani_age;
	} 
	public	String getStray_Ani_Neu() { 
		return this.stray_Ani_Neu;
	} 
	public	String getStray_Ani_chip() { 
		return this.stray_Ani_chip;
	} 
	public	Date getStray_Ani_date() { 
		return this.stray_Ani_date;
	} 
	public	String getStray_Ani_status() { 
		return this.stray_Ani_status;
	} 
	public	Date getStray_Ani_CreDate() { 
		return this.stray_Ani_CreDate;
	} 
	public	Double getStray_Ani_FinLat() { 
		return this.stray_Ani_FinLat;
	} 
	public	Double getStray_Ani_FinLon() { 
		return this.stray_Ani_FinLon;
	} 
	public	String getStray_Ani_city() { 
		return this.stray_Ani_city;
	} 
	public	String getStray_Ani_town() { 
		return this.stray_Ani_town;
	} 
	public	String getStray_Ani_road() { 
		return this.stray_Ani_road;
	} 
	public	void setStray_Ani_Id(String aStray_Ani_Id) { 
		this.stray_Ani_Id = aStray_Ani_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setStray_Ani_name(String aStray_Ani_name) { 
		this.stray_Ani_name = aStray_Ani_name; 
	} 
 
	public	void setStray_Ani_type(String aStray_Ani_type) { 
		this.stray_Ani_type = aStray_Ani_type; 
	} 
 
	public	void setStray_Ani_gender(String aStray_Ani_gender) { 
		this.stray_Ani_gender = aStray_Ani_gender; 
	} 
 
	public	void setStray_Ani_heal(String aStray_Ani_heal) { 
		this.stray_Ani_heal = aStray_Ani_heal; 
	} 
 
	public	void setStray_Ani_Vac(String aStray_Ani_Vac) { 
		this.stray_Ani_Vac = aStray_Ani_Vac; 
	} 
 
	public	void setStray_Ani_color(String aStray_Ani_color) { 
		this.stray_Ani_color = aStray_Ani_color; 
	} 
 
	public	void setStray_Ani_body(String aStray_Ani_body) { 
		this.stray_Ani_body = aStray_Ani_body; 
	} 
 
	public	void setStray_Ani_age(String aStray_Ani_age) { 
		this.stray_Ani_age = aStray_Ani_age; 
	} 
 
	public	void setStray_Ani_Neu(String aStray_Ani_Neu) { 
		this.stray_Ani_Neu = aStray_Ani_Neu; 
	} 
 
	public	void setStray_Ani_chip(String aStray_Ani_chip) { 
		this.stray_Ani_chip = aStray_Ani_chip; 
	} 
 
	public	void setStray_Ani_date(Date aStray_Ani_date) { 
		this.stray_Ani_date = aStray_Ani_date; 
	} 
 
	public	void setStray_Ani_status(String aStray_Ani_status) { 
		this.stray_Ani_status = aStray_Ani_status; 
	} 
 
	public	void setStray_Ani_CreDate(Date aStray_Ani_CreDate) { 
		this.stray_Ani_CreDate = aStray_Ani_CreDate; 
	} 
 
	public	void setStray_Ani_FinLat(Double aStray_Ani_FinLat) { 
		this.stray_Ani_FinLat = aStray_Ani_FinLat; 
	} 
 
	public	void setStray_Ani_FinLon(Double aStray_Ani_FinLon) { 
		this.stray_Ani_FinLon = aStray_Ani_FinLon; 
	} 
 
	public	void setStray_Ani_city(String aStray_Ani_city) { 
		this.stray_Ani_city = aStray_Ani_city; 
	} 
 
	public	void setStray_Ani_town(String aStray_Ani_town) { 
		this.stray_Ani_town = aStray_Ani_town; 
	} 
 
	public	void setStray_Ani_road(String aStray_Ani_road) { 
		this.stray_Ani_road = aStray_Ani_road; 
	} 
 
}
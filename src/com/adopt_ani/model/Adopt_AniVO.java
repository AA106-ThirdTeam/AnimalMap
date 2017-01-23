package com.adopt_ani.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:送養動物<br>
 *	英文:adopt_Ani<br>
 */ 
public class Adopt_AniVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String adopt_Ani_Id; 
	private	String mem_Id; 
	private	String adopt_Ani_name; 
	private	String adopt_Ani_type; 
	private	String adopt_Ani_gender; 
	private	String adopt_Ani_heal; 
	private	String adopt_Ani_Vac; 
	private	String adopt_Ani_color; 
	private	String adopt_Ani_body; 
	private	String adopt_Ani_age; 
	private	String adopt_Ani_Neu; 
	private	String adopt_Ani_chip; 
	private	Date adopt_Ani_date; 
	private	String adopt_Ani_status; 
	private	Date adopt_Ani_CreDate; 
	private	Double adopt_Ani_FinLat; 
	private	Double adopt_Ani_FinLon; 
	private	String adopt_Ani_city; 
	private	String adopt_Ani_town; 
	private	String adopt_Ani_road; 
	public	String getAdopt_Ani_Id() { 
		return this.adopt_Ani_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	String getAdopt_Ani_name() { 
		return this.adopt_Ani_name;
	} 
	public	String getAdopt_Ani_type() { 
		return this.adopt_Ani_type;
	} 
	public	String getAdopt_Ani_gender() { 
		return this.adopt_Ani_gender;
	} 
	public	String getAdopt_Ani_heal() { 
		return this.adopt_Ani_heal;
	} 
	public	String getAdopt_Ani_Vac() { 
		return this.adopt_Ani_Vac;
	} 
	public	String getAdopt_Ani_color() { 
		return this.adopt_Ani_color;
	} 
	public	String getAdopt_Ani_body() { 
		return this.adopt_Ani_body;
	} 
	public	String getAdopt_Ani_age() { 
		return this.adopt_Ani_age;
	} 
	public	String getAdopt_Ani_Neu() { 
		return this.adopt_Ani_Neu;
	} 
	public	String getAdopt_Ani_chip() { 
		return this.adopt_Ani_chip;
	} 
	public	Date getAdopt_Ani_date() { 
		return this.adopt_Ani_date;
	} 
	public	String getAdopt_Ani_status() { 
		return this.adopt_Ani_status;
	} 
	public	Date getAdopt_Ani_CreDate() { 
		return this.adopt_Ani_CreDate;
	} 
	public	Double getAdopt_Ani_FinLat() { 
		return this.adopt_Ani_FinLat;
	} 
	public	Double getAdopt_Ani_FinLon() { 
		return this.adopt_Ani_FinLon;
	} 
	public	String getAdopt_Ani_city() { 
		return this.adopt_Ani_city;
	} 
	public	String getAdopt_Ani_town() { 
		return this.adopt_Ani_town;
	} 
	public	String getAdopt_Ani_road() { 
		return this.adopt_Ani_road;
	} 
	public	void setAdopt_Ani_Id(String aAdopt_Ani_Id) { 
		this.adopt_Ani_Id = aAdopt_Ani_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setAdopt_Ani_name(String aAdopt_Ani_name) { 
		this.adopt_Ani_name = aAdopt_Ani_name; 
	} 
 
	public	void setAdopt_Ani_type(String aAdopt_Ani_type) { 
		this.adopt_Ani_type = aAdopt_Ani_type; 
	} 
 
	public	void setAdopt_Ani_gender(String aAdopt_Ani_gender) { 
		this.adopt_Ani_gender = aAdopt_Ani_gender; 
	} 
 
	public	void setAdopt_Ani_heal(String aAdopt_Ani_heal) { 
		this.adopt_Ani_heal = aAdopt_Ani_heal; 
	} 
 
	public	void setAdopt_Ani_Vac(String aAdopt_Ani_Vac) { 
		this.adopt_Ani_Vac = aAdopt_Ani_Vac; 
	} 
 
	public	void setAdopt_Ani_color(String aAdopt_Ani_color) { 
		this.adopt_Ani_color = aAdopt_Ani_color; 
	} 
 
	public	void setAdopt_Ani_body(String aAdopt_Ani_body) { 
		this.adopt_Ani_body = aAdopt_Ani_body; 
	} 
 
	public	void setAdopt_Ani_age(String aAdopt_Ani_age) { 
		this.adopt_Ani_age = aAdopt_Ani_age; 
	} 
 
	public	void setAdopt_Ani_Neu(String aAdopt_Ani_Neu) { 
		this.adopt_Ani_Neu = aAdopt_Ani_Neu; 
	} 
 
	public	void setAdopt_Ani_chip(String aAdopt_Ani_chip) { 
		this.adopt_Ani_chip = aAdopt_Ani_chip; 
	} 
 
	public	void setAdopt_Ani_date(Date aAdopt_Ani_date) { 
		this.adopt_Ani_date = aAdopt_Ani_date; 
	} 
 
	public	void setAdopt_Ani_status(String aAdopt_Ani_status) { 
		this.adopt_Ani_status = aAdopt_Ani_status; 
	} 
 
	public	void setAdopt_Ani_CreDate(Date aAdopt_Ani_CreDate) { 
		this.adopt_Ani_CreDate = aAdopt_Ani_CreDate; 
	} 
 
	public	void setAdopt_Ani_FinLat(Double aAdopt_Ani_FinLat) { 
		this.adopt_Ani_FinLat = aAdopt_Ani_FinLat; 
	} 
 
	public	void setAdopt_Ani_FinLon(Double aAdopt_Ani_FinLon) { 
		this.adopt_Ani_FinLon = aAdopt_Ani_FinLon; 
	} 
 
	public	void setAdopt_Ani_city(String aAdopt_Ani_city) { 
		this.adopt_Ani_city = aAdopt_Ani_city; 
	} 
 
	public	void setAdopt_Ani_town(String aAdopt_Ani_town) { 
		this.adopt_Ani_town = aAdopt_Ani_town; 
	} 
 
	public	void setAdopt_Ani_road(String aAdopt_Ani_road) { 
		this.adopt_Ani_road = aAdopt_Ani_road; 
	} 
 
}
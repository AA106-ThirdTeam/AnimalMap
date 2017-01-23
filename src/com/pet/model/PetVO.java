package com.pet.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:自家寵物<br>
 *	英文:pet<br>
 */ 
public class PetVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String pet_Id; 
	private	String mem_Id; 
	private	String pet_name; 
	private	String pet_type; 
	private	String pet_gender; 
	private	String pet_heal; 
	private	String pet_Vac; 
	private	String pet_color; 
	private	String pet_body; 
	private	String pet_age; 
	private	String pet_Neu; 
	private	String pet_chip; 
	private	Date pet_birth; 
	private	String pet_status; 
	private	Date pet_CreDATE; 
	private	String pet_city; 
	private	String pet_town; 
	private	String pet_road; 
	private	Double pet_FinLat; 
	private	Double pet_FinLon; 
	public	String getPet_Id() { 
		return this.pet_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	String getPet_name() { 
		return this.pet_name;
	} 
	public	String getPet_type() { 
		return this.pet_type;
	} 
	public	String getPet_gender() { 
		return this.pet_gender;
	} 
	public	String getPet_heal() { 
		return this.pet_heal;
	} 
	public	String getPet_Vac() { 
		return this.pet_Vac;
	} 
	public	String getPet_color() { 
		return this.pet_color;
	} 
	public	String getPet_body() { 
		return this.pet_body;
	} 
	public	String getPet_age() { 
		return this.pet_age;
	} 
	public	String getPet_Neu() { 
		return this.pet_Neu;
	} 
	public	String getPet_chip() { 
		return this.pet_chip;
	} 
	public	Date getPet_birth() { 
		return this.pet_birth;
	} 
	public	String getPet_status() { 
		return this.pet_status;
	} 
	public	Date getPet_CreDATE() { 
		return this.pet_CreDATE;
	} 
	public	String getPet_city() { 
		return this.pet_city;
	} 
	public	String getPet_town() { 
		return this.pet_town;
	} 
	public	String getPet_road() { 
		return this.pet_road;
	} 
	public	Double getPet_FinLat() { 
		return this.pet_FinLat;
	} 
	public	Double getPet_FinLon() { 
		return this.pet_FinLon;
	} 
	public	void setPet_Id(String aPet_Id) { 
		this.pet_Id = aPet_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setPet_name(String aPet_name) { 
		this.pet_name = aPet_name; 
	} 
 
	public	void setPet_type(String aPet_type) { 
		this.pet_type = aPet_type; 
	} 
 
	public	void setPet_gender(String aPet_gender) { 
		this.pet_gender = aPet_gender; 
	} 
 
	public	void setPet_heal(String aPet_heal) { 
		this.pet_heal = aPet_heal; 
	} 
 
	public	void setPet_Vac(String aPet_Vac) { 
		this.pet_Vac = aPet_Vac; 
	} 
 
	public	void setPet_color(String aPet_color) { 
		this.pet_color = aPet_color; 
	} 
 
	public	void setPet_body(String aPet_body) { 
		this.pet_body = aPet_body; 
	} 
 
	public	void setPet_age(String aPet_age) { 
		this.pet_age = aPet_age; 
	} 
 
	public	void setPet_Neu(String aPet_Neu) { 
		this.pet_Neu = aPet_Neu; 
	} 
 
	public	void setPet_chip(String aPet_chip) { 
		this.pet_chip = aPet_chip; 
	} 
 
	public	void setPet_birth(Date aPet_birth) { 
		this.pet_birth = aPet_birth; 
	} 
 
	public	void setPet_status(String aPet_status) { 
		this.pet_status = aPet_status; 
	} 
 
	public	void setPet_CreDATE(Date aPet_CreDATE) { 
		this.pet_CreDATE = aPet_CreDATE; 
	} 
 
	public	void setPet_city(String aPet_city) { 
		this.pet_city = aPet_city; 
	} 
 
	public	void setPet_town(String aPet_town) { 
		this.pet_town = aPet_town; 
	} 
 
	public	void setPet_road(String aPet_road) { 
		this.pet_road = aPet_road; 
	} 
 
	public	void setPet_FinLat(Double aPet_FinLat) { 
		this.pet_FinLat = aPet_FinLat; 
	} 
 
	public	void setPet_FinLon(Double aPet_FinLon) { 
		this.pet_FinLon = aPet_FinLon; 
	} 
 
}
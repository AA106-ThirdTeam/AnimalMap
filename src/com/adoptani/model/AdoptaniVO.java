package com.adoptani.model;

/**DB->VO->interface->DAO->Service**/


import java.sql.Date;
import java.sql.Timestamp;

public class AdoptaniVO implements java.io.Serializable{
	private String adopt_Ani_Id;     
	private String mem_Id;     
	private String adopt_Ani_name;  
	private String adopt_Ani_type; 
	private String adopt_Ani_gender;
	private String adopt_Ani_heal;
	private String adopt_Ani_Vac;
    private String adopt_Ani_color;
    private String adopt_Ani_body;
    private String adopt_Ani_age;
    private String adopt_Ani_Neu;
    private String adopt_Ani_chip;
    private Timestamp adopt_Ani_date;
    private String adopt_Ani_status;
    private Timestamp adopt_Ani_CreDate;
    private Double adopt_Ani_FinLat;
    private Double adopt_Ani_FinLon;
    private String adopt_Ani_city;
    private String adopt_Ani_town;
    private String adopt_Ani_road;
    private Integer adopt_Ani_like;
    
    
    
	public Integer getAdopt_Ani_like() {
		return adopt_Ani_like;
	}
	public void setAdopt_Ani_like(Integer adopt_Ani_like) {
		this.adopt_Ani_like = adopt_Ani_like;
	}
	public String getAdopt_Ani_Id() {
		return adopt_Ani_Id;
	}
	public void setAdopt_Ani_Id(String adopt_Ani_Id) {
		this.adopt_Ani_Id = adopt_Ani_Id;
	}
	public String getMem_Id() {
		return mem_Id;
	}
	public void setMem_Id(String mem_Id) {
		this.mem_Id = mem_Id;
	}
	public String getAdopt_Ani_name() {
		return adopt_Ani_name;
	}
	public void setAdopt_Ani_name(String adopt_Ani_name) {
		this.adopt_Ani_name = adopt_Ani_name;
	}
	public String getAdopt_Ani_type() {
		return adopt_Ani_type;
	}
	public void setAdopt_Ani_type(String adopt_Ani_type) {
		this.adopt_Ani_type = adopt_Ani_type;
	}
	public String getAdopt_Ani_gender() {
		return adopt_Ani_gender;
	}
	public void setAdopt_Ani_gender(String adopt_Ani_gender) {
		this.adopt_Ani_gender = adopt_Ani_gender;
	}
	public String getAdopt_Ani_heal() {
		return adopt_Ani_heal;
	}
	public void setAdopt_Ani_heal(String adopt_Ani_heal) {
		this.adopt_Ani_heal = adopt_Ani_heal;
	}
	public String getAdopt_Ani_Vac() {
		return adopt_Ani_Vac;
	}
	public void setAdopt_Ani_Vac(String adopt_Ani_Vac) {
		this.adopt_Ani_Vac = adopt_Ani_Vac;
	}
	public String getAdopt_Ani_color() {
		return adopt_Ani_color;
	}
	public void setAdopt_Ani_color(String adopt_Ani_color) {
		this.adopt_Ani_color = adopt_Ani_color;
	}
	public String getAdopt_Ani_body() {
		return adopt_Ani_body;
	}
	public void setAdopt_Ani_body(String adopt_Ani_body) {
		this.adopt_Ani_body = adopt_Ani_body;
	}
	public String getAdopt_Ani_age() {
		return adopt_Ani_age;
	}
	public void setAdopt_Ani_age(String adopt_Ani_age) {
		this.adopt_Ani_age = adopt_Ani_age;
	}
	public String getAdopt_Ani_Neu() {
		return adopt_Ani_Neu;
	}
	public void setAdopt_Ani_Neu(String adopt_Ani_Neu) {
		this.adopt_Ani_Neu = adopt_Ani_Neu;
	}
	public String getAdopt_Ani_chip() {
		return adopt_Ani_chip;
	}
	public void setAdopt_Ani_chip(String adopt_Ani_chip) {
		this.adopt_Ani_chip = adopt_Ani_chip;
	}
	public Timestamp getAdopt_Ani_date() {
		return adopt_Ani_date;
	}
	public void setAdopt_Ani_date(Timestamp adopt_Ani_date) {
		this.adopt_Ani_date = adopt_Ani_date;
	}
	public String getAdopt_Ani_status() {
		return adopt_Ani_status;
	}
	public void setAdopt_Ani_status(String adopt_Ani_status) {
		this.adopt_Ani_status = adopt_Ani_status;
	}
	public Timestamp getAdopt_Ani_CreDate() {
		return adopt_Ani_CreDate;
	}
	public void setAdopt_Ani_CreDate(Timestamp adopt_Ani_CreDate) {
		this.adopt_Ani_CreDate = adopt_Ani_CreDate;
	}
	public Double getAdopt_Ani_FinLat() {
		return adopt_Ani_FinLat;
	}
	public void setAdopt_Ani_FinLat(Double adopt_Ani_FinLat) {
		this.adopt_Ani_FinLat = adopt_Ani_FinLat;
	}
	public Double getAdopt_Ani_FinLon() {
		return adopt_Ani_FinLon;
	}
	public void setAdopt_Ani_FinLon(Double adopt_Ani_FinLon) {
		this.adopt_Ani_FinLon = adopt_Ani_FinLon;
	}
	public String getAdopt_Ani_city() {
		return adopt_Ani_city;
	}
	public void setAdopt_Ani_city(String adopt_Ani_city) {
		this.adopt_Ani_city = adopt_Ani_city;
	}
	public String getAdopt_Ani_town() {
		return adopt_Ani_town;
	}
	public void setAdopt_Ani_town(String adopt_Ani_town) {
		this.adopt_Ani_town = adopt_Ani_town;
	}
	public String getAdopt_Ani_road() {
		return adopt_Ani_road;
	}
	public void setAdopt_Ani_road(String adopt_Ani_road) {
		this.adopt_Ani_road = adopt_Ani_road;
	}
    
    
    
}

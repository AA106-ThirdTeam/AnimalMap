package com.adp.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:領養活動<br>
 *	英文:adp<br>
 */ 
public class AdpVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String adp_Id; 
	private	String mem_Id; 
	private	String adp_title; 
	private	String adp_adp_content; 
	private	Date adp_start_date; 
	private	Date adp_end_date; 
	private	Date adp_upDate; 
	private	String adp_city; 
	private	String adp_town; 
	private	String adp_road; 
	private	Double adp_lon; 
	private	Double adp_lat; 
	public	String getAdp_Id() { 
		return this.adp_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	String getAdp_title() { 
		return this.adp_title;
	} 
	public	String getAdp_adp_content() { 
		return this.adp_adp_content;
	} 
	public	Date getAdp_start_date() { 
		return this.adp_start_date;
	} 
	public	Date getAdp_end_date() { 
		return this.adp_end_date;
	} 
	public	Date getAdp_upDate() { 
		return this.adp_upDate;
	} 
	public	String getAdp_city() { 
		return this.adp_city;
	} 
	public	String getAdp_town() { 
		return this.adp_town;
	} 
	public	String getAdp_road() { 
		return this.adp_road;
	} 
	public	Double getAdp_lon() { 
		return this.adp_lon;
	} 
	public	Double getAdp_lat() { 
		return this.adp_lat;
	} 
	public	void setAdp_Id(String aAdp_Id) { 
		this.adp_Id = aAdp_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setAdp_title(String aAdp_title) { 
		this.adp_title = aAdp_title; 
	} 
 
	public	void setAdp_adp_content(String aAdp_adp_content) { 
		this.adp_adp_content = aAdp_adp_content; 
	} 
 
	public	void setAdp_start_date(Date aAdp_start_date) { 
		this.adp_start_date = aAdp_start_date; 
	} 
 
	public	void setAdp_end_date(Date aAdp_end_date) { 
		this.adp_end_date = aAdp_end_date; 
	} 
 
	public	void setAdp_upDate(Date aAdp_upDate) { 
		this.adp_upDate = aAdp_upDate; 
	} 
 
	public	void setAdp_city(String aAdp_city) { 
		this.adp_city = aAdp_city; 
	} 
 
	public	void setAdp_town(String aAdp_town) { 
		this.adp_town = aAdp_town; 
	} 
 
	public	void setAdp_road(String aAdp_road) { 
		this.adp_road = aAdp_road; 
	} 
 
	public	void setAdp_lon(Double aAdp_lon) { 
		this.adp_lon = aAdp_lon; 
	} 
 
	public	void setAdp_lat(Double aAdp_lat) { 
		this.adp_lat = aAdp_lat; 
	} 
 
}
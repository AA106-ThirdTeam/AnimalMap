package com.park.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:公園<br>
 *	英文:park<br>
 */ 
public class ParkVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String park_Id; 
	private	String emp_Id; 
	private	String park_title; 
	private	String park_content; 
	private	byte[] park_pic; 
	private	Date adp_start_date; 
	private	Date adp_upDate; 
	private	String adp_city; 
	private	String park_town; 
	private	String park_road; 
	private	Double park_lon; 
	private	Double park_lat; 
	public	String getPark_Id() { 
		return this.park_Id;
	} 
	public	String getEmp_Id() { 
		return this.emp_Id;
	} 
	public	String getPark_title() { 
		return this.park_title;
	} 
	public	String getPark_content() { 
		return this.park_content;
	} 
	public	byte[] getPark_pic() { 
		return this.park_pic;
	} 
	public	Date getAdp_start_date() { 
		return this.adp_start_date;
	} 
	public	Date getAdp_upDate() { 
		return this.adp_upDate;
	} 
	public	String getAdp_city() { 
		return this.adp_city;
	} 
	public	String getPark_town() { 
		return this.park_town;
	} 
	public	String getPark_road() { 
		return this.park_road;
	} 
	public	Double getPark_lon() { 
		return this.park_lon;
	} 
	public	Double getPark_lat() { 
		return this.park_lat;
	} 
	public	void setPark_Id(String aPark_Id) { 
		this.park_Id = aPark_Id; 
	} 
 
	public	void setEmp_Id(String aEmp_Id) { 
		this.emp_Id = aEmp_Id; 
	} 
 
	public	void setPark_title(String aPark_title) { 
		this.park_title = aPark_title; 
	} 
 
	public	void setPark_content(String aPark_content) { 
		this.park_content = aPark_content; 
	} 
 
	public	void setPark_pic(byte[] aPark_pic) { 
		this.park_pic = aPark_pic; 
	} 
 
	public	void setAdp_start_date(Date aAdp_start_date) { 
		this.adp_start_date = aAdp_start_date; 
	} 
 
	public	void setAdp_upDate(Date aAdp_upDate) { 
		this.adp_upDate = aAdp_upDate; 
	} 
 
	public	void setAdp_city(String aAdp_city) { 
		this.adp_city = aAdp_city; 
	} 
 
	public	void setPark_town(String aPark_town) { 
		this.park_town = aPark_town; 
	} 
 
	public	void setPark_road(String aPark_road) { 
		this.park_road = aPark_road; 
	} 
 
	public	void setPark_lon(Double aPark_lon) { 
		this.park_lon = aPark_lon; 
	} 
 
	public	void setPark_lat(Double aPark_lat) { 
		this.park_lat = aPark_lat; 
	} 
 
}
package com.vet_hospital.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:診所<br>
 *	英文:vet_hospital<br>
 */ 
public class Vet_hospitalVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String hos_Id; 
	private	String mem_Id; 
	private	String hos_name; 
	private	String hos_city; 
	private	String hos_town; 
	private	String hos_road; 
	private	Integer hos_Eval; 
	private	String hos_URL; 
	private	Date hos_StartTime; 
	private	Date hos_EndTime; 
	private	String hos_Tel; 
	private	String hos_Desc; 
	private	Double hos_Long; 
	private	Double hos_Lat; 
	private	Date hos_CreateTime; 
	private	String hos_visible; 
	public	String getHos_Id() { 
		return this.hos_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	String getHos_name() { 
		return this.hos_name;
	} 
	public	String getHos_city() { 
		return this.hos_city;
	} 
	public	String getHos_town() { 
		return this.hos_town;
	} 
	public	String getHos_road() { 
		return this.hos_road;
	} 
	public	Integer getHos_Eval() { 
		return this.hos_Eval;
	} 
	public	String getHos_URL() { 
		return this.hos_URL;
	} 
	public	Date getHos_StartTime() { 
		return this.hos_StartTime;
	} 
	public	Date getHos_EndTime() { 
		return this.hos_EndTime;
	} 
	public	String getHos_Tel() { 
		return this.hos_Tel;
	} 
	public	String getHos_Desc() { 
		return this.hos_Desc;
	} 
	public	Double getHos_Long() { 
		return this.hos_Long;
	} 
	public	Double getHos_Lat() { 
		return this.hos_Lat;
	} 
	public	Date getHos_CreateTime() { 
		return this.hos_CreateTime;
	} 
	public	String getHos_visible() { 
		return this.hos_visible;
	} 
	public	void setHos_Id(String aHos_Id) { 
		this.hos_Id = aHos_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setHos_name(String aHos_name) { 
		this.hos_name = aHos_name; 
	} 
 
	public	void setHos_city(String aHos_city) { 
		this.hos_city = aHos_city; 
	} 
 
	public	void setHos_town(String aHos_town) { 
		this.hos_town = aHos_town; 
	} 
 
	public	void setHos_road(String aHos_road) { 
		this.hos_road = aHos_road; 
	} 
 
	public	void setHos_Eval(Integer aHos_Eval) { 
		this.hos_Eval = aHos_Eval; 
	} 
 
	public	void setHos_URL(String aHos_URL) { 
		this.hos_URL = aHos_URL; 
	} 
 
	public	void setHos_StartTime(Date aHos_StartTime) { 
		this.hos_StartTime = aHos_StartTime; 
	} 
 
	public	void setHos_EndTime(Date aHos_EndTime) { 
		this.hos_EndTime = aHos_EndTime; 
	} 
 
	public	void setHos_Tel(String aHos_Tel) { 
		this.hos_Tel = aHos_Tel; 
	} 
 
	public	void setHos_Desc(String aHos_Desc) { 
		this.hos_Desc = aHos_Desc; 
	} 
 
	public	void setHos_Long(Double aHos_Long) { 
		this.hos_Long = aHos_Long; 
	} 
 
	public	void setHos_Lat(Double aHos_Lat) { 
		this.hos_Lat = aHos_Lat; 
	} 
 
	public	void setHos_CreateTime(Date aHos_CreateTime) { 
		this.hos_CreateTime = aHos_CreateTime; 
	} 
 
	public	void setHos_visible(String aHos_visible) { 
		this.hos_visible = aHos_visible; 
	} 
 
}
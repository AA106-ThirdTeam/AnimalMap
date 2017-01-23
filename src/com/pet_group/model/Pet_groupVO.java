package com.pet_group.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:揪團<br>
 *	英文:pet_group<br>
 */ 
public class Pet_groupVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String grp_Id; 
	private	String grp_MemId; 
	private	String grp_name; 
	private	String grp_city; 
	private	String grp_Addr; 
	private	String grp_road; 
	private	Date grp_StartTime; 
	private	Date grp_EndTime; 
	private	String grp_Desc; 
	private	Double grp_Long; 
	private	Double grp_Lat; 
	private	Date grp_CreateTime; 
	private	String grp_visible; 
	private	byte[] grp_photo; 
	public	String getGrp_Id() { 
		return this.grp_Id;
	} 
	public	String getGrp_MemId() { 
		return this.grp_MemId;
	} 
	public	String getGrp_name() { 
		return this.grp_name;
	} 
	public	String getGrp_city() { 
		return this.grp_city;
	} 
	public	String getGrp_Addr() { 
		return this.grp_Addr;
	} 
	public	String getGrp_road() { 
		return this.grp_road;
	} 
	public	Date getGrp_StartTime() { 
		return this.grp_StartTime;
	} 
	public	Date getGrp_EndTime() { 
		return this.grp_EndTime;
	} 
	public	String getGrp_Desc() { 
		return this.grp_Desc;
	} 
	public	Double getGrp_Long() { 
		return this.grp_Long;
	} 
	public	Double getGrp_Lat() { 
		return this.grp_Lat;
	} 
	public	Date getGrp_CreateTime() { 
		return this.grp_CreateTime;
	} 
	public	String getGrp_visible() { 
		return this.grp_visible;
	} 
	public	byte[] getGrp_photo() { 
		return this.grp_photo;
	} 
	public	void setGrp_Id(String aGrp_Id) { 
		this.grp_Id = aGrp_Id; 
	} 
 
	public	void setGrp_MemId(String aGrp_MemId) { 
		this.grp_MemId = aGrp_MemId; 
	} 
 
	public	void setGrp_name(String aGrp_name) { 
		this.grp_name = aGrp_name; 
	} 
 
	public	void setGrp_city(String aGrp_city) { 
		this.grp_city = aGrp_city; 
	} 
 
	public	void setGrp_Addr(String aGrp_Addr) { 
		this.grp_Addr = aGrp_Addr; 
	} 
 
	public	void setGrp_road(String aGrp_road) { 
		this.grp_road = aGrp_road; 
	} 
 
	public	void setGrp_StartTime(Date aGrp_StartTime) { 
		this.grp_StartTime = aGrp_StartTime; 
	} 
 
	public	void setGrp_EndTime(Date aGrp_EndTime) { 
		this.grp_EndTime = aGrp_EndTime; 
	} 
 
	public	void setGrp_Desc(String aGrp_Desc) { 
		this.grp_Desc = aGrp_Desc; 
	} 
 
	public	void setGrp_Long(Double aGrp_Long) { 
		this.grp_Long = aGrp_Long; 
	} 
 
	public	void setGrp_Lat(Double aGrp_Lat) { 
		this.grp_Lat = aGrp_Lat; 
	} 
 
	public	void setGrp_CreateTime(Date aGrp_CreateTime) { 
		this.grp_CreateTime = aGrp_CreateTime; 
	} 
 
	public	void setGrp_visible(String aGrp_visible) { 
		this.grp_visible = aGrp_visible; 
	} 
 
	public	void setGrp_photo(byte[] aGrp_photo) { 
		this.grp_photo = aGrp_photo; 
	} 
 
}
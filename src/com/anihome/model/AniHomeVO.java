package com.anihome.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class AniHomeVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String aniHome_Id; 
	private	String mem_Id; 
	private	String aniHome_title; 
	private	String aniHome_content; 
	private	Date aniHome_start_date; 
	private	Date aniHome_upDate; 
	private	String aniHome_city; 
	private	String aniHome_town; 
	private	String aniHome_road; 
	private	Double aniHome_lon; 
	private	Double aniHome_lat; 
	public	String getAniHome_Id() { 
		return this.aniHome_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	String getAniHome_title() { 
		return this.aniHome_title;
	} 
	public	String getAniHome_content() { 
		return this.aniHome_content;
	} 
	public	Date getAniHome_start_date() { 
		return this.aniHome_start_date;
	} 
	public	Date getAniHome_upDate() { 
		return this.aniHome_upDate;
	} 
	public	String getAniHome_city() { 
		return this.aniHome_city;
	} 
	public	String getAniHome_town() { 
		return this.aniHome_town;
	} 
	public	String getAniHome_road() { 
		return this.aniHome_road;
	} 
	public	Double getAniHome_lon() { 
		return this.aniHome_lon;
	} 
	public	Double getAniHome_lat() { 
		return this.aniHome_lat;
	} 
	public	void setAniHome_Id(String aAniHome_Id) { 
		this.aniHome_Id = aAniHome_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setAniHome_title(String aAniHome_title) { 
		this.aniHome_title = aAniHome_title; 
	} 
 
	public	void setAniHome_content(String aAniHome_content) { 
		this.aniHome_content = aAniHome_content; 
	} 
 
	public	void setAniHome_start_date(Date aAniHome_start_date) { 
		this.aniHome_start_date = aAniHome_start_date; 
	} 
 
	public	void setAniHome_upDate(Date aAniHome_upDate) { 
		this.aniHome_upDate = aAniHome_upDate; 
	} 
 
	public	void setAniHome_city(String aAniHome_city) { 
		this.aniHome_city = aAniHome_city; 
	} 
 
	public	void setAniHome_town(String aAniHome_town) { 
		this.aniHome_town = aAniHome_town; 
	} 
 
	public	void setAniHome_road(String aAniHome_road) { 
		this.aniHome_road = aAniHome_road; 
	} 
 
	public	void setAniHome_lon(Double aAniHome_lon) { 
		this.aniHome_lon = aAniHome_lon; 
	} 
 
	public	void setAniHome_lat(Double aAniHome_lat) { 
		this.aniHome_lat = aAniHome_lat; 
	} 
 
}
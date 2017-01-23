package com.petshop.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class PetShopVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String shop_Id; 
	private	String shop_MemId; 
	private	String shop_name; 
	private	String shop_city; 
	private	String shop_town; 
	private	String shop_road; 
	private	Integer shop_Eval; 
	private	String shop_URL; 
	private	Date shop_StartTime; 
	private	Date shop_EndTime; 
	private	String shop_Tel; 
	private	String shop_Desc; 
	private	Double shop_Long; 
	private	Double shop_Lat; 
	private	Date shop_CreateTime; 
	private	String shop_visible; 
	public	String getShop_Id() { 
		return this.shop_Id;
	} 
	public	String getShop_MemId() { 
		return this.shop_MemId;
	} 
	public	String getShop_name() { 
		return this.shop_name;
	} 
	public	String getShop_city() { 
		return this.shop_city;
	} 
	public	String getShop_town() { 
		return this.shop_town;
	} 
	public	String getShop_road() { 
		return this.shop_road;
	} 
	public	Integer getShop_Eval() { 
		return this.shop_Eval;
	} 
	public	String getShop_URL() { 
		return this.shop_URL;
	} 
	public	Date getShop_StartTime() { 
		return this.shop_StartTime;
	} 
	public	Date getShop_EndTime() { 
		return this.shop_EndTime;
	} 
	public	String getShop_Tel() { 
		return this.shop_Tel;
	} 
	public	String getShop_Desc() { 
		return this.shop_Desc;
	} 
	public	Double getShop_Long() { 
		return this.shop_Long;
	} 
	public	Double getShop_Lat() { 
		return this.shop_Lat;
	} 
	public	Date getShop_CreateTime() { 
		return this.shop_CreateTime;
	} 
	public	String getShop_visible() { 
		return this.shop_visible;
	} 
	public	void setShop_Id(String aShop_Id) { 
		this.shop_Id = aShop_Id; 
	} 
 
	public	void setShop_MemId(String aShop_MemId) { 
		this.shop_MemId = aShop_MemId; 
	} 
 
	public	void setShop_name(String aShop_name) { 
		this.shop_name = aShop_name; 
	} 
 
	public	void setShop_city(String aShop_city) { 
		this.shop_city = aShop_city; 
	} 
 
	public	void setShop_town(String aShop_town) { 
		this.shop_town = aShop_town; 
	} 
 
	public	void setShop_road(String aShop_road) { 
		this.shop_road = aShop_road; 
	} 
 
	public	void setShop_Eval(Integer aShop_Eval) { 
		this.shop_Eval = aShop_Eval; 
	} 
 
	public	void setShop_URL(String aShop_URL) { 
		this.shop_URL = aShop_URL; 
	} 
 
	public	void setShop_StartTime(Date aShop_StartTime) { 
		this.shop_StartTime = aShop_StartTime; 
	} 
 
	public	void setShop_EndTime(Date aShop_EndTime) { 
		this.shop_EndTime = aShop_EndTime; 
	} 
 
	public	void setShop_Tel(String aShop_Tel) { 
		this.shop_Tel = aShop_Tel; 
	} 
 
	public	void setShop_Desc(String aShop_Desc) { 
		this.shop_Desc = aShop_Desc; 
	} 
 
	public	void setShop_Long(Double aShop_Long) { 
		this.shop_Long = aShop_Long; 
	} 
 
	public	void setShop_Lat(Double aShop_Lat) { 
		this.shop_Lat = aShop_Lat; 
	} 
 
	public	void setShop_CreateTime(Date aShop_CreateTime) { 
		this.shop_CreateTime = aShop_CreateTime; 
	} 
 
	public	void setShop_visible(String aShop_visible) { 
		this.shop_visible = aShop_visible; 
	} 
 
}
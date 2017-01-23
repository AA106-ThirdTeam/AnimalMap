package com.second_prod.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:二手商品<br>
 *	英文:second_Prod<br>
 */ 
public class Second_ProdVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String second_Prod_Id; 
	private	String mem_Id; 
	private	String second_Prod_Title; 
	private	String second_Prod_Content; 
	private	Date second_Prod_adp_start_date; 
	private	Date second_Prod_adp_end_date; 
	private	Date second_Prod_adp_upDate; 
	private	String second_Prod_adp_city; 
	private	String second_Prod_Town; 
	private	String second_Prod_Road; 
	private	Double second_Prod_Lon; 
	private	Double second_Prod_Lat; 
	public	String getSecond_Prod_Id() { 
		return this.second_Prod_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	String getSecond_Prod_Title() { 
		return this.second_Prod_Title;
	} 
	public	String getSecond_Prod_Content() { 
		return this.second_Prod_Content;
	} 
	public	Date getSecond_Prod_adp_start_date() { 
		return this.second_Prod_adp_start_date;
	} 
	public	Date getSecond_Prod_adp_end_date() { 
		return this.second_Prod_adp_end_date;
	} 
	public	Date getSecond_Prod_adp_upDate() { 
		return this.second_Prod_adp_upDate;
	} 
	public	String getSecond_Prod_adp_city() { 
		return this.second_Prod_adp_city;
	} 
	public	String getSecond_Prod_Town() { 
		return this.second_Prod_Town;
	} 
	public	String getSecond_Prod_Road() { 
		return this.second_Prod_Road;
	} 
	public	Double getSecond_Prod_Lon() { 
		return this.second_Prod_Lon;
	} 
	public	Double getSecond_Prod_Lat() { 
		return this.second_Prod_Lat;
	} 
	public	void setSecond_Prod_Id(String aSecond_Prod_Id) { 
		this.second_Prod_Id = aSecond_Prod_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setSecond_Prod_Title(String aSecond_Prod_Title) { 
		this.second_Prod_Title = aSecond_Prod_Title; 
	} 
 
	public	void setSecond_Prod_Content(String aSecond_Prod_Content) { 
		this.second_Prod_Content = aSecond_Prod_Content; 
	} 
 
	public	void setSecond_Prod_adp_start_date(Date aSecond_Prod_adp_start_date) { 
		this.second_Prod_adp_start_date = aSecond_Prod_adp_start_date; 
	} 
 
	public	void setSecond_Prod_adp_end_date(Date aSecond_Prod_adp_end_date) { 
		this.second_Prod_adp_end_date = aSecond_Prod_adp_end_date; 
	} 
 
	public	void setSecond_Prod_adp_upDate(Date aSecond_Prod_adp_upDate) { 
		this.second_Prod_adp_upDate = aSecond_Prod_adp_upDate; 
	} 
 
	public	void setSecond_Prod_adp_city(String aSecond_Prod_adp_city) { 
		this.second_Prod_adp_city = aSecond_Prod_adp_city; 
	} 
 
	public	void setSecond_Prod_Town(String aSecond_Prod_Town) { 
		this.second_Prod_Town = aSecond_Prod_Town; 
	} 
 
	public	void setSecond_Prod_Road(String aSecond_Prod_Road) { 
		this.second_Prod_Road = aSecond_Prod_Road; 
	} 
 
	public	void setSecond_Prod_Lon(Double aSecond_Prod_Lon) { 
		this.second_Prod_Lon = aSecond_Prod_Lon; 
	} 
 
	public	void setSecond_Prod_Lat(Double aSecond_Prod_Lat) { 
		this.second_Prod_Lat = aSecond_Prod_Lat; 
	} 
 
}
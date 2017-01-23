package com.emg_h.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class Emg_HVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String emg_H_Id; 
	private	String mem_Id; 
	private	Date emg_H_start_date; 
	private	Date emg_H_end_date; 
	private	String emg_H_title; 
	private	String emg_H_content; 
	private	byte[] emg_H_Pic; 
	private	String emg_H_Pic_format; 
	private	String emg_H_city; 
	private	String emg_H_town; 
	private	String emg_H_road; 
	private	Double emg_H_Lon; 
	private	Double emg_H_Lat; 
	public	String getEmg_H_Id() { 
		return this.emg_H_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	Date getEmg_H_start_date() { 
		return this.emg_H_start_date;
	} 
	public	Date getEmg_H_end_date() { 
		return this.emg_H_end_date;
	} 
	public	String getEmg_H_title() { 
		return this.emg_H_title;
	} 
	public	String getEmg_H_content() { 
		return this.emg_H_content;
	} 
	public	byte[] getEmg_H_Pic() { 
		return this.emg_H_Pic;
	} 
	public	String getEmg_H_Pic_format() { 
		return this.emg_H_Pic_format;
	} 
	public	String getEmg_H_city() { 
		return this.emg_H_city;
	} 
	public	String getEmg_H_town() { 
		return this.emg_H_town;
	} 
	public	String getEmg_H_road() { 
		return this.emg_H_road;
	} 
	public	Double getEmg_H_Lon() { 
		return this.emg_H_Lon;
	} 
	public	Double getEmg_H_Lat() { 
		return this.emg_H_Lat;
	} 
	public	void setEmg_H_Id(String aEmg_H_Id) { 
		this.emg_H_Id = aEmg_H_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setEmg_H_start_date(Date aEmg_H_start_date) { 
		this.emg_H_start_date = aEmg_H_start_date; 
	} 
 
	public	void setEmg_H_end_date(Date aEmg_H_end_date) { 
		this.emg_H_end_date = aEmg_H_end_date; 
	} 
 
	public	void setEmg_H_title(String aEmg_H_title) { 
		this.emg_H_title = aEmg_H_title; 
	} 
 
	public	void setEmg_H_content(String aEmg_H_content) { 
		this.emg_H_content = aEmg_H_content; 
	} 
 
	public	void setEmg_H_Pic(byte[] aEmg_H_Pic) { 
		this.emg_H_Pic = aEmg_H_Pic; 
	} 
 
	public	void setEmg_H_Pic_format(String aEmg_H_Pic_format) { 
		this.emg_H_Pic_format = aEmg_H_Pic_format; 
	} 
 
	public	void setEmg_H_city(String aEmg_H_city) { 
		this.emg_H_city = aEmg_H_city; 
	} 
 
	public	void setEmg_H_town(String aEmg_H_town) { 
		this.emg_H_town = aEmg_H_town; 
	} 
 
	public	void setEmg_H_road(String aEmg_H_road) { 
		this.emg_H_road = aEmg_H_road; 
	} 
 
	public	void setEmg_H_Lon(Double aEmg_H_Lon) { 
		this.emg_H_Lon = aEmg_H_Lon; 
	} 
 
	public	void setEmg_H_Lat(Double aEmg_H_Lat) { 
		this.emg_H_Lat = aEmg_H_Lat; 
	} 
 
}
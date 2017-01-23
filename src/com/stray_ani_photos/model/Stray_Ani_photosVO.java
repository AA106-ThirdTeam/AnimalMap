package com.stray_ani_photos.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class Stray_Ani_photosVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String str_Ani_Pic_No; 
	private	String stray_Ani_Id; 
	private	String mem_Id; 
	private	byte[] stray_Ani_Pic; 
	private	String stray_Pic_name; 
	private	String stray_Pic_extent; 
	private	Date stray_Pic_time; 
	private	String stray_Pic_type; 
	public	String getStr_Ani_Pic_No() { 
		return this.str_Ani_Pic_No;
	} 
	public	String getStray_Ani_Id() { 
		return this.stray_Ani_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	byte[] getStray_Ani_Pic() { 
		return this.stray_Ani_Pic;
	} 
	public	String getStray_Pic_name() { 
		return this.stray_Pic_name;
	} 
	public	String getStray_Pic_extent() { 
		return this.stray_Pic_extent;
	} 
	public	Date getStray_Pic_time() { 
		return this.stray_Pic_time;
	} 
	public	String getStray_Pic_type() { 
		return this.stray_Pic_type;
	} 
	public	void setStr_Ani_Pic_No(String aStr_Ani_Pic_No) { 
		this.str_Ani_Pic_No = aStr_Ani_Pic_No; 
	} 
 
	public	void setStray_Ani_Id(String aStray_Ani_Id) { 
		this.stray_Ani_Id = aStray_Ani_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setStray_Ani_Pic(byte[] aStray_Ani_Pic) { 
		this.stray_Ani_Pic = aStray_Ani_Pic; 
	} 
 
	public	void setStray_Pic_name(String aStray_Pic_name) { 
		this.stray_Pic_name = aStray_Pic_name; 
	} 
 
	public	void setStray_Pic_extent(String aStray_Pic_extent) { 
		this.stray_Pic_extent = aStray_Pic_extent; 
	} 
 
	public	void setStray_Pic_time(Date aStray_Pic_time) { 
		this.stray_Pic_time = aStray_Pic_time; 
	} 
 
	public	void setStray_Pic_type(String aStray_Pic_type) { 
		this.stray_Pic_type = aStray_Pic_type; 
	} 
 
}
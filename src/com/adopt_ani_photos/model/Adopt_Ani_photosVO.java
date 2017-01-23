package com.adopt_ani_photos.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class Adopt_Ani_photosVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String ado_Ani_Pic_No; 
	private	String adopt_Ani_Id; 
	private	String mem_Id; 
	private	byte[] ado_Ani_Pic; 
	private	String ado_Pic_name; 
	private	String ado_Pic_extent; 
	private	Date ado_Pic_time; 
	private	String ado_Pic_type; 
	public	String getAdo_Ani_Pic_No() { 
		return this.ado_Ani_Pic_No;
	} 
	public	String getAdopt_Ani_Id() { 
		return this.adopt_Ani_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	byte[] getAdo_Ani_Pic() { 
		return this.ado_Ani_Pic;
	} 
	public	String getAdo_Pic_name() { 
		return this.ado_Pic_name;
	} 
	public	String getAdo_Pic_extent() { 
		return this.ado_Pic_extent;
	} 
	public	Date getAdo_Pic_time() { 
		return this.ado_Pic_time;
	} 
	public	String getAdo_Pic_type() { 
		return this.ado_Pic_type;
	} 
	public	void setAdo_Ani_Pic_No(String aAdo_Ani_Pic_No) { 
		this.ado_Ani_Pic_No = aAdo_Ani_Pic_No; 
	} 
 
	public	void setAdopt_Ani_Id(String aAdopt_Ani_Id) { 
		this.adopt_Ani_Id = aAdopt_Ani_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setAdo_Ani_Pic(byte[] aAdo_Ani_Pic) { 
		this.ado_Ani_Pic = aAdo_Ani_Pic; 
	} 
 
	public	void setAdo_Pic_name(String aAdo_Pic_name) { 
		this.ado_Pic_name = aAdo_Pic_name; 
	} 
 
	public	void setAdo_Pic_extent(String aAdo_Pic_extent) { 
		this.ado_Pic_extent = aAdo_Pic_extent; 
	} 
 
	public	void setAdo_Pic_time(Date aAdo_Pic_time) { 
		this.ado_Pic_time = aAdo_Pic_time; 
	} 
 
	public	void setAdo_Pic_type(String aAdo_Pic_type) { 
		this.ado_Pic_type = aAdo_Pic_type; 
	} 
 
}
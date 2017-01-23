package com.pet_photos.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:自家寵物相簿<br>
 *	英文:pet_Photos<br>
 */ 
public class Pet_PhotosVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String pet_Pic_No; 
	private	String pet_Id; 
	private	String mem_Id; 
	private	byte[] pet_Pic; 
	private	String pet_Pic_name; 
	private	String pet_Pic_extent; 
	private	Date pet_Pic_time; 
	private	String pet_Pic_type; 
	public	String getPet_Pic_No() { 
		return this.pet_Pic_No;
	} 
	public	String getPet_Id() { 
		return this.pet_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	byte[] getPet_Pic() { 
		return this.pet_Pic;
	} 
	public	String getPet_Pic_name() { 
		return this.pet_Pic_name;
	} 
	public	String getPet_Pic_extent() { 
		return this.pet_Pic_extent;
	} 
	public	Date getPet_Pic_time() { 
		return this.pet_Pic_time;
	} 
	public	String getPet_Pic_type() { 
		return this.pet_Pic_type;
	} 
	public	void setPet_Pic_No(String aPet_Pic_No) { 
		this.pet_Pic_No = aPet_Pic_No; 
	} 
 
	public	void setPet_Id(String aPet_Id) { 
		this.pet_Id = aPet_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setPet_Pic(byte[] aPet_Pic) { 
		this.pet_Pic = aPet_Pic; 
	} 
 
	public	void setPet_Pic_name(String aPet_Pic_name) { 
		this.pet_Pic_name = aPet_Pic_name; 
	} 
 
	public	void setPet_Pic_extent(String aPet_Pic_extent) { 
		this.pet_Pic_extent = aPet_Pic_extent; 
	} 
 
	public	void setPet_Pic_time(Date aPet_Pic_time) { 
		this.pet_Pic_time = aPet_Pic_time; 
	} 
 
	public	void setPet_Pic_type(String aPet_Pic_type) { 
		this.pet_Pic_type = aPet_Pic_type; 
	} 
 
}
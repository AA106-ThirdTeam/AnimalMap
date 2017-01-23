package com.hosphoto.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class HosPhotoVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String hosPhoto_Id; 
	private	String hosPhoto_HosId; 
	private	byte[] hosPhoto_photo; 
	private	String isDisp_HosPhoto; 
	private	String hosPhoto_name; 
	private	String hosPhoto_extent; 
	public	String getHosPhoto_Id() { 
		return this.hosPhoto_Id;
	} 
	public	String getHosPhoto_HosId() { 
		return this.hosPhoto_HosId;
	} 
	public	byte[] getHosPhoto_photo() { 
		return this.hosPhoto_photo;
	} 
	public	String getIsDisp_HosPhoto() { 
		return this.isDisp_HosPhoto;
	} 
	public	String getHosPhoto_name() { 
		return this.hosPhoto_name;
	} 
	public	String getHosPhoto_extent() { 
		return this.hosPhoto_extent;
	} 
	public	void setHosPhoto_Id(String aHosPhoto_Id) { 
		this.hosPhoto_Id = aHosPhoto_Id; 
	} 
 
	public	void setHosPhoto_HosId(String aHosPhoto_HosId) { 
		this.hosPhoto_HosId = aHosPhoto_HosId; 
	} 
 
	public	void setHosPhoto_photo(byte[] aHosPhoto_photo) { 
		this.hosPhoto_photo = aHosPhoto_photo; 
	} 
 
	public	void setIsDisp_HosPhoto(String aIsDisp_HosPhoto) { 
		this.isDisp_HosPhoto = aIsDisp_HosPhoto; 
	} 
 
	public	void setHosPhoto_name(String aHosPhoto_name) { 
		this.hosPhoto_name = aHosPhoto_name; 
	} 
 
	public	void setHosPhoto_extent(String aHosPhoto_extent) { 
		this.hosPhoto_extent = aHosPhoto_extent; 
	} 
 
}
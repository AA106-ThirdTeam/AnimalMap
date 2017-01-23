package com.stray_ani_loc.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class Stray_Ani_LocVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String str_Ani_Loc_No; 
	private	String stray_Ani_Id; 
	private	String mem_Id; 
	private	Double str_Ani_LocLat; 
	private	Double str_Ani_LocLon; 
	public	String getStr_Ani_Loc_No() { 
		return this.str_Ani_Loc_No;
	} 
	public	String getStray_Ani_Id() { 
		return this.stray_Ani_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	Double getStr_Ani_LocLat() { 
		return this.str_Ani_LocLat;
	} 
	public	Double getStr_Ani_LocLon() { 
		return this.str_Ani_LocLon;
	} 
	public	void setStr_Ani_Loc_No(String aStr_Ani_Loc_No) { 
		this.str_Ani_Loc_No = aStr_Ani_Loc_No; 
	} 
 
	public	void setStray_Ani_Id(String aStray_Ani_Id) { 
		this.stray_Ani_Id = aStray_Ani_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setStr_Ani_LocLat(Double aStr_Ani_LocLat) { 
		this.str_Ani_LocLat = aStr_Ani_LocLat; 
	} 
 
	public	void setStr_Ani_LocLon(Double aStr_Ani_LocLon) { 
		this.str_Ani_LocLon = aStr_Ani_LocLon; 
	} 
 
}
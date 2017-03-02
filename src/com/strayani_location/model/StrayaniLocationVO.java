package com.strayani_location.model;

/**DB->VO->interface->DAO->Service**/


import java.sql.Date;
import java.sql.Timestamp;

public class StrayaniLocationVO implements java.io.Serializable{
	private String str_Ani_Loc_No;
	private String stray_Ani_Id;     
	private String mem_Id;  
	private Integer str_Ani_LocLat; 
	private Integer str_Ani_LocLon;
	
	
	
	public String getStr_Ani_Loc_No() {
		return str_Ani_Loc_No;
	}
	public void setStr_Ani_Loc_No(String str_Ani_Loc_No) {
		this.str_Ani_Loc_No = str_Ani_Loc_No;
	}
	public String getStray_Ani_Id() {
		return stray_Ani_Id;
	}
	public void setStray_Ani_Id(String stray_Ani_Id) {
		this.stray_Ani_Id = stray_Ani_Id;
	}
	public String getMem_Id() {
		return mem_Id;
	}
	public void setMem_Id(String mem_Id) {
		this.mem_Id = mem_Id;
	}
	public Integer getStr_Ani_LocLat() {
		return str_Ani_LocLat;
	}
	public void setStr_Ani_LocLat(Integer str_Ani_LocLat) {
		this.str_Ani_LocLat = str_Ani_LocLat;
	}
	public Integer getStr_Ani_LocLon() {
		return str_Ani_LocLon;
	}
	public void setStr_Ani_LocLon(Integer str_Ani_LocLon) {
		this.str_Ani_LocLon = str_Ani_LocLon;
	}

	

    
    
}

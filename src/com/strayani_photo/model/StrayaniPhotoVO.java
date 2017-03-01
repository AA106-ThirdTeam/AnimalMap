package com.strayani_photo.model;

import java.sql.Timestamp;

public class StrayaniPhotoVO {
	
	private String str_Ani_Pic_No;  
	private String stray_Ani_Id;     
	private String mem_Id;  
	private byte[] stray_Ani_Pic; 
	private String stray_Pic_name;
	private String stray_Pic_nameEX;
	private Timestamp stray_Pic_time;
    private String stray_Pic_type;
    
    
    
	public String getStr_Ani_Pic_No() {
		return str_Ani_Pic_No;
	}
	public void setStr_Ani_Pic_No(String str_Ani_Pic_No) {
		this.str_Ani_Pic_No = str_Ani_Pic_No;
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
	public byte[] getStray_Ani_Pic() {
		return stray_Ani_Pic;
	}
	public void setStray_Ani_Pic(byte[] stray_Ani_Pic) {
		this.stray_Ani_Pic = stray_Ani_Pic;
	}
	public String getStray_Pic_name() {
		return stray_Pic_name;
	}
	public void setStray_Pic_name(String stray_Pic_name) {
		this.stray_Pic_name = stray_Pic_name;
	}
	public String getStray_Pic_nameEX() {
		return stray_Pic_nameEX;
	}
	public void setStray_Pic_nameEX(String stray_Pic_nameEX) {
		this.stray_Pic_nameEX = stray_Pic_nameEX;
	}
	public Timestamp getStray_Pic_time() {
		return stray_Pic_time;
	}
	public void setStray_Pic_time(Timestamp stray_Pic_time) {
		this.stray_Pic_time = stray_Pic_time;
	}
	public String getStray_Pic_type() {
		return stray_Pic_type;
	}
	public void setStray_Pic_type(String stray_Pic_type) {
		this.stray_Pic_type = stray_Pic_type;
	}
    
    
    
    
    
    
}

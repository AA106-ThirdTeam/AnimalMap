package com.adoptani_photo.model;

/**DB->VO->interface->DAO->Service**/

import java.sql.Date;
import java.sql.Timestamp;

public class AdoptaniPhotoVO implements java.io.Serializable{
	private String ado_Ani_Pic_No;     
	private String adopt_Ani_Id;     
	private String mem_Id;  
	private byte[] ado_Ani_Pic; 
	private String ado_Pic_name;
	private String ado_Pic_nameEX;
	private Timestamp ado_Pic_time;
    private String ado_Pic_type;
	
    
    
    public String getAdo_Ani_Pic_No() {
		return ado_Ani_Pic_No;
	}
	public void setAdo_Ani_Pic_No(String ado_Ani_Pic_No) {
		this.ado_Ani_Pic_No = ado_Ani_Pic_No;
	}
	public String getAdopt_Ani_Id() {
		return adopt_Ani_Id;
	}
	public void setAdopt_Ani_Id(String adopt_Ani_Id) {
		this.adopt_Ani_Id = adopt_Ani_Id;
	}
	public String getMem_Id() {
		return mem_Id;
	}
	public void setMem_Id(String mem_Id) {
		this.mem_Id = mem_Id;
	}
	public byte[] getAdo_Ani_Pic() {
		return ado_Ani_Pic;
	}
	public void setAdo_Ani_Pic(byte[] ado_Ani_Pic) {
		this.ado_Ani_Pic = ado_Ani_Pic;
	}
	public String getAdo_Pic_name() {
		return ado_Pic_name;
	}
	public void setAdo_Pic_name(String ado_Pic_name) {
		this.ado_Pic_name = ado_Pic_name;
	}
	public String getAdo_Pic_nameEX() {
		return ado_Pic_nameEX;
	}
	public void setAdo_Pic_nameEX(String ado_Pic_nameEX) {
		this.ado_Pic_nameEX = ado_Pic_nameEX;
	}
	public Timestamp getAdo_Pic_time() {
		return ado_Pic_time;
	}
	public void setAdo_Pic_time(Timestamp ado_Pic_time) {
		this.ado_Pic_time = ado_Pic_time;
	}
	public String getAdo_Pic_type() {
		return ado_Pic_type;
	}
	public void setAdo_Pic_type(String ado_Pic_type) {
		this.ado_Pic_type = ado_Pic_type;
	}
    
    
    
    

    
    
}

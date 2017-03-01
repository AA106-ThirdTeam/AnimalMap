package com.adoptani_sponsor.model;

/**DB->VO->interface->DAO->Service**/


import java.sql.Date;
import java.sql.Timestamp;

public class AdoptaniSponsorVO implements java.io.Serializable{
	private String ado_Ani_Spo_No;
	private String adopt_Ani_Id;     
	private String mem_Id;  
	private String ado_Ani_Spo_thing; 
	private Integer ado_Ani_Spo_money;
	private Timestamp ado_Ani_Spo_time;
	public String getAdo_Ani_Spo_No() {
		return ado_Ani_Spo_No;
	}
	public void setAdo_Ani_Spo_No(String ado_Ani_Spo_No) {
		this.ado_Ani_Spo_No = ado_Ani_Spo_No;
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
	public String getAdo_Ani_Spo_thing() {
		return ado_Ani_Spo_thing;
	}
	public void setAdo_Ani_Spo_thing(String ado_Ani_Spo_thing) {
		this.ado_Ani_Spo_thing = ado_Ani_Spo_thing;
	}
	public Integer getAdo_Ani_Spo_money() {
		return ado_Ani_Spo_money;
	}
	public void setAdo_Ani_Spo_money(Integer ado_Ani_Spo_money) {
		this.ado_Ani_Spo_money = ado_Ani_Spo_money;
	}
	public Timestamp getAdo_Ani_Spo_time() {
		return ado_Ani_Spo_time;
	}
	public void setAdo_Ani_Spo_time(Timestamp ado_Ani_Spo_time) {
		this.ado_Ani_Spo_time = ado_Ani_Spo_time;
	}
	
	
	

    
    
}

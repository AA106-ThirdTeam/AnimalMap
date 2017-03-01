package com.adoptani_message.model;

/**DB->VO->interface->DAO->Service**/


import java.sql.Date;
import java.sql.Timestamp;

import antlr.collections.List;

public class AdoptaniMessageVO implements java.io.Serializable{
	private String ado_Ani_Mes_No;
	private String adopt_Ani_Id;     
	private String mem_Id;  
	private String ado_Ani_Mes_time; 
	private String ado_Ani_Mes;
	
	
	public String getAdo_Ani_Mes_No() {
		return ado_Ani_Mes_No;
	}
	public void setAdo_Ani_Mes_No(String ado_Ani_Mes_No) {
		this.ado_Ani_Mes_No = ado_Ani_Mes_No;
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
	public String getAdo_Ani_Mes_time() {
		return ado_Ani_Mes_time;
	}
	public void setAdo_Ani_Mes_time(String ado_Ani_Mes_time) {
		this.ado_Ani_Mes_time = ado_Ani_Mes_time;
	}
	public String getAdo_Ani_Mes() {
		return ado_Ani_Mes;
	}
	public void setAdo_Ani_Mes(String ado_Ani_Mes) {
		this.ado_Ani_Mes = ado_Ani_Mes;
	}

    
    
}

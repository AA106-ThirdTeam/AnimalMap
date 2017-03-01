package com.charge.model;
import java.sql.Date;

public class ChargeVO implements java.io.Serializable{
	private String charge_no;
	private String mem_Id;
	private Integer charge_number;
	private Integer pay;
	private Date applytime;
	
	public String getCharge_no() {
		return charge_no;
	}
	public void setCharge_no(String charge_no) {
		this.charge_no = charge_no;
	}
	public String getMem_Id() {
		return mem_Id;
	}
	public void setMem_id(String mem_id) {
		this.mem_Id = mem_id;
	}
	public Integer getCharge_number() {
		return charge_number;
	}
	public void setCharge_number(Integer charge_number) {
		this.charge_number = charge_number;
	}
	public Integer getPay() {
		return pay;
	}
	public void setPay(Integer pay) {
		this.pay = pay;
	}
	public Date getApplytime() {
		return applytime;
	}
	public void setApplytime(Date applytime) {
		this.applytime = applytime;
	}
	
	
}

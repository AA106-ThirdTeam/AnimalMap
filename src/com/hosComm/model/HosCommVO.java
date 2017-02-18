package com.hosComm.model;

import java.sql.Timestamp;

public class HosCommVO {

	private String hosComment_Id;
	private String hosComment_MemId ;
	private String hosComment_HosId ;
	private String hosComment_content;
	private Timestamp hosComment_SendTime;
	
	public String getHosComment_Id() {
		return hosComment_Id;
	}
	public String getHosComment_MemId() {
		return hosComment_MemId;
	}
	public String getHosComment_HosId() {
		return hosComment_HosId;
	}
	public String getHosComment_content() {
		return hosComment_content;
	}
	public Timestamp getHosComment_SendTime() {
		return hosComment_SendTime;
	}
	public void setHosComment_Id(String hosComment_Id) {
		this.hosComment_Id = hosComment_Id;
	}
	public void setHosComment_MemId(String hosComment_MemId) {
		this.hosComment_MemId = hosComment_MemId;
	}
	public void setHosComment_HosId(String hosComment_HosId) {
		this.hosComment_HosId = hosComment_HosId;
	}
	public void setHosComment_content(String hosComment_content) {
		this.hosComment_content = hosComment_content;
	}
	public void setHosComment_SendTime(Timestamp hosComment_SendTime) {
		this.hosComment_SendTime = hosComment_SendTime;
	}
		
	
}

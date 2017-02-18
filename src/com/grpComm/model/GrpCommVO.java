package com.grpComm.model;

import java.sql.Timestamp;

public class GrpCommVO {

	private String grpComment_Id;
	private String grpComment_MemId ;
	private String grpComment_GrpId ;
	private String grpComment_content;
	private Timestamp grpComment_SendTime ;
	
	public String getGrpComment_Id() {
		return grpComment_Id;
	}
	public String getGrpComment_MemId() {
		return grpComment_MemId;
	}
	public String getGrpComment_GrpId() {
		return grpComment_GrpId;
	}
	public String getGrpComment_content() {
		return grpComment_content;
	}
	public Timestamp getGrpComment_SendTime() {
		return grpComment_SendTime;
	}
	public void setGrpComment_Id(String grpComment_Id) {
		this.grpComment_Id = grpComment_Id;
	}
	public void setGrpComment_MemId(String grpComment_MemId) {
		this.grpComment_MemId = grpComment_MemId;
	}
	public void setGrpComment_GrpId(String grpComment_GrpId) {
		this.grpComment_GrpId = grpComment_GrpId;
	}
	public void setGrpComment_content(String grpComment_content) {
		this.grpComment_content = grpComment_content;
	}
	public void setGrpComment_SendTime(Timestamp grpComment_SendTime) {
		this.grpComment_SendTime = grpComment_SendTime;
	}
		
	
}

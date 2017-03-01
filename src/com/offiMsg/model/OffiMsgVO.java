package com.offiMsg.model;

import java.sql.Date;

public class OffiMsgVO implements java.io.Serializable{
	private String offiMsg_Id;
//	private String emp_No;
	private String offiMsg_empId;
	
	private String offiMsg_Title;
	private String offiMsg_Content;
	private Date offiMsg_Date;
	
	public String getOffiMsg_Id() {
		return offiMsg_Id;
	}
	public String getOffiMsg_empId() {
		return offiMsg_empId;
	}
	public void setOffiMsg_empId(String offiMsg_empId) {
		this.offiMsg_empId = offiMsg_empId;
	}
	public void setOffiMsg_Id(String offiMsg_Id) {
		this.offiMsg_Id = offiMsg_Id;
	}
//	public String getEmp_No() {
//		return emp_No;
//	}
//	public void setEmp_No(String emp_No) {
//		this.emp_No = emp_No;
//	}
	public String getOffiMsg_Title() {
		return offiMsg_Title;
	}
	public void setOffiMsg_Title(String offiMsg_Title) {
		this.offiMsg_Title = offiMsg_Title;
	}
	public String getOffiMsg_Content() {
		return offiMsg_Content;
	}
	public void setOffiMsg_Content(String offiMsg_Content) {
		this.offiMsg_Content = offiMsg_Content;
	}
	public Date getOffiMsg_Date() {
		return offiMsg_Date;
	}
	public void setOffiMsg_Date(Date offiMsg_Date) {
		this.offiMsg_Date = offiMsg_Date;
	}
	
	


}

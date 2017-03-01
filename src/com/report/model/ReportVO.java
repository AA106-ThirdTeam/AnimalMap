package com.report.model;

import java.sql.Date;

public class ReportVO implements java.io.Serializable {

	private String report_No;
	private String report_name;
	private String report_class;
	private String report_class_No;
	private String report_class_No_value;
	private String report_class_status;
	private String report_content;
	private String report_status;
	private String mem_Id_active;
	private String mem_Id_passive;
	private Date report_time;

	public String getReport_No() {
		return report_No;
	}

	public void setReport_No(String report_No) {
		this.report_No = report_No;
	}

	public String getReport_name() {
		return report_name;
	}

	public void setReport_name(String report_name) {
		this.report_name = report_name;
	}

	public String getReport_class() {
		return report_class;
	}

	public void setReport_class(String report_class) {
		this.report_class = report_class;
	}

	public String getReport_class_No() {
		return report_class_No;
	}

	public void setReport_class_No(String report_class_No) {
		this.report_class_No = report_class_No;
	}

	public String getReport_content() {
		return report_content;
	}

	public void setReport_content(String report_content) {
		this.report_content = report_content;
	}

	public String getReport_status() {
		return report_status;
	}

	public void setReport_status(String report_status) {
		this.report_status = report_status;
	}

	public String getMem_Id_active() {
		return mem_Id_active;
	}

	public void setMem_Id_active(String mem_Id_active) {
		this.mem_Id_active = mem_Id_active;
	}

	public String getMem_Id_passive() {
		return mem_Id_passive;
	}

	public void setMem_Id_passive(String mem_Id_passive) {
		this.mem_Id_passive = mem_Id_passive;
	}

	public Date getReport_time() {
		return report_time;
	}

	public void setReport_time(Date report_time) {
		this.report_time = report_time;
	}
	
	public String getReport_class_No_value() {
		return report_class_No_value;
	}

	public void setReport_class_No_value(String report_class_No_value) {
		this.report_class_No_value = report_class_No_value;
	}

	public String getReport_class_status() {
		return report_class_status;
	}

	public void setReport_class_status(String report_class_status) {
		this.report_class_status = report_class_status;
	}
	
	
}

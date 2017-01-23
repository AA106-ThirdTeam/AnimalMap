package com.hos_comment.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class Hos_commentVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String hosComm_Id; 
	private	String hosComm_MemId; 
	private	String hosComm_HosId; 
	private	String hosComm_content; 
	private	Date hosComm_SendTime; 
	public	String getHosComm_Id() { 
		return this.hosComm_Id;
	} 
	public	String getHosComm_MemId() { 
		return this.hosComm_MemId;
	} 
	public	String getHosComm_HosId() { 
		return this.hosComm_HosId;
	} 
	public	String getHosComm_content() { 
		return this.hosComm_content;
	} 
	public	Date getHosComm_SendTime() { 
		return this.hosComm_SendTime;
	} 
	public	void setHosComm_Id(String aHosComm_Id) { 
		this.hosComm_Id = aHosComm_Id; 
	} 
 
	public	void setHosComm_MemId(String aHosComm_MemId) { 
		this.hosComm_MemId = aHosComm_MemId; 
	} 
 
	public	void setHosComm_HosId(String aHosComm_HosId) { 
		this.hosComm_HosId = aHosComm_HosId; 
	} 
 
	public	void setHosComm_content(String aHosComm_content) { 
		this.hosComm_content = aHosComm_content; 
	} 
 
	public	void setHosComm_SendTime(Date aHosComm_SendTime) { 
		this.hosComm_SendTime = aHosComm_SendTime; 
	} 
 
}
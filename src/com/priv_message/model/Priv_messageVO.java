package com.priv_message.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class Priv_messageVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String privMes_Id; 
	private	String privMesSend_MemId; 
	private	String privMesRec_MemId; 
	private	String privMes_content; 
	private	Date privMes_SendTime; 
	private	String privMes_type; 
	public	String getPrivMes_Id() { 
		return this.privMes_Id;
	} 
	public	String getPrivMesSend_MemId() { 
		return this.privMesSend_MemId;
	} 
	public	String getPrivMesRec_MemId() { 
		return this.privMesRec_MemId;
	} 
	public	String getPrivMes_content() { 
		return this.privMes_content;
	} 
	public	Date getPrivMes_SendTime() { 
		return this.privMes_SendTime;
	} 
	public	String getPrivMes_type() { 
		return this.privMes_type;
	} 
	public	void setPrivMes_Id(String aPrivMes_Id) { 
		this.privMes_Id = aPrivMes_Id; 
	} 
 
	public	void setPrivMesSend_MemId(String aPrivMesSend_MemId) { 
		this.privMesSend_MemId = aPrivMesSend_MemId; 
	} 
 
	public	void setPrivMesRec_MemId(String aPrivMesRec_MemId) { 
		this.privMesRec_MemId = aPrivMesRec_MemId; 
	} 
 
	public	void setPrivMes_content(String aPrivMes_content) { 
		this.privMes_content = aPrivMes_content; 
	} 
 
	public	void setPrivMes_SendTime(Date aPrivMes_SendTime) { 
		this.privMes_SendTime = aPrivMes_SendTime; 
	} 
 
	public	void setPrivMes_type(String aPrivMes_type) { 
		this.privMes_type = aPrivMes_type; 
	} 
 
}
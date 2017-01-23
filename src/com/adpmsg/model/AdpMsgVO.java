package com.adpmsg.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class AdpMsgVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String adpMsg_Id; 
	private	String adp_Id; 
	private	String mem_Id; 
	private	String msg; 
	private	Date adpMsgDate; 
	private	Date adpMsgadp_upDate; 
	public	String getAdpMsg_Id() { 
		return this.adpMsg_Id;
	} 
	public	String getAdp_Id() { 
		return this.adp_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	String getMsg() { 
		return this.msg;
	} 
	public	Date getAdpMsgDate() { 
		return this.adpMsgDate;
	} 
	public	Date getAdpMsgadp_upDate() { 
		return this.adpMsgadp_upDate;
	} 
	public	void setAdpMsg_Id(String aAdpMsg_Id) { 
		this.adpMsg_Id = aAdpMsg_Id; 
	} 
 
	public	void setAdp_Id(String aAdp_Id) { 
		this.adp_Id = aAdp_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setMsg(String aMsg) { 
		this.msg = aMsg; 
	} 
 
	public	void setAdpMsgDate(Date aAdpMsgDate) { 
		this.adpMsgDate = aAdpMsgDate; 
	} 
 
	public	void setAdpMsgadp_upDate(Date aAdpMsgadp_upDate) { 
		this.adpMsgadp_upDate = aAdpMsgadp_upDate; 
	} 
 
}
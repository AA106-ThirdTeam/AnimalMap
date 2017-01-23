package com.offimsg.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:公告訊息<br>
 *	英文:offiMsg<br>
 */ 
public class OffiMsgVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String offiMsg_Id; 
	private	String offiMsg_empId; 
	private	String offiMsg_Title; 
	private	String offiMsg_Content; 
	private	Date offiMsg_Date; 
	public	String getOffiMsg_Id() { 
		return this.offiMsg_Id;
	} 
	public	String getOffiMsg_empId() { 
		return this.offiMsg_empId;
	} 
	public	String getOffiMsg_Title() { 
		return this.offiMsg_Title;
	} 
	public	String getOffiMsg_Content() { 
		return this.offiMsg_Content;
	} 
	public	Date getOffiMsg_Date() { 
		return this.offiMsg_Date;
	} 
	public	void setOffiMsg_Id(String aOffiMsg_Id) { 
		this.offiMsg_Id = aOffiMsg_Id; 
	} 
 
	public	void setOffiMsg_empId(String aOffiMsg_empId) { 
		this.offiMsg_empId = aOffiMsg_empId; 
	} 
 
	public	void setOffiMsg_Title(String aOffiMsg_Title) { 
		this.offiMsg_Title = aOffiMsg_Title; 
	} 
 
	public	void setOffiMsg_Content(String aOffiMsg_Content) { 
		this.offiMsg_Content = aOffiMsg_Content; 
	} 
 
	public	void setOffiMsg_Date(Date aOffiMsg_Date) { 
		this.offiMsg_Date = aOffiMsg_Date; 
	} 
 
}
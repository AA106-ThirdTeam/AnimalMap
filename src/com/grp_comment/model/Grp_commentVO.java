package com.grp_comment.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:揪團留言<br>
 *	英文:grp_comment<br>
 */ 
public class Grp_commentVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String grpComment_Id; 
	private	String grpComment_MemId; 
	private	String grpComment_GrpId; 
	private	String grpComment_content; 
	private	Date grpComment_SendTime; 
	public	String getGrpComment_Id() { 
		return this.grpComment_Id;
	} 
	public	String getGrpComment_MemId() { 
		return this.grpComment_MemId;
	} 
	public	String getGrpComment_GrpId() { 
		return this.grpComment_GrpId;
	} 
	public	String getGrpComment_content() { 
		return this.grpComment_content;
	} 
	public	Date getGrpComment_SendTime() { 
		return this.grpComment_SendTime;
	} 
	public	void setGrpComment_Id(String aGrpComment_Id) { 
		this.grpComment_Id = aGrpComment_Id; 
	} 
 
	public	void setGrpComment_MemId(String aGrpComment_MemId) { 
		this.grpComment_MemId = aGrpComment_MemId; 
	} 
 
	public	void setGrpComment_GrpId(String aGrpComment_GrpId) { 
		this.grpComment_GrpId = aGrpComment_GrpId; 
	} 
 
	public	void setGrpComment_content(String aGrpComment_content) { 
		this.grpComment_content = aGrpComment_content; 
	} 
 
	public	void setGrpComment_SendTime(Date aGrpComment_SendTime) { 
		this.grpComment_SendTime = aGrpComment_SendTime; 
	} 
 
}
package com.joinlist.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class JoinListVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String joinList_GrpId; 
	private	String joinList_MemId; 
	public	String getJoinList_GrpId() { 
		return this.joinList_GrpId;
	} 
	public	String getJoinList_MemId() { 
		return this.joinList_MemId;
	} 
	public	void setJoinList_GrpId(String aJoinList_GrpId) { 
		this.joinList_GrpId = aJoinList_GrpId; 
	} 
 
	public	void setJoinList_MemId(String aJoinList_MemId) { 
		this.joinList_MemId = aJoinList_MemId; 
	} 
 
}
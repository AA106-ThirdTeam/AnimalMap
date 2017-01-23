package com.rel_list.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class Rel_ListVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String rel_MemId; 
	private	String added_MemId; 
	private	String isBlackList; 
	private	String isInvited; 
	public	String getRel_MemId() { 
		return this.rel_MemId;
	} 
	public	String getAdded_MemId() { 
		return this.added_MemId;
	} 
	public	String getIsBlackList() { 
		return this.isBlackList;
	} 
	public	String getIsInvited() { 
		return this.isInvited;
	} 
	public	void setRel_MemId(String aRel_MemId) { 
		this.rel_MemId = aRel_MemId; 
	} 
 
	public	void setAdded_MemId(String aAdded_MemId) { 
		this.added_MemId = aAdded_MemId; 
	} 
 
	public	void setIsBlackList(String aIsBlackList) { 
		this.isBlackList = aIsBlackList; 
	} 
 
	public	void setIsInvited(String aIsInvited) { 
		this.isInvited = aIsInvited; 
	} 
 
}
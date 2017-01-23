package com.rel_list.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:關係名單<br>
 *	英文:rel_List<br>
 */ 
public class Rel_ListVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:(PK,FK)<br>
 	*/ 
	private	String rel_MemId; 
 
	/** 
 	*	欄位名稱:'被加會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:(PK,FK)<br>
 	*/ 
	private	String added_MemId; 
 
	/** 
 	*	欄位名稱:'是否為黑名單 | PS: 0為否，1為是'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String isBlackList; 
 
	/** 
 	*	欄位名稱:'是否已被邀請至揪團 | PS: 0為否，1為是'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String isInvited; 
 
	/** 
 	*	欄位名稱:'會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:(PK,FK)<br>
 	*/ 
	public	String getRel_MemId() { 
		return this.rel_MemId;
	} 
	/** 
 	*	欄位名稱:'被加會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:(PK,FK)<br>
 	*/ 
	public	String getAdded_MemId() { 
		return this.added_MemId;
	} 
	/** 
 	*	欄位名稱:'是否為黑名單 | PS: 0為否，1為是'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getIsBlackList() { 
		return this.isBlackList;
	} 
	/** 
 	*	欄位名稱:'是否已被邀請至揪團 | PS: 0為否，1為是'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getIsInvited() { 
		return this.isInvited;
	} 
	/** 
 	*	欄位名稱:'會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:(PK,FK)<br>
 	*/ 
	public	void setRel_MemId(String aRel_MemId) { 
		this.rel_MemId = aRel_MemId; 
	} 
 
	/** 
 	*	欄位名稱:'被加會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:(PK,FK)<br>
 	*/ 
	public	void setAdded_MemId(String aAdded_MemId) { 
		this.added_MemId = aAdded_MemId; 
	} 
 
	/** 
 	*	欄位名稱:'是否為黑名單 | PS: 0為否，1為是'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setIsBlackList(String aIsBlackList) { 
		this.isBlackList = aIsBlackList; 
	} 
 
	/** 
 	*	欄位名稱:'是否已被邀請至揪團 | PS: 0為否，1為是'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setIsInvited(String aIsInvited) { 
		this.isInvited = aIsInvited; 
	} 
 
}
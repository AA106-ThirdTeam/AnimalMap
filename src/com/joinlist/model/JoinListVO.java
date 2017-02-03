package com.joinlist.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	揪團參加名單<br>
 *	英文:JoinList<br>
 */ 
public class JoinListVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'活動編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:(PK)(FK)<br>
 	*/ 
	private	String joinList_GrpId; 
 
	/** 
 	*	欄位名稱:'會員編號(參加者) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:(PK)(FK)<br>
 	*/ 
	private	String joinList_MemId; 
 
	/** 
 	*	欄位名稱:'活動編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:(PK)(FK)<br>
 	*/ 
	public	String getJoinList_GrpId() { 
		return this.joinList_GrpId;
	} 
	/** 
 	*	欄位名稱:'會員編號(參加者) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:(PK)(FK)<br>
 	*/ 
	public	String getJoinList_MemId() { 
		return this.joinList_MemId;
	} 
	/** 
 	*	欄位名稱:'活動編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:(PK)(FK)<br>
 	*/ 
	public	void setJoinList_GrpId(String aJoinList_GrpId) { 
		this.joinList_GrpId = aJoinList_GrpId; 
	} 
 
	/** 
 	*	欄位名稱:'會員編號(參加者) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:(PK)(FK)<br>
 	*/ 
	public	void setJoinList_MemId(String aJoinList_MemId) { 
		this.joinList_MemId = aJoinList_MemId; 
	} 
 
}
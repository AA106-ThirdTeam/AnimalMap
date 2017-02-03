package com.track.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	追蹤收藏<br>
 *	英文:track<br>
 */ 
public class TrackVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'收藏編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String track_Id; 
 
	/** 
 	*	欄位名稱:'會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'收藏種類 | PS: 0.流浪動物 1.領養活動 2.揪團 3.緊急求救 4.店家 5.二手 6.自家寵物'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	private	String track_record_class; 
 
	/** 
 	*	欄位名稱:'種類編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:<br>
 	*/ 
	private	String track_record_class_Id; 
 
	/** 
 	*	欄位名稱:'收藏編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getTrack_Id() { 
		return this.track_Id;
	} 
	/** 
 	*	欄位名稱:'會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	/** 
 	*	欄位名稱:'收藏種類 | PS: 0.流浪動物 1.領養活動 2.揪團 3.緊急求救 4.店家 5.二手 6.自家寵物'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	String getTrack_record_class() { 
		return this.track_record_class;
	} 
	/** 
 	*	欄位名稱:'種類編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:<br>
 	*/ 
	public	String getTrack_record_class_Id() { 
		return this.track_record_class_Id;
	} 
	/** 
 	*	欄位名稱:'收藏編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setTrack_Id(String aTrack_Id) { 
		this.track_Id = aTrack_Id; 
	} 
 
	/** 
 	*	欄位名稱:'會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	/** 
 	*	欄位名稱:'收藏種類 | PS: 0.流浪動物 1.領養活動 2.揪團 3.緊急求救 4.店家 5.二手 6.自家寵物'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:1<br>
	*	限制條件:<br>
 	*/ 
	public	void setTrack_record_class(String aTrack_record_class) { 
		this.track_record_class = aTrack_record_class; 
	} 
 
	/** 
 	*	欄位名稱:'種類編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:<br>
 	*/ 
	public	void setTrack_record_class_Id(String aTrack_record_class_Id) { 
		this.track_record_class_Id = aTrack_record_class_Id; 
	} 
 
}
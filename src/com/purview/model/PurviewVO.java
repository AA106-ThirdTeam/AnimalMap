package com.purview.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:權限<br>
 *	英文:purview<br>
 */ 
public class PurviewVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String purview_No; 
	private	String pruview_name; 
	public	String getPurview_No() { 
		return this.purview_No;
	} 
	public	String getPruview_name() { 
		return this.pruview_name;
	} 
	public	void setPurview_No(String aPurview_No) { 
		this.purview_No = aPurview_No; 
	} 
 
	public	void setPruview_name(String aPruview_name) { 
		this.pruview_name = aPruview_name; 
	} 
 
}
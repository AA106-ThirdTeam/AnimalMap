package com.res_ponse.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class Res_ponseVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String res_Id; 
	private	String mem_Id; 
	private	String post_Id; 
	private	String res_ponse_content; 
	private	Date post_time; 
	private	Date res_ponse_upDate; 
	public	String getRes_Id() { 
		return this.res_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	String getPost_Id() { 
		return this.post_Id;
	} 
	public	String getRes_ponse_content() { 
		return this.res_ponse_content;
	} 
	public	Date getPost_time() { 
		return this.post_time;
	} 
	public	Date getRes_ponse_upDate() { 
		return this.res_ponse_upDate;
	} 
	public	void setRes_Id(String aRes_Id) { 
		this.res_Id = aRes_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setPost_Id(String aPost_Id) { 
		this.post_Id = aPost_Id; 
	} 
 
	public	void setRes_ponse_content(String aRes_ponse_content) { 
		this.res_ponse_content = aRes_ponse_content; 
	} 
 
	public	void setPost_time(Date aPost_time) { 
		this.post_time = aPost_time; 
	} 
 
	public	void setRes_ponse_upDate(Date aRes_ponse_upDate) { 
		this.res_ponse_upDate = aRes_ponse_upDate; 
	} 
 
}
package com.post.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class PostVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String post_Id; 
	private	String mem_Id; 
	private	String post_class; 
	private	String post_class_Id; 
	private	String post_title; 
	private	String post_content; 
	private	Date post_time; 
	private	Date post_upDate; 
	private	Integer post_resNum; 
	public	String getPost_Id() { 
		return this.post_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	String getPost_class() { 
		return this.post_class;
	} 
	public	String getPost_class_Id() { 
		return this.post_class_Id;
	} 
	public	String getPost_title() { 
		return this.post_title;
	} 
	public	String getPost_content() { 
		return this.post_content;
	} 
	public	Date getPost_time() { 
		return this.post_time;
	} 
	public	Date getPost_upDate() { 
		return this.post_upDate;
	} 
	public	Integer getPost_resNum() { 
		return this.post_resNum;
	} 
	public	void setPost_Id(String aPost_Id) { 
		this.post_Id = aPost_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setPost_class(String aPost_class) { 
		this.post_class = aPost_class; 
	} 
 
	public	void setPost_class_Id(String aPost_class_Id) { 
		this.post_class_Id = aPost_class_Id; 
	} 
 
	public	void setPost_title(String aPost_title) { 
		this.post_title = aPost_title; 
	} 
 
	public	void setPost_content(String aPost_content) { 
		this.post_content = aPost_content; 
	} 
 
	public	void setPost_time(Date aPost_time) { 
		this.post_time = aPost_time; 
	} 
 
	public	void setPost_upDate(Date aPost_upDate) { 
		this.post_upDate = aPost_upDate; 
	} 
 
	public	void setPost_resNum(Integer aPost_resNum) { 
		this.post_resNum = aPost_resNum; 
	} 
 
}
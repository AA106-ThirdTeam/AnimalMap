package com.post_Response.model;

import java.sql.Date;

public class Post_ResponseVO  implements java.io.Serializable{
	private String res_Id;
	private String mem_Id;
	private String post_Id;
	private String post_Response_content;
	private Date post_time;
	private Date post_Response_upDate;
	
	public String getRes_Id() {
		return res_Id;
	}
	public void setRes_Id(String res_Id) {
		this.res_Id = res_Id;
	}
	public String getMem_Id() {
		return mem_Id;
	}
	public void setMem_Id(String mem_Id) {
		this.mem_Id = mem_Id;
	}
	public String getPost_Id() {
		return post_Id;
	}
	public void setPost_Id(String post_Id) {
		this.post_Id = post_Id;
	}
	public String getPost_Response_content() {
		return post_Response_content;
	}
	public void setPost_Response_content(String post_Response_content) {
		this.post_Response_content = post_Response_content;
	}
	public Date getPost_time() {
		return post_time;
	}
	public void setPost_time(Date post_time) {
		this.post_time = post_time;
	}
	public Date getPost_Response_upDate() {
		return post_Response_upDate;
	}
	public void setPost_Response_upDate(Date post_Response_upDate) {
		this.post_Response_upDate = post_Response_upDate;
	}
	
	

}

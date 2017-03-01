package com.post.model;

import java.sql.Date;

public class PostVO  implements java.io.Serializable {

	private String post_Id;
	private String mem_Id;
	private String post_class;
	private String post_class_Id;
	private String post_title;
	private String post_content;
	private Date post_time;
	private Date post_upDate;
	private Integer post_resNum;

	public String getPost_Id() {
		return post_Id;
	}

	public void setPost_Id(String post_Id) {
		this.post_Id = post_Id;
	}

	public String getMem_Id() {
		return mem_Id;
	}

	public void setMem_Id(String mem_Id) {
		this.mem_Id = mem_Id;
	}

	public String getPost_class() {
		return post_class;
	}

	public void setPost_class(String post_class) {
		this.post_class = post_class;
	}

	public String getPost_class_Id() {
		return post_class_Id;
	}

	public void setPost_class_Id(String post_class_Id) {
		this.post_class_Id = post_class_Id;
	}

	public String getPost_title() {
		return post_title;
	}

	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public Date getPost_time() {
		return post_time;
	}

	public void setPost_time(Date post_time) {
		this.post_time = post_time;
	}

	public Date getPost_upDate() {
		return post_upDate;
	}

	public void setPost_upDate(Date post_upDate) {
		this.post_upDate = post_upDate;
	}

	public Integer getPost_resNum() {
		return post_resNum;
	}

	public void setPost_resNum(Integer post_resNum) {
		this.post_resNum = post_resNum;
	}

}

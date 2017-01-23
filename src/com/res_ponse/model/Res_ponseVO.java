package com.res_ponse.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:討論區留言 <br>
 *	英文:res_ponse<br>
 */ 
public class Res_ponseVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'留言(回覆)編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String res_Id; 
 
	/** 
 	*	欄位名稱:'會員編號(發文者) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'文章編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String post_Id; 
 
	/** 
 	*	欄位名稱:'文章留言內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:900<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String res_ponse_content; 
 
	/** 
 	*	欄位名稱:'發佈時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date post_time; 
 
	/** 
 	*	欄位名稱:'修改時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date res_ponse_upDate; 
 
	/** 
 	*	欄位名稱:'留言(回覆)編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getRes_Id() { 
		return this.res_Id;
	} 
	/** 
 	*	欄位名稱:'會員編號(發文者) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	/** 
 	*	欄位名稱:'文章編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	String getPost_Id() { 
		return this.post_Id;
	} 
	/** 
 	*	欄位名稱:'文章留言內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:900<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getRes_ponse_content() { 
		return this.res_ponse_content;
	} 
	/** 
 	*	欄位名稱:'發佈時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getPost_time() { 
		return this.post_time;
	} 
	/** 
 	*	欄位名稱:'修改時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getRes_ponse_upDate() { 
		return this.res_ponse_upDate;
	} 
	/** 
 	*	欄位名稱:'留言(回覆)編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setRes_Id(String aRes_Id) { 
		this.res_Id = aRes_Id; 
	} 
 
	/** 
 	*	欄位名稱:'會員編號(發文者) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	/** 
 	*	欄位名稱:'文章編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	public	void setPost_Id(String aPost_Id) { 
		this.post_Id = aPost_Id; 
	} 
 
	/** 
 	*	欄位名稱:'文章留言內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:900<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setRes_ponse_content(String aRes_ponse_content) { 
		this.res_ponse_content = aRes_ponse_content; 
	} 
 
	/** 
 	*	欄位名稱:'發佈時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setPost_time(Date aPost_time) { 
		this.post_time = aPost_time; 
	} 
 
	/** 
 	*	欄位名稱:'修改時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setRes_ponse_upDate(Date aRes_ponse_upDate) { 
		this.res_ponse_upDate = aRes_ponse_upDate; 
	} 
 
}
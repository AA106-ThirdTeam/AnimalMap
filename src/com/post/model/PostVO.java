package com.post.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	討論區<br>
 *	英文:post<br>
 */ 
public class PostVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'文章編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String post_Id; 
 
	/** 
 	*	欄位名稱:'會員編號(發文者) | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL (FK)<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'文章分類 | PS: 1.自介 2.請問 3.資訊 4.推薦(反推) 5.認養 6.協尋 7.拾獲 8.心得'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:10<br>
	*	限制條件:<br>
 	*/ 
	private	String post_class; 
 
	/** 
 	*	欄位名稱:'文章分類編號 | PS: 對應其他Table的PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:<br>
 	*/ 
	private	String post_class_Id; 
 
	/** 
 	*	欄位名稱:'文章標題 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:80<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String post_title; 
 
	/** 
 	*	欄位名稱:'文章內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String post_content; 
 
	/** 
 	*	欄位名稱:'發佈時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	Date post_time; 
 
	/** 
 	*	欄位名稱:'修改時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date post_upDate; 
 
	/** 
 	*	欄位名稱:'回覆數量 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:4<br>
	*	限制條件:<br>
 	*/ 
	private	Integer post_resNum; 
 
	/** 
 	*	欄位名稱:'文章編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getPost_Id() { 
		return this.post_Id;
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
 	*	欄位名稱:'文章分類 | PS: 1.自介 2.請問 3.資訊 4.推薦(反推) 5.認養 6.協尋 7.拾獲 8.心得'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:10<br>
	*	限制條件:<br>
 	*/ 
	public	String getPost_class() { 
		return this.post_class;
	} 
	/** 
 	*	欄位名稱:'文章分類編號 | PS: 對應其他Table的PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:<br>
 	*/ 
	public	String getPost_class_Id() { 
		return this.post_class_Id;
	} 
	/** 
 	*	欄位名稱:'文章標題 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:80<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getPost_title() { 
		return this.post_title;
	} 
	/** 
 	*	欄位名稱:'文章內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getPost_content() { 
		return this.post_content;
	} 
	/** 
 	*	欄位名稱:'發佈時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
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
	public	Date getPost_upDate() { 
		return this.post_upDate;
	} 
	/** 
 	*	欄位名稱:'回覆數量 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:4<br>
	*	限制條件:<br>
 	*/ 
	public	Integer getPost_resNum() { 
		return this.post_resNum;
	} 
	/** 
 	*	欄位名稱:'文章編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setPost_Id(String aPost_Id) { 
		this.post_Id = aPost_Id; 
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
 	*	欄位名稱:'文章分類 | PS: 1.自介 2.請問 3.資訊 4.推薦(反推) 5.認養 6.協尋 7.拾獲 8.心得'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:10<br>
	*	限制條件:<br>
 	*/ 
	public	void setPost_class(String aPost_class) { 
		this.post_class = aPost_class; 
	} 
 
	/** 
 	*	欄位名稱:'文章分類編號 | PS: 對應其他Table的PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:<br>
 	*/ 
	public	void setPost_class_Id(String aPost_class_Id) { 
		this.post_class_Id = aPost_class_Id; 
	} 
 
	/** 
 	*	欄位名稱:'文章標題 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:80<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setPost_title(String aPost_title) { 
		this.post_title = aPost_title; 
	} 
 
	/** 
 	*	欄位名稱:'文章內容 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setPost_content(String aPost_content) { 
		this.post_content = aPost_content; 
	} 
 
	/** 
 	*	欄位名稱:'發佈時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
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
	public	void setPost_upDate(Date aPost_upDate) { 
		this.post_upDate = aPost_upDate; 
	} 
 
	/** 
 	*	欄位名稱:'回覆數量 | PS: '<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:4<br>
	*	限制條件:<br>
 	*/ 
	public	void setPost_resNum(Integer aPost_resNum) { 
		this.post_resNum = aPost_resNum; 
	} 
 
}
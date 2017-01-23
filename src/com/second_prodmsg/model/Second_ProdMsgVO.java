package com.second_prodmsg.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:二手商品留言<br>
 *	英文:second_ProdMsg<br>
 */ 
public class Second_ProdMsgVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'二手商品留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String second_ProdMsg_Id; 
 
	/** 
 	*	欄位名稱:'二手商品編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL FK<br>
 	*/ 
	private	String second_Prod_Id; 
 
	/** 
 	*	欄位名稱:'留言會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL FK<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'二手商品留言 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	private	String second_ProdMsg_Msg; 
 
	/** 
 	*	欄位名稱:'留言發布日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date second_ProdMsg_DATE; 
 
	/** 
 	*	欄位名稱:'留言更新日期 | PS: 有更新才會有值'<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date second_ProdMsg_adp_upDate; 
 
	/** 
 	*	欄位名稱:'二手商品留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getSecond_ProdMsg_Id() { 
		return this.second_ProdMsg_Id;
	} 
	/** 
 	*	欄位名稱:'二手商品編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL FK<br>
 	*/ 
	public	String getSecond_Prod_Id() { 
		return this.second_Prod_Id;
	} 
	/** 
 	*	欄位名稱:'留言會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL FK<br>
 	*/ 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	/** 
 	*	欄位名稱:'二手商品留言 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	String getSecond_ProdMsg_Msg() { 
		return this.second_ProdMsg_Msg;
	} 
	/** 
 	*	欄位名稱:'留言發布日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getSecond_ProdMsg_DATE() { 
		return this.second_ProdMsg_DATE;
	} 
	/** 
 	*	欄位名稱:'留言更新日期 | PS: 有更新才會有值'<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getSecond_ProdMsg_adp_upDate() { 
		return this.second_ProdMsg_adp_upDate;
	} 
	/** 
 	*	欄位名稱:'二手商品留言編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setSecond_ProdMsg_Id(String aSecond_ProdMsg_Id) { 
		this.second_ProdMsg_Id = aSecond_ProdMsg_Id; 
	} 
 
	/** 
 	*	欄位名稱:'二手商品編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL FK<br>
 	*/ 
	public	void setSecond_Prod_Id(String aSecond_Prod_Id) { 
		this.second_Prod_Id = aSecond_Prod_Id; 
	} 
 
	/** 
 	*	欄位名稱:'留言會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:NOT NULL FK<br>
 	*/ 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	/** 
 	*	欄位名稱:'二手商品留言 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	void setSecond_ProdMsg_Msg(String aSecond_ProdMsg_Msg) { 
		this.second_ProdMsg_Msg = aSecond_ProdMsg_Msg; 
	} 
 
	/** 
 	*	欄位名稱:'留言發布日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setSecond_ProdMsg_DATE(Date aSecond_ProdMsg_DATE) { 
		this.second_ProdMsg_DATE = aSecond_ProdMsg_DATE; 
	} 
 
	/** 
 	*	欄位名稱:'留言更新日期 | PS: 有更新才會有值'<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setSecond_ProdMsg_adp_upDate(Date aSecond_ProdMsg_adp_upDate) { 
		this.second_ProdMsg_adp_upDate = aSecond_ProdMsg_adp_upDate; 
	} 
 
}
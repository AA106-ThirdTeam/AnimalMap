package com.adpmsg.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	領養活動留言<br>
 *	英文:adpMsg<br>
 */ 
public class AdpMsgVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'領養活動留言編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String adpMsg_Id; 
 
	/** 
 	*	欄位名稱:'領養活動編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	private	String adp_Id; 
 
	/** 
 	*	欄位名稱:'留言會員編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'領養活動留言 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	private	String msg; 
 
	/** 
 	*	欄位名稱:'留言發布日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date adpMsgDate; 
 
	/** 
 	*	欄位名稱:'留言更新日期 | PS: 有更新才會有值'<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date adpMsgadp_upDate; 
 
	/** 
 	*	欄位名稱:'領養活動留言編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getAdpMsg_Id() { 
		return this.adpMsg_Id;
	} 
	/** 
 	*	欄位名稱:'領養活動編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	String getAdp_Id() { 
		return this.adp_Id;
	} 
	/** 
 	*	欄位名稱:'留言會員編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	/** 
 	*	欄位名稱:'領養活動留言 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	String getMsg() { 
		return this.msg;
	} 
	/** 
 	*	欄位名稱:'留言發布日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getAdpMsgDate() { 
		return this.adpMsgDate;
	} 
	/** 
 	*	欄位名稱:'留言更新日期 | PS: 有更新才會有值'<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getAdpMsgadp_upDate() { 
		return this.adpMsgadp_upDate;
	} 
	/** 
 	*	欄位名稱:'領養活動留言編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setAdpMsg_Id(String aAdpMsg_Id) { 
		this.adpMsg_Id = aAdpMsg_Id; 
	} 
 
	/** 
 	*	欄位名稱:'領養活動編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	void setAdp_Id(String aAdp_Id) { 
		this.adp_Id = aAdp_Id; 
	} 
 
	/** 
 	*	欄位名稱:'留言會員編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	/** 
 	*	欄位名稱:'領養活動留言 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	void setMsg(String aMsg) { 
		this.msg = aMsg; 
	} 
 
	/** 
 	*	欄位名稱:'留言發布日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdpMsgDate(Date aAdpMsgDate) { 
		this.adpMsgDate = aAdpMsgDate; 
	} 
 
	/** 
 	*	欄位名稱:'留言更新日期 | PS: 有更新才會有值'<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdpMsgadp_upDate(Date aAdpMsgadp_upDate) { 
		this.adpMsgadp_upDate = aAdpMsgadp_upDate; 
	} 
 
}
package com.anihome_msg.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:動物之家留言<br>
 *	英文:aniHome_Msg<br>
 */ 
public class AniHome_MsgVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'動物之家留言編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String aniHome_Msg_Id; 
 
	/** 
 	*	欄位名稱:'動物之家編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	private	String aniHome_Id; 
 
	/** 
 	*	欄位名稱:'留言會員編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'動物之家留言 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	private	String aniHome_Msg; 
 
	/** 
 	*	欄位名稱:'留言發布日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	Date adp_start_date; 
 
	/** 
 	*	欄位名稱:'動物之家留言編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getAniHome_Msg_Id() { 
		return this.aniHome_Msg_Id;
	} 
	/** 
 	*	欄位名稱:'動物之家編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	String getAniHome_Id() { 
		return this.aniHome_Id;
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
 	*	欄位名稱:'動物之家留言 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	String getAniHome_Msg() { 
		return this.aniHome_Msg;
	} 
	/** 
 	*	欄位名稱:'留言發布日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	Date getAdp_start_date() { 
		return this.adp_start_date;
	} 
	/** 
 	*	欄位名稱:'動物之家留言編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setAniHome_Msg_Id(String aAniHome_Msg_Id) { 
		this.aniHome_Msg_Id = aAniHome_Msg_Id; 
	} 
 
	/** 
 	*	欄位名稱:'動物之家編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	void setAniHome_Id(String aAniHome_Id) { 
		this.aniHome_Id = aAniHome_Id; 
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
 	*	欄位名稱:'動物之家留言 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	void setAniHome_Msg(String aAniHome_Msg) { 
		this.aniHome_Msg = aAniHome_Msg; 
	} 
 
	/** 
 	*	欄位名稱:'留言發布日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setAdp_start_date(Date aAdp_start_date) { 
		this.adp_start_date = aAdp_start_date; 
	} 
 
}
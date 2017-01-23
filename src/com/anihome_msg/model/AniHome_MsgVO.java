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
	private	String aniHome_Msg_Id; 
	private	String aniHome_Id; 
	private	String mem_Id; 
	private	String aniHome_Msg; 
	private	Date adp_start_date; 
	public	String getAniHome_Msg_Id() { 
		return this.aniHome_Msg_Id;
	} 
	public	String getAniHome_Id() { 
		return this.aniHome_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	String getAniHome_Msg() { 
		return this.aniHome_Msg;
	} 
	public	Date getAdp_start_date() { 
		return this.adp_start_date;
	} 
	public	void setAniHome_Msg_Id(String aAniHome_Msg_Id) { 
		this.aniHome_Msg_Id = aAniHome_Msg_Id; 
	} 
 
	public	void setAniHome_Id(String aAniHome_Id) { 
		this.aniHome_Id = aAniHome_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setAniHome_Msg(String aAniHome_Msg) { 
		this.aniHome_Msg = aAniHome_Msg; 
	} 
 
	public	void setAdp_start_date(Date aAdp_start_date) { 
		this.adp_start_date = aAdp_start_date; 
	} 
 
}
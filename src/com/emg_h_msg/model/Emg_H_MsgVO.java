package com.emg_h_msg.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:緊急求救留言<br>
 *	英文:emg_H_Msg<br>
 */ 
public class Emg_H_MsgVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String emg_H_Msg_Id; 
	private	String mem_Id; 
	private	String emg_H_Id; 
	private	Date emg_H_Msg_start; 
	private	String emg_H_Msg_content; 
	public	String getEmg_H_Msg_Id() { 
		return this.emg_H_Msg_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	String getEmg_H_Id() { 
		return this.emg_H_Id;
	} 
	public	Date getEmg_H_Msg_start() { 
		return this.emg_H_Msg_start;
	} 
	public	String getEmg_H_Msg_content() { 
		return this.emg_H_Msg_content;
	} 
	public	void setEmg_H_Msg_Id(String aEmg_H_Msg_Id) { 
		this.emg_H_Msg_Id = aEmg_H_Msg_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setEmg_H_Id(String aEmg_H_Id) { 
		this.emg_H_Id = aEmg_H_Id; 
	} 
 
	public	void setEmg_H_Msg_start(Date aEmg_H_Msg_start) { 
		this.emg_H_Msg_start = aEmg_H_Msg_start; 
	} 
 
	public	void setEmg_H_Msg_content(String aEmg_H_Msg_content) { 
		this.emg_H_Msg_content = aEmg_H_Msg_content; 
	} 
 
}
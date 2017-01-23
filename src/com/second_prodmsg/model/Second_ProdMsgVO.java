package com.second_prodmsg.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class Second_ProdMsgVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String second_ProdMsg_Id; 
	private	String second_Prod_Id; 
	private	String mem_Id; 
	private	String second_ProdMsg_Msg; 
	private	Date second_ProdMsg_DATE; 
	private	Date second_ProdMsg_adp_upDate; 
	public	String getSecond_ProdMsg_Id() { 
		return this.second_ProdMsg_Id;
	} 
	public	String getSecond_Prod_Id() { 
		return this.second_Prod_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	String getSecond_ProdMsg_Msg() { 
		return this.second_ProdMsg_Msg;
	} 
	public	Date getSecond_ProdMsg_DATE() { 
		return this.second_ProdMsg_DATE;
	} 
	public	Date getSecond_ProdMsg_adp_upDate() { 
		return this.second_ProdMsg_adp_upDate;
	} 
	public	void setSecond_ProdMsg_Id(String aSecond_ProdMsg_Id) { 
		this.second_ProdMsg_Id = aSecond_ProdMsg_Id; 
	} 
 
	public	void setSecond_Prod_Id(String aSecond_Prod_Id) { 
		this.second_Prod_Id = aSecond_Prod_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setSecond_ProdMsg_Msg(String aSecond_ProdMsg_Msg) { 
		this.second_ProdMsg_Msg = aSecond_ProdMsg_Msg; 
	} 
 
	public	void setSecond_ProdMsg_DATE(Date aSecond_ProdMsg_DATE) { 
		this.second_ProdMsg_DATE = aSecond_ProdMsg_DATE; 
	} 
 
	public	void setSecond_ProdMsg_adp_upDate(Date aSecond_ProdMsg_adp_upDate) { 
		this.second_ProdMsg_adp_upDate = aSecond_ProdMsg_adp_upDate; 
	} 
 
}
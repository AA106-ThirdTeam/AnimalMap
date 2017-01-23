package com.shop_comment.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class Shop_commentVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String shopComm_Id; 
	private	String shopComm_MemId; 
	private	String shopComm_ShopId; 
	private	String shopComm_content; 
	private	Date shopComm_SendTime; 
	public	String getShopComm_Id() { 
		return this.shopComm_Id;
	} 
	public	String getShopComm_MemId() { 
		return this.shopComm_MemId;
	} 
	public	String getShopComm_ShopId() { 
		return this.shopComm_ShopId;
	} 
	public	String getShopComm_content() { 
		return this.shopComm_content;
	} 
	public	Date getShopComm_SendTime() { 
		return this.shopComm_SendTime;
	} 
	public	void setShopComm_Id(String aShopComm_Id) { 
		this.shopComm_Id = aShopComm_Id; 
	} 
 
	public	void setShopComm_MemId(String aShopComm_MemId) { 
		this.shopComm_MemId = aShopComm_MemId; 
	} 
 
	public	void setShopComm_ShopId(String aShopComm_ShopId) { 
		this.shopComm_ShopId = aShopComm_ShopId; 
	} 
 
	public	void setShopComm_content(String aShopComm_content) { 
		this.shopComm_content = aShopComm_content; 
	} 
 
	public	void setShopComm_SendTime(Date aShopComm_SendTime) { 
		this.shopComm_SendTime = aShopComm_SendTime; 
	} 
 
}
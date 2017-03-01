package com.shopComm.model;

import java.sql.Date;

public class ShopCommVO {

	private String shopComment_Id;
	private String shopComment_MemId ;
	private String shopComment_ShopId ;
	private String shopComment_content;
	private Date shopComment_SendTime ;
	
	
	public String getShopComment_Id() {
		return shopComment_Id;
	}
	public String getShopComment_MemId() {
		return shopComment_MemId;
	}
	public String getShopComment_ShopId() {
		return shopComment_ShopId;
	}
	public String getShopComment_content() {
		return shopComment_content;
	}
	public Date getShopComment_SendTime() {
		return shopComment_SendTime;
	}
	public void setShopComment_Id(String shopComment_Id) {
		this.shopComment_Id = shopComment_Id;
	}
	public void setShopComment_MemId(String shopComment_MemId) {
		this.shopComment_MemId = shopComment_MemId;
	}
	public void setShopComment_ShopId(String shopComment_ShopId) {
		this.shopComment_ShopId = shopComment_ShopId;
	}
	public void setShopComment_content(String shopComment_content) {
		this.shopComment_content = shopComment_content;
	}
	public void setShopComment_SendTime(Date shopComment_SendTime) {
		this.shopComment_SendTime = shopComment_SendTime;
	}
		
	
}

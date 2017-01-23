package com.shopphoto.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class ShopPhotoVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String shopPhoto_Id; 
	private	String shopPhoto_ShopId; 
	private	byte[] shopPhoto_photo; 
	private	String isDisp_shopPhoto; 
	private	String shopPhoto_name; 
	private	String shopPhoto_extent; 
	public	String getShopPhoto_Id() { 
		return this.shopPhoto_Id;
	} 
	public	String getShopPhoto_ShopId() { 
		return this.shopPhoto_ShopId;
	} 
	public	byte[] getShopPhoto_photo() { 
		return this.shopPhoto_photo;
	} 
	public	String getIsDisp_shopPhoto() { 
		return this.isDisp_shopPhoto;
	} 
	public	String getShopPhoto_name() { 
		return this.shopPhoto_name;
	} 
	public	String getShopPhoto_extent() { 
		return this.shopPhoto_extent;
	} 
	public	void setShopPhoto_Id(String aShopPhoto_Id) { 
		this.shopPhoto_Id = aShopPhoto_Id; 
	} 
 
	public	void setShopPhoto_ShopId(String aShopPhoto_ShopId) { 
		this.shopPhoto_ShopId = aShopPhoto_ShopId; 
	} 
 
	public	void setShopPhoto_photo(byte[] aShopPhoto_photo) { 
		this.shopPhoto_photo = aShopPhoto_photo; 
	} 
 
	public	void setIsDisp_shopPhoto(String aIsDisp_shopPhoto) { 
		this.isDisp_shopPhoto = aIsDisp_shopPhoto; 
	} 
 
	public	void setShopPhoto_name(String aShopPhoto_name) { 
		this.shopPhoto_name = aShopPhoto_name; 
	} 
 
	public	void setShopPhoto_extent(String aShopPhoto_extent) { 
		this.shopPhoto_extent = aShopPhoto_extent; 
	} 
 
}
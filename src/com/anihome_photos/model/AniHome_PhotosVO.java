package com.anihome_photos.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:動物之家相簿<br>
 *	英文:aniHome_Photos<br>
 */ 
public class AniHome_PhotosVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String aniHome_Photos_Id; 
	private	String aniHome_Id; 
	private	byte[] aniHome_Photos_pic; 
	public	String getAniHome_Photos_Id() { 
		return this.aniHome_Photos_Id;
	} 
	public	String getAniHome_Id() { 
		return this.aniHome_Id;
	} 
	public	byte[] getAniHome_Photos_pic() { 
		return this.aniHome_Photos_pic;
	} 
	public	void setAniHome_Photos_Id(String aAniHome_Photos_Id) { 
		this.aniHome_Photos_Id = aAniHome_Photos_Id; 
	} 
 
	public	void setAniHome_Id(String aAniHome_Id) { 
		this.aniHome_Id = aAniHome_Id; 
	} 
 
	public	void setAniHome_Photos_pic(byte[] aAniHome_Photos_pic) { 
		this.aniHome_Photos_pic = aAniHome_Photos_pic; 
	} 
 
}
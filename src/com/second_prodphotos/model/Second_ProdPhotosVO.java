package com.second_prodphotos.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class Second_ProdPhotosVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String second_ProdPhotos_Id; 
	private	String second_Prod_Id; 
	public	String getSecond_ProdPhotos_Id() { 
		return this.second_ProdPhotos_Id;
	} 
	public	String getSecond_Prod_Id() { 
		return this.second_Prod_Id;
	} 
	public	void setSecond_ProdPhotos_Id(String aSecond_ProdPhotos_Id) { 
		this.second_ProdPhotos_Id = aSecond_ProdPhotos_Id; 
	} 
 
	public	void setSecond_Prod_Id(String aSecond_Prod_Id) { 
		this.second_Prod_Id = aSecond_Prod_Id; 
	} 
 
}
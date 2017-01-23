package com.adpphotos.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class AdpPhotosVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String adpPhotos_Id; 
	private	String adp_Id; 
	private	byte[] adpPhotosPic; 
	public	String getAdpPhotos_Id() { 
		return this.adpPhotos_Id;
	} 
	public	String getAdp_Id() { 
		return this.adp_Id;
	} 
	public	byte[] getAdpPhotosPic() { 
		return this.adpPhotosPic;
	} 
	public	void setAdpPhotos_Id(String aAdpPhotos_Id) { 
		this.adpPhotos_Id = aAdpPhotos_Id; 
	} 
 
	public	void setAdp_Id(String aAdp_Id) { 
		this.adp_Id = aAdp_Id; 
	} 
 
	public	void setAdpPhotosPic(byte[] aAdpPhotosPic) { 
		this.adpPhotosPic = aAdpPhotosPic; 
	} 
 
}
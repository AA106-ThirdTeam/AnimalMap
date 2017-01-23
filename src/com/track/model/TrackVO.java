package com.track.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

public class TrackVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String track_Id; 
	private	String mem_Id; 
	private	String track_record_class; 
	private	String track_record_class_Id; 
	public	String getTrack_Id() { 
		return this.track_Id;
	} 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	public	String getTrack_record_class() { 
		return this.track_record_class;
	} 
	public	String getTrack_record_class_Id() { 
		return this.track_record_class_Id;
	} 
	public	void setTrack_Id(String aTrack_Id) { 
		this.track_Id = aTrack_Id; 
	} 
 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	public	void setTrack_record_class(String aTrack_record_class) { 
		this.track_record_class = aTrack_record_class; 
	} 
 
	public	void setTrack_record_class_Id(String aTrack_record_class_Id) { 
		this.track_record_class_Id = aTrack_record_class_Id; 
	} 
 
}
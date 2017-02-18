package com.grp.model;

import java.sql.Date;
import java.sql.Timestamp;

public class GrpVO {

	private String grp_Id;
	private String grp_MemId ;
	private String grp_name ;
	private String grp_city;
	private String grp_town ;
	private String grp_road ;
	private Timestamp grp_EndTime;
	private Timestamp grp_StartTime;
	private Date grp_CreateTime;
	private String grp_Desc;
	private Double grp_Long;
	private Double grp_Lat;
	private String grp_visible;
	private byte[] grp_photo;
	public String getGrp_Id() {
		return grp_Id;
	}
	public String getGrp_MemId() {
		return grp_MemId;
	}
	public String getGrp_name() {
		return grp_name;
	}
	public String getGrp_city() {
		return grp_city;
	}
	public String getGrp_town() {
		return grp_town;
	}
	public String getGrp_road() {
		return grp_road;
	}
	public Timestamp getGrp_EndTime() {
		return grp_EndTime;
	}
	public Timestamp getGrp_StartTime() {
		return grp_StartTime;
	}
	public Date getGrp_CreateTime() {
		return grp_CreateTime;
	}
	public String getGrp_Desc() {
		return grp_Desc;
	}
	public Double getGrp_Long() {
		return grp_Long;
	}
	public Double getGrp_Lat() {
		return grp_Lat;
	}
	public String getGrp_visible() {
		return grp_visible;
	}
	public byte[] getGrp_photo() {
		return grp_photo;
	}
	public void setGrp_Id(String grp_Id) {
		this.grp_Id = grp_Id;
	}
	public void setGrp_MemId(String grp_MemId) {
		this.grp_MemId = grp_MemId;
	}
	public void setGrp_name(String grp_name) {
		this.grp_name = grp_name;
	}
	public void setGrp_city(String grp_city) {
		this.grp_city = grp_city;
	}
	public void setGrp_town(String grp_town) {
		this.grp_town = grp_town;
	}
	public void setGrp_road(String grp_road) {
		this.grp_road = grp_road;
	}
	public void setGrp_EndTime(Timestamp grp_EndTime) {
		this.grp_EndTime = grp_EndTime;
	}
	public void setGrp_StartTime(Timestamp grp_StartTime) {
		this.grp_StartTime = grp_StartTime;
	}
	public void setGrp_CreateTime(Date grp_CreateTime) {
		this.grp_CreateTime = grp_CreateTime;
	}
	public void setGrp_Desc(String grp_Desc) {
		this.grp_Desc = grp_Desc;
	}
	public void setGrp_Long(Double grp_Long) {
		this.grp_Long = grp_Long;
	}
	public void setGrp_Lat(Double grp_Lat) {
		this.grp_Lat = grp_Lat;
	}
	public void setGrp_visible(String grp_visible) {
		this.grp_visible = grp_visible;
	}
	public void setGrp_photo(byte[] grp_photo) {
		this.grp_photo = grp_photo;
	}
	
	
}

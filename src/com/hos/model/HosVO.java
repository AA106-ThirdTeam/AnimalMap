package com.hos.model;

import java.sql.*;

public class HosVO {

	private String hos_Id;
	private String hos_MemId ;
	private String hos_name ;
	private String hos_city;
	private String hos_town ;
	private String hos_road ;
	private String hos_EndTime;
	private String hos_StartTime;
	private Date hos_CreateTime;
	private String hos_Desc;
	private Double hos_Long;
	private Double hos_Lat;
	private String hos_visible;
	private Integer hos_Eval = 0;
	private String hos_URL;
	private String hos_Tel;
	
	
	public String getHos_Id() {
		return hos_Id;
	}
	public String getHos_MemId() {
		return hos_MemId;
	}
	public String getHos_name() {
		return hos_name;
	}
	public String getHos_city() {
		return hos_city;
	}
	public String getHos_town() {
		return hos_town;
	}
	public String getHos_road() {
		return hos_road;
	}
	public String getHos_EndTime() {
		return hos_EndTime;
	}
	public String getHos_StartTime() {
		return hos_StartTime;
	}
	public Date getHos_CreateTime() {
		return hos_CreateTime;
	}
	public String getHos_Desc() {
		return hos_Desc;
	}
	public Double getHos_Long() {
		return hos_Long;
	}
	public Double getHos_Lat() {
		return hos_Lat;
	}
	public String getHos_visible() {
		return hos_visible;
	}
	public Integer getHos_Eval() {
		return hos_Eval;
	}
	public String getHos_URL() {
		return hos_URL;
	}
	public String getHos_Tel() {
		return hos_Tel;
	}
	public void setHos_Id(String hos_Id) {
		this.hos_Id = hos_Id;
	}
	public void setHos_MemId(String hos_MemId) {
		this.hos_MemId = hos_MemId;
	}
	public void setHos_name(String hos_name) {
		this.hos_name = hos_name;
	}
	public void setHos_city(String hos_city) {
		this.hos_city = hos_city;
	}
	public void setHos_town(String hos_town) {
		this.hos_town = hos_town;
	}
	public void setHos_road(String hos_road) {
		this.hos_road = hos_road;
	}
	public void setHos_EndTime(String hos_EndTime) {
		this.hos_EndTime = hos_EndTime;
	}
	public void setHos_StartTime(String hos_StartTime) {
		this.hos_StartTime = hos_StartTime;
	}
	public void setHos_CreateTime(Date hos_CreateTime) {
		this.hos_CreateTime = hos_CreateTime;
	}
	public void setHos_Desc(String hos_Desc) {
		this.hos_Desc = hos_Desc;
	}
	public void setHos_Long(Double hos_Long) {
		this.hos_Long = hos_Long;
	}
	public void setHos_Lat(Double hos_Lat) {
		this.hos_Lat = hos_Lat;
	}
	public void setHos_visible(String hos_visible) {
		this.hos_visible = hos_visible;
	}
	public void setHos_Eval(Integer hos_Eval) {
		this.hos_Eval = hos_Eval;
	}
	public void setHos_URL(String hos_URL) {
		this.hos_URL = hos_URL;
	}
	public void setHos_Tel(String hos_Tel) {
		this.hos_Tel = hos_Tel;
	}
	
	public boolean equals(Object obj) throws ClassCastException{
		HosVO e = (HosVO)obj;
		return hos_Id.equals(e.hos_Id);
	}
	
	public int hashCode(){
		return hos_Id.hashCode();
	}
	
	
	
}

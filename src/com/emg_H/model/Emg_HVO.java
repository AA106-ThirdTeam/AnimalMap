package com.emg_H.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Emg_HVO implements java.io.Serializable{
	
	private String emg_H_Id;
	private String mem_Id;
	private Timestamp emg_H_start_date;
	private Timestamp emg_H_end_date;
	private String emg_H_title;
	private String emg_H_content;
	private byte[] emg_H_pic;
	private String emg_H_pic_fomat;
	private String emg_H_city;
	private String emg_H_town;
	private String emg_H_road;
	private Double emg_H_Lon;
	private Double emg_H_Lat;
	private String emg_H_status;
	
	
	public String getEmg_H_status() {
		return emg_H_status;
	}
	public void setEmg_H_status(String emg_H_status) {
		this.emg_H_status = emg_H_status;
	}
	public String getEmg_H_Id() {
		return emg_H_Id;
	}
	public void setEmg_H_Id(String emg_H_Id) {
		this.emg_H_Id = emg_H_Id;
	}
	public String getMem_Id() {
		return mem_Id;
	}
	public void setMem_Id(String mem_Id) {
		this.mem_Id = mem_Id;
	}
	public Timestamp getEmg_H_start_date() {
		return emg_H_start_date;
	}
	public void setEmg_H_start_date(Timestamp emg_H_start_date) {
		this.emg_H_start_date = emg_H_start_date;
	}
	public Timestamp getEmg_H_end_date() {
		return emg_H_end_date;
	}
	public void setEmg_H_end_date(Timestamp emg_H_end_date) {
		this.emg_H_end_date = emg_H_end_date;
	}
	public String getEmg_H_title() {
		return emg_H_title;
	}
	public void setEmg_H_title(String emg_H_title) {
		this.emg_H_title = emg_H_title;
	}
	public String getEmg_H_content() {
		return emg_H_content;
	}
	public void setEmg_H_content(String emg_H_content) {
		this.emg_H_content = emg_H_content;
	}
	public byte[] getEmg_H_pic() {
		return emg_H_pic;
	}
	public void setEmg_H_pic(byte[] emg_H_pic) {
		this.emg_H_pic = emg_H_pic;
	}
	public String getEmg_H_pic_fomat() {
		return emg_H_pic_fomat;
	}
	public void setEmg_H_pic_fomat(String emg_H_pic_fomat) {
		this.emg_H_pic_fomat = emg_H_pic_fomat;
	}
	public String getEmg_H_city() {
		return emg_H_city;
	}
	public void setEmg_H_city(String emg_H_city) {
		this.emg_H_city = emg_H_city;
	}
	public String getEmg_H_town() {
		return emg_H_town;
	}
	public void setEmg_H_town(String emg_H_town) {
		this.emg_H_town = emg_H_town;
	}
	public String getEmg_H_road() {
		return emg_H_road;
	}
	public void setEmg_H_road(String emg_H_road) {
		this.emg_H_road = emg_H_road;
	}
	public Double getEmg_H_Lon() {
		return emg_H_Lon;
	}
	public void setEmg_H_Lon(Double emg_H_Lon) {
		this.emg_H_Lon = emg_H_Lon;
	}
	public Double getEmg_H_Lat() {
		return emg_H_Lat;
	}
	public void setEmg_H_Lat(Double emg_H_Lat) {
		this.emg_H_Lat = emg_H_Lat;
	}
	
		
}

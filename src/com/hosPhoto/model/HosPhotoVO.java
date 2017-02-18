package com.hosPhoto.model;

import java.sql.Date;

public class HosPhotoVO {

	
	
	private String hosPhoto_Id;
	private String hosPhoto_HosId;
	private byte[] hosPhoto_photo;
	private String isDisp_HosPhoto;
	private String hosPhoto_name = "hosPhoto";
	private String hosPhoto_extention = ".jpg";
	
	public String getHosPhoto_Id() {
		return hosPhoto_Id;
	}
	public String getHosPhoto_HosId() {
		return hosPhoto_HosId;
	}
	public byte[] getHosPhoto_photo() {
		return hosPhoto_photo;
	}
	public String getIsDisp_HosPhoto() {
		return isDisp_HosPhoto;
	}
	public String getHosPhoto_name() {
		return hosPhoto_name;
	}
	public String getHosPhoto_extention() {
		return hosPhoto_extention;
	}
	public void setHosPhoto_Id(String hosPhoto_Id) {
		this.hosPhoto_Id = hosPhoto_Id;
	}
	public void setHosPhoto_HosId(String hosPhoto_HosId) {
		this.hosPhoto_HosId = hosPhoto_HosId;
	}
	public void setHosPhoto_photo(byte[] hosPhoto_photo) {
		this.hosPhoto_photo = hosPhoto_photo;
	}
	public void setIsDisp_HosPhoto(String isDisp_HosPhoto) {
		this.isDisp_HosPhoto = isDisp_HosPhoto;
	}
	public void setHosPhoto_name(String hosPhoto_name) {
		this.hosPhoto_name = hosPhoto_name;
	}
	public void setHosPhoto_extention(String hosPhoto_extention) {
		this.hosPhoto_extention = hosPhoto_extention;
	}
	
	
	
}

package com.park.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	公園<br>
 *	英文:park<br>
 */ 
public class ParkVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'公園編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String park_Id; 
 
	/** 
 	*	欄位名稱:'員工編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	private	String emp_Id; 
 
	/** 
 	*	欄位名稱:'公園標題 | PS: 標題上限字數-30個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:90<br>
	*	限制條件:<br>
 	*/ 
	private	String park_title; 
 
	/** 
 	*	欄位名稱:'公園內容 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	private	String park_content; 
 
	/** 
 	*	欄位名稱:'公園照片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	byte[] park_pic; 
 
	/** 
 	*	欄位名稱:'公園發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date adp_start_date; 
 
	/** 
 	*	欄位名稱:'公園更新時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date adp_upDate; 
 
	/** 
 	*	欄位名稱:'縣市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	private	String adp_city; 
 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	private	String park_town; 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	private	String park_road; 
 
	/** 
 	*	欄位名稱:'公園經度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double park_lon; 
 
	/** 
 	*	欄位名稱:'緯度座標緯度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double park_lat; 
 
	/** 
 	*	欄位名稱:'公園編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getPark_Id() { 
		return this.park_Id;
	} 
	/** 
 	*	欄位名稱:'員工編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	String getEmp_Id() { 
		return this.emp_Id;
	} 
	/** 
 	*	欄位名稱:'公園標題 | PS: 標題上限字數-30個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:90<br>
	*	限制條件:<br>
 	*/ 
	public	String getPark_title() { 
		return this.park_title;
	} 
	/** 
 	*	欄位名稱:'公園內容 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	String getPark_content() { 
		return this.park_content;
	} 
	/** 
 	*	欄位名稱:'公園照片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	byte[] getPark_pic() { 
		return this.park_pic;
	} 
	/** 
 	*	欄位名稱:'公園發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getAdp_start_date() { 
		return this.adp_start_date;
	} 
	/** 
 	*	欄位名稱:'公園更新時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getAdp_upDate() { 
		return this.adp_upDate;
	} 
	/** 
 	*	欄位名稱:'縣市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	public	String getAdp_city() { 
		return this.adp_city;
	} 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	public	String getPark_town() { 
		return this.park_town;
	} 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	String getPark_road() { 
		return this.park_road;
	} 
	/** 
 	*	欄位名稱:'公園經度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getPark_lon() { 
		return this.park_lon;
	} 
	/** 
 	*	欄位名稱:'緯度座標緯度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getPark_lat() { 
		return this.park_lat;
	} 
	/** 
 	*	欄位名稱:'公園編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setPark_Id(String aPark_Id) { 
		this.park_Id = aPark_Id; 
	} 
 
	/** 
 	*	欄位名稱:'員工編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	void setEmp_Id(String aEmp_Id) { 
		this.emp_Id = aEmp_Id; 
	} 
 
	/** 
 	*	欄位名稱:'公園標題 | PS: 標題上限字數-30個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:90<br>
	*	限制條件:<br>
 	*/ 
	public	void setPark_title(String aPark_title) { 
		this.park_title = aPark_title; 
	} 
 
	/** 
 	*	欄位名稱:'公園內容 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	void setPark_content(String aPark_content) { 
		this.park_content = aPark_content; 
	} 
 
	/** 
 	*	欄位名稱:'公園照片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setPark_pic(byte[] aPark_pic) { 
		this.park_pic = aPark_pic; 
	} 
 
	/** 
 	*	欄位名稱:'公園發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdp_start_date(Date aAdp_start_date) { 
		this.adp_start_date = aAdp_start_date; 
	} 
 
	/** 
 	*	欄位名稱:'公園更新時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdp_upDate(Date aAdp_upDate) { 
		this.adp_upDate = aAdp_upDate; 
	} 
 
	/** 
 	*	欄位名稱:'縣市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdp_city(String aAdp_city) { 
		this.adp_city = aAdp_city; 
	} 
 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	public	void setPark_town(String aPark_town) { 
		this.park_town = aPark_town; 
	} 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	void setPark_road(String aPark_road) { 
		this.park_road = aPark_road; 
	} 
 
	/** 
 	*	欄位名稱:'公園經度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setPark_lon(Double aPark_lon) { 
		this.park_lon = aPark_lon; 
	} 
 
	/** 
 	*	欄位名稱:'緯度座標緯度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setPark_lat(Double aPark_lat) { 
		this.park_lat = aPark_lat; 
	} 
 
}
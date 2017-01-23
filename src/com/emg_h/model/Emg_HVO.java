package com.emg_h.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:緊急求救<br>
 *	英文:emg_H<br>
 */ 
public class Emg_HVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'求救編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String emg_H_Id; 
 
	/** 
 	*	欄位名稱:'發起人編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'開始時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date emg_H_start_date; 
 
	/** 
 	*	欄位名稱:'結束日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date emg_H_end_date; 
 
	/** 
 	*	欄位名稱:'求救標題 | PS: 標題上限字數-30個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:90<br>
	*	限制條件:<br>
 	*/ 
	private	String emg_H_title; 
 
	/** 
 	*	欄位名稱:'求救內容 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	private	String emg_H_content; 
 
	/** 
 	*	欄位名稱:'照片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	byte[] emg_H_Pic; 
 
	/** 
 	*	欄位名稱:'照片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:10<br>
	*	限制條件:<br>
 	*/ 
	private	String emg_H_Pic_format; 
 
	/** 
 	*	欄位名稱:'縣市 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	private	String emg_H_city; 
 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	private	String emg_H_town; 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	private	String emg_H_road; 
 
	/** 
 	*	欄位名稱:'緊急求救經度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double emg_H_Lon; 
 
	/** 
 	*	欄位名稱:'緊急求救緯度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double emg_H_Lat; 
 
	/** 
 	*	欄位名稱:'求救編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getEmg_H_Id() { 
		return this.emg_H_Id;
	} 
	/** 
 	*	欄位名稱:'發起人編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	/** 
 	*	欄位名稱:'開始時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getEmg_H_start_date() { 
		return this.emg_H_start_date;
	} 
	/** 
 	*	欄位名稱:'結束日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getEmg_H_end_date() { 
		return this.emg_H_end_date;
	} 
	/** 
 	*	欄位名稱:'求救標題 | PS: 標題上限字數-30個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:90<br>
	*	限制條件:<br>
 	*/ 
	public	String getEmg_H_title() { 
		return this.emg_H_title;
	} 
	/** 
 	*	欄位名稱:'求救內容 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	String getEmg_H_content() { 
		return this.emg_H_content;
	} 
	/** 
 	*	欄位名稱:'照片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	byte[] getEmg_H_Pic() { 
		return this.emg_H_Pic;
	} 
	/** 
 	*	欄位名稱:'照片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:10<br>
	*	限制條件:<br>
 	*/ 
	public	String getEmg_H_Pic_format() { 
		return this.emg_H_Pic_format;
	} 
	/** 
 	*	欄位名稱:'縣市 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	String getEmg_H_city() { 
		return this.emg_H_city;
	} 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	String getEmg_H_town() { 
		return this.emg_H_town;
	} 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	String getEmg_H_road() { 
		return this.emg_H_road;
	} 
	/** 
 	*	欄位名稱:'緊急求救經度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getEmg_H_Lon() { 
		return this.emg_H_Lon;
	} 
	/** 
 	*	欄位名稱:'緊急求救緯度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getEmg_H_Lat() { 
		return this.emg_H_Lat;
	} 
	/** 
 	*	欄位名稱:'求救編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setEmg_H_Id(String aEmg_H_Id) { 
		this.emg_H_Id = aEmg_H_Id; 
	} 
 
	/** 
 	*	欄位名稱:'發起人編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	/** 
 	*	欄位名稱:'開始時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setEmg_H_start_date(Date aEmg_H_start_date) { 
		this.emg_H_start_date = aEmg_H_start_date; 
	} 
 
	/** 
 	*	欄位名稱:'結束日期 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setEmg_H_end_date(Date aEmg_H_end_date) { 
		this.emg_H_end_date = aEmg_H_end_date; 
	} 
 
	/** 
 	*	欄位名稱:'求救標題 | PS: 標題上限字數-30個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:90<br>
	*	限制條件:<br>
 	*/ 
	public	void setEmg_H_title(String aEmg_H_title) { 
		this.emg_H_title = aEmg_H_title; 
	} 
 
	/** 
 	*	欄位名稱:'求救內容 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	void setEmg_H_content(String aEmg_H_content) { 
		this.emg_H_content = aEmg_H_content; 
	} 
 
	/** 
 	*	欄位名稱:'照片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setEmg_H_Pic(byte[] aEmg_H_Pic) { 
		this.emg_H_Pic = aEmg_H_Pic; 
	} 
 
	/** 
 	*	欄位名稱:'照片副檔名 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:10<br>
	*	限制條件:<br>
 	*/ 
	public	void setEmg_H_Pic_format(String aEmg_H_Pic_format) { 
		this.emg_H_Pic_format = aEmg_H_Pic_format; 
	} 
 
	/** 
 	*	欄位名稱:'縣市 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	void setEmg_H_city(String aEmg_H_city) { 
		this.emg_H_city = aEmg_H_city; 
	} 
 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:20<br>
	*	限制條件:<br>
 	*/ 
	public	void setEmg_H_town(String aEmg_H_town) { 
		this.emg_H_town = aEmg_H_town; 
	} 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	void setEmg_H_road(String aEmg_H_road) { 
		this.emg_H_road = aEmg_H_road; 
	} 
 
	/** 
 	*	欄位名稱:'緊急求救經度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setEmg_H_Lon(Double aEmg_H_Lon) { 
		this.emg_H_Lon = aEmg_H_Lon; 
	} 
 
	/** 
 	*	欄位名稱:'緊急求救緯度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setEmg_H_Lat(Double aEmg_H_Lat) { 
		this.emg_H_Lat = aEmg_H_Lat; 
	} 
 
}
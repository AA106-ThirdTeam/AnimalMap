package com.adp.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	領養活動<br>
 *	英文:adp<br>
 */ 
public class AdpVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'領養活動編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String adp_Id; 
 
	/** 
 	*	欄位名稱:'發布會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'領養活動標題 | PS: 標題上限字數-30個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:90<br>
	*	限制條件:<br>
 	*/ 
	private	String adp_title; 
 
	/** 
 	*	欄位名稱:'領養活動內容 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	private	String adp_adp_content; 
 
	/** 
 	*	欄位名稱:'領養活動發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date adp_start_date; 
 
	/** 
 	*	欄位名稱:'領養活動到期時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date adp_end_date; 
 
	/** 
 	*	欄位名稱:'領養活動更新時間 | PS: '<br>
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
	private	String adp_town; 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	private	String adp_road; 
 
	/** 
 	*	欄位名稱:'領養活動經度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double adp_lon; 
 
	/** 
 	*	欄位名稱:'緯度座標緯度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double adp_lat; 
 
	/** 
 	*	欄位名稱:'領養活動編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getAdp_Id() { 
		return this.adp_Id;
	} 
	/** 
 	*	欄位名稱:'發布會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	/** 
 	*	欄位名稱:'領養活動標題 | PS: 標題上限字數-30個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:90<br>
	*	限制條件:<br>
 	*/ 
	public	String getAdp_title() { 
		return this.adp_title;
	} 
	/** 
 	*	欄位名稱:'領養活動內容 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	String getAdp_adp_content() { 
		return this.adp_adp_content;
	} 
	/** 
 	*	欄位名稱:'領養活動發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getAdp_start_date() { 
		return this.adp_start_date;
	} 
	/** 
 	*	欄位名稱:'領養活動到期時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getAdp_end_date() { 
		return this.adp_end_date;
	} 
	/** 
 	*	欄位名稱:'領養活動更新時間 | PS: '<br>
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
	public	String getAdp_town() { 
		return this.adp_town;
	} 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	String getAdp_road() { 
		return this.adp_road;
	} 
	/** 
 	*	欄位名稱:'領養活動經度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getAdp_lon() { 
		return this.adp_lon;
	} 
	/** 
 	*	欄位名稱:'緯度座標緯度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getAdp_lat() { 
		return this.adp_lat;
	} 
	/** 
 	*	欄位名稱:'領養活動編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setAdp_Id(String aAdp_Id) { 
		this.adp_Id = aAdp_Id; 
	} 
 
	/** 
 	*	欄位名稱:'發布會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	/** 
 	*	欄位名稱:'領養活動標題 | PS: 標題上限字數-30個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:90<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdp_title(String aAdp_title) { 
		this.adp_title = aAdp_title; 
	} 
 
	/** 
 	*	欄位名稱:'領養活動內容 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdp_adp_content(String aAdp_adp_content) { 
		this.adp_adp_content = aAdp_adp_content; 
	} 
 
	/** 
 	*	欄位名稱:'領養活動發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdp_start_date(Date aAdp_start_date) { 
		this.adp_start_date = aAdp_start_date; 
	} 
 
	/** 
 	*	欄位名稱:'領養活動到期時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdp_end_date(Date aAdp_end_date) { 
		this.adp_end_date = aAdp_end_date; 
	} 
 
	/** 
 	*	欄位名稱:'領養活動更新時間 | PS: '<br>
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
	public	void setAdp_town(String aAdp_town) { 
		this.adp_town = aAdp_town; 
	} 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdp_road(String aAdp_road) { 
		this.adp_road = aAdp_road; 
	} 
 
	/** 
 	*	欄位名稱:'領養活動經度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdp_lon(Double aAdp_lon) { 
		this.adp_lon = aAdp_lon; 
	} 
 
	/** 
 	*	欄位名稱:'緯度座標緯度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdp_lat(Double aAdp_lat) { 
		this.adp_lat = aAdp_lat; 
	} 
 
}
package com.anihome.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	動物之家<br>
 *	英文:aniHome<br>
 */ 
public class AniHomeVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'動物之家編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String aniHome_Id; 
 
	/** 
 	*	欄位名稱:'會員編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'動物之家標題 | PS: 標題上限字數-30個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:90<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String aniHome_title; 
 
	/** 
 	*	欄位名稱:'動物之家內容 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	String aniHome_content; 
 
	/** 
 	*	欄位名稱:'動物之家發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	private	Date aniHome_start_date; 
 
	/** 
 	*	欄位名稱:'動物之家更新時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date aniHome_upDate; 
 
	/** 
 	*	欄位名稱:'縣市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	private	String aniHome_city; 
 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	private	String aniHome_town; 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	private	String aniHome_road; 
 
	/** 
 	*	欄位名稱:'動物之家經度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double aniHome_lon; 
 
	/** 
 	*	欄位名稱:'緯度座標緯度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double aniHome_lat; 
 
	/** 
 	*	欄位名稱:'動物之家編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getAniHome_Id() { 
		return this.aniHome_Id;
	} 
	/** 
 	*	欄位名稱:'會員編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	String getMem_Id() { 
		return this.mem_Id;
	} 
	/** 
 	*	欄位名稱:'動物之家標題 | PS: 標題上限字數-30個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:90<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getAniHome_title() { 
		return this.aniHome_title;
	} 
	/** 
 	*	欄位名稱:'動物之家內容 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	String getAniHome_content() { 
		return this.aniHome_content;
	} 
	/** 
 	*	欄位名稱:'動物之家發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	Date getAniHome_start_date() { 
		return this.aniHome_start_date;
	} 
	/** 
 	*	欄位名稱:'動物之家更新時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getAniHome_upDate() { 
		return this.aniHome_upDate;
	} 
	/** 
 	*	欄位名稱:'縣市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	public	String getAniHome_city() { 
		return this.aniHome_city;
	} 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	public	String getAniHome_town() { 
		return this.aniHome_town;
	} 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	String getAniHome_road() { 
		return this.aniHome_road;
	} 
	/** 
 	*	欄位名稱:'動物之家經度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getAniHome_lon() { 
		return this.aniHome_lon;
	} 
	/** 
 	*	欄位名稱:'緯度座標緯度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getAniHome_lat() { 
		return this.aniHome_lat;
	} 
	/** 
 	*	欄位名稱:'動物之家編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setAniHome_Id(String aAniHome_Id) { 
		this.aniHome_Id = aAniHome_Id; 
	} 
 
	/** 
 	*	欄位名稱:'會員編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	public	void setMem_Id(String aMem_Id) { 
		this.mem_Id = aMem_Id; 
	} 
 
	/** 
 	*	欄位名稱:'動物之家標題 | PS: 標題上限字數-30個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:90<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setAniHome_title(String aAniHome_title) { 
		this.aniHome_title = aAniHome_title; 
	} 
 
	/** 
 	*	欄位名稱:'動物之家內容 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setAniHome_content(String aAniHome_content) { 
		this.aniHome_content = aAniHome_content; 
	} 
 
	/** 
 	*	欄位名稱:'動物之家發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:NOT NULL<br>
 	*/ 
	public	void setAniHome_start_date(Date aAniHome_start_date) { 
		this.aniHome_start_date = aAniHome_start_date; 
	} 
 
	/** 
 	*	欄位名稱:'動物之家更新時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setAniHome_upDate(Date aAniHome_upDate) { 
		this.aniHome_upDate = aAniHome_upDate; 
	} 
 
	/** 
 	*	欄位名稱:'縣市 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	public	void setAniHome_city(String aAniHome_city) { 
		this.aniHome_city = aAniHome_city; 
	} 
 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	public	void setAniHome_town(String aAniHome_town) { 
		this.aniHome_town = aAniHome_town; 
	} 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	void setAniHome_road(String aAniHome_road) { 
		this.aniHome_road = aAniHome_road; 
	} 
 
	/** 
 	*	欄位名稱:'動物之家經度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setAniHome_lon(Double aAniHome_lon) { 
		this.aniHome_lon = aAniHome_lon; 
	} 
 
	/** 
 	*	欄位名稱:'緯度座標緯度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setAniHome_lat(Double aAniHome_lat) { 
		this.aniHome_lat = aAniHome_lat; 
	} 
 
}
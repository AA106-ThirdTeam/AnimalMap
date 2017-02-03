package com.second_prod.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	二手商品<br>
 *	英文:second_Prod<br>
 */ 
public class Second_ProdVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'二手商品編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String second_Prod_Id; 
 
	/** 
 	*	欄位名稱:'發布會員編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:FK<br>
 	*/ 
	private	String mem_Id; 
 
	/** 
 	*	欄位名稱:'二手商品標題 | PS: 標題上限字數-30個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:90<br>
	*	限制條件:<br>
 	*/ 
	private	String second_Prod_Title; 
 
	/** 
 	*	欄位名稱:'二手商品內容 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	private	String second_Prod_Content; 
 
	/** 
 	*	欄位名稱:'二手商品發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date second_Prod_adp_start_date; 
 
	/** 
 	*	欄位名稱:'二手商品截止時間 | PS: 到期刪除二手商品地圖圖標、資訊'<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date second_Prod_adp_end_date; 
 
	/** 
 	*	欄位名稱:'二手商品更新時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	Date second_Prod_adp_upDate; 
 
	/** 
 	*	欄位名稱:'縣市 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	private	String second_Prod_adp_city; 
 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	private	String second_Prod_Town; 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	private	String second_Prod_Road; 
 
	/** 
 	*	欄位名稱:'二手商品經度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double second_Prod_Lon; 
 
	/** 
 	*	欄位名稱:'緯度座標緯度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	private	Double second_Prod_Lat; 
 
	/** 
 	*	欄位名稱:'二手商品編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getSecond_Prod_Id() { 
		return this.second_Prod_Id;
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
 	*	欄位名稱:'二手商品標題 | PS: 標題上限字數-30個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:90<br>
	*	限制條件:<br>
 	*/ 
	public	String getSecond_Prod_Title() { 
		return this.second_Prod_Title;
	} 
	/** 
 	*	欄位名稱:'二手商品內容 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	String getSecond_Prod_Content() { 
		return this.second_Prod_Content;
	} 
	/** 
 	*	欄位名稱:'二手商品發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getSecond_Prod_adp_start_date() { 
		return this.second_Prod_adp_start_date;
	} 
	/** 
 	*	欄位名稱:'二手商品截止時間 | PS: 到期刪除二手商品地圖圖標、資訊'<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getSecond_Prod_adp_end_date() { 
		return this.second_Prod_adp_end_date;
	} 
	/** 
 	*	欄位名稱:'二手商品更新時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	Date getSecond_Prod_adp_upDate() { 
		return this.second_Prod_adp_upDate;
	} 
	/** 
 	*	欄位名稱:'縣市 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	public	String getSecond_Prod_adp_city() { 
		return this.second_Prod_adp_city;
	} 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	public	String getSecond_Prod_Town() { 
		return this.second_Prod_Town;
	} 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	String getSecond_Prod_Road() { 
		return this.second_Prod_Road;
	} 
	/** 
 	*	欄位名稱:'二手商品經度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getSecond_Prod_Lon() { 
		return this.second_Prod_Lon;
	} 
	/** 
 	*	欄位名稱:'緯度座標緯度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	Double getSecond_Prod_Lat() { 
		return this.second_Prod_Lat;
	} 
	/** 
 	*	欄位名稱:'二手商品編號 | PS: '<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setSecond_Prod_Id(String aSecond_Prod_Id) { 
		this.second_Prod_Id = aSecond_Prod_Id; 
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
 	*	欄位名稱:'二手商品標題 | PS: 標題上限字數-30個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:90<br>
	*	限制條件:<br>
 	*/ 
	public	void setSecond_Prod_Title(String aSecond_Prod_Title) { 
		this.second_Prod_Title = aSecond_Prod_Title; 
	} 
 
	/** 
 	*	欄位名稱:'二手商品內容 | PS: 內容上限字數-1000個中文字'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:3000<br>
	*	限制條件:<br>
 	*/ 
	public	void setSecond_Prod_Content(String aSecond_Prod_Content) { 
		this.second_Prod_Content = aSecond_Prod_Content; 
	} 
 
	/** 
 	*	欄位名稱:'二手商品發布時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setSecond_Prod_adp_start_date(Date aSecond_Prod_adp_start_date) { 
		this.second_Prod_adp_start_date = aSecond_Prod_adp_start_date; 
	} 
 
	/** 
 	*	欄位名稱:'二手商品截止時間 | PS: 到期刪除二手商品地圖圖標、資訊'<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setSecond_Prod_adp_end_date(Date aSecond_Prod_adp_end_date) { 
		this.second_Prod_adp_end_date = aSecond_Prod_adp_end_date; 
	} 
 
	/** 
 	*	欄位名稱:'二手商品更新時間 | PS: '<br>
	*	資料型態:DATE<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setSecond_Prod_adp_upDate(Date aSecond_Prod_adp_upDate) { 
		this.second_Prod_adp_upDate = aSecond_Prod_adp_upDate; 
	} 
 
	/** 
 	*	欄位名稱:'縣市 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	public	void setSecond_Prod_adp_city(String aSecond_Prod_adp_city) { 
		this.second_Prod_adp_city = aSecond_Prod_adp_city; 
	} 
 
	/** 
 	*	欄位名稱:'鄉鎮市區 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:12<br>
	*	限制條件:<br>
 	*/ 
	public	void setSecond_Prod_Town(String aSecond_Prod_Town) { 
		this.second_Prod_Town = aSecond_Prod_Town; 
	} 
 
	/** 
 	*	欄位名稱:'道路街名村里 | PS: 可以為空'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:50<br>
	*	限制條件:<br>
 	*/ 
	public	void setSecond_Prod_Road(String aSecond_Prod_Road) { 
		this.second_Prod_Road = aSecond_Prod_Road; 
	} 
 
	/** 
 	*	欄位名稱:'二手商品經度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setSecond_Prod_Lon(Double aSecond_Prod_Lon) { 
		this.second_Prod_Lon = aSecond_Prod_Lon; 
	} 
 
	/** 
 	*	欄位名稱:'緯度座標緯度座標 | PS: 由住址分析出來，或手機抓GPS取得(有小數點)'<br>
	*	資料型態:NUMBER<br>
	*	欄位長度:9,6<br>
	*	限制條件:<br>
 	*/ 
	public	void setSecond_Prod_Lat(Double aSecond_Prod_Lat) { 
		this.second_Prod_Lat = aSecond_Prod_Lat; 
	} 
 
}
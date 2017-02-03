package com.adpphotos.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	領養活動相簿<br>
 *	英文:adpPhotos<br>
 */ 
public class AdpPhotosVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	/** 
 	*	欄位名稱:'領養活動相簿編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	private	String adpPhotos_Id; 
 
	/** 
 	*	欄位名稱:'領養活動編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:<br>
 	*/ 
	private	String adp_Id; 
 
	/** 
 	*	欄位名稱:'領養活動照片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	private	byte[] adpPhotosPic; 
 
	/** 
 	*	欄位名稱:'領養活動相簿編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	String getAdpPhotos_Id() { 
		return this.adpPhotos_Id;
	} 
	/** 
 	*	欄位名稱:'領養活動編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:<br>
 	*/ 
	public	String getAdp_Id() { 
		return this.adp_Id;
	} 
	/** 
 	*	欄位名稱:'領養活動照片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	byte[] getAdpPhotosPic() { 
		return this.adpPhotosPic;
	} 
	/** 
 	*	欄位名稱:'領養活動相簿編號 | PS: PK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:PK<br>
 	*/ 
	public	void setAdpPhotos_Id(String aAdpPhotos_Id) { 
		this.adpPhotos_Id = aAdpPhotos_Id; 
	} 
 
	/** 
 	*	欄位名稱:'領養活動編號 | PS: FK'<br>
	*	資料型態:VARCHAR2<br>
	*	欄位長度:8<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdp_Id(String aAdp_Id) { 
		this.adp_Id = aAdp_Id; 
	} 
 
	/** 
 	*	欄位名稱:'領養活動照片 | PS: '<br>
	*	資料型態:BLOB<br>
	*	欄位長度:<br>
	*	限制條件:<br>
 	*/ 
	public	void setAdpPhotosPic(byte[] aAdpPhotosPic) { 
		this.adpPhotosPic = aAdpPhotosPic; 
	} 
 
}
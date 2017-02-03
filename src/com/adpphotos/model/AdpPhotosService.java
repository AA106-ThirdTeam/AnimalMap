package com.adpphotos.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:領養活動相簿<br>
 *	英文:adpPhotos<br>
 */ 
public class AdpPhotosService{
	private AdpPhotosDAO_interface dao; 

	public AdpPhotosService(){
		dao = new AdpPhotosDAO();
	}

	//====以下是insert方法====
	public AdpPhotosVO addAdpPhotos(String adp_Id,byte[] adpPhotosPic){
		AdpPhotosVO adpphotosVO = new AdpPhotosVO();

		adpphotosVO.setAdp_Id(adp_Id);
		adpphotosVO.setAdpPhotosPic(adpPhotosPic);

		dao.insert(adpphotosVO);

		return adpphotosVO;
	}

	//====以下是update方法====
	public AdpPhotosVO updateAdpPhotos(String adpPhotos_Id,String adp_Id,byte[] adpPhotosPic){

		AdpPhotosVO adpphotosVO = new AdpPhotosVO();

		adpphotosVO.setAdpPhotos_Id(adpPhotos_Id);
		adpphotosVO.setAdp_Id(adp_Id);
		adpphotosVO.setAdpPhotosPic(adpPhotosPic);

		dao.update(adpphotosVO);

		return adpphotosVO;
	}

	//====以下是delete方法====
	public void deleteAdpPhotos(String  adpPhotos_Id){
		dao.delete(adpPhotos_Id);
	}

	//====以下是getOne方法====
	public AdpPhotosVO getOneAdpPhotos(String  adpPhotos_Id){
		return dao.findByPrimaryKey(adpPhotos_Id);
	}

	//====以下是getAll方法====
	public List<AdpPhotosVO> getAll(){
		return dao.getAll();
	}
}

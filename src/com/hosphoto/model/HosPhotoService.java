package com.hosphoto.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:診所相片<br>
 *	英文:hosPhoto<br>
 */ 
public class HosPhotoService{
	private HosPhotoDAO_interface dao; 

	public HosPhotoService(){
		dao = new HosPhotoDAO();
	}

	//====以下是insert方法====
	public HosPhotoVO addHosPhoto(String hosPhoto_HosId,byte[] hosPhoto_photo,String isDisp_HosPhoto,String hosPhoto_name,String hosPhoto_extent){
		HosPhotoVO hosphotoVO = new HosPhotoVO();

		hosphotoVO.setHosPhoto_HosId(hosPhoto_HosId);
		hosphotoVO.setHosPhoto_photo(hosPhoto_photo);
		hosphotoVO.setIsDisp_HosPhoto(isDisp_HosPhoto);
		hosphotoVO.setHosPhoto_name(hosPhoto_name);
		hosphotoVO.setHosPhoto_extent(hosPhoto_extent);

		dao.insert(hosphotoVO);

		return hosphotoVO;
	}

	//====以下是update方法====
	public HosPhotoVO updateHosPhoto(String hosPhoto_Id,String hosPhoto_HosId,byte[] hosPhoto_photo,String isDisp_HosPhoto,String hosPhoto_name,String hosPhoto_extent){

		HosPhotoVO hosphotoVO = new HosPhotoVO();

		hosphotoVO.setHosPhoto_Id(hosPhoto_Id);
		hosphotoVO.setHosPhoto_HosId(hosPhoto_HosId);
		hosphotoVO.setHosPhoto_photo(hosPhoto_photo);
		hosphotoVO.setIsDisp_HosPhoto(isDisp_HosPhoto);
		hosphotoVO.setHosPhoto_name(hosPhoto_name);
		hosphotoVO.setHosPhoto_extent(hosPhoto_extent);

		dao.update(hosphotoVO);

		return hosphotoVO;
	}

	//====以下是delete方法====
	public void deleteHosPhoto(String  hosPhoto_Id){
		dao.delete(hosPhoto_Id);
	}

	//====以下是getOne方法====
	public HosPhotoVO getOneHosPhoto(String  hosPhoto_Id){
		return dao.findByPrimaryKey(hosPhoto_Id);
	}

	//====以下是getAll方法====
	public List<HosPhotoVO> getAll(){
		return dao.getAll();
	}
}

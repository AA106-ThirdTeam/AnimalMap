package com.second_prodphotos.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:二手商品相簿<br>
 *	英文:second_ProdPhotos<br>
 */ 
public class Second_ProdPhotosService{
	private Second_ProdPhotosDAO_interface dao; 

	public Second_ProdPhotosService(){
		dao = new Second_ProdPhotosDAO();
	}

	//====以下是insert方法====
	public Second_ProdPhotosVO addSecond_ProdPhotos(String second_Prod_Id){
		Second_ProdPhotosVO second_prodphotosVO = new Second_ProdPhotosVO();

		second_prodphotosVO.setSecond_Prod_Id(second_Prod_Id);

		dao.insert(second_prodphotosVO);

		return second_prodphotosVO;
	}

	//====以下是update方法====
	public Second_ProdPhotosVO updateSecond_ProdPhotos(String second_ProdPhotos_Id,String second_Prod_Id){

		Second_ProdPhotosVO second_prodphotosVO = new Second_ProdPhotosVO();

		second_prodphotosVO.setSecond_ProdPhotos_Id(second_ProdPhotos_Id);
		second_prodphotosVO.setSecond_Prod_Id(second_Prod_Id);

		dao.update(second_prodphotosVO);

		return second_prodphotosVO;
	}

	//====以下是delete方法====
	public void deleteSecond_ProdPhotos(String  second_ProdPhotos_Id){
		dao.delete(second_ProdPhotos_Id);
	}

	//====以下是getOne方法====
	public Second_ProdPhotosVO getOneSecond_ProdPhotos(String  second_ProdPhotos_Id){
		return dao.findByPrimaryKey(second_ProdPhotos_Id);
	}

	//====以下是getAll方法====
	public List<Second_ProdPhotosVO> getAll(){
		return dao.getAll();
	}
}

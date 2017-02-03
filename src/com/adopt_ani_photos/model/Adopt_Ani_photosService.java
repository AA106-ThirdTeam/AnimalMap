package com.adopt_ani_photos.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:送養動物相簿<br>
 *	英文:adopt_Ani_photos<br>
 */ 
public class Adopt_Ani_photosService{
	private Adopt_Ani_photosDAO_interface dao; 

	public Adopt_Ani_photosService(){
		dao = new Adopt_Ani_photosDAO();
	}

	//====以下是insert方法====
	public Adopt_Ani_photosVO addAdopt_Ani_photos(String adopt_Ani_Id,String mem_Id,byte[] ado_Ani_Pic,String ado_Pic_name,String ado_Pic_extent,java.sql.Date ado_Pic_time,String ado_Pic_type){
		Adopt_Ani_photosVO adopt_ani_photosVO = new Adopt_Ani_photosVO();

		adopt_ani_photosVO.setAdopt_Ani_Id(adopt_Ani_Id);
		adopt_ani_photosVO.setMem_Id(mem_Id);
		adopt_ani_photosVO.setAdo_Ani_Pic(ado_Ani_Pic);
		adopt_ani_photosVO.setAdo_Pic_name(ado_Pic_name);
		adopt_ani_photosVO.setAdo_Pic_extent(ado_Pic_extent);
		adopt_ani_photosVO.setAdo_Pic_time(ado_Pic_time);
		adopt_ani_photosVO.setAdo_Pic_type(ado_Pic_type);

		dao.insert(adopt_ani_photosVO);

		return adopt_ani_photosVO;
	}

	//====以下是update方法====
	public Adopt_Ani_photosVO updateAdopt_Ani_photos(String ado_Ani_Pic_No,String adopt_Ani_Id,String mem_Id,byte[] ado_Ani_Pic,String ado_Pic_name,String ado_Pic_extent,java.sql.Date ado_Pic_time,String ado_Pic_type){

		Adopt_Ani_photosVO adopt_ani_photosVO = new Adopt_Ani_photosVO();

		adopt_ani_photosVO.setAdo_Ani_Pic_No(ado_Ani_Pic_No);
		adopt_ani_photosVO.setAdopt_Ani_Id(adopt_Ani_Id);
		adopt_ani_photosVO.setMem_Id(mem_Id);
		adopt_ani_photosVO.setAdo_Ani_Pic(ado_Ani_Pic);
		adopt_ani_photosVO.setAdo_Pic_name(ado_Pic_name);
		adopt_ani_photosVO.setAdo_Pic_extent(ado_Pic_extent);
		adopt_ani_photosVO.setAdo_Pic_time(ado_Pic_time);
		adopt_ani_photosVO.setAdo_Pic_type(ado_Pic_type);

		dao.update(adopt_ani_photosVO);

		return adopt_ani_photosVO;
	}

	//====以下是delete方法====
	public void deleteAdopt_Ani_photos(String  ado_Ani_Pic_No){
		dao.delete(ado_Ani_Pic_No);
	}

	//====以下是getOne方法====
	public Adopt_Ani_photosVO getOneAdopt_Ani_photos(String  ado_Ani_Pic_No){
		return dao.findByPrimaryKey(ado_Ani_Pic_No);
	}

	//====以下是getAll方法====
	public List<Adopt_Ani_photosVO> getAll(){
		return dao.getAll();
	}
}

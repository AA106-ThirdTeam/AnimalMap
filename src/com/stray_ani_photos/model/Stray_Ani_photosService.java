package com.stray_ani_photos.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:社區流浪動物相簿<br>
 *	英文:stray_Ani_photos<br>
 */ 
public class Stray_Ani_photosService{
	private Stray_Ani_photosDAO_interface dao; 

	public Stray_Ani_photosService(){
		dao = new Stray_Ani_photosDAO();
	}

	//====以下是insert方法====
	public Stray_Ani_photosVO addStray_Ani_photos(String stray_Ani_Id,String mem_Id,byte[] stray_Ani_Pic,String stray_Pic_name,String stray_Pic_extent,java.sql.Date stray_Pic_time,String stray_Pic_type){
		Stray_Ani_photosVO stray_ani_photosVO = new Stray_Ani_photosVO();

		stray_ani_photosVO.setStray_Ani_Id(stray_Ani_Id);
		stray_ani_photosVO.setMem_Id(mem_Id);
		stray_ani_photosVO.setStray_Ani_Pic(stray_Ani_Pic);
		stray_ani_photosVO.setStray_Pic_name(stray_Pic_name);
		stray_ani_photosVO.setStray_Pic_extent(stray_Pic_extent);
		stray_ani_photosVO.setStray_Pic_time(stray_Pic_time);
		stray_ani_photosVO.setStray_Pic_type(stray_Pic_type);

		dao.insert(stray_ani_photosVO);

		return stray_ani_photosVO;
	}

	//====以下是update方法====
	public Stray_Ani_photosVO updateStray_Ani_photos(String str_Ani_Pic_No,String stray_Ani_Id,String mem_Id,byte[] stray_Ani_Pic,String stray_Pic_name,String stray_Pic_extent,java.sql.Date stray_Pic_time,String stray_Pic_type){

		Stray_Ani_photosVO stray_ani_photosVO = new Stray_Ani_photosVO();

		stray_ani_photosVO.setStr_Ani_Pic_No(str_Ani_Pic_No);
		stray_ani_photosVO.setStray_Ani_Id(stray_Ani_Id);
		stray_ani_photosVO.setMem_Id(mem_Id);
		stray_ani_photosVO.setStray_Ani_Pic(stray_Ani_Pic);
		stray_ani_photosVO.setStray_Pic_name(stray_Pic_name);
		stray_ani_photosVO.setStray_Pic_extent(stray_Pic_extent);
		stray_ani_photosVO.setStray_Pic_time(stray_Pic_time);
		stray_ani_photosVO.setStray_Pic_type(stray_Pic_type);

		dao.update(stray_ani_photosVO);

		return stray_ani_photosVO;
	}

	//====以下是delete方法====
	public void deleteStray_Ani_photos(String  str_Ani_Pic_No){
		dao.delete(str_Ani_Pic_No);
	}

	//====以下是getOne方法====
	public Stray_Ani_photosVO getOneStray_Ani_photos(String  str_Ani_Pic_No){
		return dao.findByPrimaryKey(str_Ani_Pic_No);
	}

	//====以下是getAll方法====
	public List<Stray_Ani_photosVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<Stray_Ani_photosVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<Stray_Ani_photosVO> getStray_Ani_photossByStray_Ani_Id(String stray_Ani_Id) {
        return dao.getStray_Ani_photossByStray_Ani_Id(stray_Ani_Id);
    }

    //====以下是getSet方法====
    public Set<Stray_Ani_photosVO> getStray_Ani_photossByMem_Id(String mem_Id) {
        return dao.getStray_Ani_photossByMem_Id(mem_Id);
    }
}

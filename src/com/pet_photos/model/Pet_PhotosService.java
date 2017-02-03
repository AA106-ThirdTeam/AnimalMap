package com.pet_photos.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:自家寵物相簿<br>
 *	英文:pet_Photos<br>
 */ 
public class Pet_PhotosService{
	private Pet_PhotosDAO_interface dao; 

	public Pet_PhotosService(){
		dao = new Pet_PhotosDAO();
	}

	//====以下是insert方法====
	public Pet_PhotosVO addPet_Photos(String pet_Id,String mem_Id,byte[] pet_Pic,String pet_Pic_name,String pet_Pic_extent,java.sql.Date pet_Pic_time,String pet_Pic_type){
		Pet_PhotosVO pet_photosVO = new Pet_PhotosVO();

		pet_photosVO.setPet_Id(pet_Id);
		pet_photosVO.setMem_Id(mem_Id);
		pet_photosVO.setPet_Pic(pet_Pic);
		pet_photosVO.setPet_Pic_name(pet_Pic_name);
		pet_photosVO.setPet_Pic_extent(pet_Pic_extent);
		pet_photosVO.setPet_Pic_time(pet_Pic_time);
		pet_photosVO.setPet_Pic_type(pet_Pic_type);

		dao.insert(pet_photosVO);

		return pet_photosVO;
	}

	//====以下是update方法====
	public Pet_PhotosVO updatePet_Photos(String pet_Pic_No,String pet_Id,String mem_Id,byte[] pet_Pic,String pet_Pic_name,String pet_Pic_extent,java.sql.Date pet_Pic_time,String pet_Pic_type){

		Pet_PhotosVO pet_photosVO = new Pet_PhotosVO();

		pet_photosVO.setPet_Pic_No(pet_Pic_No);
		pet_photosVO.setPet_Id(pet_Id);
		pet_photosVO.setMem_Id(mem_Id);
		pet_photosVO.setPet_Pic(pet_Pic);
		pet_photosVO.setPet_Pic_name(pet_Pic_name);
		pet_photosVO.setPet_Pic_extent(pet_Pic_extent);
		pet_photosVO.setPet_Pic_time(pet_Pic_time);
		pet_photosVO.setPet_Pic_type(pet_Pic_type);

		dao.update(pet_photosVO);

		return pet_photosVO;
	}

	//====以下是delete方法====
	public void deletePet_Photos(String  pet_Pic_No){
		dao.delete(pet_Pic_No);
	}

	//====以下是getOne方法====
	public Pet_PhotosVO getOnePet_Photos(String  pet_Pic_No){
		return dao.findByPrimaryKey(pet_Pic_No);
	}

	//====以下是getAll方法====
	public List<Pet_PhotosVO> getAll(){
		return dao.getAll();
	}
}

package com.pet_group.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:揪團<br>
 *	英文:pet_group<br>
 */ 
public class Pet_groupService{
	private Pet_groupDAO_interface dao; 

	public Pet_groupService(){
		dao = new Pet_groupDAO();
	}

	//====以下是insert方法====
	public Pet_groupVO addPet_group(String grp_MemId,String grp_name,String grp_city,String grp_Addr,String grp_road,String grp_StartTime,String grp_EndTime,String grp_Desc,Double grp_Long,Double grp_Lat,java.sql.Date grp_CreateTime,String grp_visible,byte[] grp_photo){
		Pet_groupVO pet_groupVO = new Pet_groupVO();

		pet_groupVO.setGrp_MemId(grp_MemId);
		pet_groupVO.setGrp_name(grp_name);
		pet_groupVO.setGrp_city(grp_city);
		pet_groupVO.setGrp_Addr(grp_Addr);
		pet_groupVO.setGrp_road(grp_road);
		pet_groupVO.setGrp_StartTime(grp_StartTime);
		pet_groupVO.setGrp_EndTime(grp_EndTime);
		pet_groupVO.setGrp_Desc(grp_Desc);
		pet_groupVO.setGrp_Long(grp_Long);
		pet_groupVO.setGrp_Lat(grp_Lat);
		pet_groupVO.setGrp_CreateTime(grp_CreateTime);
		pet_groupVO.setGrp_visible(grp_visible);
		pet_groupVO.setGrp_photo(grp_photo);

		dao.insert(pet_groupVO);

		return pet_groupVO;
	}

	//====以下是update方法====
	public Pet_groupVO updatePet_group(String grp_Id,String grp_MemId,String grp_name,String grp_city,String grp_Addr,String grp_road,String grp_StartTime,String grp_EndTime,String grp_Desc,Double grp_Long,Double grp_Lat,java.sql.Date grp_CreateTime,String grp_visible,byte[] grp_photo){

		Pet_groupVO pet_groupVO = new Pet_groupVO();

		pet_groupVO.setGrp_Id(grp_Id);
		pet_groupVO.setGrp_MemId(grp_MemId);
		pet_groupVO.setGrp_name(grp_name);
		pet_groupVO.setGrp_city(grp_city);
		pet_groupVO.setGrp_Addr(grp_Addr);
		pet_groupVO.setGrp_road(grp_road);
		pet_groupVO.setGrp_StartTime(grp_StartTime);
		pet_groupVO.setGrp_EndTime(grp_EndTime);
		pet_groupVO.setGrp_Desc(grp_Desc);
		pet_groupVO.setGrp_Long(grp_Long);
		pet_groupVO.setGrp_Lat(grp_Lat);
		pet_groupVO.setGrp_CreateTime(grp_CreateTime);
		pet_groupVO.setGrp_visible(grp_visible);
		pet_groupVO.setGrp_photo(grp_photo);

		dao.update(pet_groupVO);

		return pet_groupVO;
	}

	//====以下是delete方法====
	public void deletePet_group(String  grp_Id){
		dao.delete(grp_Id);
	}

	//====以下是getOne方法====
	public Pet_groupVO getOnePet_group(String  grp_Id){
		return dao.findByPrimaryKey(grp_Id);
	}

	//====以下是getAll方法====
	public List<Pet_groupVO> getAll(){
		return dao.getAll();
	}
}

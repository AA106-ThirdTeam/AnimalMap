package com.hos.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hosComm.model.HosCommVO;
import com.hosPhoto.model.HosPhotoVO;

public class HosService {
	private HosDAO_interface hosdao;

	public HosService() {
		hosdao = new HosDAO();
	}

	public HosVO addHos(String hos_MemId, String hos_name, String hos_city, String hos_town, String hos_road,
			String hos_EndTime, String hos_StartTime, String hos_Desc	,
			Double hos_Long, Double hos_Lat, String hos_visible, Integer hos_Eval,String hos_URL, String hos_Tel, List<HosPhotoVO> photoList) {

		HosVO hosVO = new HosVO();
		
		hosVO.setHos_MemId(hos_MemId);
		hosVO.setHos_name(hos_name);
		hosVO.setHos_city(hos_city);
	 	hosVO.setHos_town(hos_town);
	 	hosVO.setHos_road(hos_road);
	 	hosVO.setHos_EndTime(hos_EndTime);
	 	hosVO.setHos_StartTime(hos_StartTime);
	 	hosVO.setHos_Desc(hos_Desc);
	 	hosVO.setHos_Long(hos_Long);
	 	hosVO.setHos_Lat(hos_Lat);
	 	hosVO.setHos_visible(hos_visible);
	 	hosVO.setHos_Eval(hos_Eval);
	 	hosVO.setHos_URL(hos_URL);
	 	hosVO.setHos_Tel(hos_Tel);
	 	
	 	return hosdao.insert(hosVO,photoList);
	}

	public HosVO updateHos(String hos_Id, String hos_MemId, String hos_name, String hos_city, String hos_town, String hos_road,
			String hos_EndTime, String hos_StartTime,  java.sql.Date hos_CreateTime ,String hos_Desc	,
			Double hos_Long, Double hos_Lat, String hos_visible, Integer hos_Eval,String hos_URL, String hos_Tel) {

		HosVO hosVO = new HosVO();
		
		
		hosVO.setHos_Id(hos_Id);
		hosVO.setHos_MemId(hos_MemId);
		hosVO.setHos_name(hos_name);
	 	hosVO.setHos_city(hos_city);
	 	hosVO.setHos_town(hos_town);
	 	hosVO.setHos_road(hos_road);
	 	hosVO.setHos_EndTime(hos_EndTime);
	 	hosVO.setHos_StartTime(hos_StartTime);
	 	hosVO.setHos_CreateTime(hos_CreateTime);
	 	hosVO.setHos_Desc(hos_Desc);
	 	hosVO.setHos_Long(hos_Long);
	 	hosVO.setHos_Lat(hos_Lat);
	 	hosVO.setHos_visible(hos_visible);
	 	hosVO.setHos_Eval(hos_Eval);
	 	hosVO.setHos_URL(hos_URL);
	 	hosVO.setHos_Tel(hos_Tel);
	 	
	 	hosdao.update(hosVO);

		return hosVO;
	}

	public void deleteHos(String hos_Id) {
		hosdao.delete(hos_Id);
		
	}

	public HosVO getOneHos(String hos_Id) {
		return hosdao.findByPrimaryKey(hos_Id);
	}

	public List<HosVO> getAll() {
		return hosdao.getAll();
	}
	
	public Set<HosPhotoVO> getPhotosByHosId(String hos_Id){
		return hosdao.getPhotosByHosId(hos_Id);	
	}
	
	public List<HosVO> searchAll(String searchCondition){
		return hosdao.searchAll(searchCondition);
	}
	
	public Set<HosCommVO> getCommentsByHosId(String hos_Id){
		return hosdao.getCommentsByHosId(hos_Id);
	}

	public List<HosVO> getAll(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return  hosdao.getAll(map);
	}
	
}

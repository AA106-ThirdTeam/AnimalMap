package com.hosPhoto.model;

import java.util.List;
import java.util.Set;

import com.hos.model.HosDAO;
import com.hos.model.HosDAO_interface;
import com.hos.model.HosVO;

public class HosPhotoService {
	private HosPhotoDAO_interface hosphotodao;

	public HosPhotoService() {
		hosphotodao = new HosPhotoDAO();
	}

	public List<HosPhotoVO> addPhoto(String hos_Id, List<HosPhotoVO> photoList) {

		HosPhotoVO hosPhotoVO = new HosPhotoVO();
	
		for(HosPhotoVO hpVO : photoList){
			hpVO.setHosPhoto_HosId(hos_Id);
			hpVO.setHosPhoto_photo(hpVO.getHosPhoto_photo());
			hpVO.setIsDisp_HosPhoto("0");
		}

	 	hosphotodao.insert(hos_Id,photoList);

		return photoList;
	}

//	public HosVO updateHos(String hos_Id, String hos_MemId, String hos_name, String hos_city, String hos_town, String hos_road,
//			String hos_EndTime, String hos_StartTime,  java.sql.Date hos_CreateTime ,String hos_Desc	,
//			Double hos_Long, Double hos_Lat, String hos_visible, Integer hos_Eval,String hos_URL, String hos_Tel) {
//
//		HosVO hosVO = new HosVO();
//		
//		
//		hosVO.setHos_Id(hos_Id);
//		hosVO.setHos_MemId(hos_MemId);
//		hosVO.setHos_name(hos_name);
//	 	hosVO.setHos_city(hos_city);
//	 	hosVO.setHos_town(hos_town);
//	 	hosVO.setHos_road(hos_road);
//	 	hosVO.setHos_EndTime(hos_EndTime);
//	 	hosVO.setHos_StartTime(hos_StartTime);
//	 	hosVO.setHos_CreateTime(hos_CreateTime);
//	 	hosVO.setHos_Desc(hos_Desc);
//	 	hosVO.setHos_Long(hos_Long);
//	 	hosVO.setHos_Lat(hos_Lat);
//	 	hosVO.setHos_visible(hos_visible);
//	 	hosVO.setHos_Eval(hos_Eval);
//	 	hosVO.setHos_URL(hos_URL);
//	 	hosVO.setHos_Tel(hos_Tel);
//	 	
//	 	hosdao.update(hosVO);
//
//		return hosVO;
//	}
//
	public void deletePhoto(String hosPhoto_Id) {
		hosphotodao.delete(hosPhoto_Id);
		
	}
//
//	public HosVO getOneHos(String hos_Id) {
//		return hosdao.findByPrimaryKey(hos_Id);
//	}
//
//	public List<HosVO> getAll() {
//		return hosdao.getAll();
//	}
//	
//	public Set<HosPhotoVO> getPhotosByHosId(String hosId){
//		return hosdao.getPhotosByHosId(hosId);
//		
//	}
	public void setDisplayPhoto(String hosPhoto_Id, String hosPhoto_HosId) {
		hosphotodao.setDisplayPhoto(hosPhoto_Id,  hosPhoto_HosId);
		
	}

	
	
	
	
	
	
}

package com.strayani.model;

import java.util.List;

/**�t�d�լ�DAO**/

public class StrayaniService {
	
	private StrayaniDAO_interface dao;
	
	public StrayaniService(){
		dao = new StrayaniJNDIDAO();
	}
	
	public StrayaniVO addStrayani(String Mem_Id, String stray_Ani_name, String stray_Ani_type, String stray_Ani_gender, String stray_Ani_heal, String stray_Ani_Vac, String stray_Ani_color, String stray_Ani_body, String stray_Ani_age, String stray_Ani_Neu, String stray_Ani_chip,  java.sql.Timestamp stray_Ani_date, String stray_Ani_status, java.sql.Timestamp stray_Ani_CreDate, Double stray_Ani_FinLat, Double stray_Ani_FinLon, String stray_Ani_city, String stray_Ani_town, String stray_Ani_road  ){
		
		StrayaniVO strayaniVO = new StrayaniVO();
		
//		adoptaniVO.setStray_Ani_Id(Stray_Ani_Id);
		strayaniVO.setMem_Id(Mem_Id);
        strayaniVO.setStray_Ani_name(stray_Ani_name);
        strayaniVO.setStray_Ani_type(stray_Ani_type);
        strayaniVO.setStray_Ani_gender(stray_Ani_gender);
        strayaniVO.setStray_Ani_heal(stray_Ani_heal);
        strayaniVO.setStray_Ani_Vac(stray_Ani_Vac);
        strayaniVO.setStray_Ani_color(stray_Ani_color);
        strayaniVO.setStray_Ani_body(stray_Ani_body);
        strayaniVO.setStray_Ani_age(stray_Ani_age);
        strayaniVO.setStray_Ani_Neu(stray_Ani_Neu);
        strayaniVO.setStray_Ani_chip(stray_Ani_chip);
        strayaniVO.setStray_Ani_date(stray_Ani_date);
        strayaniVO.setStray_Ani_status(stray_Ani_status);
        strayaniVO.setStray_Ani_CreDate(stray_Ani_CreDate);
        strayaniVO.setStray_Ani_FinLat(stray_Ani_FinLat);
        strayaniVO.setStray_Ani_FinLon(stray_Ani_FinLon);
        strayaniVO.setStray_Ani_city(stray_Ani_city);
        strayaniVO.setStray_Ani_town(stray_Ani_town);
        strayaniVO.setStray_Ani_road(stray_Ani_road);
//        strayaniVO.setStray_Ani_like(stray_Ani_like);   
		strayaniVO.setStray_Ani_Id(dao.insert(strayaniVO));
		
		
		return strayaniVO;
	}
	
	public StrayaniVO updateStrayani(String stray_Ani_Id, String Mem_Id, String stray_Ani_name, String stray_Ani_type, String stray_Ani_gender, String stray_Ani_heal, String stray_Ani_Vac, String stray_Ani_color, String stray_Ani_body, String stray_Ani_age, String stray_Ani_Neu, String stray_Ani_chip,  java.sql.Timestamp stray_Ani_date, String stray_Ani_status, java.sql.Timestamp stray_Ani_CreDate, Double stray_Ani_FinLat, Double stray_Ani_FinLon, String stray_Ani_city, String stray_Ani_town, String stray_Ani_road){
		
		StrayaniVO strayaniVO = new StrayaniVO();
        strayaniVO.setStray_Ani_Id(stray_Ani_Id);
        strayaniVO.setMem_Id(Mem_Id);
        strayaniVO.setStray_Ani_name(stray_Ani_name);
        strayaniVO.setStray_Ani_type(stray_Ani_type);
        strayaniVO.setStray_Ani_gender(stray_Ani_gender);
        strayaniVO.setStray_Ani_heal(stray_Ani_heal);
        strayaniVO.setStray_Ani_Vac(stray_Ani_Vac);
        strayaniVO.setStray_Ani_color(stray_Ani_color);
        strayaniVO.setStray_Ani_body(stray_Ani_body);
        strayaniVO.setStray_Ani_age(stray_Ani_age);
        strayaniVO.setStray_Ani_Neu(stray_Ani_Neu);
        strayaniVO.setStray_Ani_chip(stray_Ani_chip);
        strayaniVO.setStray_Ani_date(stray_Ani_date);
        strayaniVO.setStray_Ani_status(stray_Ani_status);
        strayaniVO.setStray_Ani_CreDate(stray_Ani_CreDate);
        strayaniVO.setStray_Ani_FinLat(stray_Ani_FinLat);
        strayaniVO.setStray_Ani_FinLon(stray_Ani_FinLon);
        strayaniVO.setStray_Ani_city(stray_Ani_city);
        strayaniVO.setStray_Ani_town(stray_Ani_town);
        strayaniVO.setStray_Ani_road(stray_Ani_road);  
//        strayaniVO.setStray_Ani_like(stray_Ani_like); 
		dao.update(strayaniVO);
		
		return strayaniVO;
	}
	
	public void deleteStrayani(String stray_Ani_Id){
		dao.delete(stray_Ani_Id);
		
	}
	public StrayaniVO getOneStrayani(String stray_Ani_Id){
		return dao.findByPrimaryKey(stray_Ani_Id);
	}
	
	public List<StrayaniVO> getAll() {
		return dao.getAll();
	}
	
	public void changeLike(String stray_Ani_Id,String likeOrNot){
		dao.changeLike(stray_Ani_Id,likeOrNot);
	}
	
}

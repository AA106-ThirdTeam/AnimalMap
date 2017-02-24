package com.adoptani.model;

import java.util.List;

/**�t�d�լ�DAO**/

public class AdoptaniService {
	
	private AdoptaniDAO_interface dao;
	
	public AdoptaniService(){
		dao = new AdoptaniJNDIDAO();
	}
	
	public AdoptaniVO addAdoptani(String Mem_Id, String Adopt_Ani_name, String Adopt_Ani_type, String Adopt_Ani_gender, String Adopt_Ani_heal, String Adopt_Ani_Vac, String Adopt_Ani_color, String Adopt_Ani_body, String Adopt_Ani_age, String Adopt_Ani_Neu, String Adopt_Ani_chip,  java.sql.Timestamp Adopt_Ani_date, String Adopt_Ani_status, java.sql.Timestamp Adopt_Ani_CreDate, Double Adopt_Ani_FinLat, Double Adopt_Ani_FinLon, String Adopt_Ani_city, String Adopt_Ani_town, String Adopt_Ani_road  ){
		
		AdoptaniVO adoptaniVO = new AdoptaniVO();
		

		adoptaniVO.setMem_Id(Mem_Id);
		adoptaniVO.setAdopt_Ani_name(Adopt_Ani_name);
		adoptaniVO.setAdopt_Ani_type(Adopt_Ani_type);
		adoptaniVO.setAdopt_Ani_gender(Adopt_Ani_gender);
		adoptaniVO.setAdopt_Ani_heal(Adopt_Ani_heal);
		adoptaniVO.setAdopt_Ani_Vac(Adopt_Ani_Vac);
		adoptaniVO.setAdopt_Ani_color(Adopt_Ani_color);
		adoptaniVO.setAdopt_Ani_body(Adopt_Ani_body);
		adoptaniVO.setAdopt_Ani_age(Adopt_Ani_age);
		adoptaniVO.setAdopt_Ani_Neu(Adopt_Ani_Neu);
		adoptaniVO.setAdopt_Ani_chip(Adopt_Ani_chip);
		adoptaniVO.setAdopt_Ani_date(Adopt_Ani_date);
		adoptaniVO.setAdopt_Ani_status(Adopt_Ani_status);
		adoptaniVO.setAdopt_Ani_CreDate(Adopt_Ani_CreDate);
		adoptaniVO.setAdopt_Ani_FinLat(Adopt_Ani_FinLat);
		adoptaniVO.setAdopt_Ani_FinLon(Adopt_Ani_FinLon);
		adoptaniVO.setAdopt_Ani_city(Adopt_Ani_city);
		adoptaniVO.setAdopt_Ani_town(Adopt_Ani_town);
		adoptaniVO.setAdopt_Ani_road(Adopt_Ani_road);
//		adoptaniVO.setAdopt_Ani_like(Adopt_Ani_like);   
		adoptaniVO.setAdopt_Ani_Id(dao.insert(adoptaniVO));
		
		return adoptaniVO;
	}
	
	public AdoptaniVO updateAdoptani(String adopt_Ani_Id, String Mem_Id, String Adopt_Ani_name, String Adopt_Ani_type, String Adopt_Ani_gender, String Adopt_Ani_heal, String Adopt_Ani_Vac, String Adopt_Ani_color, String Adopt_Ani_body, String Adopt_Ani_age, String Adopt_Ani_Neu, String Adopt_Ani_chip,  java.sql.Timestamp Adopt_Ani_date, String Adopt_Ani_status, java.sql.Timestamp Adopt_Ani_CreDate, Double Adopt_Ani_FinLat, Double Adopt_Ani_FinLon, String Adopt_Ani_city, String Adopt_Ani_town, String Adopt_Ani_road){
		
		AdoptaniVO adoptaniVO = new AdoptaniVO();
		adoptaniVO.setAdopt_Ani_Id(adopt_Ani_Id);
		adoptaniVO.setMem_Id(Mem_Id);
		adoptaniVO.setAdopt_Ani_name(Adopt_Ani_name);
		adoptaniVO.setAdopt_Ani_type(Adopt_Ani_type);
		adoptaniVO.setAdopt_Ani_gender(Adopt_Ani_gender);
		adoptaniVO.setAdopt_Ani_heal(Adopt_Ani_heal);
		adoptaniVO.setAdopt_Ani_Vac(Adopt_Ani_Vac);
		adoptaniVO.setAdopt_Ani_color(Adopt_Ani_color);
		adoptaniVO.setAdopt_Ani_body(Adopt_Ani_body);
		adoptaniVO.setAdopt_Ani_age(Adopt_Ani_age);
		adoptaniVO.setAdopt_Ani_Neu(Adopt_Ani_Neu);
		adoptaniVO.setAdopt_Ani_chip(Adopt_Ani_chip);
		adoptaniVO.setAdopt_Ani_date(Adopt_Ani_date);
		adoptaniVO.setAdopt_Ani_status(Adopt_Ani_status);
		adoptaniVO.setAdopt_Ani_CreDate(Adopt_Ani_CreDate);
		adoptaniVO.setAdopt_Ani_FinLat(Adopt_Ani_FinLat);
		adoptaniVO.setAdopt_Ani_FinLon(Adopt_Ani_FinLon);
		adoptaniVO.setAdopt_Ani_city(Adopt_Ani_city);
		adoptaniVO.setAdopt_Ani_town(Adopt_Ani_town);
		adoptaniVO.setAdopt_Ani_road(Adopt_Ani_road);  
//		adoptaniVO.setAdopt_Ani_like(Adopt_Ani_like); 
		dao.update(adoptaniVO);
		
		return adoptaniVO;
	}
	
	public void deleteAdoptani(String Adopt_Ani_Id){
		dao.delete(Adopt_Ani_Id);
		
	}
	public AdoptaniVO getOneAdoptani(String Adopt_Ani_Id){
		return dao.findByPrimaryKey(Adopt_Ani_Id);
	}
	
	public List<AdoptaniVO> getAll() {
		return dao.getAll();
	}
	
	public void changeLike(String adopt_Ani_Id,String likeOrNot){
		dao.changeLike(adopt_Ani_Id,likeOrNot);
	}
}

package com.stray_ani.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:社區流浪動物<br>
 *	英文:stray_Ani<br>
 */ 
public class Stray_AniService{
	private Stray_AniDAO_interface dao; 

	public Stray_AniService(){
		dao = new Stray_AniDAO();
	}

	//====以下是insert方法====
	public Stray_AniVO addStray_Ani(String mem_Id,String stray_Ani_name,String stray_Ani_type,String stray_Ani_gender,String stray_Ani_heal,String stray_Ani_Vac,String stray_Ani_color,String stray_Ani_body,String stray_Ani_age,String stray_Ani_Neu,String stray_Ani_chip,java.sql.Date stray_Ani_date,String stray_Ani_status,java.sql.Date stray_Ani_CreDate,Double stray_Ani_FinLat,Double stray_Ani_FinLon,String stray_Ani_city,String stray_Ani_town,String stray_Ani_road){
		Stray_AniVO stray_aniVO = new Stray_AniVO();

		stray_aniVO.setMem_Id(mem_Id);
		stray_aniVO.setStray_Ani_name(stray_Ani_name);
		stray_aniVO.setStray_Ani_type(stray_Ani_type);
		stray_aniVO.setStray_Ani_gender(stray_Ani_gender);
		stray_aniVO.setStray_Ani_heal(stray_Ani_heal);
		stray_aniVO.setStray_Ani_Vac(stray_Ani_Vac);
		stray_aniVO.setStray_Ani_color(stray_Ani_color);
		stray_aniVO.setStray_Ani_body(stray_Ani_body);
		stray_aniVO.setStray_Ani_age(stray_Ani_age);
		stray_aniVO.setStray_Ani_Neu(stray_Ani_Neu);
		stray_aniVO.setStray_Ani_chip(stray_Ani_chip);
		stray_aniVO.setStray_Ani_date(stray_Ani_date);
		stray_aniVO.setStray_Ani_status(stray_Ani_status);
		stray_aniVO.setStray_Ani_CreDate(stray_Ani_CreDate);
		stray_aniVO.setStray_Ani_FinLat(stray_Ani_FinLat);
		stray_aniVO.setStray_Ani_FinLon(stray_Ani_FinLon);
		stray_aniVO.setStray_Ani_city(stray_Ani_city);
		stray_aniVO.setStray_Ani_town(stray_Ani_town);
		stray_aniVO.setStray_Ani_road(stray_Ani_road);

		dao.insert(stray_aniVO);

		return stray_aniVO;
	}

	//====以下是update方法====
	public Stray_AniVO updateStray_Ani(String stray_Ani_Id,String mem_Id,String stray_Ani_name,String stray_Ani_type,String stray_Ani_gender,String stray_Ani_heal,String stray_Ani_Vac,String stray_Ani_color,String stray_Ani_body,String stray_Ani_age,String stray_Ani_Neu,String stray_Ani_chip,java.sql.Date stray_Ani_date,String stray_Ani_status,java.sql.Date stray_Ani_CreDate,Double stray_Ani_FinLat,Double stray_Ani_FinLon,String stray_Ani_city,String stray_Ani_town,String stray_Ani_road){

		Stray_AniVO stray_aniVO = new Stray_AniVO();

		stray_aniVO.setStray_Ani_Id(stray_Ani_Id);
		stray_aniVO.setMem_Id(mem_Id);
		stray_aniVO.setStray_Ani_name(stray_Ani_name);
		stray_aniVO.setStray_Ani_type(stray_Ani_type);
		stray_aniVO.setStray_Ani_gender(stray_Ani_gender);
		stray_aniVO.setStray_Ani_heal(stray_Ani_heal);
		stray_aniVO.setStray_Ani_Vac(stray_Ani_Vac);
		stray_aniVO.setStray_Ani_color(stray_Ani_color);
		stray_aniVO.setStray_Ani_body(stray_Ani_body);
		stray_aniVO.setStray_Ani_age(stray_Ani_age);
		stray_aniVO.setStray_Ani_Neu(stray_Ani_Neu);
		stray_aniVO.setStray_Ani_chip(stray_Ani_chip);
		stray_aniVO.setStray_Ani_date(stray_Ani_date);
		stray_aniVO.setStray_Ani_status(stray_Ani_status);
		stray_aniVO.setStray_Ani_CreDate(stray_Ani_CreDate);
		stray_aniVO.setStray_Ani_FinLat(stray_Ani_FinLat);
		stray_aniVO.setStray_Ani_FinLon(stray_Ani_FinLon);
		stray_aniVO.setStray_Ani_city(stray_Ani_city);
		stray_aniVO.setStray_Ani_town(stray_Ani_town);
		stray_aniVO.setStray_Ani_road(stray_Ani_road);

		dao.update(stray_aniVO);

		return stray_aniVO;
	}

	//====以下是delete方法====
	public void deleteStray_Ani(String  stray_Ani_Id){
		dao.delete(stray_Ani_Id);
	}

	//====以下是getOne方法====
	public Stray_AniVO getOneStray_Ani(String  stray_Ani_Id){
		return dao.findByPrimaryKey(stray_Ani_Id);
	}

	//====以下是getAll方法====
	public List<Stray_AniVO> getAll(){
		return dao.getAll();
	}
}

package com.adopt_ani.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:送養動物<br>
 *	英文:adopt_Ani<br>
 */ 
public class Adopt_AniService{
	private Adopt_AniDAO_interface dao; 

	public Adopt_AniService(){
		dao = new Adopt_AniDAO();
	}

	//====以下是insert方法====
	public Adopt_AniVO addAdopt_Ani(String mem_Id,String adopt_Ani_name,String adopt_Ani_type,String adopt_Ani_gender,String adopt_Ani_heal,String adopt_Ani_Vac,String adopt_Ani_color,String adopt_Ani_body,String adopt_Ani_age,String adopt_Ani_Neu,String adopt_Ani_chip,java.sql.Date adopt_Ani_date,String adopt_Ani_status,java.sql.Date adopt_Ani_CreDate,Double adopt_Ani_FinLat,Double adopt_Ani_FinLon,String adopt_Ani_city,String adopt_Ani_town,String adopt_Ani_road,Integer adopt_Ani_like){
		Adopt_AniVO adopt_aniVO = new Adopt_AniVO();

		adopt_aniVO.setMem_Id(mem_Id);
		adopt_aniVO.setAdopt_Ani_name(adopt_Ani_name);
		adopt_aniVO.setAdopt_Ani_type(adopt_Ani_type);
		adopt_aniVO.setAdopt_Ani_gender(adopt_Ani_gender);
		adopt_aniVO.setAdopt_Ani_heal(adopt_Ani_heal);
		adopt_aniVO.setAdopt_Ani_Vac(adopt_Ani_Vac);
		adopt_aniVO.setAdopt_Ani_color(adopt_Ani_color);
		adopt_aniVO.setAdopt_Ani_body(adopt_Ani_body);
		adopt_aniVO.setAdopt_Ani_age(adopt_Ani_age);
		adopt_aniVO.setAdopt_Ani_Neu(adopt_Ani_Neu);
		adopt_aniVO.setAdopt_Ani_chip(adopt_Ani_chip);
		adopt_aniVO.setAdopt_Ani_date(adopt_Ani_date);
		adopt_aniVO.setAdopt_Ani_status(adopt_Ani_status);
		adopt_aniVO.setAdopt_Ani_CreDate(adopt_Ani_CreDate);
		adopt_aniVO.setAdopt_Ani_FinLat(adopt_Ani_FinLat);
		adopt_aniVO.setAdopt_Ani_FinLon(adopt_Ani_FinLon);
		adopt_aniVO.setAdopt_Ani_city(adopt_Ani_city);
		adopt_aniVO.setAdopt_Ani_town(adopt_Ani_town);
		adopt_aniVO.setAdopt_Ani_road(adopt_Ani_road);
		adopt_aniVO.setAdopt_Ani_like(adopt_Ani_like);

		dao.insert(adopt_aniVO);

		return adopt_aniVO;
	}

	//====以下是update方法====
	public Adopt_AniVO updateAdopt_Ani(String adopt_Ani_Id,String mem_Id,String adopt_Ani_name,String adopt_Ani_type,String adopt_Ani_gender,String adopt_Ani_heal,String adopt_Ani_Vac,String adopt_Ani_color,String adopt_Ani_body,String adopt_Ani_age,String adopt_Ani_Neu,String adopt_Ani_chip,java.sql.Date adopt_Ani_date,String adopt_Ani_status,java.sql.Date adopt_Ani_CreDate,Double adopt_Ani_FinLat,Double adopt_Ani_FinLon,String adopt_Ani_city,String adopt_Ani_town,String adopt_Ani_road,Integer adopt_Ani_like){

		Adopt_AniVO adopt_aniVO = new Adopt_AniVO();

		adopt_aniVO.setAdopt_Ani_Id(adopt_Ani_Id);
		adopt_aniVO.setMem_Id(mem_Id);
		adopt_aniVO.setAdopt_Ani_name(adopt_Ani_name);
		adopt_aniVO.setAdopt_Ani_type(adopt_Ani_type);
		adopt_aniVO.setAdopt_Ani_gender(adopt_Ani_gender);
		adopt_aniVO.setAdopt_Ani_heal(adopt_Ani_heal);
		adopt_aniVO.setAdopt_Ani_Vac(adopt_Ani_Vac);
		adopt_aniVO.setAdopt_Ani_color(adopt_Ani_color);
		adopt_aniVO.setAdopt_Ani_body(adopt_Ani_body);
		adopt_aniVO.setAdopt_Ani_age(adopt_Ani_age);
		adopt_aniVO.setAdopt_Ani_Neu(adopt_Ani_Neu);
		adopt_aniVO.setAdopt_Ani_chip(adopt_Ani_chip);
		adopt_aniVO.setAdopt_Ani_date(adopt_Ani_date);
		adopt_aniVO.setAdopt_Ani_status(adopt_Ani_status);
		adopt_aniVO.setAdopt_Ani_CreDate(adopt_Ani_CreDate);
		adopt_aniVO.setAdopt_Ani_FinLat(adopt_Ani_FinLat);
		adopt_aniVO.setAdopt_Ani_FinLon(adopt_Ani_FinLon);
		adopt_aniVO.setAdopt_Ani_city(adopt_Ani_city);
		adopt_aniVO.setAdopt_Ani_town(adopt_Ani_town);
		adopt_aniVO.setAdopt_Ani_road(adopt_Ani_road);
		adopt_aniVO.setAdopt_Ani_like(adopt_Ani_like);

		dao.update(adopt_aniVO);

		return adopt_aniVO;
	}

	//====以下是delete方法====
	public void deleteAdopt_Ani(String  adopt_Ani_Id){
		dao.delete(adopt_Ani_Id);
	}

	//====以下是getOne方法====
	public Adopt_AniVO getOneAdopt_Ani(String  adopt_Ani_Id){
		return dao.findByPrimaryKey(adopt_Ani_Id);
	}

	//====以下是getAll方法====
	public List<Adopt_AniVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<Adopt_AniVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<Adopt_AniVO> getAdopt_AnisByMem_Id(String mem_Id) {
        return dao.getAdopt_AnisByMem_Id(mem_Id);
    }
}

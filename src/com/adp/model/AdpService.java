package com.adp.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:領養活動<br>
 *	英文:adp<br>
 */ 
public class AdpService{
	private AdpDAO_interface dao; 

	public AdpService(){
		dao = new AdpDAO();
	}

	//====以下是insert方法====
	public AdpVO addAdp(String mem_Id,String adp_title,String adp_adp_content,java.sql.Date adp_start_date,java.sql.Date adp_end_date,java.sql.Date adp_upDate,String adp_city,String adp_town,String adp_road,Double adp_lon,Double adp_lat){
		AdpVO adpVO = new AdpVO();

		adpVO.setMem_Id(mem_Id);
		adpVO.setAdp_title(adp_title);
		adpVO.setAdp_adp_content(adp_adp_content);
		adpVO.setAdp_start_date(adp_start_date);
		adpVO.setAdp_end_date(adp_end_date);
		adpVO.setAdp_upDate(adp_upDate);
		adpVO.setAdp_city(adp_city);
		adpVO.setAdp_town(adp_town);
		adpVO.setAdp_road(adp_road);
		adpVO.setAdp_lon(adp_lon);
		adpVO.setAdp_lat(adp_lat);

		dao.insert(adpVO);

		return adpVO;
	}

	//====以下是update方法====
	public AdpVO updateAdp(String adp_Id,String mem_Id,String adp_title,String adp_adp_content,java.sql.Date adp_start_date,java.sql.Date adp_end_date,java.sql.Date adp_upDate,String adp_city,String adp_town,String adp_road,Double adp_lon,Double adp_lat){

		AdpVO adpVO = new AdpVO();

		adpVO.setAdp_Id(adp_Id);
		adpVO.setMem_Id(mem_Id);
		adpVO.setAdp_title(adp_title);
		adpVO.setAdp_adp_content(adp_adp_content);
		adpVO.setAdp_start_date(adp_start_date);
		adpVO.setAdp_end_date(adp_end_date);
		adpVO.setAdp_upDate(adp_upDate);
		adpVO.setAdp_city(adp_city);
		adpVO.setAdp_town(adp_town);
		adpVO.setAdp_road(adp_road);
		adpVO.setAdp_lon(adp_lon);
		adpVO.setAdp_lat(adp_lat);

		dao.update(adpVO);

		return adpVO;
	}

	//====以下是delete方法====
	public void deleteAdp(String  adp_Id){
		dao.delete(adp_Id);
	}

	//====以下是getOne方法====
	public AdpVO getOneAdp(String  adp_Id){
		return dao.findByPrimaryKey(adp_Id);
	}

	//====以下是getAll方法====
	public List<AdpVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<AdpVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<AdpVO> getAdpsByMem_Id(String mem_Id) {
        return dao.getAdpsByMem_Id(mem_Id);
    }
}

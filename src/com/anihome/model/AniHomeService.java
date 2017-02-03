package com.anihome.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:動物之家<br>
 *	英文:aniHome<br>
 */ 
public class AniHomeService{
	private AniHomeDAO_interface dao; 

	public AniHomeService(){
		dao = new AniHomeDAO();
	}

	//====以下是insert方法====
	public AniHomeVO addAniHome(String mem_Id,String aniHome_title,String aniHome_content,java.sql.Date aniHome_start_date,java.sql.Date aniHome_upDate,String aniHome_city,String aniHome_town,String aniHome_road,Double aniHome_lon,Double aniHome_lat){
		AniHomeVO anihomeVO = new AniHomeVO();

		anihomeVO.setMem_Id(mem_Id);
		anihomeVO.setAniHome_title(aniHome_title);
		anihomeVO.setAniHome_content(aniHome_content);
		anihomeVO.setAniHome_start_date(aniHome_start_date);
		anihomeVO.setAniHome_upDate(aniHome_upDate);
		anihomeVO.setAniHome_city(aniHome_city);
		anihomeVO.setAniHome_town(aniHome_town);
		anihomeVO.setAniHome_road(aniHome_road);
		anihomeVO.setAniHome_lon(aniHome_lon);
		anihomeVO.setAniHome_lat(aniHome_lat);

		dao.insert(anihomeVO);

		return anihomeVO;
	}

	//====以下是update方法====
	public AniHomeVO updateAniHome(String aniHome_Id,String mem_Id,String aniHome_title,String aniHome_content,java.sql.Date aniHome_start_date,java.sql.Date aniHome_upDate,String aniHome_city,String aniHome_town,String aniHome_road,Double aniHome_lon,Double aniHome_lat){

		AniHomeVO anihomeVO = new AniHomeVO();

		anihomeVO.setAniHome_Id(aniHome_Id);
		anihomeVO.setMem_Id(mem_Id);
		anihomeVO.setAniHome_title(aniHome_title);
		anihomeVO.setAniHome_content(aniHome_content);
		anihomeVO.setAniHome_start_date(aniHome_start_date);
		anihomeVO.setAniHome_upDate(aniHome_upDate);
		anihomeVO.setAniHome_city(aniHome_city);
		anihomeVO.setAniHome_town(aniHome_town);
		anihomeVO.setAniHome_road(aniHome_road);
		anihomeVO.setAniHome_lon(aniHome_lon);
		anihomeVO.setAniHome_lat(aniHome_lat);

		dao.update(anihomeVO);

		return anihomeVO;
	}

	//====以下是delete方法====
	public void deleteAniHome(String  aniHome_Id){
		dao.delete(aniHome_Id);
	}

	//====以下是getOne方法====
	public AniHomeVO getOneAniHome(String  aniHome_Id){
		return dao.findByPrimaryKey(aniHome_Id);
	}

	//====以下是getAll方法====
	public List<AniHomeVO> getAll(){
		return dao.getAll();
	}
}

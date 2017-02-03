package com.second_prod.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:二手商品<br>
 *	英文:second_Prod<br>
 */ 
public class Second_ProdService{
	private Second_ProdDAO_interface dao; 

	public Second_ProdService(){
		dao = new Second_ProdDAO();
	}

	//====以下是insert方法====
	public Second_ProdVO addSecond_Prod(String mem_Id,String second_Prod_Title,String second_Prod_Content,java.sql.Date second_Prod_adp_start_date,java.sql.Date second_Prod_adp_end_date,java.sql.Date second_Prod_adp_upDate,String second_Prod_adp_city,String second_Prod_Town,String second_Prod_Road,Double second_Prod_Lon,Double second_Prod_Lat){
		Second_ProdVO second_prodVO = new Second_ProdVO();

		second_prodVO.setMem_Id(mem_Id);
		second_prodVO.setSecond_Prod_Title(second_Prod_Title);
		second_prodVO.setSecond_Prod_Content(second_Prod_Content);
		second_prodVO.setSecond_Prod_adp_start_date(second_Prod_adp_start_date);
		second_prodVO.setSecond_Prod_adp_end_date(second_Prod_adp_end_date);
		second_prodVO.setSecond_Prod_adp_upDate(second_Prod_adp_upDate);
		second_prodVO.setSecond_Prod_adp_city(second_Prod_adp_city);
		second_prodVO.setSecond_Prod_Town(second_Prod_Town);
		second_prodVO.setSecond_Prod_Road(second_Prod_Road);
		second_prodVO.setSecond_Prod_Lon(second_Prod_Lon);
		second_prodVO.setSecond_Prod_Lat(second_Prod_Lat);

		dao.insert(second_prodVO);

		return second_prodVO;
	}

	//====以下是update方法====
	public Second_ProdVO updateSecond_Prod(String second_Prod_Id,String mem_Id,String second_Prod_Title,String second_Prod_Content,java.sql.Date second_Prod_adp_start_date,java.sql.Date second_Prod_adp_end_date,java.sql.Date second_Prod_adp_upDate,String second_Prod_adp_city,String second_Prod_Town,String second_Prod_Road,Double second_Prod_Lon,Double second_Prod_Lat){

		Second_ProdVO second_prodVO = new Second_ProdVO();

		second_prodVO.setSecond_Prod_Id(second_Prod_Id);
		second_prodVO.setMem_Id(mem_Id);
		second_prodVO.setSecond_Prod_Title(second_Prod_Title);
		second_prodVO.setSecond_Prod_Content(second_Prod_Content);
		second_prodVO.setSecond_Prod_adp_start_date(second_Prod_adp_start_date);
		second_prodVO.setSecond_Prod_adp_end_date(second_Prod_adp_end_date);
		second_prodVO.setSecond_Prod_adp_upDate(second_Prod_adp_upDate);
		second_prodVO.setSecond_Prod_adp_city(second_Prod_adp_city);
		second_prodVO.setSecond_Prod_Town(second_Prod_Town);
		second_prodVO.setSecond_Prod_Road(second_Prod_Road);
		second_prodVO.setSecond_Prod_Lon(second_Prod_Lon);
		second_prodVO.setSecond_Prod_Lat(second_Prod_Lat);

		dao.update(second_prodVO);

		return second_prodVO;
	}

	//====以下是delete方法====
	public void deleteSecond_Prod(String  second_Prod_Id){
		dao.delete(second_Prod_Id);
	}

	//====以下是getOne方法====
	public Second_ProdVO getOneSecond_Prod(String  second_Prod_Id){
		return dao.findByPrimaryKey(second_Prod_Id);
	}

	//====以下是getAll方法====
	public List<Second_ProdVO> getAll(){
		return dao.getAll();
	}
}

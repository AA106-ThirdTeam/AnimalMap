package com.park.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:公園<br>
 *	英文:park<br>
 */ 
public class ParkService{
	private ParkDAO_interface dao; 

	public ParkService(){
		dao = new ParkDAO();
	}

	//====以下是insert方法====
	public ParkVO addPark(String emp_Id,String park_title,String park_content,byte[] park_pic,java.sql.Date adp_start_date,java.sql.Date adp_upDate,String adp_city,String park_town,String park_road,Double park_lon,Double park_lat){
		ParkVO parkVO = new ParkVO();

		parkVO.setEmp_Id(emp_Id);
		parkVO.setPark_title(park_title);
		parkVO.setPark_content(park_content);
		parkVO.setPark_pic(park_pic);
		parkVO.setAdp_start_date(adp_start_date);
		parkVO.setAdp_upDate(adp_upDate);
		parkVO.setAdp_city(adp_city);
		parkVO.setPark_town(park_town);
		parkVO.setPark_road(park_road);
		parkVO.setPark_lon(park_lon);
		parkVO.setPark_lat(park_lat);

		dao.insert(parkVO);

		return parkVO;
	}

	//====以下是update方法====
	public ParkVO updatePark(String park_Id,String emp_Id,String park_title,String park_content,byte[] park_pic,java.sql.Date adp_start_date,java.sql.Date adp_upDate,String adp_city,String park_town,String park_road,Double park_lon,Double park_lat){

		ParkVO parkVO = new ParkVO();

		parkVO.setPark_Id(park_Id);
		parkVO.setEmp_Id(emp_Id);
		parkVO.setPark_title(park_title);
		parkVO.setPark_content(park_content);
		parkVO.setPark_pic(park_pic);
		parkVO.setAdp_start_date(adp_start_date);
		parkVO.setAdp_upDate(adp_upDate);
		parkVO.setAdp_city(adp_city);
		parkVO.setPark_town(park_town);
		parkVO.setPark_road(park_road);
		parkVO.setPark_lon(park_lon);
		parkVO.setPark_lat(park_lat);

		dao.update(parkVO);

		return parkVO;
	}

	//====以下是delete方法====
	public void deletePark(String  park_Id){
		dao.delete(park_Id);
	}

	//====以下是getOne方法====
	public ParkVO getOnePark(String  park_Id){
		return dao.findByPrimaryKey(park_Id);
	}

	//====以下是getAll方法====
	public List<ParkVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<ParkVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<ParkVO> getParksByEmp_No(String emp_Id) {
        return dao.getParksByEmp_No(emp_Id);
    }
}

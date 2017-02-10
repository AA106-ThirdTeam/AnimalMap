package com.vet_hospital.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:診所<br>
 *	英文:vet_hospital<br>
 */ 
public class Vet_hospitalService{
	private Vet_hospitalDAO_interface dao; 

	public Vet_hospitalService(){
		dao = new Vet_hospitalDAO();
	}

	//====以下是insert方法====
	public Vet_hospitalVO addVet_hospital(String hos_MemId,String hos_name,String hos_city,String hos_town,String hos_road,Integer hos_Eval,String hos_URL,String hos_StartTime,String hos_EndTime,String hos_Tel,String hos_Desc,Double hos_Long,Double hos_Lat,java.sql.Date hos_CreateTime,String hos_visible){
		Vet_hospitalVO vet_hospitalVO = new Vet_hospitalVO();

		vet_hospitalVO.setHos_MemId(hos_MemId);
		vet_hospitalVO.setHos_name(hos_name);
		vet_hospitalVO.setHos_city(hos_city);
		vet_hospitalVO.setHos_town(hos_town);
		vet_hospitalVO.setHos_road(hos_road);
		vet_hospitalVO.setHos_Eval(hos_Eval);
		vet_hospitalVO.setHos_URL(hos_URL);
		vet_hospitalVO.setHos_StartTime(hos_StartTime);
		vet_hospitalVO.setHos_EndTime(hos_EndTime);
		vet_hospitalVO.setHos_Tel(hos_Tel);
		vet_hospitalVO.setHos_Desc(hos_Desc);
		vet_hospitalVO.setHos_Long(hos_Long);
		vet_hospitalVO.setHos_Lat(hos_Lat);
		vet_hospitalVO.setHos_CreateTime(hos_CreateTime);
		vet_hospitalVO.setHos_visible(hos_visible);

		dao.insert(vet_hospitalVO);

		return vet_hospitalVO;
	}

	//====以下是update方法====
	public Vet_hospitalVO updateVet_hospital(String hos_Id,String hos_MemId,String hos_name,String hos_city,String hos_town,String hos_road,Integer hos_Eval,String hos_URL,String hos_StartTime,String hos_EndTime,String hos_Tel,String hos_Desc,Double hos_Long,Double hos_Lat,java.sql.Date hos_CreateTime,String hos_visible){

		Vet_hospitalVO vet_hospitalVO = new Vet_hospitalVO();

		vet_hospitalVO.setHos_Id(hos_Id);
		vet_hospitalVO.setHos_MemId(hos_MemId);
		vet_hospitalVO.setHos_name(hos_name);
		vet_hospitalVO.setHos_city(hos_city);
		vet_hospitalVO.setHos_town(hos_town);
		vet_hospitalVO.setHos_road(hos_road);
		vet_hospitalVO.setHos_Eval(hos_Eval);
		vet_hospitalVO.setHos_URL(hos_URL);
		vet_hospitalVO.setHos_StartTime(hos_StartTime);
		vet_hospitalVO.setHos_EndTime(hos_EndTime);
		vet_hospitalVO.setHos_Tel(hos_Tel);
		vet_hospitalVO.setHos_Desc(hos_Desc);
		vet_hospitalVO.setHos_Long(hos_Long);
		vet_hospitalVO.setHos_Lat(hos_Lat);
		vet_hospitalVO.setHos_CreateTime(hos_CreateTime);
		vet_hospitalVO.setHos_visible(hos_visible);

		dao.update(vet_hospitalVO);

		return vet_hospitalVO;
	}

	//====以下是delete方法====
	public void deleteVet_hospital(String  hos_Id){
		dao.delete(hos_Id);
	}

	//====以下是getOne方法====
	public Vet_hospitalVO getOneVet_hospital(String  hos_Id){
		return dao.findByPrimaryKey(hos_Id);
	}

	//====以下是getAll方法====
	public List<Vet_hospitalVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<Vet_hospitalVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<Vet_hospitalVO> getVet_hospitalsByMem_Id(String hos_MemId) {
        return dao.getVet_hospitalsByMem_Id(hos_MemId);
    }
}

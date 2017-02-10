package com.stray_ani_loc.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:社區流浪動物出沒範圍<br>
 *	英文:stray_Ani_Loc<br>
 */ 
public class Stray_Ani_LocService{
	private Stray_Ani_LocDAO_interface dao; 

	public Stray_Ani_LocService(){
		dao = new Stray_Ani_LocDAO();
	}

	//====以下是insert方法====
	public Stray_Ani_LocVO addStray_Ani_Loc(String stray_Ani_Id,String mem_Id,Double str_Ani_LocLat,Double str_Ani_LocLon){
		Stray_Ani_LocVO stray_ani_locVO = new Stray_Ani_LocVO();

		stray_ani_locVO.setStray_Ani_Id(stray_Ani_Id);
		stray_ani_locVO.setMem_Id(mem_Id);
		stray_ani_locVO.setStr_Ani_LocLat(str_Ani_LocLat);
		stray_ani_locVO.setStr_Ani_LocLon(str_Ani_LocLon);

		dao.insert(stray_ani_locVO);

		return stray_ani_locVO;
	}

	//====以下是update方法====
	public Stray_Ani_LocVO updateStray_Ani_Loc(String str_Ani_Loc_No,String stray_Ani_Id,String mem_Id,Double str_Ani_LocLat,Double str_Ani_LocLon){

		Stray_Ani_LocVO stray_ani_locVO = new Stray_Ani_LocVO();

		stray_ani_locVO.setStr_Ani_Loc_No(str_Ani_Loc_No);
		stray_ani_locVO.setStray_Ani_Id(stray_Ani_Id);
		stray_ani_locVO.setMem_Id(mem_Id);
		stray_ani_locVO.setStr_Ani_LocLat(str_Ani_LocLat);
		stray_ani_locVO.setStr_Ani_LocLon(str_Ani_LocLon);

		dao.update(stray_ani_locVO);

		return stray_ani_locVO;
	}

	//====以下是delete方法====
	public void deleteStray_Ani_Loc(String  str_Ani_Loc_No){
		dao.delete(str_Ani_Loc_No);
	}

	//====以下是getOne方法====
	public Stray_Ani_LocVO getOneStray_Ani_Loc(String  str_Ani_Loc_No){
		return dao.findByPrimaryKey(str_Ani_Loc_No);
	}

	//====以下是getAll方法====
	public List<Stray_Ani_LocVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<Stray_Ani_LocVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<Stray_Ani_LocVO> getStray_Ani_LocsByStray_Ani_Id(String stray_Ani_Id) {
        return dao.getStray_Ani_LocsByStray_Ani_Id(stray_Ani_Id);
    }

    //====以下是getSet方法====
    public Set<Stray_Ani_LocVO> getStray_Ani_LocsByMem_Id(String mem_Id) {
        return dao.getStray_Ani_LocsByMem_Id(mem_Id);
    }
}

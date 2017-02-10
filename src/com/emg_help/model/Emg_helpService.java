package com.emg_help.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:緊急求救<br>
 *	英文:emg_help<br>
 */ 
public class Emg_helpService{
	private Emg_helpDAO_interface dao; 

	public Emg_helpService(){
		dao = new Emg_helpDAO();
	}

	//====以下是insert方法====
	public Emg_helpVO addEmg_help(String mem_Id,java.sql.Date emg_H_start_date,java.sql.Date emg_H_end_date,String emg_H_title,String emg_H_content,byte[] emg_H_Pic,String emg_H_Pic_format,String emg_H_city,String emg_H_town,String emg_H_road,Double emg_H_Lon,Double emg_H_Lat){
		Emg_helpVO emg_helpVO = new Emg_helpVO();

		emg_helpVO.setMem_Id(mem_Id);
		emg_helpVO.setEmg_H_start_date(emg_H_start_date);
		emg_helpVO.setEmg_H_end_date(emg_H_end_date);
		emg_helpVO.setEmg_H_title(emg_H_title);
		emg_helpVO.setEmg_H_content(emg_H_content);
		emg_helpVO.setEmg_H_Pic(emg_H_Pic);
		emg_helpVO.setEmg_H_Pic_format(emg_H_Pic_format);
		emg_helpVO.setEmg_H_city(emg_H_city);
		emg_helpVO.setEmg_H_town(emg_H_town);
		emg_helpVO.setEmg_H_road(emg_H_road);
		emg_helpVO.setEmg_H_Lon(emg_H_Lon);
		emg_helpVO.setEmg_H_Lat(emg_H_Lat);

		dao.insert(emg_helpVO);

		return emg_helpVO;
	}

	//====以下是update方法====
	public Emg_helpVO updateEmg_help(String emg_H_Id,String mem_Id,java.sql.Date emg_H_start_date,java.sql.Date emg_H_end_date,String emg_H_title,String emg_H_content,byte[] emg_H_Pic,String emg_H_Pic_format,String emg_H_city,String emg_H_town,String emg_H_road,Double emg_H_Lon,Double emg_H_Lat){

		Emg_helpVO emg_helpVO = new Emg_helpVO();

		emg_helpVO.setEmg_H_Id(emg_H_Id);
		emg_helpVO.setMem_Id(mem_Id);
		emg_helpVO.setEmg_H_start_date(emg_H_start_date);
		emg_helpVO.setEmg_H_end_date(emg_H_end_date);
		emg_helpVO.setEmg_H_title(emg_H_title);
		emg_helpVO.setEmg_H_content(emg_H_content);
		emg_helpVO.setEmg_H_Pic(emg_H_Pic);
		emg_helpVO.setEmg_H_Pic_format(emg_H_Pic_format);
		emg_helpVO.setEmg_H_city(emg_H_city);
		emg_helpVO.setEmg_H_town(emg_H_town);
		emg_helpVO.setEmg_H_road(emg_H_road);
		emg_helpVO.setEmg_H_Lon(emg_H_Lon);
		emg_helpVO.setEmg_H_Lat(emg_H_Lat);

		dao.update(emg_helpVO);

		return emg_helpVO;
	}

	//====以下是delete方法====
	public void deleteEmg_help(String  emg_H_Id){
		dao.delete(emg_H_Id);
	}

	//====以下是getOne方法====
	public Emg_helpVO getOneEmg_help(String  emg_H_Id){
		return dao.findByPrimaryKey(emg_H_Id);
	}

	//====以下是getAll方法====
	public List<Emg_helpVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<Emg_helpVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<Emg_helpVO> getEmg_helpsByMem_Id(String mem_Id) {
        return dao.getEmg_helpsByMem_Id(mem_Id);
    }
}

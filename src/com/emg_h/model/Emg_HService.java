package com.emg_h.model;

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
 *	英文:emg_H<br>
 */ 
public class Emg_HService{
	private Emg_HDAO_interface dao; 

	public Emg_HService(){
		dao = new Emg_HDAO();
	}

	//====以下是insert方法====
	public Emg_HVO addEmg_H(String mem_Id,java.sql.Date emg_H_start_date,java.sql.Date emg_H_end_date,String emg_H_title,String emg_H_content,byte[] emg_H_Pic,String emg_H_Pic_format,String emg_H_city,String emg_H_town,String emg_H_road,Double emg_H_Lon,Double emg_H_Lat){
		Emg_HVO emg_hVO = new Emg_HVO();

		emg_hVO.setMem_Id(mem_Id);
		emg_hVO.setEmg_H_start_date(emg_H_start_date);
		emg_hVO.setEmg_H_end_date(emg_H_end_date);
		emg_hVO.setEmg_H_title(emg_H_title);
		emg_hVO.setEmg_H_content(emg_H_content);
		emg_hVO.setEmg_H_Pic(emg_H_Pic);
		emg_hVO.setEmg_H_Pic_format(emg_H_Pic_format);
		emg_hVO.setEmg_H_city(emg_H_city);
		emg_hVO.setEmg_H_town(emg_H_town);
		emg_hVO.setEmg_H_road(emg_H_road);
		emg_hVO.setEmg_H_Lon(emg_H_Lon);
		emg_hVO.setEmg_H_Lat(emg_H_Lat);

		dao.insert(emg_hVO);

		return emg_hVO;
	}

	//====以下是update方法====
	public Emg_HVO updateEmg_H(String emg_H_Id,String mem_Id,java.sql.Date emg_H_start_date,java.sql.Date emg_H_end_date,String emg_H_title,String emg_H_content,byte[] emg_H_Pic,String emg_H_Pic_format,String emg_H_city,String emg_H_town,String emg_H_road,Double emg_H_Lon,Double emg_H_Lat){

		Emg_HVO emg_hVO = new Emg_HVO();

		emg_hVO.setEmg_H_Id(emg_H_Id);
		emg_hVO.setMem_Id(mem_Id);
		emg_hVO.setEmg_H_start_date(emg_H_start_date);
		emg_hVO.setEmg_H_end_date(emg_H_end_date);
		emg_hVO.setEmg_H_title(emg_H_title);
		emg_hVO.setEmg_H_content(emg_H_content);
		emg_hVO.setEmg_H_Pic(emg_H_Pic);
		emg_hVO.setEmg_H_Pic_format(emg_H_Pic_format);
		emg_hVO.setEmg_H_city(emg_H_city);
		emg_hVO.setEmg_H_town(emg_H_town);
		emg_hVO.setEmg_H_road(emg_H_road);
		emg_hVO.setEmg_H_Lon(emg_H_Lon);
		emg_hVO.setEmg_H_Lat(emg_H_Lat);

		dao.update(emg_hVO);

		return emg_hVO;
	}

	//====以下是delete方法====
	public void deleteEmg_H(String  emg_H_Id){
		dao.delete(emg_H_Id);
	}

	//====以下是getOne方法====
	public Emg_HVO getOneEmg_H(String  emg_H_Id){
		return dao.findByPrimaryKey(emg_H_Id);
	}

	//====以下是getAll方法====
	public List<Emg_HVO> getAll(){
		return dao.getAll();
	}
}

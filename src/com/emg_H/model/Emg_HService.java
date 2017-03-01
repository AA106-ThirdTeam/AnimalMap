package com.emg_H.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.emg_H_Msg.model.Emg_H_MsgVO;

public class Emg_HService {
	
	private Emg_HDAO_interface dao;
	
	public Emg_HService(){
		dao=new Emg_HDAO();
	}
	
	
	public List<Emg_HVO> getAll(){
		return dao.getAll();
	}
	
	
	public void delete(String emg_H_Id) {
		dao.delete(emg_H_Id);
	}
	
	
	public Emg_HVO addEmg_H(String mem_Id,	 java.sql.Timestamp emg_H_start_date,java.sql.Timestamp emg_H_end_date,String emg_H_title,String emg_H_content,byte[] emg_H_pic, String emg_H_city,String emg_H_town, String emg_H_road, Double emg_H_Lon, Double emg_H_Lat ){
	
	Emg_HVO emg_HVO = new Emg_HVO();

	
	emg_HVO.setMem_Id(mem_Id);
	emg_HVO.setEmg_H_start_date(emg_H_start_date);
	emg_HVO.setEmg_H_end_date(emg_H_end_date);
	emg_HVO.setEmg_H_title(emg_H_title);
	emg_HVO.setEmg_H_content(emg_H_content);
	emg_HVO.setEmg_H_pic(emg_H_pic);
	emg_HVO.setEmg_H_city(emg_H_city);
	emg_HVO.setEmg_H_town(emg_H_town);
	emg_HVO.setEmg_H_road(emg_H_road);
	emg_HVO.setEmg_H_Lon(emg_H_Lon);
	emg_HVO.setEmg_H_Lat(emg_H_Lat);
	
	// return 回DAO PK值會在那時候包回VO
		return dao.insert(emg_HVO);
	}
	
	
	public Emg_HVO getOneEmg_H(String emg_H_Id){
		
		return dao.findByPrimaryKey(emg_H_Id);
		
	}
	
	public Set<Emg_H_MsgVO> getEmg_H_MsgByEmg_H_Id(String emg_H_Id){
		return dao.getEmg_H_MsgByEmg_H_Id(emg_H_Id);
		
	}

}

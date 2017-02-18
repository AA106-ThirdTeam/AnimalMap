package com.grp.model;


import java.sql.*;
import java.util.List;
import java.util.Set;

import com.grp.model.GrpDAO;
import com.grp.model.GrpDAO_interface;
import com.grp.model.GrpVO;
import com.grpComm.model.GrpCommVO;

public class GrpService {
	private GrpDAO_interface grpdao;

	public GrpService() {
		grpdao = new GrpDAO();
	}

	public GrpVO addGrp(String grp_MemId, String grp_name, String grp_city, String grp_town, String grp_road,
			Timestamp grp_StartTime, Timestamp grp_EndTime, String grp_Desc,
			Double grp_Long, Double grp_Lat, String grp_visible, byte[] grp_photo) {

		GrpVO grpVO = new GrpVO();
				
		grpVO.setGrp_MemId(grp_MemId);
		grpVO.setGrp_name(grp_name);
		grpVO.setGrp_city(grp_city);
	 	grpVO.setGrp_town(grp_town);
	 	grpVO.setGrp_road(grp_road);
	 	grpVO.setGrp_EndTime(grp_EndTime);
	 	grpVO.setGrp_StartTime(grp_StartTime);
	 	grpVO.setGrp_Desc(grp_Desc);
	 	grpVO.setGrp_Long(grp_Long);
	 	grpVO.setGrp_Lat(grp_Lat);
	 	grpVO.setGrp_visible(grp_visible);
	 	grpVO.setGrp_photo(grp_photo);
	 			
		grpdao.insert(grpVO);

		return grpVO;
	}

	public GrpVO updateGrp(String grp_Id, String grp_MemId, String grp_name, String grp_city, String grp_town, String grp_road,
			Timestamp grp_StartTime, Timestamp grp_EndTime, java.sql.Date grp_CreateTime , String grp_Desc,
			Double grp_Long, Double grp_Lat, String grp_visible, byte[] grp_photo) {

		GrpVO grpVO = new GrpVO();
				
		grpVO.setGrp_Id(grp_Id);
		grpVO.setGrp_MemId(grp_MemId);
		grpVO.setGrp_name(grp_name);
		grpVO.setGrp_city(grp_city);
	 	grpVO.setGrp_town(grp_town);
	 	grpVO.setGrp_road(grp_road);
	 	grpVO.setGrp_EndTime(grp_EndTime);
	 	grpVO.setGrp_StartTime(grp_StartTime);
	 	grpVO.setGrp_CreateTime(grp_CreateTime);
	 	grpVO.setGrp_Desc(grp_Desc);
	 	grpVO.setGrp_Long(grp_Long);
	 	grpVO.setGrp_Lat(grp_Lat);
	 	grpVO.setGrp_visible(grp_visible);
	 	grpVO.setGrp_photo(grp_photo);
	 	
	 	grpdao.update(grpVO);

		return grpVO;
	}

	public void deleteGrp(String grp_Id) {
		grpdao.delete(grp_Id);
	}

	public GrpVO getOneGrp(String grp_Id) {
		return grpdao.findByPrimaryKey(grp_Id);
	}

	public List<GrpVO> getAll() {
		return grpdao.getAll();
	}
	
	public Set<GrpCommVO> getCommentsByGrpId(String grp_Id){
		return  grpdao.getCommentsByGrpId(grp_Id);
		
	};
	
}

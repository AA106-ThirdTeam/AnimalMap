package com.grp.model;


import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import com.grpComm.model.GrpCommVO;
import com.joinlist.model.JoinListVO;

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
	 			
		return grpdao.insert(grpVO);
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
		
	}
	
	
	public Set<JoinListVO> getJoinListByGrpId(String grp_Id){
		return  grpdao.getJoinListByGrpId(grp_Id);
		
	}
	
	public Set<JoinListVO> getJoinListByMemId(String mem_Id) {
		return grpdao.getJoinListByMemId(mem_Id);
		
	}
	
	
	
	public int getCount(String joinList_GrpId){
		return grpdao.get_count_By_joinList_GrpId(joinList_GrpId);
	}
	
}

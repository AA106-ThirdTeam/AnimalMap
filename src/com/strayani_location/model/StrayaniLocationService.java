package com.strayani_location.model;

import java.util.List;


public class StrayaniLocationService {
	
	private StrayaniLocationDAO_interface dao;
	
	public StrayaniLocationService(){
		dao = new StrayaniLocationJNDIDAO();
	}
	
	public StrayaniLocationVO addStrayaniLocation(String stray_Ani_Id, String Mem_Id, Integer str_Ani_LocLat, Integer str_Ani_LocLon ){
		
		StrayaniLocationVO strayaniLocationVO = new StrayaniLocationVO();
		
//		adoptaniVO.setAdopt_Ani_Id(Adopt_Ani_Id);
		
		strayaniLocationVO.setStray_Ani_Id(stray_Ani_Id);
		strayaniLocationVO.setMem_Id(Mem_Id);
		strayaniLocationVO.setStr_Ani_LocLat(str_Ani_LocLat);
		strayaniLocationVO.setStr_Ani_LocLon(str_Ani_LocLon);

		
		dao.insert(strayaniLocationVO);
		
		return strayaniLocationVO;
	}
	
	/**修改
	 * @param 
	 * @param 
	 * @return 
	 * **/
	
	public StrayaniLocationVO updateStrayaniLocation( Integer str_Ani_LocLat, Integer str_Ani_LocLon){
		
		StrayaniLocationVO strayaniLocationVO = new StrayaniLocationVO();
		strayaniLocationVO.setStr_Ani_LocLat(str_Ani_LocLat);
		strayaniLocationVO.setStr_Ani_LocLon(str_Ani_LocLon);
		dao.update(strayaniLocationVO);
		
		return strayaniLocationVO;
	}
	
	public void deleteAdoptaniSponsor(String str_Ani_Loc_No){
		dao.delete(str_Ani_Loc_No);
		
	}
	public StrayaniLocationVO getOneStrayaniLocation(String str_Ani_Loc_No){
		return dao.findByPrimaryKey(str_Ani_Loc_No);
	}
	
	public List<StrayaniLocationVO> getOneStrayaniAllLocation(String stray_Ani_Id){
		return dao.getOneAllLocation(stray_Ani_Id);
	}
	
	public List<StrayaniLocationVO> getAllSponsor() {
		return dao.getAll();
	}
	
	
}

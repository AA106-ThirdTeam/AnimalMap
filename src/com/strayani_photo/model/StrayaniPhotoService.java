package com.strayani_photo.model;
import java.sql.Timestamp;
import java.util.List;

import com.strayani.model.StrayaniVO;


public class StrayaniPhotoService {
	
	private StrayaniPhotoDAO_interface dao;
	public StrayaniPhotoService(){
		dao = new StrayaniPhotoJNDIDAO();
	}
	
	
	public StrayaniPhotoVO addStrayaniPhoto(String stray_Ani_Id, String mem_Id, byte[] str_Ani_Pic, String str_Pic_name, String str_Pic_nameEX, String str_Pic_type){
		
		StrayaniPhotoVO strayaniPhotoVO = new StrayaniPhotoVO();
		
		
		strayaniPhotoVO.setStray_Ani_Id(stray_Ani_Id);
		strayaniPhotoVO.setMem_Id(mem_Id);
		strayaniPhotoVO.setStray_Ani_Pic(str_Ani_Pic);
		strayaniPhotoVO.setStray_Pic_name(str_Pic_name);
		strayaniPhotoVO.setStray_Pic_nameEX(str_Pic_nameEX);
		
		strayaniPhotoVO.setStray_Pic_type(str_Pic_type);
		dao.insert(strayaniPhotoVO);
		
		
		return strayaniPhotoVO;
		
	}
	
	public StrayaniPhotoVO upadaeStrayaniPhoto(StrayaniPhotoVO strayaniPhotoVO){

/**	原版
 * 	public StrayaniPhotoVO upadaeStrayaniPhoto(byte[] str_Ani_Pic, String str_Pic_name, String str_Pic_nameEX, String str_Pic_type){

	StrayaniPhotoVO strayaniPhotoVO = new StrayaniPhotoVO();
	
	strayaniPhotoVO.setStr_Ani_Pic(str_Ani_Pic);
	strayaniPhotoVO.setStr_Pic_name(str_Pic_name);
	strayaniPhotoVO.setStr_Pic_nameEX(str_Pic_nameEX);
	strayaniPhotoVO.setStr_Pic_type(str_Pic_type);
**/	
		
	dao.update(strayaniPhotoVO);
	
	
	return strayaniPhotoVO;
	
	}
	
	public void deleteStrayaniPhoto(String str_Ani_Pic_No){
		dao.delete(str_Ani_Pic_No);
		
	}
	
	//取得一隻送養動物的照片(多張)
	public List<StrayaniPhotoVO> getOneStrayaniPhoto(String str_Ani_Pic_No){
		return dao.getOneStrayAni(str_Ani_Pic_No);
	}
	
	public List<StrayaniPhotoVO> getAll() {
		return dao.getAll();
	}
	
	//取得單一照片(單張)
	public StrayaniPhotoVO findByPrimaryKey(String str_Ani_Pic_No){
		return dao.findByPrimaryKey(str_Ani_Pic_No);
	}	
	
	
	public void changeHeadPhotoToNomal(String stray_Ani_Id){
		dao.changeHeadPhotoToNomal(stray_Ani_Id);
	}
	
	public void changeNomalPhotoToHead(String stray_Ani_Id , String str_Ani_Pic_No){
		dao.changeNomalPhotoToHead(stray_Ani_Id , str_Ani_Pic_No);
	}
	
}

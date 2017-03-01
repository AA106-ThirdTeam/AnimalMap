package com.adoptani_photo.model;
import java.sql.Timestamp;
import java.util.List;

import com.adoptani.model.AdoptaniVO;


public class AdoptaniPhotoService {
	
	private AdoptaniPhotoDAO_interface dao;
	public AdoptaniPhotoService(){
		dao = new AdoptaniPhotoJNDIDAO();
	}
	
	
	public AdoptaniPhotoVO addAdoptaniPhoto(String adopt_Ani_Id, String mem_Id, byte[] ado_Ani_Pic, String ado_Pic_name, String ado_Pic_nameEX, String ado_Pic_type){
		
		AdoptaniPhotoVO adoptaniPhotoVO = new AdoptaniPhotoVO();
		
		
		adoptaniPhotoVO.setAdopt_Ani_Id(adopt_Ani_Id);
		adoptaniPhotoVO.setMem_Id(mem_Id);
		adoptaniPhotoVO.setAdo_Ani_Pic(ado_Ani_Pic);
		adoptaniPhotoVO.setAdo_Pic_name(ado_Pic_name);
		adoptaniPhotoVO.setAdo_Pic_nameEX(ado_Pic_nameEX);
		
		adoptaniPhotoVO.setAdo_Pic_type(ado_Pic_type);
		dao.insert(adoptaniPhotoVO);
		
		
		return adoptaniPhotoVO;
		
	}
	
	public AdoptaniPhotoVO upadaeAdoptaniPhoto(AdoptaniPhotoVO adoptaniPhotoVO){

/**	原版
 * 	public AdoptaniPhotoVO upadaeAdoptaniPhoto(byte[] ado_Ani_Pic, String ado_Pic_name, String ado_Pic_nameEX, String ado_Pic_type){

	AdoptaniPhotoVO adoptaniPhotoVO = new AdoptaniPhotoVO();
	
	adoptaniPhotoVO.setAdo_Ani_Pic(ado_Ani_Pic);
	adoptaniPhotoVO.setAdo_Pic_name(ado_Pic_name);
	adoptaniPhotoVO.setAdo_Pic_nameEX(ado_Pic_nameEX);
	adoptaniPhotoVO.setAdo_Pic_type(ado_Pic_type);
**/	
		
	dao.update(adoptaniPhotoVO);
	
	
	return adoptaniPhotoVO;
	
	}
	
	public void deleteAdoptaniPhoto(String ado_Ani_Pic_No){
		dao.delete(ado_Ani_Pic_No);
		
	}
	
	//取得一隻送養動物的照片(多張)
	public List<AdoptaniPhotoVO> getOneAdoptaniPhoto(String ado_Ani_Pic_No){
		return dao.getOneAdoptAni(ado_Ani_Pic_No);
	}
	
	public List<AdoptaniPhotoVO> getAll() {
		return dao.getAll();
	}
	
	//取得單一照片(單張)
	public AdoptaniPhotoVO findByPrimaryKey(String ado_Ani_Pic_No){
		return dao.findByPrimaryKey(ado_Ani_Pic_No);
	}	
	
	
	public void changeHeadPhotoToNomal(String adopt_Ani_Id){
		dao.changeHeadPhotoToNomal(adopt_Ani_Id);
	}
	
	public void changeNomalPhotoToHead(String adopt_Ani_Id , String ado_Ani_Pic_No){
		dao.changeNomalPhotoToHead(adopt_Ani_Id , ado_Ani_Pic_No);
	}
	
}

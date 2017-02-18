package com.adoptani_photo.model;

import java.util.List;



public interface AdoptaniPhotoDAO_interface {
	public void insert(AdoptaniPhotoVO adoptaniPhotoVO);
    public void update(AdoptaniPhotoVO adoptaniPhotoVO);
    public void delete(String ado_Ani_Pic_No);
    public AdoptaniPhotoVO findByPrimaryKey(String ado_Ani_Pic_No);
    public List<AdoptaniPhotoVO> getAll();
    public List<AdoptaniPhotoVO> getOneAdoptAni(String adopt_Ani_Id);
    
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
    //public List<EmpVO> getAll(Map<String, String[]> map); 

}

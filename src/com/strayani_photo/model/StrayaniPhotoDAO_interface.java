package com.strayani_photo.model;

import java.util.List;



public interface StrayaniPhotoDAO_interface {
	public void insert(StrayaniPhotoVO strayaniPhotoVO);
    public void update(StrayaniPhotoVO strayaniPhotoVO);
    public void delete(String str_Ani_Pic_No);
    public StrayaniPhotoVO findByPrimaryKey(String str_Ani_Pic_No);
    public List<StrayaniPhotoVO> getAll();
    public List<StrayaniPhotoVO> getOneStrayAni(String stray_Ani_Id);
    
    public void changeHeadPhotoToNomal(String stray_Ani_Id);
    public void changeNomalPhotoToHead(String stray_Ani_Id , String str_Ani_Pic_No);
    
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
    //public List<EmpVO> getAll(Map<String, String[]> map); 

}

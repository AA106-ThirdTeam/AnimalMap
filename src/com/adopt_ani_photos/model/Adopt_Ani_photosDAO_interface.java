package com.adopt_ani_photos.model;

import java.util.*; 

public interface Adopt_Ani_photosDAO_interface {
	public void insert(Adopt_Ani_photosVO adopt_ani_photosVO);
	public void update(Adopt_Ani_photosVO adopt_ani_photosVO);
    public void delete(String ado_Ani_Pic_No);
	public Adopt_Ani_photosVO findByPrimaryKey(String ado_Ani_Pic_No);
	public List<Adopt_Ani_photosVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Adopt_Ani_photosVO> getAll(Map<String, String[]> map);

    //查詢某送養動物相簿的送養動物編號(一對多)(回傳 Set)
    public Set<Adopt_Ani_photosVO> getAdopt_Ani_photossByAdopt_Ani_Id(String adopt_Ani_Id);

    //查詢某送養動物相簿的發布者會員編號(一對多)(回傳 Set)
    public Set<Adopt_Ani_photosVO> getAdopt_Ani_photossByMem_Id(String mem_Id);
}

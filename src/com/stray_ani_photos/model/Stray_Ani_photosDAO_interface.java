package com.stray_ani_photos.model;

import java.util.*; 

public interface Stray_Ani_photosDAO_interface {
	public void insert(Stray_Ani_photosVO stray_ani_photosVO);
	public void update(Stray_Ani_photosVO stray_ani_photosVO);
    public void delete(String str_Ani_Pic_No);
	public Stray_Ani_photosVO findByPrimaryKey(String str_Ani_Pic_No);
	public List<Stray_Ani_photosVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Stray_Ani_photosVO> getAll(Map<String, String[]> map);

    //查詢某社區流浪動物相簿的社區動物編號(一對多)(回傳 Set)
    public Set<Stray_Ani_photosVO> getStray_Ani_photossByStray_Ani_Id(String stray_Ani_Id);

    //查詢某社區流浪動物相簿的發布者會員編號(一對多)(回傳 Set)
    public Set<Stray_Ani_photosVO> getStray_Ani_photossByMem_Id(String mem_Id);
}

package com.pet_photos.model;

import java.util.*; 

public interface Pet_PhotosDAO_interface {
	public void insert(Pet_PhotosVO pet_photosVO);
	public void update(Pet_PhotosVO pet_photosVO);
    public void delete(String pet_Pic_No);
	public Pet_PhotosVO findByPrimaryKey(String pet_Pic_No);
	public List<Pet_PhotosVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Pet_PhotosVO> getAll(Map<String, String[]> map);

    //查詢某自家寵物相簿的寵物編號(一對多)(回傳 Set)
    public Set<Pet_PhotosVO> getPet_PhotossByPet_Id(String pet_Id);

    //查詢某自家寵物相簿的發布者會員編號(一對多)(回傳 Set)
    public Set<Pet_PhotosVO> getPet_PhotossByMem_Id(String mem_Id);
}

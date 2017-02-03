package com.pet_photos.model;

import java.util.*; 

public interface Pet_PhotosDAO_interface {
	public void insert(Pet_PhotosVO pet_photosVO);
	public void update(Pet_PhotosVO pet_photosVO);
    public void delete(String pet_Pic_No);
	public Pet_PhotosVO findByPrimaryKey(String pet_Pic_No);
	public List<Pet_PhotosVO> getAll();
}
package com.pet_photos.model;

import java.util.*; 

public interface Pet_PhotosDAO_interface {
	public void insert(Pet_PhotosVO pet_photosVO);
	public void update(Pet_PhotosVO pet_photosVO);
	public void delete1(Integer pet_Pic_No);
	public Pet_PhotosVO findByPrimaryKey1(Integer pet_Pic_No);
	public List<Pet_PhotosVO> getAll();
}
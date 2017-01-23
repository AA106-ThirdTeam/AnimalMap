package com.pet_photos.model;

import java.util.* 

public interface Pet_PhotosDAO_interface {
	public void insert(Pet_PhotosVO pet_photosVO);
	public void update(Pet_PhotosVO pet_photosVO);
	public void delete(Integer empno);
	public Pet_PhotosVO findByPrimaryKey(Integer empno);
	public List<Pet_PhotosVO> getAll();
}
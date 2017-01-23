package com.adopt_ani_photos.model;

import java.util.*; 

public interface Adopt_Ani_photosDAO_interface {
	public void insert(Adopt_Ani_photosVO adopt_ani_photosVO);
	public void update(Adopt_Ani_photosVO adopt_ani_photosVO);
	public void delete(String ado_Ani_Pic_No);
	public Adopt_Ani_photosVO findByPrimaryKey(String ado_Ani_Pic_No);
	public List<Adopt_Ani_photosVO> getAll();
}
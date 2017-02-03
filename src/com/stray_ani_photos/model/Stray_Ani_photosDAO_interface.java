package com.stray_ani_photos.model;

import java.util.*; 

public interface Stray_Ani_photosDAO_interface {
	public void insert(Stray_Ani_photosVO stray_ani_photosVO);
	public void update(Stray_Ani_photosVO stray_ani_photosVO);
    public void delete(String str_Ani_Pic_No);
	public Stray_Ani_photosVO findByPrimaryKey(String str_Ani_Pic_No);
	public List<Stray_Ani_photosVO> getAll();
}
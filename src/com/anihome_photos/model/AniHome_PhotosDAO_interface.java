package com.anihome_photos.model;

import java.util.*; 

public interface AniHome_PhotosDAO_interface {
	public void insert(AniHome_PhotosVO anihome_photosVO);
	public void update(AniHome_PhotosVO anihome_photosVO);
    public void delete(String aniHome_Photos_Id);
	public AniHome_PhotosVO findByPrimaryKey(String aniHome_Photos_Id);
	public List<AniHome_PhotosVO> getAll();
}
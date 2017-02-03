package com.adpphotos.model;

import java.util.*; 

public interface AdpPhotosDAO_interface {
	public void insert(AdpPhotosVO adpphotosVO);
	public void update(AdpPhotosVO adpphotosVO);
    public void delete(String adpPhotos_Id);
	public AdpPhotosVO findByPrimaryKey(String adpPhotos_Id);
	public List<AdpPhotosVO> getAll();
}
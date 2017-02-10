package com.anihome_photos.model;

import java.util.*; 

public interface AniHome_PhotosDAO_interface {
	public void insert(AniHome_PhotosVO anihome_photosVO);
	public void update(AniHome_PhotosVO anihome_photosVO);
    public void delete(String aniHome_Photos_Id);
	public AniHome_PhotosVO findByPrimaryKey(String aniHome_Photos_Id);
	public List<AniHome_PhotosVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<AniHome_PhotosVO> getAll(Map<String, String[]> map);

    //查詢某動物之家相簿的動物之家編號(一對多)(回傳 Set)
    public Set<AniHome_PhotosVO> getAniHome_PhotossByAniHome_Id(String aniHome_Id);
}

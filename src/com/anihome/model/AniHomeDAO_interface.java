package com.anihome.model;

import java.util.*; 

public interface AniHomeDAO_interface {
	public void insert(AniHomeVO anihomeVO);
	public void update(AniHomeVO anihomeVO);
    public void delete(String aniHome_Id);
	public AniHomeVO findByPrimaryKey(String aniHome_Id);
	public List<AniHomeVO> getAll();
}
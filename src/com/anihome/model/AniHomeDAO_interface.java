package com.anihome.model;

import java.util.*; 

public interface AniHomeDAO_interface {
	public void insert(AniHomeVO anihomeVO);
	public void update(AniHomeVO anihomeVO);
	public void delete1(Integer aniHome_Id);
	public AniHomeVO findByPrimaryKey1(Integer aniHome_Id);
	public List<AniHomeVO> getAll();
}
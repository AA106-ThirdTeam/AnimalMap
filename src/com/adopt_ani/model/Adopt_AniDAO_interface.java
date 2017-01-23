package com.adopt_ani.model;

import java.util.*; 

public interface Adopt_AniDAO_interface {
	public void insert(Adopt_AniVO adopt_aniVO);
	public void update(Adopt_AniVO adopt_aniVO);
	public void delete(String adopt_Ani_Id);
	public Adopt_AniVO findByPrimaryKey(String adopt_Ani_Id);
	public List<Adopt_AniVO> getAll();
}
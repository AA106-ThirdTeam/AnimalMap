package com.stray_ani.model;

import java.util.*; 

public interface Stray_AniDAO_interface {
	public void insert(Stray_AniVO stray_aniVO);
	public void update(Stray_AniVO stray_aniVO);
    public void delete(String stray_Ani_Id);
	public Stray_AniVO findByPrimaryKey(String stray_Ani_Id);
	public List<Stray_AniVO> getAll();
}
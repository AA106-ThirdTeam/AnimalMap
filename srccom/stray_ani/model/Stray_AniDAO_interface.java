package com.stray_ani.model;

import java.util.* 

public interface Stray_AniDAO_interface {
	public void insert(Stray_AniVO stray_aniVO);
	public void update(Stray_AniVO stray_aniVO);
	public void delete(Integer empno);
	public Stray_AniVO findByPrimaryKey(Integer empno);
	public List<Stray_AniVO> getAll();
}
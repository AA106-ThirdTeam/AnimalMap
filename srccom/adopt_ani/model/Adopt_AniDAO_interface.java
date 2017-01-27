package com.adopt_ani.model;

import java.util.* 

public interface Adopt_AniDAO_interface {
	public void insert(Adopt_AniVO adopt_aniVO);
	public void update(Adopt_AniVO adopt_aniVO);
	public void delete(Integer empno);
	public Adopt_AniVO findByPrimaryKey(Integer empno);
	public List<Adopt_AniVO> getAll();
}
package com.anihome.model;

import java.util.* 

public interface AniHomeDAO_interface {
	public void insert(AniHomeVO anihomeVO);
	public void update(AniHomeVO anihomeVO);
	public void delete(Integer empno);
	public AniHomeVO findByPrimaryKey(Integer empno);
	public List<AniHomeVO> getAll();
}
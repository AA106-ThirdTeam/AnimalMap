package com.adpphotos.model;

import java.util.* 

public interface AdpPhotosDAO_interface {
	public void insert(AdpPhotosVO adpphotosVO);
	public void update(AdpPhotosVO adpphotosVO);
	public void delete(Integer empno);
	public AdpPhotosVO findByPrimaryKey(Integer empno);
	public List<AdpPhotosVO> getAll();
}
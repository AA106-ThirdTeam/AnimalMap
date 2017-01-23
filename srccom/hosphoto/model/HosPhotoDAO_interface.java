package com.hosphoto.model;

import java.util.* 

public interface HosPhotoDAO_interface {
	public void insert(HosPhotoVO hosphotoVO);
	public void update(HosPhotoVO hosphotoVO);
	public void delete(Integer empno);
	public HosPhotoVO findByPrimaryKey(Integer empno);
	public List<HosPhotoVO> getAll();
}
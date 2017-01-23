package com.hosphoto.model;

import java.util.*; 

public interface HosPhotoDAO_interface {
	public void insert(HosPhotoVO hosphotoVO);
	public void update(HosPhotoVO hosphotoVO);
	public void delete(String hosPhoto_Id);
	public HosPhotoVO findByPrimaryKey(String hosPhoto_Id);
	public List<HosPhotoVO> getAll();
}
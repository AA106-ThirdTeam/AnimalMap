package com.hosphoto.model;

import java.util.*; 

public interface HosPhotoDAO_interface {
	public void insert(HosPhotoVO hosphotoVO);
	public void update(HosPhotoVO hosphotoVO);
	public void delete1(Integer hosPhoto_Id);
	public HosPhotoVO findByPrimaryKey1(Integer hosPhoto_Id);
	public List<HosPhotoVO> getAll();
}
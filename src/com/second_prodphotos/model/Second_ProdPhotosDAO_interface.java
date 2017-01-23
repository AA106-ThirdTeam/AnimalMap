package com.second_prodphotos.model;

import java.util.*; 

public interface Second_ProdPhotosDAO_interface {
	public void insert(Second_ProdPhotosVO second_prodphotosVO);
	public void update(Second_ProdPhotosVO second_prodphotosVO);
	public void delete1(Integer second_ProdPhotos_Id);
	public Second_ProdPhotosVO findByPrimaryKey1(Integer second_ProdPhotos_Id);
	public List<Second_ProdPhotosVO> getAll();
}
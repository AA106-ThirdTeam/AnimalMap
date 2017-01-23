package com.shopphoto.model;

import java.util.*; 

public interface ShopPhotoDAO_interface {
	public void insert(ShopPhotoVO shopphotoVO);
	public void update(ShopPhotoVO shopphotoVO);
	public void delete1(Integer shopPhoto_Id);
	public ShopPhotoVO findByPrimaryKey1(Integer shopPhoto_Id);
	public List<ShopPhotoVO> getAll();
}
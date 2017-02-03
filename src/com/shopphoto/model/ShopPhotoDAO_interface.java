package com.shopphoto.model;

import java.util.*; 

public interface ShopPhotoDAO_interface {
	public void insert(ShopPhotoVO shopphotoVO);
	public void update(ShopPhotoVO shopphotoVO);
    public void delete(String shopPhoto_Id);
	public ShopPhotoVO findByPrimaryKey(String shopPhoto_Id);
	public List<ShopPhotoVO> getAll();
}
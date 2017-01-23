package com.shopphoto.model;

import java.util.* 

public interface ShopPhotoDAO_interface {
	public void insert(ShopPhotoVO shopphotoVO);
	public void update(ShopPhotoVO shopphotoVO);
	public void delete(Integer empno);
	public ShopPhotoVO findByPrimaryKey(Integer empno);
	public List<ShopPhotoVO> getAll();
}
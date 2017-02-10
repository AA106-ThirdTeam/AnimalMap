package com.shopphoto.model;

import java.util.*; 

public interface ShopPhotoDAO_interface {
	public void insert(ShopPhotoVO shopphotoVO);
	public void update(ShopPhotoVO shopphotoVO);
    public void delete(String shopPhoto_Id);
	public ShopPhotoVO findByPrimaryKey(String shopPhoto_Id);
	public List<ShopPhotoVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<ShopPhotoVO> getAll(Map<String, String[]> map);

    //查詢某商家相片的商家編號(相片擁有商家)(一對多)(回傳 Set)
    public Set<ShopPhotoVO> getShopPhotosByShop_Id(String shopPhoto_ShopId);
}

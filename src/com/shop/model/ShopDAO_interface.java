package com.shop.model;

import java.util.List;

public interface ShopDAO_interface {
	public void insert(ShopVO shopVO);
    public void update(ShopVO shopVO);
    public void delete(String shop_Id);
    public ShopVO findByPrimaryKey(String shop_Id);
    public List<ShopVO> getAll();
}

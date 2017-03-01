package com.shopComm.model;

import java.util.List;

public interface ShopCommDAO_interface {
	public void insert(ShopCommVO shopCommVO);
    public void update(ShopCommVO shopCommVO);
    public void delete(String shopComment_Id);
    public ShopCommVO findByPrimaryKey(String shopComment_Id);
    public List<ShopCommVO> getAll();
}

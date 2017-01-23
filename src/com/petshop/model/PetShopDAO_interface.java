package com.petshop.model;

import java.util.*; 

public interface PetShopDAO_interface {
	public void insert(PetShopVO petshopVO);
	public void update(PetShopVO petshopVO);
	public void delete1(Integer shop_Id);
	public PetShopVO findByPrimaryKey1(Integer shop_Id);
	public List<PetShopVO> getAll();
}
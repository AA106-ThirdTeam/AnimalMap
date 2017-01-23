package com.petshop.model;

import java.util.* 

public interface PetShopDAO_interface {
	public void insert(PetShopVO petshopVO);
	public void update(PetShopVO petshopVO);
	public void delete(Integer empno);
	public PetShopVO findByPrimaryKey(Integer empno);
	public List<PetShopVO> getAll();
}
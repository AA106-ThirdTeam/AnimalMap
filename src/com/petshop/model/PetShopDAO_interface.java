package com.petshop.model;

import java.util.*; 

public interface PetShopDAO_interface {
	public void insert(PetShopVO petshopVO);
	public void update(PetShopVO petshopVO);
    public void delete(String shop_Id);
	public PetShopVO findByPrimaryKey(String shop_Id);
	public List<PetShopVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<PetShopVO> getAll(Map<String, String[]> map);

    //查詢某寵物商店的會員編號(負責人)(一對多)(回傳 Set)
    public Set<PetShopVO> getPetShopsByMem_Id(String shop_MemId);
}

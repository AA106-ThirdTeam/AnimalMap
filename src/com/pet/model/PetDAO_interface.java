package com.pet.model;

import java.util.*; 

public interface PetDAO_interface {
	public void insert(PetVO petVO);
	public void update(PetVO petVO);
    public void delete(String pet_Id);
	public PetVO findByPrimaryKey(String pet_Id);
	public List<PetVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<PetVO> getAll(Map<String, String[]> map);

    //查詢某自家寵物的主人會員編號(一對多)(回傳 Set)
    public Set<PetVO> getPetsByMem_Id(String mem_Id);
}

package com.pet.model;

import java.util.*; 

public interface PetDAO_interface {
	public void insert(PetVO petVO);
	public void update(PetVO petVO);
    public void delete(String pet_Id);
	public PetVO findByPrimaryKey(String pet_Id);
	public List<PetVO> getAll();
}
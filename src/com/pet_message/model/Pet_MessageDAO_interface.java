package com.pet_message.model;

import java.util.*; 

public interface Pet_MessageDAO_interface {
	public void insert(Pet_MessageVO pet_messageVO);
	public void update(Pet_MessageVO pet_messageVO);
	public void delete1(Integer pet_Mes_No);
	public Pet_MessageVO findByPrimaryKey1(Integer pet_Mes_No);
	public List<Pet_MessageVO> getAll();
}
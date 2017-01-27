package com.pet_group.model;

import java.util.* 

public interface Pet_groupDAO_interface {
	public void insert(Pet_groupVO pet_groupVO);
	public void update(Pet_groupVO pet_groupVO);
	public void delete(Integer empno);
	public Pet_groupVO findByPrimaryKey(Integer empno);
	public List<Pet_groupVO> getAll();
}
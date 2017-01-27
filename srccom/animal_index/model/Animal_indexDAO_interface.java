package com.animal_index.model;

import java.util.* 

public interface Animal_indexDAO_interface {
	public void insert(Animal_indexVO animal_indexVO);
	public void update(Animal_indexVO animal_indexVO);
	public void delete(Integer empno);
	public Animal_indexVO findByPrimaryKey(Integer empno);
	public List<Animal_indexVO> getAll();
}
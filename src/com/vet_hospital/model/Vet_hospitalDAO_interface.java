package com.vet_hospital.model;

import java.util.*; 

public interface Vet_hospitalDAO_interface {
	public void insert(Vet_hospitalVO vet_hospitalVO);
	public void update(Vet_hospitalVO vet_hospitalVO);
    public void delete(String hos_Id);
	public Vet_hospitalVO findByPrimaryKey(String hos_Id);
	public List<Vet_hospitalVO> getAll();
}
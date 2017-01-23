package com.park.model;

import java.util.*; 

public interface ParkDAO_interface {
	public void insert(ParkVO parkVO);
	public void update(ParkVO parkVO);
	public void delete1(Integer park_Id);
	public ParkVO findByPrimaryKey1(Integer park_Id);
	public List<ParkVO> getAll();
}
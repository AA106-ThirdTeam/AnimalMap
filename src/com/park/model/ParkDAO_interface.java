package com.park.model;

import java.util.*; 

public interface ParkDAO_interface {
	public void insert(ParkVO parkVO);
	public void update(ParkVO parkVO);
	public void delete(String park_Id);
	public ParkVO findByPrimaryKey(String park_Id);
	public List<ParkVO> getAll();
}
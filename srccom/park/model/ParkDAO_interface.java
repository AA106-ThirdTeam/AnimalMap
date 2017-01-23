package com.park.model;

import java.util.* 

public interface ParkDAO_interface {
	public void insert(ParkVO parkVO);
	public void update(ParkVO parkVO);
	public void delete(Integer empno);
	public ParkVO findByPrimaryKey(Integer empno);
	public List<ParkVO> getAll();
}
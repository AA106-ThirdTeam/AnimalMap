package com.purview.model;

import java.util.*; 

public interface PurviewDAO_interface {
	public void insert(PurviewVO purviewVO);
	public void update(PurviewVO purviewVO);
	public void delete(String purview_No);
	public PurviewVO findByPrimaryKey(String purview_No);
	public List<PurviewVO> getAll();
}
package com.purview.model;

import java.util.*; 

public interface PurviewDAO_interface {
	public void insert(PurviewVO purviewVO);
	public void update(PurviewVO purviewVO);
	public void delete1(Integer purview_No);
	public PurviewVO findByPrimaryKey1(Integer purview_No);
	public List<PurviewVO> getAll();
}
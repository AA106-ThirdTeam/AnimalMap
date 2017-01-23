package com.adp.model;

import java.util.*; 

public interface AdpDAO_interface {
	public void insert(AdpVO adpVO);
	public void update(AdpVO adpVO);
	public void delete1(Integer adp_Id);
	public AdpVO findByPrimaryKey1(Integer adp_Id);
	public List<AdpVO> getAll();
}
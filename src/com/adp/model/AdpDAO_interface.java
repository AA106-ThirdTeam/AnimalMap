package com.adp.model;

import java.util.*; 

public interface AdpDAO_interface {
	public void insert(AdpVO adpVO);
	public void update(AdpVO adpVO);
    public void delete(String adp_Id);
	public AdpVO findByPrimaryKey(String adp_Id);
	public List<AdpVO> getAll();
}
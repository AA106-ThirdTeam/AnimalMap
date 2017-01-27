package com.adp.model;

import java.util.* 

public interface AdpDAO_interface {
	public void insert(AdpVO adpVO);
	public void update(AdpVO adpVO);
	public void delete(Integer empno);
	public AdpVO findByPrimaryKey(Integer empno);
	public List<AdpVO> getAll();
}
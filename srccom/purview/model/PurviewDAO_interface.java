package com.purview.model;

import java.util.* 

public interface PurviewDAO_interface {
	public void insert(PurviewVO purviewVO);
	public void update(PurviewVO purviewVO);
	public void delete(Integer empno);
	public PurviewVO findByPrimaryKey(Integer empno);
	public List<PurviewVO> getAll();
}
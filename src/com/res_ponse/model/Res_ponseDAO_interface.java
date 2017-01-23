package com.res_ponse.model;

import java.util.*; 

public interface Res_ponseDAO_interface {
	public void insert(Res_ponseVO res_ponseVO);
	public void update(Res_ponseVO res_ponseVO);
	public void delete1(Integer res_Id);
	public Res_ponseVO findByPrimaryKey1(Integer res_Id);
	public List<Res_ponseVO> getAll();
}
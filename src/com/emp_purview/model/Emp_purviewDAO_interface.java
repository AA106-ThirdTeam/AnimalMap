package com.emp_purview.model;

import java.util.*; 

public interface Emp_purviewDAO_interface {
	public void insert(Emp_purviewVO emp_purviewVO);
	public void update(Emp_purviewVO emp_purviewVO);
    public void delete_By_emp_No(String emp_No);
	public Emp_purviewVO findByPrimaryKey_By_emp_No(String emp_No);
    public void delete_By_purview_No(String purview_No);
	public Emp_purviewVO findByPrimaryKey_By_purview_No(String purview_No);
	public List<Emp_purviewVO> getAll();
}
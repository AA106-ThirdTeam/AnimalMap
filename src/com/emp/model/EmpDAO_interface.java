package com.emp.model;

import java.util.*; 

public interface EmpDAO_interface {
	public void insert(EmpVO empVO);
	public void update(EmpVO empVO);
	public void delete1(Integer emp_No);
	public EmpVO findByPrimaryKey1(Integer emp_No);
	public List<EmpVO> getAll();
}
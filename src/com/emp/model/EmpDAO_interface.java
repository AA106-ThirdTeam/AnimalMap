package com.emp.model;

import java.util.*; 

public interface EmpDAO_interface {
	public void insert(EmpVO empVO);
	public void update(EmpVO empVO);
    public void delete(String emp_No);
	public EmpVO findByPrimaryKey(String emp_No);
	public List<EmpVO> getAll();
}
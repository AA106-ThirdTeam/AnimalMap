package com.emp.model;

import java.util.* 

public interface EmpDAO_interface {
	public void insert(EmpVO empVO);
	public void update(EmpVO empVO);
	public void delete(Integer empno);
	public EmpVO findByPrimaryKey(Integer empno);
	public List<EmpVO> getAll();
}
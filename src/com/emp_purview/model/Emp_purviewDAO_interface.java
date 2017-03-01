package com.emp_purview.model;

import java.util.List;
import java.util.Set;

import com.emp_purview.model.*;

public interface Emp_purviewDAO_interface {
	
	public void insert (Emp_purviewVO emp_purviewVO); 
	
	public void delete (String emp_No);
	
	public List<Emp_purviewVO> getAll();
	
	//查詢員工有哪些權限
	public Set<Emp_purviewVO> Emp_purviewByEmp_no(String emp_No);
	

}

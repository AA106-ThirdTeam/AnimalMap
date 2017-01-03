package com.mem.model;

import java.util.List;

/**
 * 
 * @author Administrator
 * 作SQL的"增刪修查"的四大步驟
 */
public interface MemDAO_interface {
	//增
	public void insert(DeptVO deptVO);
	//刪
	public void delete(Integer memId);
	//修
	public void update(DeptVO deptVO);
	//查
	public List<MemDAO> getAll();
	
}

package com.mem.model;

import java.util.* 

public interface MemDAO_interface {
	public void insert(MemVO memVO);
	public void update(MemVO memVO);
	public void delete(Integer empno);
	public MemVO findByPrimaryKey(Integer empno);
	public List<MemVO> getAll();
}
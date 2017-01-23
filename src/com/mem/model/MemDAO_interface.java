package com.mem.model;

import java.util.*; 

public interface MemDAO_interface {
	public void insert(MemVO memVO);
	public void update(MemVO memVO);
	public void delete1(Integer mem_Id);
	public MemVO findByPrimaryKey1(Integer mem_Id);
	public List<MemVO> getAll();
}
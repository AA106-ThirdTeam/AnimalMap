package com.rel_list.model;

import java.util.*; 

public interface Rel_ListDAO_interface {
	public void insert(Rel_ListVO rel_listVO);
	public void update(Rel_ListVO rel_listVO);
	public void delete1(Integer rel_MemId);
	public Rel_ListVO findByPrimaryKey1(Integer rel_MemId);
	public void delete2(Integer added_MemId);
	public Rel_ListVO findByPrimaryKey2(Integer added_MemId);
	public List<Rel_ListVO> getAll();
}
package com.rel_list.model;

import java.util.*; 

public interface Rel_ListDAO_interface {
	public void insert(Rel_ListVO rel_listVO);
	public void update(Rel_ListVO rel_listVO);
    public void delete_By_rel_MemId(String rel_MemId);
	public Rel_ListVO findByPrimaryKey_By_rel_MemId(String rel_MemId);
    public void delete_By_added_MemId(String added_MemId);
	public Rel_ListVO findByPrimaryKey_By_added_MemId(String added_MemId);
	public List<Rel_ListVO> getAll();
}
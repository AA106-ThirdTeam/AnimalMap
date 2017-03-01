package com.mem.model;

import java.util.List;

import com.rel_list.model.Rel_ListVO; 

public interface MemDAO_interface {
	public void insert(MemVO memVO);
	public void update(MemVO memVO);
    public void delete(String mem_Id);
	public MemVO findByPrimaryKey(String mem_Id);
	public List<MemVO> getAll();
	public List<Rel_ListVO> getRelListByMemId(String mem_Id);
}
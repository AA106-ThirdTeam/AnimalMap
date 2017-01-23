package com.rel_list.model;

import java.util.* 

public interface Rel_ListDAO_interface {
	public void insert(Rel_ListVO rel_listVO);
	public void update(Rel_ListVO rel_listVO);
	public void delete(Integer empno);
	public Rel_ListVO findByPrimaryKey(Integer empno);
	public List<Rel_ListVO> getAll();
}
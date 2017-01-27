package com.second_prod.model;

import java.util.* 

public interface Second_ProdDAO_interface {
	public void insert(Second_ProdVO second_prodVO);
	public void update(Second_ProdVO second_prodVO);
	public void delete(Integer empno);
	public Second_ProdVO findByPrimaryKey(Integer empno);
	public List<Second_ProdVO> getAll();
}
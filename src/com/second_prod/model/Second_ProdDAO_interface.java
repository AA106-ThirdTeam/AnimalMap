package com.second_prod.model;

import java.util.*; 

public interface Second_ProdDAO_interface {
	public void insert(Second_ProdVO second_prodVO);
	public void update(Second_ProdVO second_prodVO);
	public void delete(String second_Prod_Id);
	public Second_ProdVO findByPrimaryKey(String second_Prod_Id);
	public List<Second_ProdVO> getAll();
}
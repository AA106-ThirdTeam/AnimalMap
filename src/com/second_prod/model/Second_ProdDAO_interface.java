package com.second_prod.model;

import java.util.*; 

public interface Second_ProdDAO_interface {
	public void insert(Second_ProdVO second_prodVO);
	public void update(Second_ProdVO second_prodVO);
	public void delete1(Integer second_Prod_Id);
	public Second_ProdVO findByPrimaryKey1(Integer second_Prod_Id);
	public List<Second_ProdVO> getAll();
}
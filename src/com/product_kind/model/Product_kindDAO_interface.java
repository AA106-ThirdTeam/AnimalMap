package com.product_kind.model;

import java.util.*; 

public interface Product_kindDAO_interface {
	public void insert(Product_kindVO product_kindVO);
	public void update(Product_kindVO product_kindVO);
	public void delete1(Integer product_kind_no);
	public Product_kindVO findByPrimaryKey1(Integer product_kind_no);
	public List<Product_kindVO> getAll();
}
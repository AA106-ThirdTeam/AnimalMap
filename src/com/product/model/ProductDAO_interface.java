package com.product.model;

import java.util.*; 

public interface ProductDAO_interface {
	public void insert(ProductVO productVO);
	public void update(ProductVO productVO);
	public void delete1(Integer product_no);
	public ProductVO findByPrimaryKey1(Integer product_no);
	public List<ProductVO> getAll();
}
package com.product_kind.model;

import java.util.* 

public interface Product_kindDAO_interface {
	public void insert(Product_kindVO product_kindVO);
	public void update(Product_kindVO product_kindVO);
	public void delete(Integer empno);
	public Product_kindVO findByPrimaryKey(Integer empno);
	public List<Product_kindVO> getAll();
}
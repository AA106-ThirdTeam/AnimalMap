package com.second_prodphotos.model;

import java.util.* 

public interface Second_ProdPhotosDAO_interface {
	public void insert(Second_ProdPhotosVO second_prodphotosVO);
	public void update(Second_ProdPhotosVO second_prodphotosVO);
	public void delete(Integer empno);
	public Second_ProdPhotosVO findByPrimaryKey(Integer empno);
	public List<Second_ProdPhotosVO> getAll();
}
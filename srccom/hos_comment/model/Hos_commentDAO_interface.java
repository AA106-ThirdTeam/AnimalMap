package com.hos_comment.model;

import java.util.* 

public interface Hos_commentDAO_interface {
	public void insert(Hos_commentVO hos_commentVO);
	public void update(Hos_commentVO hos_commentVO);
	public void delete(Integer empno);
	public Hos_commentVO findByPrimaryKey(Integer empno);
	public List<Hos_commentVO> getAll();
}
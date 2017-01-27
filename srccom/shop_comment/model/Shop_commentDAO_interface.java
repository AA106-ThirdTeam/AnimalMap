package com.shop_comment.model;

import java.util.* 

public interface Shop_commentDAO_interface {
	public void insert(Shop_commentVO shop_commentVO);
	public void update(Shop_commentVO shop_commentVO);
	public void delete(Integer empno);
	public Shop_commentVO findByPrimaryKey(Integer empno);
	public List<Shop_commentVO> getAll();
}
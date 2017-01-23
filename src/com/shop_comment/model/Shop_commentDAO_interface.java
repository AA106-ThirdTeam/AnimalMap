package com.shop_comment.model;

import java.util.*; 

public interface Shop_commentDAO_interface {
	public void insert(Shop_commentVO shop_commentVO);
	public void update(Shop_commentVO shop_commentVO);
	public void delete(String shopComm_Id);
	public Shop_commentVO findByPrimaryKey(String shopComm_Id);
	public List<Shop_commentVO> getAll();
}
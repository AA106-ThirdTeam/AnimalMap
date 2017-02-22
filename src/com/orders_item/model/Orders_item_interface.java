package com.orders_item.model;

import java.util.*;

public interface Orders_item_interface {
	public void insert(Orders_itemVO orders_itemVO);
	public void update(Orders_itemVO orders_itemVO);
	public void delete(String orders_no);
	public Orders_itemVO findByPrimaryKey(String orders_no);
	public List<Orders_itemVO> getAll();
	 //同時新增
	public void insert2 (Orders_itemVO orders_itemVO , java.sql.Connection con);
}

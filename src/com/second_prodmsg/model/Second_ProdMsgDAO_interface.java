package com.second_prodmsg.model;

import java.util.*; 

public interface Second_ProdMsgDAO_interface {
	public void insert(Second_ProdMsgVO second_prodmsgVO);
	public void update(Second_ProdMsgVO second_prodmsgVO);
	public void delete(String second_ProdMsg_Id);
	public Second_ProdMsgVO findByPrimaryKey(String second_ProdMsg_Id);
	public List<Second_ProdMsgVO> getAll();
}
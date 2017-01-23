package com.offimsg.model;

import java.util.*; 

public interface OffiMsgDAO_interface {
	public void insert(OffiMsgVO offimsgVO);
	public void update(OffiMsgVO offimsgVO);
	public void delete(String offiMsg_Id);
	public OffiMsgVO findByPrimaryKey(String offiMsg_Id);
	public List<OffiMsgVO> getAll();
}
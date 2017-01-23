package com.offimsg.model;

import java.util.*; 

public interface OffiMsgDAO_interface {
	public void insert(OffiMsgVO offimsgVO);
	public void update(OffiMsgVO offimsgVO);
	public void delete1(Integer offiMsg_Id);
	public OffiMsgVO findByPrimaryKey1(Integer offiMsg_Id);
	public List<OffiMsgVO> getAll();
}
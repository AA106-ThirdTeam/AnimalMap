package com.adpmsg.model;

import java.util.*; 

public interface AdpMsgDAO_interface {
	public void insert(AdpMsgVO adpmsgVO);
	public void update(AdpMsgVO adpmsgVO);
	public void delete(String adpMsg_Id);
	public AdpMsgVO findByPrimaryKey(String adpMsg_Id);
	public List<AdpMsgVO> getAll();
}
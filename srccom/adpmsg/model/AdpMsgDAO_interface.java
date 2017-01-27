package com.adpmsg.model;

import java.util.* 

public interface AdpMsgDAO_interface {
	public void insert(AdpMsgVO adpmsgVO);
	public void update(AdpMsgVO adpmsgVO);
	public void delete(Integer empno);
	public AdpMsgVO findByPrimaryKey(Integer empno);
	public List<AdpMsgVO> getAll();
}
package com.offimsg.model;

import java.util.* 

public interface OffiMsgDAO_interface {
	public void insert(OffiMsgVO offimsgVO);
	public void update(OffiMsgVO offimsgVO);
	public void delete(Integer empno);
	public OffiMsgVO findByPrimaryKey(Integer empno);
	public List<OffiMsgVO> getAll();
}
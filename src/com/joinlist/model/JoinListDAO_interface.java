package com.joinlist.model;

import java.util.*; 

public interface JoinListDAO_interface {
	public void insert(JoinListVO joinlistVO);
	public void update(JoinListVO joinlistVO);
	public void delete1(Integer joinList_GrpId);
	public JoinListVO findByPrimaryKey1(Integer joinList_GrpId);
	public void delete2(Integer joinList_MemId);
	public JoinListVO findByPrimaryKey2(Integer joinList_MemId);
	public List<JoinListVO> getAll();
}
package com.joinlist.model;

import java.util.*; 

public interface JoinListDAO_interface {
	public void insert(JoinListVO joinlistVO);
	public void update(JoinListVO joinlistVO);
	public void delete(String joinList_GrpId);
	public JoinListVO findByPrimaryKey(String joinList_GrpId);
	public void delete2(String joinList_MemId);
	public JoinListVO findByPrimaryKey2(String joinList_MemId);
	public List<JoinListVO> getAll();
}
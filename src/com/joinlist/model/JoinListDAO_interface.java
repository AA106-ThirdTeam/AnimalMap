package com.joinlist.model;

import java.util.*; 

public interface JoinListDAO_interface {
	public void insert(JoinListVO joinlistVO);
	public void update(JoinListVO joinlistVO);
    public void delete_By_joinList_GrpId(String joinList_GrpId);
	public JoinListVO findByPrimaryKey_By_joinList_GrpId(String joinList_GrpId);
    public void delete_By_joinList_MemId(String joinList_MemId);
	public JoinListVO findByPrimaryKey_By_joinList_MemId(String joinList_MemId);
	public List<JoinListVO> getAll();
}
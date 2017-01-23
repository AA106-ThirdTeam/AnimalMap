package com.grp_comment.model;

import java.util.*; 

public interface Grp_commentDAO_interface {
	public void insert(Grp_commentVO grp_commentVO);
	public void update(Grp_commentVO grp_commentVO);
	public void delete1(Integer grpComment_Id);
	public Grp_commentVO findByPrimaryKey1(Integer grpComment_Id);
	public List<Grp_commentVO> getAll();
}
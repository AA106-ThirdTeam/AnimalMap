package com.grp_comment.model;

import java.util.* 

public interface Grp_commentDAO_interface {
	public void insert(Grp_commentVO grp_commentVO);
	public void update(Grp_commentVO grp_commentVO);
	public void delete(Integer empno);
	public Grp_commentVO findByPrimaryKey(Integer empno);
	public List<Grp_commentVO> getAll();
}
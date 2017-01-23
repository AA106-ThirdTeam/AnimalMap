package com.joinlist.model;

import java.util.* 

public interface JoinListDAO_interface {
	public void insert(JoinListVO joinlistVO);
	public void update(JoinListVO joinlistVO);
	public void delete(Integer empno);
	public JoinListVO findByPrimaryKey(Integer empno);
	public List<JoinListVO> getAll();
}
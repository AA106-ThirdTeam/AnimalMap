package com.post.model;

import java.util.* 

public interface PostDAO_interface {
	public void insert(PostVO postVO);
	public void update(PostVO postVO);
	public void delete(Integer empno);
	public PostVO findByPrimaryKey(Integer empno);
	public List<PostVO> getAll();
}
package com.post.model;

import java.util.*; 

public interface PostDAO_interface {
	public void insert(PostVO postVO);
	public void update(PostVO postVO);
	public void delete1(Integer post_Id);
	public PostVO findByPrimaryKey1(Integer post_Id);
	public List<PostVO> getAll();
}
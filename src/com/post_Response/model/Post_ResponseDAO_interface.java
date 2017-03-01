package com.post_Response.model;

import java.util.List;
import java.util.Set;


public interface Post_ResponseDAO_interface {

	 public void insert(Post_ResponseVO post_ResponseVO);
     public void update(Post_ResponseVO post_ResponseVO);
     public void delete(String res_Id);
     public Post_ResponseVO findByPrimaryKey(String res_Id);
     public List<Post_ResponseVO> getAll();
     public List<Post_ResponseVO> getSameResId(String post_Id);
     //萬用複合查詢(傳入參數型態Map)(回傳 List)
//   public List<PostVO> getAll(Map<String, String[]> map); 
	
}

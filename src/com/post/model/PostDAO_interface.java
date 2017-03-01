package com.post.model;

import java.util.*;
import com.post_Response.model.Post_ResponseVO;

public interface PostDAO_interface {
	public void insert(PostVO postVO);
	public void update(PostVO postVO);
	public void delete(String post_Id);
	public PostVO findByPrimaryKey(String post_Id);
	public List<PostVO> getAll();
	
      //查詢某文章的回覆(一對多)(回傳 Set)
      public Set<Post_ResponseVO> getPost_ResponsesByPost_Id(String post_Id);
	
}
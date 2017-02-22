package com.post_Response.model;

import java.util.*;

public class Post_ResponseService {

	private Post_ResponseDAO_interface dao;

	//Post_Response多方
	public Post_ResponseService() {
		dao = new Post_ResponseDAO();
	}

	public Post_ResponseVO addPost_Response(String mem_Id, String post_Id, String post_Response_content,
			java.sql.Date post_time, java.sql.Date post_Response_upDate) {

		Post_ResponseVO post_ResponseVO = new Post_ResponseVO();

		post_ResponseVO.setMem_Id(mem_Id);
		post_ResponseVO.setPost_Id(post_Id);
		post_ResponseVO.setPost_Response_content(post_Response_content);
		post_ResponseVO.setPost_time(post_time);
		post_ResponseVO.setPost_Response_upDate(post_Response_upDate);
		dao.insert(post_ResponseVO);

		return post_ResponseVO;
	}

	public Post_ResponseVO updatePost_Response(String res_Id, String mem_Id, String post_Id,
			String post_Response_content, java.sql.Date post_time, java.sql.Date post_Response_upDate) {

		Post_ResponseVO post_ResponseVO = new Post_ResponseVO();

		post_ResponseVO.setRes_Id(res_Id);
		post_ResponseVO.setMem_Id(mem_Id);
		post_ResponseVO.setPost_Id(post_Id);
		post_ResponseVO.setPost_Response_content(post_Response_content);
		post_ResponseVO.setPost_time(post_time);
		post_ResponseVO.setPost_Response_upDate(post_Response_upDate);
		dao.update(post_ResponseVO);

		return post_ResponseVO;
	}

	public void deletePost_Response(String res_Id) {
		dao.delete(res_Id);
	}

	public Post_ResponseVO getOnePost_Response(String res_Id) {
		return dao.findByPrimaryKey(res_Id);
	}

	public List<Post_ResponseVO> getAll() {
		return dao.getAll();
	}
	
	public List<Post_ResponseVO> getSameResId(String post_Id){
		return dao.getSameResId(post_Id);
	}

}

package com.res_ponse.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:討論區留言<br>
 *	英文:res_ponse<br>
 */ 
public class Res_ponseService{
	private Res_ponseDAO_interface dao; 

	public Res_ponseService(){
		dao = new Res_ponseDAO();
	}

	//====以下是insert方法====
	public Res_ponseVO addRes_ponse(String mem_Id,String post_Id,String res_ponse_content,java.sql.Date post_time,java.sql.Date res_ponse_upDate){
		Res_ponseVO res_ponseVO = new Res_ponseVO();

		res_ponseVO.setMem_Id(mem_Id);
		res_ponseVO.setPost_Id(post_Id);
		res_ponseVO.setRes_ponse_content(res_ponse_content);
		res_ponseVO.setPost_time(post_time);
		res_ponseVO.setRes_ponse_upDate(res_ponse_upDate);

		dao.insert(res_ponseVO);

		return res_ponseVO;
	}

	//====以下是update方法====
	public Res_ponseVO updateRes_ponse(String res_Id,String mem_Id,String post_Id,String res_ponse_content,java.sql.Date post_time,java.sql.Date res_ponse_upDate){

		Res_ponseVO res_ponseVO = new Res_ponseVO();

		res_ponseVO.setRes_Id(res_Id);
		res_ponseVO.setMem_Id(mem_Id);
		res_ponseVO.setPost_Id(post_Id);
		res_ponseVO.setRes_ponse_content(res_ponse_content);
		res_ponseVO.setPost_time(post_time);
		res_ponseVO.setRes_ponse_upDate(res_ponse_upDate);

		dao.update(res_ponseVO);

		return res_ponseVO;
	}

	//====以下是delete方法====
	public void deleteRes_ponse(String  res_Id){
		dao.delete(res_Id);
	}

	//====以下是getOne方法====
	public Res_ponseVO getOneRes_ponse(String  res_Id){
		return dao.findByPrimaryKey(res_Id);
	}

	//====以下是getAll方法====
	public List<Res_ponseVO> getAll(){
		return dao.getAll();
	}
}

package com.hos_comment.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:診所留言<br>
 *	英文:hos_comment<br>
 */ 
public class Hos_commentService{
	private Hos_commentDAO_interface dao; 

	public Hos_commentService(){
		dao = new Hos_commentDAO();
	}

	//====以下是insert方法====
	public Hos_commentVO addHos_comment(String hosComm_MemId,String hosComm_HosId,String hosComm_content,java.sql.Date hosComm_SendTime){
		Hos_commentVO hos_commentVO = new Hos_commentVO();

		hos_commentVO.setHosComm_MemId(hosComm_MemId);
		hos_commentVO.setHosComm_HosId(hosComm_HosId);
		hos_commentVO.setHosComm_content(hosComm_content);
		hos_commentVO.setHosComm_SendTime(hosComm_SendTime);

		dao.insert(hos_commentVO);

		return hos_commentVO;
	}

	//====以下是update方法====
	public Hos_commentVO updateHos_comment(String hosComm_Id,String hosComm_MemId,String hosComm_HosId,String hosComm_content,java.sql.Date hosComm_SendTime){

		Hos_commentVO hos_commentVO = new Hos_commentVO();

		hos_commentVO.setHosComm_Id(hosComm_Id);
		hos_commentVO.setHosComm_MemId(hosComm_MemId);
		hos_commentVO.setHosComm_HosId(hosComm_HosId);
		hos_commentVO.setHosComm_content(hosComm_content);
		hos_commentVO.setHosComm_SendTime(hosComm_SendTime);

		dao.update(hos_commentVO);

		return hos_commentVO;
	}

	//====以下是delete方法====
	public void deleteHos_comment(String  hosComm_Id){
		dao.delete(hosComm_Id);
	}

	//====以下是getOne方法====
	public Hos_commentVO getOneHos_comment(String  hosComm_Id){
		return dao.findByPrimaryKey(hosComm_Id);
	}

	//====以下是getAll方法====
	public List<Hos_commentVO> getAll(){
		return dao.getAll();
	}
}

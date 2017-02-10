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
	public Hos_commentVO addHos_comment(String hosComment_MemId,String hosComment_HosId,String hosComment_content,java.sql.Date hosComment_SendTime){
		Hos_commentVO hos_commentVO = new Hos_commentVO();

		hos_commentVO.setHosComment_MemId(hosComment_MemId);
		hos_commentVO.setHosComment_HosId(hosComment_HosId);
		hos_commentVO.setHosComment_content(hosComment_content);
		hos_commentVO.setHosComment_SendTime(hosComment_SendTime);

		dao.insert(hos_commentVO);

		return hos_commentVO;
	}

	//====以下是update方法====
	public Hos_commentVO updateHos_comment(String hosComment_Id,String hosComment_MemId,String hosComment_HosId,String hosComment_content,java.sql.Date hosComment_SendTime){

		Hos_commentVO hos_commentVO = new Hos_commentVO();

		hos_commentVO.setHosComment_Id(hosComment_Id);
		hos_commentVO.setHosComment_MemId(hosComment_MemId);
		hos_commentVO.setHosComment_HosId(hosComment_HosId);
		hos_commentVO.setHosComment_content(hosComment_content);
		hos_commentVO.setHosComment_SendTime(hosComment_SendTime);

		dao.update(hos_commentVO);

		return hos_commentVO;
	}

	//====以下是delete方法====
	public void deleteHos_comment(String  hosComment_Id){
		dao.delete(hosComment_Id);
	}

	//====以下是getOne方法====
	public Hos_commentVO getOneHos_comment(String  hosComment_Id){
		return dao.findByPrimaryKey(hosComment_Id);
	}

	//====以下是getAll方法====
	public List<Hos_commentVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<Hos_commentVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<Hos_commentVO> getHos_commentsByMem_Id(String hosComment_MemId) {
        return dao.getHos_commentsByMem_Id(hosComment_MemId);
    }

    //====以下是getSet方法====
    public Set<Hos_commentVO> getHos_commentsByHos_Id(String hosComment_HosId) {
        return dao.getHos_commentsByHos_Id(hosComment_HosId);
    }
}

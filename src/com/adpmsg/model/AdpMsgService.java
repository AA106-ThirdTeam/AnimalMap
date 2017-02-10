package com.adpmsg.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:領養活動留言<br>
 *	英文:adpMsg<br>
 */ 
public class AdpMsgService{
	private AdpMsgDAO_interface dao; 

	public AdpMsgService(){
		dao = new AdpMsgDAO();
	}

	//====以下是insert方法====
	public AdpMsgVO addAdpMsg(String adp_Id,String mem_Id,String msg,java.sql.Date adpMsgDate,java.sql.Date adpMsgadp_upDate){
		AdpMsgVO adpmsgVO = new AdpMsgVO();

		adpmsgVO.setAdp_Id(adp_Id);
		adpmsgVO.setMem_Id(mem_Id);
		adpmsgVO.setMsg(msg);
		adpmsgVO.setAdpMsgDate(adpMsgDate);
		adpmsgVO.setAdpMsgadp_upDate(adpMsgadp_upDate);

		dao.insert(adpmsgVO);

		return adpmsgVO;
	}

	//====以下是update方法====
	public AdpMsgVO updateAdpMsg(String adpMsg_Id,String adp_Id,String mem_Id,String msg,java.sql.Date adpMsgDate,java.sql.Date adpMsgadp_upDate){

		AdpMsgVO adpmsgVO = new AdpMsgVO();

		adpmsgVO.setAdpMsg_Id(adpMsg_Id);
		adpmsgVO.setAdp_Id(adp_Id);
		adpmsgVO.setMem_Id(mem_Id);
		adpmsgVO.setMsg(msg);
		adpmsgVO.setAdpMsgDate(adpMsgDate);
		adpmsgVO.setAdpMsgadp_upDate(adpMsgadp_upDate);

		dao.update(adpmsgVO);

		return adpmsgVO;
	}

	//====以下是delete方法====
	public void deleteAdpMsg(String  adpMsg_Id){
		dao.delete(adpMsg_Id);
	}

	//====以下是getOne方法====
	public AdpMsgVO getOneAdpMsg(String  adpMsg_Id){
		return dao.findByPrimaryKey(adpMsg_Id);
	}

	//====以下是getAll方法====
	public List<AdpMsgVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<AdpMsgVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<AdpMsgVO> getAdpMsgsByAdp_Id(String adp_Id) {
        return dao.getAdpMsgsByAdp_Id(adp_Id);
    }

    //====以下是getSet方法====
    public Set<AdpMsgVO> getAdpMsgsByMem_Id(String mem_Id) {
        return dao.getAdpMsgsByMem_Id(mem_Id);
    }
}

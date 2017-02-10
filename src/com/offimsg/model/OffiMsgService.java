package com.offimsg.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:公告訊息<br>
 *	英文:offiMsg<br>
 */ 
public class OffiMsgService{
	private OffiMsgDAO_interface dao; 

	public OffiMsgService(){
		dao = new OffiMsgDAO();
	}

	//====以下是insert方法====
	public OffiMsgVO addOffiMsg(String offiMsg_empId,String offiMsg_Title,String offiMsg_Content,java.sql.Date offiMsg_Date){
		OffiMsgVO offimsgVO = new OffiMsgVO();

		offimsgVO.setOffiMsg_empId(offiMsg_empId);
		offimsgVO.setOffiMsg_Title(offiMsg_Title);
		offimsgVO.setOffiMsg_Content(offiMsg_Content);
		offimsgVO.setOffiMsg_Date(offiMsg_Date);

		dao.insert(offimsgVO);

		return offimsgVO;
	}

	//====以下是update方法====
	public OffiMsgVO updateOffiMsg(String offiMsg_Id,String offiMsg_empId,String offiMsg_Title,String offiMsg_Content,java.sql.Date offiMsg_Date){

		OffiMsgVO offimsgVO = new OffiMsgVO();

		offimsgVO.setOffiMsg_Id(offiMsg_Id);
		offimsgVO.setOffiMsg_empId(offiMsg_empId);
		offimsgVO.setOffiMsg_Title(offiMsg_Title);
		offimsgVO.setOffiMsg_Content(offiMsg_Content);
		offimsgVO.setOffiMsg_Date(offiMsg_Date);

		dao.update(offimsgVO);

		return offimsgVO;
	}

	//====以下是delete方法====
	public void deleteOffiMsg(String  offiMsg_Id){
		dao.delete(offiMsg_Id);
	}

	//====以下是getOne方法====
	public OffiMsgVO getOneOffiMsg(String  offiMsg_Id){
		return dao.findByPrimaryKey(offiMsg_Id);
	}

	//====以下是getAll方法====
	public List<OffiMsgVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<OffiMsgVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<OffiMsgVO> getOffiMsgsByEmp_No(String offiMsg_empId) {
        return dao.getOffiMsgsByEmp_No(offiMsg_empId);
    }
}

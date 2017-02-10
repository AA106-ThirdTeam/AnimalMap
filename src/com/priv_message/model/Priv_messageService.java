package com.priv_message.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:私人訊息<br>
 *	英文:priv_message<br>
 */ 
public class Priv_messageService{
	private Priv_messageDAO_interface dao; 

	public Priv_messageService(){
		dao = new Priv_messageDAO();
	}

	//====以下是insert方法====
	public Priv_messageVO addPriv_message(String privMesSend_MemId,String privMesRec_MemId,String privMes_content,java.sql.Date privMes_SendTime,String privMes_type){
		Priv_messageVO priv_messageVO = new Priv_messageVO();

		priv_messageVO.setPrivMesSend_MemId(privMesSend_MemId);
		priv_messageVO.setPrivMesRec_MemId(privMesRec_MemId);
		priv_messageVO.setPrivMes_content(privMes_content);
		priv_messageVO.setPrivMes_SendTime(privMes_SendTime);
		priv_messageVO.setPrivMes_type(privMes_type);

		dao.insert(priv_messageVO);

		return priv_messageVO;
	}

	//====以下是update方法====
	public Priv_messageVO updatePriv_message(String privMes_Id,String privMesSend_MemId,String privMesRec_MemId,String privMes_content,java.sql.Date privMes_SendTime,String privMes_type){

		Priv_messageVO priv_messageVO = new Priv_messageVO();

		priv_messageVO.setPrivMes_Id(privMes_Id);
		priv_messageVO.setPrivMesSend_MemId(privMesSend_MemId);
		priv_messageVO.setPrivMesRec_MemId(privMesRec_MemId);
		priv_messageVO.setPrivMes_content(privMes_content);
		priv_messageVO.setPrivMes_SendTime(privMes_SendTime);
		priv_messageVO.setPrivMes_type(privMes_type);

		dao.update(priv_messageVO);

		return priv_messageVO;
	}

	//====以下是delete方法====
	public void deletePriv_message(String  privMes_Id){
		dao.delete(privMes_Id);
	}

	//====以下是getOne方法====
	public Priv_messageVO getOnePriv_message(String  privMes_Id){
		return dao.findByPrimaryKey(privMes_Id);
	}

	//====以下是getAll方法====
	public List<Priv_messageVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<Priv_messageVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<Priv_messageVO> getPriv_messagesByMem_Id(String privMesSend_MemId) {
        return dao.getPriv_messagesByMem_Id(privMesSend_MemId);
    }

    //====以下是getSet方法====
    public Set<Priv_messageVO> getPriv_messagesByMem_Id2(String privMesRec_MemId) {
        return dao.getPriv_messagesByMem_Id2(privMesRec_MemId);
    }
}

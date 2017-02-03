package com.second_prodmsg.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:二手商品留言<br>
 *	英文:second_ProdMsg<br>
 */ 
public class Second_ProdMsgService{
	private Second_ProdMsgDAO_interface dao; 

	public Second_ProdMsgService(){
		dao = new Second_ProdMsgDAO();
	}

	//====以下是insert方法====
	public Second_ProdMsgVO addSecond_ProdMsg(String second_Prod_Id,String mem_Id,String second_ProdMsg_Msg,java.sql.Date second_ProdMsg_DATE,java.sql.Date second_ProdMsg_adp_upDate){
		Second_ProdMsgVO second_prodmsgVO = new Second_ProdMsgVO();

		second_prodmsgVO.setSecond_Prod_Id(second_Prod_Id);
		second_prodmsgVO.setMem_Id(mem_Id);
		second_prodmsgVO.setSecond_ProdMsg_Msg(second_ProdMsg_Msg);
		second_prodmsgVO.setSecond_ProdMsg_DATE(second_ProdMsg_DATE);
		second_prodmsgVO.setSecond_ProdMsg_adp_upDate(second_ProdMsg_adp_upDate);

		dao.insert(second_prodmsgVO);

		return second_prodmsgVO;
	}

	//====以下是update方法====
	public Second_ProdMsgVO updateSecond_ProdMsg(String second_ProdMsg_Id,String second_Prod_Id,String mem_Id,String second_ProdMsg_Msg,java.sql.Date second_ProdMsg_DATE,java.sql.Date second_ProdMsg_adp_upDate){

		Second_ProdMsgVO second_prodmsgVO = new Second_ProdMsgVO();

		second_prodmsgVO.setSecond_ProdMsg_Id(second_ProdMsg_Id);
		second_prodmsgVO.setSecond_Prod_Id(second_Prod_Id);
		second_prodmsgVO.setMem_Id(mem_Id);
		second_prodmsgVO.setSecond_ProdMsg_Msg(second_ProdMsg_Msg);
		second_prodmsgVO.setSecond_ProdMsg_DATE(second_ProdMsg_DATE);
		second_prodmsgVO.setSecond_ProdMsg_adp_upDate(second_ProdMsg_adp_upDate);

		dao.update(second_prodmsgVO);

		return second_prodmsgVO;
	}

	//====以下是delete方法====
	public void deleteSecond_ProdMsg(String  second_ProdMsg_Id){
		dao.delete(second_ProdMsg_Id);
	}

	//====以下是getOne方法====
	public Second_ProdMsgVO getOneSecond_ProdMsg(String  second_ProdMsg_Id){
		return dao.findByPrimaryKey(second_ProdMsg_Id);
	}

	//====以下是getAll方法====
	public List<Second_ProdMsgVO> getAll(){
		return dao.getAll();
	}
}

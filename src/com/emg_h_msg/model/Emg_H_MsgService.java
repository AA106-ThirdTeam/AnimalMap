package com.emg_h_msg.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:緊急求救留言<br>
 *	英文:emg_H_Msg<br>
 */ 
public class Emg_H_MsgService{
	private Emg_H_MsgDAO_interface dao; 

	public Emg_H_MsgService(){
		dao = new Emg_H_MsgDAO();
	}

	//====以下是insert方法====
	public Emg_H_MsgVO addEmg_H_Msg(String mem_Id,String emg_H_Id,java.sql.Date emg_H_Msg_start,String emg_H_Msg_content){
		Emg_H_MsgVO emg_h_msgVO = new Emg_H_MsgVO();

		emg_h_msgVO.setMem_Id(mem_Id);
		emg_h_msgVO.setEmg_H_Id(emg_H_Id);
		emg_h_msgVO.setEmg_H_Msg_start(emg_H_Msg_start);
		emg_h_msgVO.setEmg_H_Msg_content(emg_H_Msg_content);

		dao.insert(emg_h_msgVO);

		return emg_h_msgVO;
	}

	//====以下是update方法====
	public Emg_H_MsgVO updateEmg_H_Msg(String emg_H_Msg_Id,String mem_Id,String emg_H_Id,java.sql.Date emg_H_Msg_start,String emg_H_Msg_content){

		Emg_H_MsgVO emg_h_msgVO = new Emg_H_MsgVO();

		emg_h_msgVO.setEmg_H_Msg_Id(emg_H_Msg_Id);
		emg_h_msgVO.setMem_Id(mem_Id);
		emg_h_msgVO.setEmg_H_Id(emg_H_Id);
		emg_h_msgVO.setEmg_H_Msg_start(emg_H_Msg_start);
		emg_h_msgVO.setEmg_H_Msg_content(emg_H_Msg_content);

		dao.update(emg_h_msgVO);

		return emg_h_msgVO;
	}

	//====以下是delete方法====
	public void deleteEmg_H_Msg(String  emg_H_Msg_Id){
		dao.delete(emg_H_Msg_Id);
	}

	//====以下是getOne方法====
	public Emg_H_MsgVO getOneEmg_H_Msg(String  emg_H_Msg_Id){
		return dao.findByPrimaryKey(emg_H_Msg_Id);
	}

	//====以下是getAll方法====
	public List<Emg_H_MsgVO> getAll(){
		return dao.getAll();
	}
}

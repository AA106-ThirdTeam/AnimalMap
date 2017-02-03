package com.stray_ani_message.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:社區流浪動物留言<br>
 *	英文:stray_Ani_message<br>
 */ 
public class Stray_Ani_messageService{
	private Stray_Ani_messageDAO_interface dao; 

	public Stray_Ani_messageService(){
		dao = new Stray_Ani_messageDAO();
	}

	//====以下是insert方法====
	public Stray_Ani_messageVO addStray_Ani_message(String stray_Ani_Id,String mem_Id,java.sql.Date str_Ani_Mes_time,String str_Ani_Mes){
		Stray_Ani_messageVO stray_ani_messageVO = new Stray_Ani_messageVO();

		stray_ani_messageVO.setStray_Ani_Id(stray_Ani_Id);
		stray_ani_messageVO.setMem_Id(mem_Id);
		stray_ani_messageVO.setStr_Ani_Mes_time(str_Ani_Mes_time);
		stray_ani_messageVO.setStr_Ani_Mes(str_Ani_Mes);

		dao.insert(stray_ani_messageVO);

		return stray_ani_messageVO;
	}

	//====以下是update方法====
	public Stray_Ani_messageVO updateStray_Ani_message(String str_Ani_Mes_No,String stray_Ani_Id,String mem_Id,java.sql.Date str_Ani_Mes_time,String str_Ani_Mes){

		Stray_Ani_messageVO stray_ani_messageVO = new Stray_Ani_messageVO();

		stray_ani_messageVO.setStr_Ani_Mes_No(str_Ani_Mes_No);
		stray_ani_messageVO.setStray_Ani_Id(stray_Ani_Id);
		stray_ani_messageVO.setMem_Id(mem_Id);
		stray_ani_messageVO.setStr_Ani_Mes_time(str_Ani_Mes_time);
		stray_ani_messageVO.setStr_Ani_Mes(str_Ani_Mes);

		dao.update(stray_ani_messageVO);

		return stray_ani_messageVO;
	}

	//====以下是delete方法====
	public void deleteStray_Ani_message(String  str_Ani_Mes_No){
		dao.delete(str_Ani_Mes_No);
	}

	//====以下是getOne方法====
	public Stray_Ani_messageVO getOneStray_Ani_message(String  str_Ani_Mes_No){
		return dao.findByPrimaryKey(str_Ani_Mes_No);
	}

	//====以下是getAll方法====
	public List<Stray_Ani_messageVO> getAll(){
		return dao.getAll();
	}
}

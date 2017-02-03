package com.pet_message.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:自家寵物留言<br>
 *	英文:pet_Message<br>
 */ 
public class Pet_MessageService{
	private Pet_MessageDAO_interface dao; 

	public Pet_MessageService(){
		dao = new Pet_MessageDAO();
	}

	//====以下是insert方法====
	public Pet_MessageVO addPet_Message(String pet_Id,String mem_Id,String pet_Mes,java.sql.Date pet_Mes_time){
		Pet_MessageVO pet_messageVO = new Pet_MessageVO();

		pet_messageVO.setPet_Id(pet_Id);
		pet_messageVO.setMem_Id(mem_Id);
		pet_messageVO.setPet_Mes(pet_Mes);
		pet_messageVO.setPet_Mes_time(pet_Mes_time);

		dao.insert(pet_messageVO);

		return pet_messageVO;
	}

	//====以下是update方法====
	public Pet_MessageVO updatePet_Message(String pet_Mes_No,String pet_Id,String mem_Id,String pet_Mes,java.sql.Date pet_Mes_time){

		Pet_MessageVO pet_messageVO = new Pet_MessageVO();

		pet_messageVO.setPet_Mes_No(pet_Mes_No);
		pet_messageVO.setPet_Id(pet_Id);
		pet_messageVO.setMem_Id(mem_Id);
		pet_messageVO.setPet_Mes(pet_Mes);
		pet_messageVO.setPet_Mes_time(pet_Mes_time);

		dao.update(pet_messageVO);

		return pet_messageVO;
	}

	//====以下是delete方法====
	public void deletePet_Message(String  pet_Mes_No){
		dao.delete(pet_Mes_No);
	}

	//====以下是getOne方法====
	public Pet_MessageVO getOnePet_Message(String  pet_Mes_No){
		return dao.findByPrimaryKey(pet_Mes_No);
	}

	//====以下是getAll方法====
	public List<Pet_MessageVO> getAll(){
		return dao.getAll();
	}
}

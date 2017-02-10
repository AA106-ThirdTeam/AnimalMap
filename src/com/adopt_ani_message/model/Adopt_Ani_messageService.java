package com.adopt_ani_message.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:送養動物留言<br>
 *	英文:adopt_Ani_message<br>
 */ 
public class Adopt_Ani_messageService{
	private Adopt_Ani_messageDAO_interface dao; 

	public Adopt_Ani_messageService(){
		dao = new Adopt_Ani_messageDAO();
	}

	//====以下是insert方法====
	public Adopt_Ani_messageVO addAdopt_Ani_message(String adopt_Ani_Id,String mem_Id,String ado_Ani_Mes,java.sql.Date ado_Ani_Mes_time){
		Adopt_Ani_messageVO adopt_ani_messageVO = new Adopt_Ani_messageVO();

		adopt_ani_messageVO.setAdopt_Ani_Id(adopt_Ani_Id);
		adopt_ani_messageVO.setMem_Id(mem_Id);
		adopt_ani_messageVO.setAdo_Ani_Mes(ado_Ani_Mes);
		adopt_ani_messageVO.setAdo_Ani_Mes_time(ado_Ani_Mes_time);

		dao.insert(adopt_ani_messageVO);

		return adopt_ani_messageVO;
	}

	//====以下是update方法====
	public Adopt_Ani_messageVO updateAdopt_Ani_message(String ado_Ani_Mes_No,String adopt_Ani_Id,String mem_Id,String ado_Ani_Mes,java.sql.Date ado_Ani_Mes_time){

		Adopt_Ani_messageVO adopt_ani_messageVO = new Adopt_Ani_messageVO();

		adopt_ani_messageVO.setAdo_Ani_Mes_No(ado_Ani_Mes_No);
		adopt_ani_messageVO.setAdopt_Ani_Id(adopt_Ani_Id);
		adopt_ani_messageVO.setMem_Id(mem_Id);
		adopt_ani_messageVO.setAdo_Ani_Mes(ado_Ani_Mes);
		adopt_ani_messageVO.setAdo_Ani_Mes_time(ado_Ani_Mes_time);

		dao.update(adopt_ani_messageVO);

		return adopt_ani_messageVO;
	}

	//====以下是delete方法====
	public void deleteAdopt_Ani_message(String  ado_Ani_Mes_No){
		dao.delete(ado_Ani_Mes_No);
	}

	//====以下是getOne方法====
	public Adopt_Ani_messageVO getOneAdopt_Ani_message(String  ado_Ani_Mes_No){
		return dao.findByPrimaryKey(ado_Ani_Mes_No);
	}

	//====以下是getAll方法====
	public List<Adopt_Ani_messageVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<Adopt_Ani_messageVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<Adopt_Ani_messageVO> getAdopt_Ani_messagesByAdopt_Ani_Id(String adopt_Ani_Id) {
        return dao.getAdopt_Ani_messagesByAdopt_Ani_Id(adopt_Ani_Id);
    }

    //====以下是getSet方法====
    public Set<Adopt_Ani_messageVO> getAdopt_Ani_messagesByMem_Id(String mem_Id) {
        return dao.getAdopt_Ani_messagesByMem_Id(mem_Id);
    }
}

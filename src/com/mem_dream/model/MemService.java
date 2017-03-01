package com.mem_dream.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:一般會員<br>
 *	英文:mem<br>
 */ 
public class MemService{
	private MemDAO_interface dao; 

	public MemService(){
		dao = new MemDAO();
	}

	//====以下是insert方法====
	public MemVO addMem(String mem_account,String mem_Psw,String mem_nick_name,String mem_name,String mem_gender,String mem_Tw_Id,java.sql.Date mem_birth_date,String mem_phone,String mem_Intro,byte[] mem_profile,String mem_black_list,String mem_permission,String mem_setting,Integer mem_balance){
		MemVO memVO = new MemVO();

		memVO.setMem_account(mem_account);
		memVO.setMem_Psw(mem_Psw);
		memVO.setMem_nick_name(mem_nick_name);
		memVO.setMem_name(mem_name);
		memVO.setMem_gender(mem_gender);
		memVO.setMem_Tw_Id(mem_Tw_Id);
		memVO.setMem_birth_date(mem_birth_date);
		memVO.setMem_phone(mem_phone);
		memVO.setMem_Intro(mem_Intro);
		memVO.setMem_profile(mem_profile);
		memVO.setMem_black_list(mem_black_list);
		memVO.setMem_permission(mem_permission);
		memVO.setMem_setting(mem_setting);
		memVO.setMem_balance(mem_balance);

		dao.insert(memVO);

		return memVO;
	}

	//====以下是update方法====
	public MemVO updateMem(String mem_Id,String mem_account,String mem_Psw,String mem_nick_name,String mem_name,String mem_gender,String mem_Tw_Id,java.sql.Date mem_birth_date,String mem_phone,String mem_Intro,byte[] mem_profile,String mem_black_list,String mem_permission,String mem_setting,Integer mem_balance){

		MemVO memVO = new MemVO();

		memVO.setMem_Id(mem_Id);
		memVO.setMem_account(mem_account);
		memVO.setMem_Psw(mem_Psw);
		memVO.setMem_nick_name(mem_nick_name);
		memVO.setMem_name(mem_name);
		memVO.setMem_gender(mem_gender);
		memVO.setMem_Tw_Id(mem_Tw_Id);
		memVO.setMem_birth_date(mem_birth_date);
		memVO.setMem_phone(mem_phone);
		memVO.setMem_Intro(mem_Intro);
		memVO.setMem_profile(mem_profile);
		memVO.setMem_black_list(mem_black_list);
		memVO.setMem_permission(mem_permission);
		memVO.setMem_setting(mem_setting);
		memVO.setMem_balance(mem_balance);

		dao.update(memVO);

		return memVO;
	}

	//====以下是delete方法====
	public void deleteMem(String  mem_Id){
		dao.delete(mem_Id);
	}

	//====以下是getOne方法====
	public MemVO getOneMem(String  mem_Id){
		return dao.findByPrimaryKey(mem_Id);
	}

	//====以下是getAll方法====
	public List<MemVO> getAll(){
		return dao.getAll();
	}
}

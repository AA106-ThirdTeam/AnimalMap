package com.emp.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:員工<br>
 *	英文:emp<br>
 */ 
public class EmpService{
	private EmpDAO_interface dao; 

	public EmpService(){
		dao = new EmpDAO();
	}

	//====以下是insert方法====
	public EmpVO addEmp(String emp_name,String emp_Pw,String emp_email,String emp_Id,java.sql.Date emp_birthday,String emp_phone,String emp_address,String emp_status,byte[] emp_picture,String emp_Pic_format,java.sql.Date emp_hiredate,java.sql.Date emp_firedate){
		EmpVO empVO = new EmpVO();

		empVO.setEmp_name(emp_name);
		empVO.setEmp_Pw(emp_Pw);
		empVO.setEmp_email(emp_email);
		empVO.setEmp_Id(emp_Id);
		empVO.setEmp_birthday(emp_birthday);
		empVO.setEmp_phone(emp_phone);
		empVO.setEmp_address(emp_address);
		empVO.setEmp_status(emp_status);
		empVO.setEmp_picture(emp_picture);
		empVO.setEmp_Pic_format(emp_Pic_format);
		empVO.setEmp_hiredate(emp_hiredate);
		empVO.setEmp_firedate(emp_firedate);

		dao.insert(empVO);

		return empVO;
	}

	//====以下是update方法====
	public EmpVO updateEmp(String emp_No,String emp_name,String emp_Pw,String emp_email,String emp_Id,java.sql.Date emp_birthday,String emp_phone,String emp_address,String emp_status,byte[] emp_picture,String emp_Pic_format,java.sql.Date emp_hiredate,java.sql.Date emp_firedate){

		EmpVO empVO = new EmpVO();

		empVO.setEmp_No(emp_No);
		empVO.setEmp_name(emp_name);
		empVO.setEmp_Pw(emp_Pw);
		empVO.setEmp_email(emp_email);
		empVO.setEmp_Id(emp_Id);
		empVO.setEmp_birthday(emp_birthday);
		empVO.setEmp_phone(emp_phone);
		empVO.setEmp_address(emp_address);
		empVO.setEmp_status(emp_status);
		empVO.setEmp_picture(emp_picture);
		empVO.setEmp_Pic_format(emp_Pic_format);
		empVO.setEmp_hiredate(emp_hiredate);
		empVO.setEmp_firedate(emp_firedate);

		dao.update(empVO);

		return empVO;
	}

	//====以下是delete方法====
	public void deleteEmp(String  emp_No){
		dao.delete(emp_No);
	}

	//====以下是getOne方法====
	public EmpVO getOneEmp(String  emp_No){
		return dao.findByPrimaryKey(emp_No);
	}

	//====以下是getAll方法====
	public List<EmpVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<EmpVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}
}

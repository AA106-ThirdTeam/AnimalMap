package com.emp_purview.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:員工權限<br>
 *	英文:emp_purview<br>
 */ 
public class Emp_purviewService{
	private Emp_purviewDAO_interface dao; 

	public Emp_purviewService(){
		dao = new Emp_purviewDAO();
	}

	//====以下是insert方法====
	public Emp_purviewVO addEmp_purview(){
		Emp_purviewVO emp_purviewVO = new Emp_purviewVO();


		dao.insert(emp_purviewVO);

		return emp_purviewVO;
	}

	//====以下是update方法====
	public Emp_purviewVO updateEmp_purview(String emp_No,String purview_No){

		Emp_purviewVO emp_purviewVO = new Emp_purviewVO();

		emp_purviewVO.setEmp_No(emp_No);
		emp_purviewVO.setPurview_No(purview_No);

		dao.update(emp_purviewVO);

		return emp_purviewVO;
	}

	//====以下是delete方法====
	public void deleteEmp_purview_By_emp_No(String  emp_No){
		dao.delete_By_emp_No(emp_No);
	}

	public void deleteEmp_purview_By_purview_No(String  purview_No){
		dao.delete_By_purview_No(purview_No);
	}

	//====以下是getOne方法====
	public Emp_purviewVO getOneEmp_purview_By_emp_No(String  emp_No){
		return dao.findByPrimaryKey_By_emp_No(emp_No);
	}

	public Emp_purviewVO getOneEmp_purview_By_purview_No(String  purview_No){
		return dao.findByPrimaryKey_By_purview_No(purview_No);
	}

	//====以下是getAll方法====
	public List<Emp_purviewVO> getAll(){
		return dao.getAll();
	}
}

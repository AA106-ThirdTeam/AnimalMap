package com.emp.model;

import java.util.List;

public class EmpService {

	private EmpDAO_interface dao;

	public EmpService() {
		dao = new EmpDAO();
	}

	public EmpVO addEmp(String emp_Name, String emp_Pw, String emp_email, String emp_Id, java.sql.Date emp_birthday,
			String emp_phone, String emp_address, String emp_status,byte[] emp_picture,java.sql.Date emp_hiredate) {

		EmpVO empVO = new EmpVO();

		empVO.setEmp_name(emp_Name);
		empVO.setEmp_Pw(emp_Pw);
		empVO.setEmp_email(emp_email);
		empVO.setEmp_Id(emp_Id);
		empVO.setEmp_birthday(emp_birthday);
		empVO.setEmp_phone(emp_phone);
		empVO.setEmp_address(emp_address);
		empVO.setEmp_status(emp_status);
		empVO.setEmp_picture(emp_picture);		
		empVO.setEmp_hiredate(emp_hiredate);
		
		dao.insert(empVO);

		return empVO;
	}

	public EmpVO updateEmp(String emp_No,String emp_Name, String emp_Pw, String emp_email, String emp_Id, java.sql.Date emp_birthday,
			String emp_phone, String emp_address, String emp_status,byte[] emp_picture,java.sql.Date emp_hiredate, java.sql.Date emp_firedate) {

		EmpVO empVO = new EmpVO();
		
		empVO.setEmp_No(emp_No);
		empVO.setEmp_name(emp_Name);
		empVO.setEmp_Pw(emp_Pw);
		empVO.setEmp_email(emp_email);
		empVO.setEmp_Id(emp_Id);
		empVO.setEmp_birthday(emp_birthday);
		empVO.setEmp_phone(emp_phone);
		empVO.setEmp_address(emp_address);
		empVO.setEmp_status(emp_status);			
		empVO.setEmp_picture(emp_picture);			
		empVO.setEmp_hiredate(emp_hiredate);
		empVO.setEmp_firedate(emp_firedate);
		dao.update(empVO);

		return empVO;
	}

	
	public EmpVO getOneUserLogin(String emp_email,String emp_Pw){
		return dao.findUserLogin(emp_email, emp_Pw);
	}
	
	
	
	public void deleteEmp(String emp_No) {
		dao.delete(emp_No);
	}

	public EmpVO getOneEmp(String emp_No) {
		return dao.findByPrimaryKey(emp_No);
	}

	public List<EmpVO> getAll() {
		return dao.getAll();
	}
}
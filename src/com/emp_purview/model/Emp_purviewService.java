package com.emp_purview.model;

import java.util.List;
import java.util.Set;

public class Emp_purviewService {

	public Emp_purviewDAO_interface dao;

	public Emp_purviewService() {
		dao = new Emp_purviewDAO();
	}

	public Emp_purviewVO addEmp_purview(String emp_No,  String purview_No)  {

		Emp_purviewVO emp_purviewVO = new Emp_purviewVO();

		emp_purviewVO.setEmp_No(emp_No);
		emp_purviewVO.setPurview_No(purview_No);
		dao.insert(emp_purviewVO);

		return emp_purviewVO;
	}

	public void deleteEmp_purview(String emp_No) {

		dao.delete(emp_No);

	}

	public List<Emp_purviewVO> getAll() {
		return dao.getAll();
	}
	
  public Set<Emp_purviewVO> Emp_purviewByEmp_no(String emp_No){
	  return dao.Emp_purviewByEmp_no(emp_No);
  }

}

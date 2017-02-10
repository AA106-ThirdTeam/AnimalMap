package com.emp_purview.model;

import java.util.*; 

public interface Emp_purviewDAO_interface {
	public void insert(Emp_purviewVO emp_purviewVO);
	public void update(Emp_purviewVO emp_purviewVO);
    public void delete_By_emp_No(String emp_No);
	public Emp_purviewVO findByPrimaryKey_By_emp_No(String emp_No);
    public void delete_By_purview_No(String purview_No);
	public Emp_purviewVO findByPrimaryKey_By_purview_No(String purview_No);
	public List<Emp_purviewVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Emp_purviewVO> getAll(Map<String, String[]> map);

    //查詢某員工權限的員工編號(一對多)(回傳 Set)
    public Set<Emp_purviewVO> getEmp_purviewsByEmp_No(String emp_No);

    //查詢某員工權限的權限編號(一對多)(回傳 Set)
    public Set<Emp_purviewVO> getEmp_purviewsByPurview_No(String purview_No);
}

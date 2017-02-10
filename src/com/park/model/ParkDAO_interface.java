package com.park.model;

import java.util.*; 

public interface ParkDAO_interface {
	public void insert(ParkVO parkVO);
	public void update(ParkVO parkVO);
    public void delete(String park_Id);
	public ParkVO findByPrimaryKey(String park_Id);
	public List<ParkVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<ParkVO> getAll(Map<String, String[]> map);

    //查詢某公園的員工編號(一對多)(回傳 Set)
    public Set<ParkVO> getParksByEmp_No(String emp_Id);
}

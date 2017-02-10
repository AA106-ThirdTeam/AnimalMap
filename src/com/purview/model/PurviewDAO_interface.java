package com.purview.model;

import java.util.*; 

public interface PurviewDAO_interface {
	public void insert(PurviewVO purviewVO);
	public void update(PurviewVO purviewVO);
    public void delete(String purview_No);
	public PurviewVO findByPrimaryKey(String purview_No);
	public List<PurviewVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<PurviewVO> getAll(Map<String, String[]> map);
}

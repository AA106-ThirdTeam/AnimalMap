package com.adp.model;

import java.util.*; 

public interface AdpDAO_interface {
	public void insert(AdpVO adpVO);
	public void update(AdpVO adpVO);
    public void delete(String adp_Id);
	public AdpVO findByPrimaryKey(String adp_Id);
	public List<AdpVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<AdpVO> getAll(Map<String, String[]> map);

    //查詢某領養活動的發布會員編號(一對多)(回傳 Set)
    public Set<AdpVO> getAdpsByMem_Id(String mem_Id);
}

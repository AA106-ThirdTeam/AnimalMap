package com.offimsg.model;

import java.util.*; 

public interface OffiMsgDAO_interface {
	public void insert(OffiMsgVO offimsgVO);
	public void update(OffiMsgVO offimsgVO);
    public void delete(String offiMsg_Id);
	public OffiMsgVO findByPrimaryKey(String offiMsg_Id);
	public List<OffiMsgVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<OffiMsgVO> getAll(Map<String, String[]> map);

    //查詢某公告訊息的發布員工編號(一對多)(回傳 Set)
    public Set<OffiMsgVO> getOffiMsgsByEmp_No(String offiMsg_empId);
}

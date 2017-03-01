package com.offiMsg.model;

import java.util.*;

public interface OffiMsgDAO_interface {

	 public void insert(OffiMsgVO offiMsgVO);
     public void update(OffiMsgVO offiMsgVO);
     public void delete(String offiMsg_Id);
     public OffiMsgVO findByPrimaryKey(String offiMsg_Id);
     public List<OffiMsgVO> getAll();
     //萬用複合查詢(傳入參數型態Map)(回傳 List)
//   public List<OffiMsgVO> getAll(Map<String, String[]> map); 
	
}

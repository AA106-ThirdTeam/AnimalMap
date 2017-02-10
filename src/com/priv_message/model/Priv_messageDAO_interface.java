package com.priv_message.model;

import java.util.*; 

public interface Priv_messageDAO_interface {
	public void insert(Priv_messageVO priv_messageVO);
	public void update(Priv_messageVO priv_messageVO);
    public void delete(String privMes_Id);
	public Priv_messageVO findByPrimaryKey(String privMes_Id);
	public List<Priv_messageVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Priv_messageVO> getAll(Map<String, String[]> map);

    //查詢某私人訊息的發送會員編號(一對多)(回傳 Set)
    public Set<Priv_messageVO> getPriv_messagesByMem_Id(String privMesSend_MemId);

    //查詢某私人訊息的接收會員編號(一對多)(回傳 Set)
    public Set<Priv_messageVO> getPriv_messagesByMem_Id2(String privMesRec_MemId);
}

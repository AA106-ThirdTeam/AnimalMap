package com.adpmsg.model;

import java.util.*; 

public interface AdpMsgDAO_interface {
	public void insert(AdpMsgVO adpmsgVO);
	public void update(AdpMsgVO adpmsgVO);
    public void delete(String adpMsg_Id);
	public AdpMsgVO findByPrimaryKey(String adpMsg_Id);
	public List<AdpMsgVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<AdpMsgVO> getAll(Map<String, String[]> map);

    //查詢某領養活動留言的領養活動編號(一對多)(回傳 Set)
    public Set<AdpMsgVO> getAdpMsgsByAdp_Id(String adp_Id);

    //查詢某領養活動留言的留言會員編號(一對多)(回傳 Set)
    public Set<AdpMsgVO> getAdpMsgsByMem_Id(String mem_Id);
}

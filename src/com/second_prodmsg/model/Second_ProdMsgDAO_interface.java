package com.second_prodmsg.model;

import java.util.*; 

public interface Second_ProdMsgDAO_interface {
	public void insert(Second_ProdMsgVO second_prodmsgVO);
	public void update(Second_ProdMsgVO second_prodmsgVO);
    public void delete(String second_ProdMsg_Id);
	public Second_ProdMsgVO findByPrimaryKey(String second_ProdMsg_Id);
	public List<Second_ProdMsgVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Second_ProdMsgVO> getAll(Map<String, String[]> map);

    //查詢某二手商品留言的二手商品編號(一對多)(回傳 Set)
    public Set<Second_ProdMsgVO> getSecond_ProdMsgsBySecond_Prod_Id(String second_Prod_Id);

    //查詢某二手商品留言的留言會員編號(一對多)(回傳 Set)
    public Set<Second_ProdMsgVO> getSecond_ProdMsgsByMem_Id(String mem_Id);
}

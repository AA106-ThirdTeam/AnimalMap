package com.shop_comment.model;

import java.util.*; 

public interface Shop_commentDAO_interface {
	public void insert(Shop_commentVO shop_commentVO);
	public void update(Shop_commentVO shop_commentVO);
    public void delete(String shopComment_Id);
	public Shop_commentVO findByPrimaryKey(String shopComment_Id);
	public List<Shop_commentVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Shop_commentVO> getAll(Map<String, String[]> map);

    //查詢某商家留言的發送會員編號(一對多)(回傳 Set)
    public Set<Shop_commentVO> getShop_commentsByMem_Id(String shopComment_MemId);

    //查詢某商家留言的商店編號(一對多)(回傳 Set)
    public Set<Shop_commentVO> getShop_commentsByShop_Id(String shopComment_ShopId);
}

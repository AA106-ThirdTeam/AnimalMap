package com.orders_item.model;

import java.util.*; 

public interface Orders_itemDAO_interface {
	public void insert(Orders_itemVO orders_itemVO);
	public void update(Orders_itemVO orders_itemVO);
    public void delete_By_orders_no(String orders_no);
	public Orders_itemVO findByPrimaryKey_By_orders_no(String orders_no);
    public void delete_By_product_no(String product_no);
	public Orders_itemVO findByPrimaryKey_By_product_no(String product_no);
	public List<Orders_itemVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Orders_itemVO> getAll(Map<String, String[]> map);

    //查詢某訂單明細的訂單編號(一對多)(回傳 Set)
    public Set<Orders_itemVO> getOrders_itemsByOrders_no(String orders_no);

    //查詢某訂單明細的商品編號(一對多)(回傳 Set)
    public Set<Orders_itemVO> getOrders_itemsByProduct_no(String product_no);
}

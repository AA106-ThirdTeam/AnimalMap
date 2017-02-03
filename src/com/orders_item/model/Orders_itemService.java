package com.orders_item.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:訂單明細<br>
 *	英文:orders_item<br>
 */ 
public class Orders_itemService{
	private Orders_itemDAO_interface dao; 

	public Orders_itemService(){
		dao = new Orders_itemDAO();
	}

	//====以下是insert方法====
	public Orders_itemVO addOrders_item(Integer commodities_amout,Integer selling_price){
		Orders_itemVO orders_itemVO = new Orders_itemVO();

		orders_itemVO.setCommodities_amout(commodities_amout);
		orders_itemVO.setSelling_price(selling_price);

		dao.insert(orders_itemVO);

		return orders_itemVO;
	}

	//====以下是update方法====
	public Orders_itemVO updateOrders_item(String orders_no,String product_no,Integer commodities_amout,Integer selling_price){

		Orders_itemVO orders_itemVO = new Orders_itemVO();

		orders_itemVO.setOrders_no(orders_no);
		orders_itemVO.setProduct_no(product_no);
		orders_itemVO.setCommodities_amout(commodities_amout);
		orders_itemVO.setSelling_price(selling_price);

		dao.update(orders_itemVO);

		return orders_itemVO;
	}

	//====以下是delete方法====
	public void deleteOrders_item_By_orders_no(String  orders_no){
		dao.delete_By_orders_no(orders_no);
	}

	public void deleteOrders_item_By_product_no(String  product_no){
		dao.delete_By_product_no(product_no);
	}

	//====以下是getOne方法====
	public Orders_itemVO getOneOrders_item_By_orders_no(String  orders_no){
		return dao.findByPrimaryKey_By_orders_no(orders_no);
	}

	public Orders_itemVO getOneOrders_item_By_product_no(String  product_no){
		return dao.findByPrimaryKey_By_product_no(product_no);
	}

	//====以下是getAll方法====
	public List<Orders_itemVO> getAll(){
		return dao.getAll();
	}
}

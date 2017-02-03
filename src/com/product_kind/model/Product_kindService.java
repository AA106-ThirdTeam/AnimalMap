package com.product_kind.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:商品類別<br>
 *	英文:product_kind<br>
 */ 
public class Product_kindService{
	private Product_kindDAO_interface dao; 

	public Product_kindService(){
		dao = new Product_kindDAO();
	}

	//====以下是insert方法====
	public Product_kindVO addProduct_kind(String product_kind_name){
		Product_kindVO product_kindVO = new Product_kindVO();

		product_kindVO.setProduct_kind_name(product_kind_name);

		dao.insert(product_kindVO);

		return product_kindVO;
	}

	//====以下是update方法====
	public Product_kindVO updateProduct_kind(String product_kind_no,String product_kind_name){

		Product_kindVO product_kindVO = new Product_kindVO();

		product_kindVO.setProduct_kind_no(product_kind_no);
		product_kindVO.setProduct_kind_name(product_kind_name);

		dao.update(product_kindVO);

		return product_kindVO;
	}

	//====以下是delete方法====
	public void deleteProduct_kind(String  product_kind_no){
		dao.delete(product_kind_no);
	}

	//====以下是getOne方法====
	public Product_kindVO getOneProduct_kind(String  product_kind_no){
		return dao.findByPrimaryKey(product_kind_no);
	}

	//====以下是getAll方法====
	public List<Product_kindVO> getAll(){
		return dao.getAll();
	}
}

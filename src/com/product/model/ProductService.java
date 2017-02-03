package com.product.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:商品<br>
 *	英文:product<br>
 */ 
public class ProductService{
	private ProductDAO_interface dao; 

	public ProductService(){
		dao = new ProductDAO();
	}

	//====以下是insert方法====
	public ProductVO addProduct(String product_name,String product_introduction,Integer product_price,Integer product_stock,byte[] product_picture_large,byte[] product_picture_small,Integer product_status,java.sql.Date product_create_date,String product_info,Integer product_kind_no){
		ProductVO productVO = new ProductVO();

		productVO.setProduct_name(product_name);
		productVO.setProduct_introduction(product_introduction);
		productVO.setProduct_price(product_price);
		productVO.setProduct_stock(product_stock);
		productVO.setProduct_picture_large(product_picture_large);
		productVO.setProduct_picture_small(product_picture_small);
		productVO.setProduct_status(product_status);
		productVO.setProduct_create_date(product_create_date);
		productVO.setProduct_info(product_info);
		productVO.setProduct_kind_no(product_kind_no);

		dao.insert(productVO);

		return productVO;
	}

	//====以下是update方法====
	public ProductVO updateProduct(String product_no,String product_name,String product_introduction,Integer product_price,Integer product_stock,byte[] product_picture_large,byte[] product_picture_small,Integer product_status,java.sql.Date product_create_date,String product_info,Integer product_kind_no){

		ProductVO productVO = new ProductVO();

		productVO.setProduct_no(product_no);
		productVO.setProduct_name(product_name);
		productVO.setProduct_introduction(product_introduction);
		productVO.setProduct_price(product_price);
		productVO.setProduct_stock(product_stock);
		productVO.setProduct_picture_large(product_picture_large);
		productVO.setProduct_picture_small(product_picture_small);
		productVO.setProduct_status(product_status);
		productVO.setProduct_create_date(product_create_date);
		productVO.setProduct_info(product_info);
		productVO.setProduct_kind_no(product_kind_no);

		dao.update(productVO);

		return productVO;
	}

	//====以下是delete方法====
	public void deleteProduct(String  product_no){
		dao.delete(product_no);
	}

	//====以下是getOne方法====
	public ProductVO getOneProduct(String  product_no){
		return dao.findByPrimaryKey(product_no);
	}

	//====以下是getAll方法====
	public List<ProductVO> getAll(){
		return dao.getAll();
	}
}

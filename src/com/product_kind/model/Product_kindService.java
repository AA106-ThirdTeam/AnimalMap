package com.product_kind.model;

import java.util.List;
import java.util.Set;
import com.product.model.ProductVO;

public class Product_kindService {
	
	private Product_kindDAO_interface dao;
	
	public Product_kindService(){
		dao = new Product_kindDAO();
	}
	
	public List<Product_kindVO> getAll(){
		return dao.getAll();
	}
	
	public Product_kindVO getOneProduct_kind(String product_kind_no){
		return dao.findByPrimaryKey(product_kind_no);
	}
	
	public Set<ProductVO> getProductsByProduct_kind_no(String product_kind_no){
		return dao.getProductsByProduct_kind_no(product_kind_no);
	}
	
	public void deleteProduct_kind(String product_kind_no){
		dao.delete(product_kind_no);
	}
}

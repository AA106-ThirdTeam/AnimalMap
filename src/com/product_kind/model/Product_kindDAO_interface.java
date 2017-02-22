package com.product_kind.model;

import java.util.*;
import com.product.model.ProductVO;


public interface Product_kindDAO_interface {
		public void insert(Product_kindVO product_kindVO);
		public void update(Product_kindVO product_kindVO);
		public void delete(String product_kind_no);
		public Product_kindVO findByPrimaryKey(String product_kind_no);
		public List<Product_kindVO> getAll();

		public Set<ProductVO> getProductsByProduct_kind_no(String product_kind_no);
		
}

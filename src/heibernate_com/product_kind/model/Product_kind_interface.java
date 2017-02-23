package heibernate_com.product_kind.model;
import java.util.*;
public interface Product_kind_interface {
          public void insert(Product_kindVO product_kindVO);
          public void update(Product_kindVO product_kindVO);
          public void delete(String product_kind_no);
          public Product_kindVO findByPrimaryKey(String product_kind_no);
          public List<Product_kindVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<Product_kindVO> getAll(Map<String, String[]> map); 
}

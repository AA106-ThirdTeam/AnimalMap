package heibernate_com.orders_item.model;
import java.util.*;
public interface Orders_item_interface {
          public void insert(Orders_itemVO orders_itemVO);
          public void update(Orders_itemVO orders_itemVO);
          public void delete(String orders_no);
          public Orders_itemVO findByPrimaryKey(String orders_no);
          public List<Orders_itemVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<Orders_itemVO> getAll(Map<String, String[]> map,boolean able_like); 
}

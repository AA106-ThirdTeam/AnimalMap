package heibernate_com.orders.model;
import java.util.*;
public interface Orders_interface {
          public void insert(OrdersVO ordersVO);
          public void update(OrdersVO ordersVO);
          public void delete(String orders_no);
          public OrdersVO findByPrimaryKey(String orders_no);
          public List<OrdersVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<OrdersVO> getAll(Map<String, String[]> map,boolean able_like); 
}

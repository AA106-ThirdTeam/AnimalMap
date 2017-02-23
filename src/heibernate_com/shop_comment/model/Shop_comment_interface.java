package heibernate_com.shop_comment.model;
import java.util.*;
public interface Shop_comment_interface {
          public void insert(Shop_commentVO shop_commentVO);
          public void update(Shop_commentVO shop_commentVO);
          public void delete(String shopComment_Id);
          public Shop_commentVO findByPrimaryKey(String shopComment_Id);
          public List<Shop_commentVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<Shop_commentVO> getAll(Map<String, String[]> map); 
}

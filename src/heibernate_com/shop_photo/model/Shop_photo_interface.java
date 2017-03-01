package heibernate_com.shop_photo.model;
import java.util.*;
public interface Shop_photo_interface {
          public void insert(Shop_photoVO shop_photoVO);
          public void update(Shop_photoVO shop_photoVO);
          public void delete(String shopPhoto_Id);
          public Shop_photoVO findByPrimaryKey(String shopPhoto_Id);
          public List<Shop_photoVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<Shop_photoVO> getAll(Map<String, String[]> map,boolean able_like); 
}

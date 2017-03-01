package heibernate_com.shopphoto.model;
import java.util.*;
public interface ShopPhoto_interface {
          public void insert(ShopPhotoVO shopphotoVO);
          public void update(ShopPhotoVO shopphotoVO);
          public void delete(String shopPhoto_Id);
          public ShopPhotoVO findByPrimaryKey(String shopPhoto_Id);
          public List<ShopPhotoVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<ShopPhotoVO> getAll(Map<String, String[]> map,boolean able_like); 
}

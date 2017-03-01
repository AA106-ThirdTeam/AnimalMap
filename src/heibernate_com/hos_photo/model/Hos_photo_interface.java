package heibernate_com.hos_photo.model;
import java.util.*;
public interface Hos_photo_interface {
          public void insert(Hos_photoVO hos_photoVO);
          public void update(Hos_photoVO hos_photoVO);
          public void delete(String hosPhoto_Id);
          public Hos_photoVO findByPrimaryKey(String hosPhoto_Id);
          public List<Hos_photoVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<Hos_photoVO> getAll(Map<String, String[]> map,boolean able_like); 
}

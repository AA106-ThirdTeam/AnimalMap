package heibernate_com.hosphoto.model;
import java.util.*;
public interface HosPhoto_interface {
          public void insert(HosPhotoVO hosphotoVO);
          public void update(HosPhotoVO hosphotoVO);
          public void delete(String hosPhoto_Id);
          public HosPhotoVO findByPrimaryKey(String hosPhoto_Id);
          public List<HosPhotoVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<HosPhotoVO> getAll(Map<String, String[]> map); 
}

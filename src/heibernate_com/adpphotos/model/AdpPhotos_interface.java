package heibernate_com.adpphotos.model;
import java.util.*;
public interface AdpPhotos_interface {
          public void insert(AdpPhotosVO adpphotosVO);
          public void update(AdpPhotosVO adpphotosVO);
          public void delete(String adpPhotos_Id);
          public AdpPhotosVO findByPrimaryKey(String adpPhotos_Id);
          public List<AdpPhotosVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<AdpPhotosVO> getAll(Map<String, String[]> map); 
}

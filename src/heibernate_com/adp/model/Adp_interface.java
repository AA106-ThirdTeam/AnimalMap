package heibernate_com.adp.model;
import java.util.*;
public interface Adp_interface {
          public void insert(AdpVO adpVO);
          public void update(AdpVO adpVO);
          public void delete(String adp_Id);
          public AdpVO findByPrimaryKey(String adp_Id);
          public List<AdpVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<AdpVO> getAll(Map<String, String[]> map,boolean able_like); 
}

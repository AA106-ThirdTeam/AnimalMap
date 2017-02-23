package heibernate_com.adoanispo.model;
import java.util.*;
public interface AdoAniSpo_interface {
          public void insert(AdoAniSpoVO adoanispoVO);
          public void update(AdoAniSpoVO adoanispoVO);
          public void delete(String adoAniSpoNo);
          public AdoAniSpoVO findByPrimaryKey(String adoAniSpoNo);
          public List<AdoAniSpoVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<AdoAniSpoVO> getAll(Map<String, String[]> map); 
}

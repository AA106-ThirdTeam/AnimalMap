package heibernate_com.adopt_ani_sponsor.model;
import java.util.*;
public interface Adopt_Ani_sponsor_interface {
          public void insert(Adopt_Ani_sponsorVO adopt_ani_sponsorVO);
          public void update(Adopt_Ani_sponsorVO adopt_ani_sponsorVO);
          public void delete(String ado_Ani_Spo_No);
          public Adopt_Ani_sponsorVO findByPrimaryKey(String ado_Ani_Spo_No);
          public List<Adopt_Ani_sponsorVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<Adopt_Ani_sponsorVO> getAll(Map<String, String[]> map,boolean able_like); 
}

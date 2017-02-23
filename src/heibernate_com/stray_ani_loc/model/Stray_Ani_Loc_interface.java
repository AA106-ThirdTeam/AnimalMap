package heibernate_com.stray_ani_loc.model;
import java.util.*;
public interface Stray_Ani_Loc_interface {
          public void insert(Stray_Ani_LocVO stray_ani_locVO);
          public void update(Stray_Ani_LocVO stray_ani_locVO);
          public void delete(String str_Ani_Loc_No);
          public Stray_Ani_LocVO findByPrimaryKey(String str_Ani_Loc_No);
          public List<Stray_Ani_LocVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<Stray_Ani_LocVO> getAll(Map<String, String[]> map); 
}

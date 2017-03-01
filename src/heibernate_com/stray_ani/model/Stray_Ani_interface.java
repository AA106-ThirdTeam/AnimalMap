package heibernate_com.stray_ani.model;
import java.util.*;
public interface Stray_Ani_interface {
          public void insert(Stray_AniVO stray_aniVO);
          public void update(Stray_AniVO stray_aniVO);
          public void delete(String stray_Ani_Id);
          public Stray_AniVO findByPrimaryKey(String stray_Ani_Id);
          public List<Stray_AniVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<Stray_AniVO> getAll(Map<String, String[]> map,boolean able_like); 
}

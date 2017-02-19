package heibernate_com.stray_ani_photos_h.model;
import java.util.*;
public interface Stray_Ani_photos_H_interface {
          public void insert(Stray_Ani_photos_HVO stray_ani_photos_hVO);
          public void update(Stray_Ani_photos_HVO stray_ani_photos_hVO);
          public void delete(String str_Ani_Pic_No);
          public Stray_Ani_photos_HVO findByPrimaryKey(String str_Ani_Pic_No);
          public List<Stray_Ani_photos_HVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<Stray_Ani_photos_HVO> getAll(Map<String, String[]> map); 
}

package heibernate_com.stray_ani_message.model;
import java.util.*;
public interface Stray_Ani_message_interface {
          public void insert(Stray_Ani_messageVO stray_ani_messageVO);
          public void update(Stray_Ani_messageVO stray_ani_messageVO);
          public void delete(String str_Ani_Mes_No);
          public Stray_Ani_messageVO findByPrimaryKey(String str_Ani_Mes_No);
          public List<Stray_Ani_messageVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<Stray_Ani_messageVO> getAll(Map<String, String[]> map,boolean able_like); 
}

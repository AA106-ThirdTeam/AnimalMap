package heibernate_com.adopt_ani_message.model;
import java.util.*;
public interface Adopt_Ani_message_interface {
          public void insert(Adopt_Ani_messageVO adopt_ani_messageVO);
          public void update(Adopt_Ani_messageVO adopt_ani_messageVO);
          public void delete(String ado_Ani_Mes_No);
          public Adopt_Ani_messageVO findByPrimaryKey(String ado_Ani_Mes_No);
          public List<Adopt_Ani_messageVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<Adopt_Ani_messageVO> getAll(Map<String, String[]> map,boolean able_like); 
}

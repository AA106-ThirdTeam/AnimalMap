package heibernate_com.pet_message.model;
import java.util.*;
public interface Pet_Message_interface {
          public void insert(Pet_MessageVO pet_messageVO);
          public void update(Pet_MessageVO pet_messageVO);
          public void delete(String pet_Mes_No);
          public Pet_MessageVO findByPrimaryKey(String pet_Mes_No);
          public List<Pet_MessageVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<Pet_MessageVO> getAll(Map<String, String[]> map,boolean able_like); 
}

package heibernate_com.priv_message.model;
import java.util.*;
public interface Priv_message_interface {
          public void insert(Priv_messageVO priv_messageVO);
          public void update(Priv_messageVO priv_messageVO);
          public void delete(String privMsg_Id);
          public Priv_messageVO findByPrimaryKey(String privMsg_Id);
          public List<Priv_messageVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<Priv_messageVO> getAll(Map<String, String[]> map); 
}

package heibernate_com.adpmsg.model;
import java.util.*;
public interface AdpMsg_interface {
          public void insert(AdpMsgVO adpmsgVO);
          public void update(AdpMsgVO adpmsgVO);
          public void delete(String adpMsg_Id);
          public AdpMsgVO findByPrimaryKey(String adpMsg_Id);
          public List<AdpMsgVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<AdpMsgVO> getAll(Map<String, String[]> map); 
}

package heibernate_com.second_prodmsg.model;
import java.util.*;
public interface Second_ProdMsg_interface {
          public void insert(Second_ProdMsgVO second_prodmsgVO);
          public void update(Second_ProdMsgVO second_prodmsgVO);
          public void delete(String second_ProdMsg_Id);
          public Second_ProdMsgVO findByPrimaryKey(String second_ProdMsg_Id);
          public List<Second_ProdMsgVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<Second_ProdMsgVO> getAll(Map<String, String[]> map,boolean able_like); 
}

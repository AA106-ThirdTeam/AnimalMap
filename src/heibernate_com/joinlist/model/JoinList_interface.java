package heibernate_com.joinlist.model;
import java.util.*;
public interface JoinList_interface {
          public void insert(JoinListVO joinlistVO);
          public void update(JoinListVO joinlistVO);
          public void delete(String joinList_GrpId);
          public JoinListVO findByPrimaryKey(String joinList_GrpId);
          public List<JoinListVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<JoinListVO> getAll(Map<String, String[]> map); 
}

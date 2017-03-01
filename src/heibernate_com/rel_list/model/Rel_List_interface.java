package heibernate_com.rel_list.model;
import java.util.*;
public interface Rel_List_interface {
          public void insert(Rel_ListVO rel_listVO);
          public void update(Rel_ListVO rel_listVO);
          public void delete(String rel_MemId);
          public Rel_ListVO findByPrimaryKey(String rel_MemId);
          public List<Rel_ListVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<Rel_ListVO> getAll(Map<String, String[]> map,boolean able_like); 
}

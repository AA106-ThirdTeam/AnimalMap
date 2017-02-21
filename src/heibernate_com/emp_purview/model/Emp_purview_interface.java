package heibernate_com.emp_purview.model;
import java.util.*;
public interface Emp_purview_interface {
          public void insert(Emp_purviewVO emp_purviewVO);
          public void update(Emp_purviewVO emp_purviewVO);
          public void delete(String emp_No);
          public Emp_purviewVO findByPrimaryKey(String emp_No);
          public List<Emp_purviewVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<Emp_purviewVO> getAll(Map<String, String[]> map); 
}

package heibernate_com.emp.model;
import java.util.*;
public interface Emp_interface {
          public void insert(EmpVO empVO);
          public void update(EmpVO empVO);
          public void delete(String emp_No);
          public EmpVO findByPrimaryKey(String emp_No);
          public List<EmpVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}

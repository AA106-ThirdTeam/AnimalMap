package heibernate_com.park.model;
import java.util.*;
public interface Park_interface {
          public void insert(ParkVO parkVO);
          public void update(ParkVO parkVO);
          public void delete(Integer park_Id);
          public ParkVO findByPrimaryKey(Integer park_Id);
          public List<ParkVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<ParkVO> getAll(Map<String, String[]> map); 
}

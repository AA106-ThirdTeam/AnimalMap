package heibernate_com.charge.model;
import java.util.*;
public interface Charge_interface {
          public void insert(ChargeVO chargeVO);
          public void update(ChargeVO chargeVO);
          public void delete(String charge_no);
          public ChargeVO findByPrimaryKey(String charge_no);
          public List<ChargeVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<ChargeVO> getAll(Map<String, String[]> map); 
}

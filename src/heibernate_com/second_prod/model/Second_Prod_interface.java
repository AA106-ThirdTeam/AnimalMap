package heibernate_com.second_prod.model;
import java.util.*;
public interface Second_Prod_interface {
          public void insert(Second_ProdVO second_prodVO);
          public void update(Second_ProdVO second_prodVO);
          public void delete(String second_Prod_Id);
          public Second_ProdVO findByPrimaryKey(String second_Prod_Id);
          public List<Second_ProdVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<Second_ProdVO> getAll(Map<String, String[]> map); 
}

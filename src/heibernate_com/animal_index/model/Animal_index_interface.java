package heibernate_com.animal_index.model;
import java.util.*;
public interface Animal_index_interface {
          public void insert(Animal_indexVO animal_indexVO);
          public void update(Animal_indexVO animal_indexVO);
          public void delete(String animal_No);
          public Animal_indexVO findByPrimaryKey(String animal_No);
          public List<Animal_indexVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<Animal_indexVO> getAll(Map<String, String[]> map); 
}

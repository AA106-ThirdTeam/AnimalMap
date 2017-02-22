package heibernate_com.pet_group.model;
import java.util.*;
public interface Pet_group_interface {
          public void insert(Pet_groupVO pet_groupVO);
          public void update(Pet_groupVO pet_groupVO);
          public void delete(String grp_Id);
          public Pet_groupVO findByPrimaryKey(String grp_Id);
          public List<Pet_groupVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<Pet_groupVO> getAll(Map<String, String[]> map); 
}

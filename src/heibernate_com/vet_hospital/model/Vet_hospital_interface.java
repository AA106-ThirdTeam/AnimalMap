package heibernate_com.vet_hospital.model;
import java.util.*;
public interface Vet_hospital_interface {
          public void insert(Vet_hospitalVO vet_hospitalVO);
          public void update(Vet_hospitalVO vet_hospitalVO);
          public void delete(String hos_Id);
          public Vet_hospitalVO findByPrimaryKey(String hos_Id);
          public List<Vet_hospitalVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<Vet_hospitalVO> getAll(Map<String, String[]> map); 
}

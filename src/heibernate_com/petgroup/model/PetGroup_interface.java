package heibernate_com.petgroup.model;
import java.util.*;
public interface PetGroup_interface {
          public void insert(PetGroupVO petgroupVO);
          public void update(PetGroupVO petgroupVO);
          public void delete(String grp_Id);
          public PetGroupVO findByPrimaryKey(String grp_Id);
          public List<PetGroupVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<PetGroupVO> getAll(Map<String, String[]> map,boolean able_like); 
}

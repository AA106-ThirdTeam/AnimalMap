package heibernate_com.second_prodphotos.model;
import java.util.*;
public interface Second_ProdPhotos_interface {
          public void insert(Second_ProdPhotosVO second_prodphotosVO);
          public void update(Second_ProdPhotosVO second_prodphotosVO);
          public void delete(String second_ProdPhotos_Id);
          public Second_ProdPhotosVO findByPrimaryKey(String second_ProdPhotos_Id);
          public List<Second_ProdPhotosVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<Second_ProdPhotosVO> getAll(Map<String, String[]> map,boolean able_like); 
}

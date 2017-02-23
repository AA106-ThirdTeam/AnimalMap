package heibernate_com.track.model;
import java.util.*;
public interface Track_interface {
          public void insert(TrackVO trackVO);
          public void update(TrackVO trackVO);
          public void delete(String track_Id);
          public TrackVO findByPrimaryKey(String track_Id);
          public List<TrackVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<TrackVO> getAll(Map<String, String[]> map); 
}

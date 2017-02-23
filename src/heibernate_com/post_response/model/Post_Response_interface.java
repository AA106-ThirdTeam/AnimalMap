package heibernate_com.post_response.model;
import java.util.*;
public interface Post_Response_interface {
          public void insert(Post_ResponseVO post_responseVO);
          public void update(Post_ResponseVO post_responseVO);
          public void delete(String res_Id);
          public Post_ResponseVO findByPrimaryKey(String res_Id);
          public List<Post_ResponseVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
	      public List<Post_ResponseVO> getAll(Map<String, String[]> map); 
}

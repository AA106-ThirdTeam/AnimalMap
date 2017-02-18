package heibernate_com.anihome_msg.model;
import java.util.*;
public interface AniHome_Msg_interface {
          public void insert(AniHome_MsgVO anihome_msgVO);
          public void update(AniHome_MsgVO anihome_msgVO);
          public void delete(Integer aniHome_Msg_Id);
          public AniHome_MsgVO findByPrimaryKey(Integer aniHome_Msg_Id);
          public List<AniHome_MsgVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<AniHome_MsgVO> getAll(Map<String, String[]> map); 
}

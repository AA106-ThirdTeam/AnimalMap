package heibernate_com.emg_help.model;
import java.util.*;
public interface Emg_Help_interface {
          public void insert(Emg_HelpVO emg_helpVO);
          public void update(Emg_HelpVO emg_helpVO);
          public void delete(String emg_H_Id);
          public Emg_HelpVO findByPrimaryKey(String emg_H_Id);
          public List<Emg_HelpVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<Emg_HelpVO> getAll(Map<String, String[]> map); 
}

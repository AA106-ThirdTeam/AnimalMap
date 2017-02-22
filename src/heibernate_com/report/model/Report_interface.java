package heibernate_com.report.model;
import java.util.*;
public interface Report_interface {
          public void insert(ReportVO reportVO);
          public void update(ReportVO reportVO);
          public void delete(String report_No);
          public ReportVO findByPrimaryKey(String report_No);
          public List<ReportVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<ReportVO> getAll(Map<String, String[]> map); 
}

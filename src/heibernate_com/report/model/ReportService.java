package heibernate_com.report.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;

public class ReportService {

	private Report_interface dao;

	public ReportService() {
		dao = new ReportDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(ReportDAO_interface) context.getBean("empDAO");
	}
	
	public ReportVO addReport(
			String report_name,String report_class,String report_class_No,String report_class_No_value
			,String report_content,String report_status,String mem_Id_active,String mem_Id_passive
			,java.sql.Timestamp report_time,String report_class_status) {
		ReportVO reportVO = new ReportVO();
		reportVO.setReport_name(report_name);
		reportVO.setReport_class(report_class);
		reportVO.setReport_class_No(report_class_No);
		reportVO.setReport_class_No_value(report_class_No_value);
		reportVO.setReport_content(report_content);
		reportVO.setReport_status(report_status);
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id_active);
		reportVO.setMemVO(memVO);
		memVO = new MemVO();
		memVO.setMem_Id(mem_Id_passive);
		reportVO.setMemVO(memVO);
		reportVO.setReport_time(report_time);
		reportVO.setReport_class_status(report_class_status);
		dao.insert(reportVO);
		return reportVO;
	}
	
	public ReportVO updateReport(
			String report_No
			,String report_name,String report_class,String report_class_No,String report_class_No_value
			,String report_content,String report_status,String mem_Id_active,String mem_Id_passive
			,java.sql.Timestamp report_time,String report_class_status) {	
		ReportVO reportVO = new ReportVO();
		reportVO.setReport_No(report_No);
		reportVO.setReport_name(report_name);
		reportVO.setReport_class(report_class);
		reportVO.setReport_class_No(report_class_No);
		reportVO.setReport_class_No_value(report_class_No_value);
		reportVO.setReport_content(report_content);
		reportVO.setReport_status(report_status);
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id_passive);
		reportVO.setMemVO(memVO);
		reportVO.setReport_time(report_time);
		reportVO.setReport_class_status(report_class_status);
		dao.update(reportVO);
		return reportVO;
	}

	public void deleteReport(String report_No) {
		dao.delete(report_No);
	}

	public ReportVO getOneReport(String report_No) {
		return dao.findByPrimaryKey(report_No);
	}

	public List<ReportVO> getAll() {
		return dao.getAll();
	}

	public List<ReportVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}

	public List<ReportVO> getAll_ver02(Map<String, String[]> map,boolean able_like) {
		return ((ReportDAO)dao).getAll_ver02(map,able_like);
	}	
}

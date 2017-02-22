package heibernate_com.report.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

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
			String report_name) {
		ReportVO reportVO = new ReportVO();
		reportVO.setReport_name(report_name);
		dao.insert(reportVO);
		return reportVO;
	}
	
	public ReportVO updateReport(
			String report_No
			,String report_name) {	
		ReportVO reportVO = new ReportVO();
		reportVO.setReport_No(report_No);
		reportVO.setReport_name(report_name);
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
	
}

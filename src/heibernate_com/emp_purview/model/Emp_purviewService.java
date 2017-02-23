package heibernate_com.emp_purview.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.emp.model.EmpVO;
import heibernate_com.purview.model.PurviewVO;

public class Emp_purviewService {

	private Emp_purview_interface dao;

	public Emp_purviewService() {
		dao = new Emp_purviewDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Emp_purviewDAO_interface) context.getBean("empDAO");
	}
	
	public Emp_purviewVO addEmp_purview(
			) {
		Emp_purviewVO emp_purviewVO = new Emp_purviewVO();
		dao.insert(emp_purviewVO);
		return emp_purviewVO;
	}
	
	public Emp_purviewVO updateEmp_purview(
			String emp_No
			,String purview_No) {	
		Emp_purviewVO emp_purviewVO = new Emp_purviewVO();
		dao.update(emp_purviewVO);
		return emp_purviewVO;
	}

	public void deleteEmp_purview(String emp_No) {
		dao.delete(emp_No);
	}

	public Emp_purviewVO getOneEmp_purview(String emp_No) {
		return dao.findByPrimaryKey(emp_No);
	}

	public List<Emp_purviewVO> getAll() {
		return dao.getAll();
	}

	public List<Emp_purviewVO> getAll(Map<String, String[]> map) {
		return dao.getAll(map);
	}
}

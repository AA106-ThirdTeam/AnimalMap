package heibernate_com.emp.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpService {

	private Emp_interface dao;

	public EmpService() {
		dao = new EmpDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(EmpDAO_interface) context.getBean("empDAO");
	}
	
	public EmpVO addEmp(
			String emp_name,String emp_Pw,String emp_email,String emp_Id
			,java.sql.Date emp_birthday,String emp_phone,String emp_address,String emp_status
			,byte[] emp_picture,String emp_Pic_format,java.sql.Date emp_hiredate,java.sql.Date emp_firedate
			) {
		EmpVO empVO = new EmpVO();
		empVO.setEmp_name(emp_name);
		empVO.setEmp_Pw(emp_Pw);
		empVO.setEmp_email(emp_email);
		empVO.setEmp_Id(emp_Id);
		empVO.setEmp_birthday(emp_birthday);
		empVO.setEmp_phone(emp_phone);
		empVO.setEmp_address(emp_address);
		empVO.setEmp_status(emp_status);
		empVO.setEmp_picture(emp_picture);
		empVO.setEmp_Pic_format(emp_Pic_format);
		empVO.setEmp_hiredate(emp_hiredate);
		empVO.setEmp_firedate(emp_firedate);
		dao.insert(empVO);
		return empVO;
	}
	
	public EmpVO updateEmp(
			String emp_No
			,String emp_name,String emp_Pw,String emp_email,String emp_Id
			,java.sql.Date emp_birthday,String emp_phone,String emp_address,String emp_status
			,byte[] emp_picture,String emp_Pic_format,java.sql.Date emp_hiredate,java.sql.Date emp_firedate
			) {	
		EmpVO empVO = new EmpVO();
		empVO.setEmp_No(emp_No);
		empVO.setEmp_name(emp_name);
		empVO.setEmp_Pw(emp_Pw);
		empVO.setEmp_email(emp_email);
		empVO.setEmp_Id(emp_Id);
		empVO.setEmp_birthday(emp_birthday);
		empVO.setEmp_phone(emp_phone);
		empVO.setEmp_address(emp_address);
		empVO.setEmp_status(emp_status);
		empVO.setEmp_picture(emp_picture);
		empVO.setEmp_Pic_format(emp_Pic_format);
		empVO.setEmp_hiredate(emp_hiredate);
		empVO.setEmp_firedate(emp_firedate);
		dao.update(empVO);
		return empVO;
	}

	public void deleteEmp(String emp_No) {
		dao.delete(emp_No);
	}

	public EmpVO getOneEmp(String emp_No) {
		return dao.findByPrimaryKey(emp_No);
	}

	public List<EmpVO> getAll() {
		return dao.getAll();
	}
	
}

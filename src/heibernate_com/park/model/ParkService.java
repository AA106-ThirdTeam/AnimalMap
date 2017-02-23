package heibernate_com.park.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.emp.model.EmpVO;

public class ParkService {

	private Park_interface dao;

	public ParkService() {
		dao = new ParkDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(ParkDAO_interface) context.getBean("empDAO");
	}
	
	public ParkVO addPark(
			String emp_No,String park_title,String park_content,String park_pic
			,java.sql.Date adp_start_date,java.sql.Date adp_upDate,String adp_city,String park_town
			,String park_road,Double park_lon,Double park_lat) {
		ParkVO parkVO = new ParkVO();
		EmpVO empVO = new EmpVO();
		empVO.setEmp_No(emp_No);
		parkVO.setEmpVO(empVO);
		parkVO.setPark_title(park_title);
		parkVO.setPark_content(park_content);
		parkVO.setPark_pic(park_pic);
		parkVO.setAdp_start_date(adp_start_date);
		parkVO.setAdp_upDate(adp_upDate);
		parkVO.setAdp_city(adp_city);
		parkVO.setPark_town(park_town);
		parkVO.setPark_road(park_road);
		parkVO.setPark_lon(park_lon);
		parkVO.setPark_lat(park_lat);
		dao.insert(parkVO);
		return parkVO;
	}
	
	public ParkVO updatePark(
			String park_Id
			,String emp_No,String park_title,String park_content,String park_pic
			,java.sql.Date adp_start_date,java.sql.Date adp_upDate,String adp_city,String park_town
			,String park_road,Double park_lon,Double park_lat) {	
		ParkVO parkVO = new ParkVO();
		parkVO.setPark_Id(park_Id);
		parkVO.setPark_title(park_title);
		parkVO.setPark_content(park_content);
		parkVO.setPark_pic(park_pic);
		parkVO.setAdp_start_date(adp_start_date);
		parkVO.setAdp_upDate(adp_upDate);
		parkVO.setAdp_city(adp_city);
		parkVO.setPark_town(park_town);
		parkVO.setPark_road(park_road);
		parkVO.setPark_lon(park_lon);
		parkVO.setPark_lat(park_lat);
		dao.update(parkVO);
		return parkVO;
	}

	public void deletePark(String park_Id) {
		dao.delete(park_Id);
	}

	public ParkVO getOnePark(String park_Id) {
		return dao.findByPrimaryKey(park_Id);
	}

	public List<ParkVO> getAll() {
		return dao.getAll();
	}

	public List<ParkVO> getAll(Map<String, String[]> map) {
		return dao.getAll(map);
	}
}

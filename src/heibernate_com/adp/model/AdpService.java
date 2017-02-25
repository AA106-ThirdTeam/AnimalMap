package heibernate_com.adp.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;

public class AdpService {

	private Adp_interface dao;

	public AdpService() {
		dao = new AdpDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(AdpDAO_interface) context.getBean("empDAO");
	}
	
	public AdpVO addAdp(
			String mem_Id,String adp_title,String adp_adp_content,java.sql.Date adp_start_date
			,java.sql.Date adp_end_date,java.sql.Date adp_upDate,String adp_city,String adp_town
			,String adp_road,String adp_addr,Double adp_lon,Double adp_lat
			,String adp_adp_pic) {
		AdpVO adpVO = new AdpVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		adpVO.setMemVO(memVO);
		adpVO.setAdp_title(adp_title);
		adpVO.setAdp_adp_content(adp_adp_content);
		adpVO.setAdp_start_date(adp_start_date);
		adpVO.setAdp_end_date(adp_end_date);
		adpVO.setAdp_upDate(adp_upDate);
		adpVO.setAdp_city(adp_city);
		adpVO.setAdp_town(adp_town);
		adpVO.setAdp_road(adp_road);
		adpVO.setAdp_addr(adp_addr);
		adpVO.setAdp_lon(adp_lon);
		adpVO.setAdp_lat(adp_lat);
		adpVO.setAdp_adp_pic(adp_adp_pic);
		dao.insert(adpVO);
		return adpVO;
	}
	
	public AdpVO updateAdp(
			String adp_Id
			,String mem_Id,String adp_title,String adp_adp_content,java.sql.Date adp_start_date
			,java.sql.Date adp_end_date,java.sql.Date adp_upDate,String adp_city,String adp_town
			,String adp_road,String adp_addr,Double adp_lon,Double adp_lat
			,String adp_adp_pic) {	
		AdpVO adpVO = new AdpVO();
		adpVO.setAdp_Id(adp_Id);
		adpVO.setAdp_title(adp_title);
		adpVO.setAdp_adp_content(adp_adp_content);
		adpVO.setAdp_start_date(adp_start_date);
		adpVO.setAdp_end_date(adp_end_date);
		adpVO.setAdp_upDate(adp_upDate);
		adpVO.setAdp_city(adp_city);
		adpVO.setAdp_town(adp_town);
		adpVO.setAdp_road(adp_road);
		adpVO.setAdp_addr(adp_addr);
		adpVO.setAdp_lon(adp_lon);
		adpVO.setAdp_lat(adp_lat);
		adpVO.setAdp_adp_pic(adp_adp_pic);
		dao.update(adpVO);
		return adpVO;
	}

	public void deleteAdp(String adp_Id) {
		dao.delete(adp_Id);
	}

	public AdpVO getOneAdp(String adp_Id) {
		return dao.findByPrimaryKey(adp_Id);
	}

	public List<AdpVO> getAll() {
		return dao.getAll();
	}

	public List<AdpVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}
}

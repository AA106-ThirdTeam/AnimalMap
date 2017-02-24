package heibernate_com.vet_hospital.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;

public class Vet_hospitalService {

	private Vet_hospital_interface dao;

	public Vet_hospitalService() {
		dao = new Vet_hospitalDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Vet_hospitalDAO_interface) context.getBean("empDAO");
	}
	
	public Vet_hospitalVO addVet_hospital(
			String hos_MemId,String hos_name,String hos_city,String hos_town
			,String hos_road,Integer hos_Eval,String hos_URL,String hos_StartTime
			,String hos_EndTime,String hos_Tel,String hos_Desc,Double hos_Long
			,Double hos_Lat,java.sql.Date hos_CreateTime,String hos_visible) {
		Vet_hospitalVO vet_hospitalVO = new Vet_hospitalVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(hos_MemId);
		vet_hospitalVO.setMemVO(memVO);
		vet_hospitalVO.setHos_name(hos_name);
		vet_hospitalVO.setHos_city(hos_city);
		vet_hospitalVO.setHos_town(hos_town);
		vet_hospitalVO.setHos_road(hos_road);
		vet_hospitalVO.setHos_Eval(hos_Eval);
		vet_hospitalVO.setHos_URL(hos_URL);
		vet_hospitalVO.setHos_StartTime(hos_StartTime);
		vet_hospitalVO.setHos_EndTime(hos_EndTime);
		vet_hospitalVO.setHos_Tel(hos_Tel);
		vet_hospitalVO.setHos_Desc(hos_Desc);
		vet_hospitalVO.setHos_Long(hos_Long);
		vet_hospitalVO.setHos_Lat(hos_Lat);
		vet_hospitalVO.setHos_CreateTime(hos_CreateTime);
		vet_hospitalVO.setHos_visible(hos_visible);
		dao.insert(vet_hospitalVO);
		return vet_hospitalVO;
	}
	
	public Vet_hospitalVO updateVet_hospital(
			String hos_Id
			,String hos_MemId,String hos_name,String hos_city,String hos_town
			,String hos_road,Integer hos_Eval,String hos_URL,String hos_StartTime
			,String hos_EndTime,String hos_Tel,String hos_Desc,Double hos_Long
			,Double hos_Lat,java.sql.Date hos_CreateTime,String hos_visible) {	
		Vet_hospitalVO vet_hospitalVO = new Vet_hospitalVO();
		vet_hospitalVO.setHos_Id(hos_Id);
		vet_hospitalVO.setHos_name(hos_name);
		vet_hospitalVO.setHos_city(hos_city);
		vet_hospitalVO.setHos_town(hos_town);
		vet_hospitalVO.setHos_road(hos_road);
		vet_hospitalVO.setHos_Eval(hos_Eval);
		vet_hospitalVO.setHos_URL(hos_URL);
		vet_hospitalVO.setHos_StartTime(hos_StartTime);
		vet_hospitalVO.setHos_EndTime(hos_EndTime);
		vet_hospitalVO.setHos_Tel(hos_Tel);
		vet_hospitalVO.setHos_Desc(hos_Desc);
		vet_hospitalVO.setHos_Long(hos_Long);
		vet_hospitalVO.setHos_Lat(hos_Lat);
		vet_hospitalVO.setHos_CreateTime(hos_CreateTime);
		vet_hospitalVO.setHos_visible(hos_visible);
		dao.update(vet_hospitalVO);
		return vet_hospitalVO;
	}

	public void deleteVet_hospital(String hos_Id) {
		dao.delete(hos_Id);
	}

	public Vet_hospitalVO getOneVet_hospital(String hos_Id) {
		return dao.findByPrimaryKey(hos_Id);
	}

	public List<Vet_hospitalVO> getAll() {
		return dao.getAll();
	}

	public List<Vet_hospitalVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}
}

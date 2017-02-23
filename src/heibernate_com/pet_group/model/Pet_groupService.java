package heibernate_com.pet_group.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;

public class Pet_groupService {

	private Pet_group_interface dao;

	public Pet_groupService() {
		dao = new Pet_groupDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Pet_groupDAO_interface) context.getBean("empDAO");
	}
	
	public Pet_groupVO addPet_group(
			String grp_MemId,String grp_name,String grp_city,String grp_Addr
			,String grp_road,String grp_StartTime,String grp_EndTime,String grp_Desc
			,Double grp_Long,Double grp_Lat,java.sql.Date grp_CreateTime,String grp_visible
			,byte[] grp_photo) {
		Pet_groupVO pet_groupVO = new Pet_groupVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(grp_MemId);
		pet_groupVO.setMemVO(memVO);
		pet_groupVO.setGrp_name(grp_name);
		pet_groupVO.setGrp_city(grp_city);
		pet_groupVO.setGrp_Addr(grp_Addr);
		pet_groupVO.setGrp_road(grp_road);
		pet_groupVO.setGrp_StartTime(grp_StartTime);
		pet_groupVO.setGrp_EndTime(grp_EndTime);
		pet_groupVO.setGrp_Desc(grp_Desc);
		pet_groupVO.setGrp_Long(grp_Long);
		pet_groupVO.setGrp_Lat(grp_Lat);
		pet_groupVO.setGrp_CreateTime(grp_CreateTime);
		pet_groupVO.setGrp_visible(grp_visible);
		pet_groupVO.setGrp_photo(grp_photo);
		dao.insert(pet_groupVO);
		return pet_groupVO;
	}
	
	public Pet_groupVO updatePet_group(
			String grp_Id
			,String grp_MemId,String grp_name,String grp_city,String grp_Addr
			,String grp_road,String grp_StartTime,String grp_EndTime,String grp_Desc
			,Double grp_Long,Double grp_Lat,java.sql.Date grp_CreateTime,String grp_visible
			,byte[] grp_photo) {	
		Pet_groupVO pet_groupVO = new Pet_groupVO();
		pet_groupVO.setGrp_Id(grp_Id);
		pet_groupVO.setGrp_name(grp_name);
		pet_groupVO.setGrp_city(grp_city);
		pet_groupVO.setGrp_Addr(grp_Addr);
		pet_groupVO.setGrp_road(grp_road);
		pet_groupVO.setGrp_StartTime(grp_StartTime);
		pet_groupVO.setGrp_EndTime(grp_EndTime);
		pet_groupVO.setGrp_Desc(grp_Desc);
		pet_groupVO.setGrp_Long(grp_Long);
		pet_groupVO.setGrp_Lat(grp_Lat);
		pet_groupVO.setGrp_CreateTime(grp_CreateTime);
		pet_groupVO.setGrp_visible(grp_visible);
		pet_groupVO.setGrp_photo(grp_photo);
		dao.update(pet_groupVO);
		return pet_groupVO;
	}

	public void deletePet_group(String grp_Id) {
		dao.delete(grp_Id);
	}

	public Pet_groupVO getOnePet_group(String grp_Id) {
		return dao.findByPrimaryKey(grp_Id);
	}

	public List<Pet_groupVO> getAll() {
		return dao.getAll();
	}

	public List<Pet_groupVO> getAll(Map<String, String[]> map) {
		return dao.getAll(map);
	}
}

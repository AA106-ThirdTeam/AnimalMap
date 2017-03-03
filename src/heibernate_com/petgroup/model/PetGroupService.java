package heibernate_com.petgroup.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;

public class PetGroupService {

	private PetGroup_interface dao;

	public PetGroupService() {
		dao = new PetGroupDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(PetGroupDAO_interface) context.getBean("empDAO");
	}
	
	public PetGroupVO addPetGroup(
			String grp_MemId,String grp_name,String grp_city,String GRP_TOWN
			,String grp_road,java.sql.Timestamp grp_EndTime,java.sql.Timestamp grp_StartTime,java.sql.Timestamp grp_CreateTime
			,String grp_Desc,Double grp_Long,Double grp_Lat,String grp_visible
			,byte[] GRP_PHOTO) {
		PetGroupVO petgroupVO = new PetGroupVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(grp_MemId);
		petgroupVO.setMemVO(memVO);
		petgroupVO.setGrp_name(grp_name);
		petgroupVO.setGrp_city(grp_city);
		petgroupVO.setGRP_TOWN(GRP_TOWN);
		petgroupVO.setGrp_road(grp_road);
		petgroupVO.setGrp_EndTime(grp_EndTime);
		petgroupVO.setGrp_StartTime(grp_StartTime);
		petgroupVO.setGrp_CreateTime(grp_CreateTime);
		petgroupVO.setGrp_Desc(grp_Desc);
		petgroupVO.setGrp_Long(grp_Long);
		petgroupVO.setGrp_Lat(grp_Lat);
		petgroupVO.setGrp_visible(grp_visible);
		petgroupVO.setGRP_PHOTO(GRP_PHOTO);
		dao.insert(petgroupVO);
		return petgroupVO;
	}
	
	public PetGroupVO updatePetGroup(
			String grp_Id
			,String grp_MemId,String grp_name,String grp_city,String GRP_TOWN
			,String grp_road,java.sql.Timestamp grp_EndTime,java.sql.Timestamp grp_StartTime,java.sql.Timestamp grp_CreateTime
			,String grp_Desc,Double grp_Long,Double grp_Lat,String grp_visible
			,byte[] GRP_PHOTO) {	
		PetGroupVO petgroupVO = new PetGroupVO();
		petgroupVO.setGrp_Id(grp_Id);
		petgroupVO.setGrp_name(grp_name);
		petgroupVO.setGrp_city(grp_city);
		petgroupVO.setGRP_TOWN(GRP_TOWN);
		petgroupVO.setGrp_road(grp_road);
		petgroupVO.setGrp_EndTime(grp_EndTime);
		petgroupVO.setGrp_StartTime(grp_StartTime);
		petgroupVO.setGrp_CreateTime(grp_CreateTime);
		petgroupVO.setGrp_Desc(grp_Desc);
		petgroupVO.setGrp_Long(grp_Long);
		petgroupVO.setGrp_Lat(grp_Lat);
		petgroupVO.setGrp_visible(grp_visible);
		petgroupVO.setGRP_PHOTO(GRP_PHOTO);
		dao.update(petgroupVO);
		return petgroupVO;
	}

	public void deletePetGroup(String grp_Id) {
		dao.delete(grp_Id);
	}

	public PetGroupVO getOnePetGroup(String grp_Id) {
		return dao.findByPrimaryKey(grp_Id);
	}

	public List<PetGroupVO> getAll() {
		return dao.getAll();
	}

	public List<PetGroupVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}

	public List<PetGroupVO> getAll_ver02(Map<String, String[]> map,boolean able_like) {
		return ((PetGroupDAO)dao).getAll_ver02(map,able_like);
	}	
}

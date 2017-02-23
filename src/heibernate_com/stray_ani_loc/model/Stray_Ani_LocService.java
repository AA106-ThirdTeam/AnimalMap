package heibernate_com.stray_ani_loc.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.stray_ani.model.Stray_AniVO;
import heibernate_com.mem.model.MemVO;

public class Stray_Ani_LocService {

	private Stray_Ani_Loc_interface dao;

	public Stray_Ani_LocService() {
		dao = new Stray_Ani_LocDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Stray_Ani_LocDAO_interface) context.getBean("empDAO");
	}
	
	public Stray_Ani_LocVO addStray_Ani_Loc(
			String stray_Ani_Id,String mem_Id,Double str_Ani_LocLat,Double str_Ani_LocLon
			) {
		Stray_Ani_LocVO stray_ani_locVO = new Stray_Ani_LocVO();
		Stray_AniVO stray_aniVO = new Stray_AniVO();
		stray_aniVO.setStray_Ani_Id(stray_Ani_Id);
		stray_ani_locVO.setStray_AniVO(stray_aniVO);
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		stray_ani_locVO.setMemVO(memVO);
		stray_ani_locVO.setStr_Ani_LocLat(str_Ani_LocLat);
		stray_ani_locVO.setStr_Ani_LocLon(str_Ani_LocLon);
		dao.insert(stray_ani_locVO);
		return stray_ani_locVO;
	}
	
	public Stray_Ani_LocVO updateStray_Ani_Loc(
			String str_Ani_Loc_No
			,String stray_Ani_Id,String mem_Id,Double str_Ani_LocLat,Double str_Ani_LocLon
			) {	
		Stray_Ani_LocVO stray_ani_locVO = new Stray_Ani_LocVO();
		stray_ani_locVO.setStr_Ani_Loc_No(str_Ani_Loc_No);
		stray_ani_locVO.setStr_Ani_LocLat(str_Ani_LocLat);
		stray_ani_locVO.setStr_Ani_LocLon(str_Ani_LocLon);
		dao.update(stray_ani_locVO);
		return stray_ani_locVO;
	}

	public void deleteStray_Ani_Loc(String str_Ani_Loc_No) {
		dao.delete(str_Ani_Loc_No);
	}

	public Stray_Ani_LocVO getOneStray_Ani_Loc(String str_Ani_Loc_No) {
		return dao.findByPrimaryKey(str_Ani_Loc_No);
	}

	public List<Stray_Ani_LocVO> getAll() {
		return dao.getAll();
	}

	public List<Stray_Ani_LocVO> getAll(Map<String, String[]> map) {
		return dao.getAll(map);
	}
}

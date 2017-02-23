package heibernate_com.anihome.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;

public class AniHomeService {

	private AniHome_interface dao;

	public AniHomeService() {
		dao = new AniHomeDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(AniHomeDAO_interface) context.getBean("empDAO");
	}
	
	public AniHomeVO addAniHome(
			String mem_Id,String aniHome_title,String aniHome_content,java.sql.Date aniHome_start_date
			,java.sql.Date aniHome_upDate,String aniHome_city,String aniHome_town,String aniHome_road
			,String aniHome_addr,Double aniHome_lon,Double aniHome_lat,String aniHome_pic
			) {
		AniHomeVO anihomeVO = new AniHomeVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		anihomeVO.setMemVO(memVO);
		anihomeVO.setAniHome_title(aniHome_title);
		anihomeVO.setAniHome_content(aniHome_content);
		anihomeVO.setAniHome_start_date(aniHome_start_date);
		anihomeVO.setAniHome_upDate(aniHome_upDate);
		anihomeVO.setAniHome_city(aniHome_city);
		anihomeVO.setAniHome_town(aniHome_town);
		anihomeVO.setAniHome_road(aniHome_road);
		anihomeVO.setAniHome_addr(aniHome_addr);
		anihomeVO.setAniHome_lon(aniHome_lon);
		anihomeVO.setAniHome_lat(aniHome_lat);
		anihomeVO.setAniHome_pic(aniHome_pic);
		dao.insert(anihomeVO);
		return anihomeVO;
	}
	
	public AniHomeVO updateAniHome(
			String aniHome_Id
			,String mem_Id,String aniHome_title,String aniHome_content,java.sql.Date aniHome_start_date
			,java.sql.Date aniHome_upDate,String aniHome_city,String aniHome_town,String aniHome_road
			,String aniHome_addr,Double aniHome_lon,Double aniHome_lat,String aniHome_pic
			) {	
		AniHomeVO anihomeVO = new AniHomeVO();
		anihomeVO.setAniHome_Id(aniHome_Id);
		anihomeVO.setAniHome_title(aniHome_title);
		anihomeVO.setAniHome_content(aniHome_content);
		anihomeVO.setAniHome_start_date(aniHome_start_date);
		anihomeVO.setAniHome_upDate(aniHome_upDate);
		anihomeVO.setAniHome_city(aniHome_city);
		anihomeVO.setAniHome_town(aniHome_town);
		anihomeVO.setAniHome_road(aniHome_road);
		anihomeVO.setAniHome_addr(aniHome_addr);
		anihomeVO.setAniHome_lon(aniHome_lon);
		anihomeVO.setAniHome_lat(aniHome_lat);
		anihomeVO.setAniHome_pic(aniHome_pic);
		dao.update(anihomeVO);
		return anihomeVO;
	}

	public void deleteAniHome(String aniHome_Id) {
		dao.delete(aniHome_Id);
	}

	public AniHomeVO getOneAniHome(String aniHome_Id) {
		return dao.findByPrimaryKey(aniHome_Id);
	}

	public List<AniHomeVO> getAll() {
		return dao.getAll();
	}
	
}

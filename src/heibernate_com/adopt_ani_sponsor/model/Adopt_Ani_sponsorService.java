package heibernate_com.adopt_ani_sponsor.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.adopt_ani.model.Adopt_AniVO;
import heibernate_com.mem.model.MemVO;

public class Adopt_Ani_sponsorService {

	private Adopt_Ani_sponsor_interface dao;

	public Adopt_Ani_sponsorService() {
		dao = new Adopt_Ani_sponsorDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Adopt_Ani_sponsorDAO_interface) context.getBean("empDAO");
	}
	
	public Adopt_Ani_sponsorVO addAdopt_Ani_sponsor(
			String adopt_Ani_Id,String mem_Id,Integer ado_Ani_Spo_money,String ado_Ani_Spo_thing
			,java.sql.Timestamp ado_Ani_Spo_time) {
		Adopt_Ani_sponsorVO adopt_ani_sponsorVO = new Adopt_Ani_sponsorVO();
		Adopt_AniVO adopt_aniVO = new Adopt_AniVO();
		adopt_aniVO.setAdopt_Ani_Id(adopt_Ani_Id);
		adopt_ani_sponsorVO.setAdopt_AniVO(adopt_aniVO);
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		adopt_ani_sponsorVO.setMemVO(memVO);
		adopt_ani_sponsorVO.setAdo_Ani_Spo_money(ado_Ani_Spo_money);
		adopt_ani_sponsorVO.setAdo_Ani_Spo_thing(ado_Ani_Spo_thing);
		adopt_ani_sponsorVO.setAdo_Ani_Spo_time(ado_Ani_Spo_time);
		dao.insert(adopt_ani_sponsorVO);
		return adopt_ani_sponsorVO;
	}
	
	public Adopt_Ani_sponsorVO updateAdopt_Ani_sponsor(
			String ado_Ani_Spo_No
			,String adopt_Ani_Id,String mem_Id,Integer ado_Ani_Spo_money,String ado_Ani_Spo_thing
			,java.sql.Timestamp ado_Ani_Spo_time) {	
		Adopt_Ani_sponsorVO adopt_ani_sponsorVO = new Adopt_Ani_sponsorVO();
		adopt_ani_sponsorVO.setAdo_Ani_Spo_No(ado_Ani_Spo_No);
		adopt_ani_sponsorVO.setAdo_Ani_Spo_money(ado_Ani_Spo_money);
		adopt_ani_sponsorVO.setAdo_Ani_Spo_thing(ado_Ani_Spo_thing);
		adopt_ani_sponsorVO.setAdo_Ani_Spo_time(ado_Ani_Spo_time);
		dao.update(adopt_ani_sponsorVO);
		return adopt_ani_sponsorVO;
	}

	public void deleteAdopt_Ani_sponsor(String ado_Ani_Spo_No) {
		dao.delete(ado_Ani_Spo_No);
	}

	public Adopt_Ani_sponsorVO getOneAdopt_Ani_sponsor(String ado_Ani_Spo_No) {
		return dao.findByPrimaryKey(ado_Ani_Spo_No);
	}

	public List<Adopt_Ani_sponsorVO> getAll() {
		return dao.getAll();
	}

	public List<Adopt_Ani_sponsorVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}
}

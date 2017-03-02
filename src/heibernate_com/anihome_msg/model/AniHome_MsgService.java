package heibernate_com.anihome_msg.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.anihome.model.AniHomeVO;
import heibernate_com.mem.model.MemVO;

public class AniHome_MsgService {

	private AniHome_Msg_interface dao;

	public AniHome_MsgService() {
		dao = new AniHome_MsgDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(AniHome_MsgDAO_interface) context.getBean("empDAO");
	}
	
	public AniHome_MsgVO addAniHome_Msg(
			String aniHome_Id,String mem_Id,String aniHome_Msg,java.sql.Date adp_start_date
			) {
		AniHome_MsgVO anihome_msgVO = new AniHome_MsgVO();
		AniHomeVO anihomeVO = new AniHomeVO();
		anihomeVO.setAniHome_Id(aniHome_Id);
		anihome_msgVO.setAniHomeVO(anihomeVO);
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		anihome_msgVO.setMemVO(memVO);
		anihome_msgVO.setAniHome_Msg(aniHome_Msg);
		anihome_msgVO.setAdp_start_date(adp_start_date);
		dao.insert(anihome_msgVO);
		return anihome_msgVO;
	}
	
	public AniHome_MsgVO updateAniHome_Msg(
			String aniHome_Msg_Id
			,String aniHome_Id,String mem_Id,String aniHome_Msg,java.sql.Date adp_start_date
			) {	
		AniHome_MsgVO anihome_msgVO = new AniHome_MsgVO();
		anihome_msgVO.setAniHome_Msg_Id(aniHome_Msg_Id);
		anihome_msgVO.setAniHome_Msg(aniHome_Msg);
		anihome_msgVO.setAdp_start_date(adp_start_date);
		dao.update(anihome_msgVO);
		return anihome_msgVO;
	}

	public void deleteAniHome_Msg(String aniHome_Msg_Id) {
		dao.delete(aniHome_Msg_Id);
	}

	public AniHome_MsgVO getOneAniHome_Msg(String aniHome_Msg_Id) {
		return dao.findByPrimaryKey(aniHome_Msg_Id);
	}

	public List<AniHome_MsgVO> getAll() {
		return dao.getAll();
	}

	public List<AniHome_MsgVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}
}

package heibernate_com.adopt_ani_message.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.adopt_ani.model.Adopt_AniVO;
import heibernate_com.mem.model.MemVO;

public class Adopt_Ani_messageService {

	private Adopt_Ani_message_interface dao;

	public Adopt_Ani_messageService() {
		dao = new Adopt_Ani_messageDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Adopt_Ani_messageDAO_interface) context.getBean("empDAO");
	}
	
	public Adopt_Ani_messageVO addAdopt_Ani_message(
			String adopt_Ani_Id,String mem_Id,String ado_Ani_Mes,java.sql.Date ado_Ani_Mes_time
			) {
		Adopt_Ani_messageVO adopt_ani_messageVO = new Adopt_Ani_messageVO();
		Adopt_AniVO adopt_aniVO = new Adopt_AniVO();
		adopt_aniVO.setAdopt_Ani_Id(adopt_Ani_Id);
		adopt_ani_messageVO.setAdopt_AniVO(adopt_aniVO);
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		adopt_ani_messageVO.setMemVO(memVO);
		adopt_ani_messageVO.setAdo_Ani_Mes(ado_Ani_Mes);
		adopt_ani_messageVO.setAdo_Ani_Mes_time(ado_Ani_Mes_time);
		dao.insert(adopt_ani_messageVO);
		return adopt_ani_messageVO;
	}
	
	public Adopt_Ani_messageVO updateAdopt_Ani_message(
			String ado_Ani_Mes_No
			,String adopt_Ani_Id,String mem_Id,String ado_Ani_Mes,java.sql.Date ado_Ani_Mes_time
			) {	
		Adopt_Ani_messageVO adopt_ani_messageVO = new Adopt_Ani_messageVO();
		adopt_ani_messageVO.setAdo_Ani_Mes_No(ado_Ani_Mes_No);
		Adopt_AniVO adopt_aniVO = new Adopt_AniVO();
		adopt_aniVO.setAdopt_Ani_Id(adopt_Ani_Id);
		adopt_ani_messageVO.setAdopt_AniVO(adopt_aniVO);
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		adopt_ani_messageVO.setMemVO(memVO);
		adopt_ani_messageVO.setAdo_Ani_Mes(ado_Ani_Mes);
		adopt_ani_messageVO.setAdo_Ani_Mes_time(ado_Ani_Mes_time);
		dao.update(adopt_ani_messageVO);
		return adopt_ani_messageVO;
	}

	public void deleteAdopt_Ani_message(String ado_Ani_Mes_No) {
		dao.delete(ado_Ani_Mes_No);
	}

	public Adopt_Ani_messageVO getOneAdopt_Ani_message(String ado_Ani_Mes_No) {
		return dao.findByPrimaryKey(ado_Ani_Mes_No);
	}

	public List<Adopt_Ani_messageVO> getAll() {
		return dao.getAll();
	}
	
}

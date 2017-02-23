package heibernate_com.stray_ani_message.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.stray_ani.model.Stray_AniVO;
import heibernate_com.mem.model.MemVO;

public class Stray_Ani_messageService {

	private Stray_Ani_message_interface dao;

	public Stray_Ani_messageService() {
		dao = new Stray_Ani_messageDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Stray_Ani_messageDAO_interface) context.getBean("empDAO");
	}
	
	public Stray_Ani_messageVO addStray_Ani_message(
			String stray_Ani_Id,String mem_Id,java.sql.Date str_Ani_Mes_time,String str_Ani_Mes
			) {
		Stray_Ani_messageVO stray_ani_messageVO = new Stray_Ani_messageVO();
		Stray_AniVO stray_aniVO = new Stray_AniVO();
		stray_aniVO.setStray_Ani_Id(stray_Ani_Id);
		stray_ani_messageVO.setStray_AniVO(stray_aniVO);
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		stray_ani_messageVO.setMemVO(memVO);
		stray_ani_messageVO.setStr_Ani_Mes_time(str_Ani_Mes_time);
		stray_ani_messageVO.setStr_Ani_Mes(str_Ani_Mes);
		dao.insert(stray_ani_messageVO);
		return stray_ani_messageVO;
	}
	
	public Stray_Ani_messageVO updateStray_Ani_message(
			String str_Ani_Mes_No
			,String stray_Ani_Id,String mem_Id,java.sql.Date str_Ani_Mes_time,String str_Ani_Mes
			) {	
		Stray_Ani_messageVO stray_ani_messageVO = new Stray_Ani_messageVO();
		stray_ani_messageVO.setStr_Ani_Mes_No(str_Ani_Mes_No);
		stray_ani_messageVO.setStr_Ani_Mes_time(str_Ani_Mes_time);
		stray_ani_messageVO.setStr_Ani_Mes(str_Ani_Mes);
		dao.update(stray_ani_messageVO);
		return stray_ani_messageVO;
	}

	public void deleteStray_Ani_message(String str_Ani_Mes_No) {
		dao.delete(str_Ani_Mes_No);
	}

	public Stray_Ani_messageVO getOneStray_Ani_message(String str_Ani_Mes_No) {
		return dao.findByPrimaryKey(str_Ani_Mes_No);
	}

	public List<Stray_Ani_messageVO> getAll() {
		return dao.getAll();
	}
	
}

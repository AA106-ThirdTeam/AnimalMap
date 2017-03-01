package heibernate_com.hos_comment.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;
import heibernate_com.vet_hospital.model.Vet_hospitalVO;

public class Hos_commentService {

	private Hos_comment_interface dao;

	public Hos_commentService() {
		dao = new Hos_commentDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Hos_commentDAO_interface) context.getBean("empDAO");
	}
	
	public Hos_commentVO addHos_comment(
			String hosComment_MemId,String hosComment_HosId,String hosComment_content,java.sql.Timestamp hosComment_SendTime
			) {
		Hos_commentVO hos_commentVO = new Hos_commentVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(hosComment_MemId);
		hos_commentVO.setMemVO(memVO);
		Vet_hospitalVO vet_hospitalVO = new Vet_hospitalVO();
		vet_hospitalVO.setHos_Id(hosComment_HosId);
		hos_commentVO.setVet_hospitalVO(vet_hospitalVO);
		hos_commentVO.setHosComment_content(hosComment_content);
		hos_commentVO.setHosComment_SendTime(hosComment_SendTime);
		dao.insert(hos_commentVO);
		return hos_commentVO;
	}
	
	public Hos_commentVO updateHos_comment(
			String hosComment_Id
			,String hosComment_MemId,String hosComment_HosId,String hosComment_content,java.sql.Timestamp hosComment_SendTime
			) {	
		Hos_commentVO hos_commentVO = new Hos_commentVO();
		hos_commentVO.setHosComment_Id(hosComment_Id);
		hos_commentVO.setHosComment_content(hosComment_content);
		hos_commentVO.setHosComment_SendTime(hosComment_SendTime);
		dao.update(hos_commentVO);
		return hos_commentVO;
	}

	public void deleteHos_comment(String hosComment_Id) {
		dao.delete(hosComment_Id);
	}

	public Hos_commentVO getOneHos_comment(String hosComment_Id) {
		return dao.findByPrimaryKey(hosComment_Id);
	}

	public List<Hos_commentVO> getAll() {
		return dao.getAll();
	}

	public List<Hos_commentVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}
}

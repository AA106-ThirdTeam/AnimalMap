package heibernate_com.purview.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PurviewService {

	private Purview_interface dao;

	public PurviewService() {
		dao = new PurviewDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(PurviewDAO_interface) context.getBean("empDAO");
	}
	
	public PurviewVO addPurview(
			String purview_name) {
		PurviewVO purviewVO = new PurviewVO();
		purviewVO.setPurview_name(purview_name);
		dao.insert(purviewVO);
		return purviewVO;
	}
	
	public PurviewVO updatePurview(
			String purview_No
			,String purview_name) {	
		PurviewVO purviewVO = new PurviewVO();
		purviewVO.setPurview_No(purview_No);
		purviewVO.setPurview_name(purview_name);
		dao.update(purviewVO);
		return purviewVO;
	}

	public void deletePurview(String purview_No) {
		dao.delete(purview_No);
	}

	public PurviewVO getOnePurview(String purview_No) {
		return dao.findByPrimaryKey(purview_No);
	}

	public List<PurviewVO> getAll() {
		return dao.getAll();
	}

	public List<PurviewVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}

	public List<PurviewVO> getAll_ver02(Map<String, String[]> map,boolean able_like) {
		return ((PurviewDAO)dao).getAll_ver02(map,able_like);
	}	
}

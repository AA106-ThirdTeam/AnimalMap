package heibernate_com.rel_list.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;

public class Rel_ListService {

	private Rel_List_interface dao;

	public Rel_ListService() {
		dao = new Rel_ListDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Rel_ListDAO_interface) context.getBean("empDAO");
	}
	
	public Rel_ListVO addRel_List(
			String isBlackList,String isInvited) {
		Rel_ListVO rel_listVO = new Rel_ListVO();
		rel_listVO.setIsBlackList(isBlackList);
		rel_listVO.setIsInvited(isInvited);
		dao.insert(rel_listVO);
		return rel_listVO;
	}
	
	public Rel_ListVO updateRel_List(
			String rel_MemId
			,String added_MemId,String isBlackList,String isInvited) {	
		Rel_ListVO rel_listVO = new Rel_ListVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(added_MemId);
		rel_listVO.setMemVO(memVO);
		rel_listVO.setIsBlackList(isBlackList);
		rel_listVO.setIsInvited(isInvited);
		dao.update(rel_listVO);
		return rel_listVO;
	}

	public void deleteRel_List(String rel_MemId) {
		dao.delete(rel_MemId);
	}

	public Rel_ListVO getOneRel_List(String rel_MemId) {
		return dao.findByPrimaryKey(rel_MemId);
	}

	public List<Rel_ListVO> getAll() {
		return dao.getAll();
	}

	public List<Rel_ListVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}
}

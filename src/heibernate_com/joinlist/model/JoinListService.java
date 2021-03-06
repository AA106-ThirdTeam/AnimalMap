package heibernate_com.joinlist.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.petgroup.model.PetGroupVO;
import heibernate_com.mem.model.MemVO;

public class JoinListService {

	private JoinList_interface dao;

	public JoinListService() {
		dao = new JoinListDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(JoinListDAO_interface) context.getBean("empDAO");
	}
	
	public JoinListVO addJoinList(
			String JOINLIST_ISINVITED) {
		JoinListVO joinlistVO = new JoinListVO();
		joinlistVO.setJOINLIST_ISINVITED(JOINLIST_ISINVITED);
		dao.insert(joinlistVO);
		return joinlistVO;
	}
	
	public JoinListVO updateJoinList(
			String joinList_GrpId
			,String joinList_MemId,String JOINLIST_ISINVITED) {	
		JoinListVO joinlistVO = new JoinListVO();
		joinlistVO.setJOINLIST_ISINVITED(JOINLIST_ISINVITED);
		dao.update(joinlistVO);
		return joinlistVO;
	}

	public void deleteJoinList(String joinList_GrpId) {
		dao.delete(joinList_GrpId);
	}

	public JoinListVO getOneJoinList(String joinList_GrpId) {
		return dao.findByPrimaryKey(joinList_GrpId);
	}

	public List<JoinListVO> getAll() {
		return dao.getAll();
	}

	public List<JoinListVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}

	public List<JoinListVO> getAll_ver02(Map<String, String[]> map,boolean able_like) {
		return ((JoinListDAO)dao).getAll_ver02(map,able_like);
	}	
}

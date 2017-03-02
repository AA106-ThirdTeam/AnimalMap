package heibernate_com.adpmsg.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.adp.model.AdpVO;
import heibernate_com.mem.model.MemVO;

public class AdpMsgService {

	private AdpMsg_interface dao;

	public AdpMsgService() {
		dao = new AdpMsgDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(AdpMsgDAO_interface) context.getBean("empDAO");
	}
	
	public AdpMsgVO addAdpMsg(
			String adp_Id,String mem_Id,String msg,java.sql.Timestamp adpMsgDate
			,java.sql.Timestamp adpMsgadp_upDate) {
		AdpMsgVO adpmsgVO = new AdpMsgVO();
		AdpVO adpVO = new AdpVO();
		adpVO.setAdp_Id(adp_Id);
		adpmsgVO.setAdpVO(adpVO);
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		adpmsgVO.setMemVO(memVO);
		adpmsgVO.setMsg(msg);
		adpmsgVO.setAdpMsgDate(adpMsgDate);
		adpmsgVO.setAdpMsgadp_upDate(adpMsgadp_upDate);
		dao.insert(adpmsgVO);
		return adpmsgVO;
	}
	
	public AdpMsgVO updateAdpMsg(
			String adpMsg_Id
			,String adp_Id,String mem_Id,String msg,java.sql.Timestamp adpMsgDate
			,java.sql.Timestamp adpMsgadp_upDate) {	
		AdpMsgVO adpmsgVO = new AdpMsgVO();
		adpmsgVO.setAdpMsg_Id(adpMsg_Id);
		adpmsgVO.setMsg(msg);
		adpmsgVO.setAdpMsgDate(adpMsgDate);
		adpmsgVO.setAdpMsgadp_upDate(adpMsgadp_upDate);
		dao.update(adpmsgVO);
		return adpmsgVO;
	}

	public void deleteAdpMsg(String adpMsg_Id) {
		dao.delete(adpMsg_Id);
	}

	public AdpMsgVO getOneAdpMsg(String adpMsg_Id) {
		return dao.findByPrimaryKey(adpMsg_Id);
	}

	public List<AdpMsgVO> getAll() {
		return dao.getAll();
	}

	public List<AdpMsgVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}

	public List<AdpMsgVO> getAll_ver02(Map<String, String[]> map,boolean able_like) {
		return ((AdpMsgDAO)dao).getAll_ver02(map,able_like);
	}	
}

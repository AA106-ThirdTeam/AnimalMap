package heibernate_com.priv_message.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;

public class Priv_messageService {

	private Priv_message_interface dao;

	public Priv_messageService() {
		dao = new Priv_messageDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Priv_messageDAO_interface) context.getBean("empDAO");
	}
	
	public Priv_messageVO addPriv_message(
			String privMsgSend_MemId,String privMsgRec_MemId,String privMsg_content,java.sql.Date privMsg_SendTime
			,String privMsg_type) {
		Priv_messageVO priv_messageVO = new Priv_messageVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(privMsgSend_MemId);
		priv_messageVO.setMemVO(memVO);
		memVO = new MemVO();
		memVO.setMem_Id(privMsgRec_MemId);
		priv_messageVO.setMemVO(memVO);
		priv_messageVO.setPrivMsg_content(privMsg_content);
		priv_messageVO.setPrivMsg_SendTime(privMsg_SendTime);
		priv_messageVO.setPrivMsg_type(privMsg_type);
		dao.insert(priv_messageVO);
		return priv_messageVO;
	}
	
	public Priv_messageVO updatePriv_message(
			String privMsg_Id
			,String privMsgSend_MemId,String privMsgRec_MemId,String privMsg_content,java.sql.Date privMsg_SendTime
			,String privMsg_type) {	
		Priv_messageVO priv_messageVO = new Priv_messageVO();
		priv_messageVO.setPrivMsg_Id(privMsg_Id);
		MemVO memVO = new MemVO();
		memVO.setMem_Id(privMsgRec_MemId);
		priv_messageVO.setMemVO(memVO);
		priv_messageVO.setPrivMsg_content(privMsg_content);
		priv_messageVO.setPrivMsg_SendTime(privMsg_SendTime);
		priv_messageVO.setPrivMsg_type(privMsg_type);
		dao.update(priv_messageVO);
		return priv_messageVO;
	}

	public void deletePriv_message(String privMsg_Id) {
		dao.delete(privMsg_Id);
	}

	public Priv_messageVO getOnePriv_message(String privMsg_Id) {
		return dao.findByPrimaryKey(privMsg_Id);
	}

	public List<Priv_messageVO> getAll() {
		return dao.getAll();
	}
	
}

package heibernate_com.offimsg.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.emp.model.EmpVO;

public class OffiMsgService {

	private OffiMsg_interface dao;

	public OffiMsgService() {
		dao = new OffiMsgDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(OffiMsgDAO_interface) context.getBean("empDAO");
	}
	
	public OffiMsgVO addOffiMsg(
			String offiMsg_empId,String offiMsg_Title,String offiMsg_Content,java.sql.Timestamp offiMsg_Date
			) {
		OffiMsgVO offimsgVO = new OffiMsgVO();
		EmpVO empVO = new EmpVO();
		empVO.setEmp_No(offiMsg_empId);
		offimsgVO.setEmpVO(empVO);
		offimsgVO.setOffiMsg_Title(offiMsg_Title);
		offimsgVO.setOffiMsg_Content(offiMsg_Content);
		offimsgVO.setOffiMsg_Date(offiMsg_Date);
		dao.insert(offimsgVO);
		return offimsgVO;
	}
	
	public OffiMsgVO updateOffiMsg(
			String offiMsg_Id
			,String offiMsg_empId,String offiMsg_Title,String offiMsg_Content,java.sql.Timestamp offiMsg_Date
			) {	
		OffiMsgVO offimsgVO = new OffiMsgVO();
		offimsgVO.setOffiMsg_Id(offiMsg_Id);
		offimsgVO.setOffiMsg_Title(offiMsg_Title);
		offimsgVO.setOffiMsg_Content(offiMsg_Content);
		offimsgVO.setOffiMsg_Date(offiMsg_Date);
		dao.update(offimsgVO);
		return offimsgVO;
	}

	public void deleteOffiMsg(String offiMsg_Id) {
		dao.delete(offiMsg_Id);
	}

	public OffiMsgVO getOneOffiMsg(String offiMsg_Id) {
		return dao.findByPrimaryKey(offiMsg_Id);
	}

	public List<OffiMsgVO> getAll() {
		return dao.getAll();
	}

	public List<OffiMsgVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}
}

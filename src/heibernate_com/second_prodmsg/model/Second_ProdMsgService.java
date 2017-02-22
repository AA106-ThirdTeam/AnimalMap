package heibernate_com.second_prodmsg.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.second_prod.model.Second_ProdVO;
import heibernate_com.mem.model.MemVO;

public class Second_ProdMsgService {

	private Second_ProdMsg_interface dao;

	public Second_ProdMsgService() {
		dao = new Second_ProdMsgDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Second_ProdMsgDAO_interface) context.getBean("empDAO");
	}
	
	public Second_ProdMsgVO addSecond_ProdMsg(
			String second_Prod_Id,String mem_Id,String second_ProdMsg_Msg,java.sql.Date second_ProdMsg_DATE
			,java.sql.Date second_ProdMsg_adp_upDate) {
		Second_ProdMsgVO second_prodmsgVO = new Second_ProdMsgVO();
		Second_ProdVO second_prodVO = new Second_ProdVO();
		second_prodVO.setSecond_Prod_Id(second_Prod_Id);
		second_prodmsgVO.setSecond_ProdVO(second_prodVO);
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		second_prodmsgVO.setMemVO(memVO);
		second_prodmsgVO.setSecond_ProdMsg_Msg(second_ProdMsg_Msg);
		second_prodmsgVO.setSecond_ProdMsg_DATE(second_ProdMsg_DATE);
		second_prodmsgVO.setSecond_ProdMsg_adp_upDate(second_ProdMsg_adp_upDate);
		dao.insert(second_prodmsgVO);
		return second_prodmsgVO;
	}
	
	public Second_ProdMsgVO updateSecond_ProdMsg(
			String second_ProdMsg_Id
			,String second_Prod_Id,String mem_Id,String second_ProdMsg_Msg,java.sql.Date second_ProdMsg_DATE
			,java.sql.Date second_ProdMsg_adp_upDate) {	
		Second_ProdMsgVO second_prodmsgVO = new Second_ProdMsgVO();
		second_prodmsgVO.setSecond_ProdMsg_Id(second_ProdMsg_Id);
		Second_ProdVO second_prodVO = new Second_ProdVO();
		second_prodVO.setSecond_Prod_Id(second_Prod_Id);
		second_prodmsgVO.setSecond_ProdVO(second_prodVO);
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		second_prodmsgVO.setMemVO(memVO);
		second_prodmsgVO.setSecond_ProdMsg_Msg(second_ProdMsg_Msg);
		second_prodmsgVO.setSecond_ProdMsg_DATE(second_ProdMsg_DATE);
		second_prodmsgVO.setSecond_ProdMsg_adp_upDate(second_ProdMsg_adp_upDate);
		dao.update(second_prodmsgVO);
		return second_prodmsgVO;
	}

	public void deleteSecond_ProdMsg(String second_ProdMsg_Id) {
		dao.delete(second_ProdMsg_Id);
	}

	public Second_ProdMsgVO getOneSecond_ProdMsg(String second_ProdMsg_Id) {
		return dao.findByPrimaryKey(second_ProdMsg_Id);
	}

	public List<Second_ProdMsgVO> getAll() {
		return dao.getAll();
	}
	
}

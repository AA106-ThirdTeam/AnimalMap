package heibernate_com.emg_h_msg.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;
import heibernate_com.emg_help.model.Emg_HelpVO;

public class Emg_H_MsgService {

	private Emg_H_Msg_interface dao;

	public Emg_H_MsgService() {
		dao = new Emg_H_MsgDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Emg_H_MsgDAO_interface) context.getBean("empDAO");
	}
	
	public Emg_H_MsgVO addEmg_H_Msg(
			String mem_Id,String emg_H_Id,java.sql.Date emg_H_Msg_start,String emg_H_Msg_content
			) {
		Emg_H_MsgVO emg_h_msgVO = new Emg_H_MsgVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		emg_h_msgVO.setMemVO(memVO);
		Emg_HelpVO emg_helpVO = new Emg_HelpVO();
		emg_helpVO.setEmg_H_Id(emg_H_Id);
		emg_h_msgVO.setEmg_HelpVO(emg_helpVO);
		emg_h_msgVO.setEmg_H_Msg_start(emg_H_Msg_start);
		emg_h_msgVO.setEmg_H_Msg_content(emg_H_Msg_content);
		dao.insert(emg_h_msgVO);
		return emg_h_msgVO;
	}
	
	public Emg_H_MsgVO updateEmg_H_Msg(
			String emg_H_Msg_Id
			,String mem_Id,String emg_H_Id,java.sql.Date emg_H_Msg_start,String emg_H_Msg_content
			) {	
		Emg_H_MsgVO emg_h_msgVO = new Emg_H_MsgVO();
		emg_h_msgVO.setEmg_H_Msg_Id(emg_H_Msg_Id);
		emg_h_msgVO.setEmg_H_Msg_start(emg_H_Msg_start);
		emg_h_msgVO.setEmg_H_Msg_content(emg_H_Msg_content);
		dao.update(emg_h_msgVO);
		return emg_h_msgVO;
	}

	public void deleteEmg_H_Msg(String emg_H_Msg_Id) {
		dao.delete(emg_H_Msg_Id);
	}

	public Emg_H_MsgVO getOneEmg_H_Msg(String emg_H_Msg_Id) {
		return dao.findByPrimaryKey(emg_H_Msg_Id);
	}

	public List<Emg_H_MsgVO> getAll() {
		return dao.getAll();
	}

	public List<Emg_H_MsgVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}
}

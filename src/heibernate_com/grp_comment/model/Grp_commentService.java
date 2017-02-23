package heibernate_com.grp_comment.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;
import heibernate_com.pet_group.model.Pet_groupVO;

public class Grp_commentService {

	private Grp_comment_interface dao;

	public Grp_commentService() {
		dao = new Grp_commentDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Grp_commentDAO_interface) context.getBean("empDAO");
	}
	
	public Grp_commentVO addGrp_comment(
			String grpComment_MemId,String grpComment_GrpId,String grpComment_content,java.sql.Date grpComment_SendTime
			) {
		Grp_commentVO grp_commentVO = new Grp_commentVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(grpComment_MemId);
		grp_commentVO.setMemVO(memVO);
		Pet_groupVO pet_groupVO = new Pet_groupVO();
		pet_groupVO.setGrp_Id(grpComment_GrpId);
		grp_commentVO.setPet_groupVO(pet_groupVO);
		grp_commentVO.setGrpComment_content(grpComment_content);
		grp_commentVO.setGrpComment_SendTime(grpComment_SendTime);
		dao.insert(grp_commentVO);
		return grp_commentVO;
	}
	
	public Grp_commentVO updateGrp_comment(
			String grpComment_Id
			,String grpComment_MemId,String grpComment_GrpId,String grpComment_content,java.sql.Date grpComment_SendTime
			) {	
		Grp_commentVO grp_commentVO = new Grp_commentVO();
		grp_commentVO.setGrpComment_Id(grpComment_Id);
		grp_commentVO.setGrpComment_content(grpComment_content);
		grp_commentVO.setGrpComment_SendTime(grpComment_SendTime);
		dao.update(grp_commentVO);
		return grp_commentVO;
	}

	public void deleteGrp_comment(String grpComment_Id) {
		dao.delete(grpComment_Id);
	}

	public Grp_commentVO getOneGrp_comment(String grpComment_Id) {
		return dao.findByPrimaryKey(grpComment_Id);
	}

	public List<Grp_commentVO> getAll() {
		return dao.getAll();
	}
	
}

package heibernate_com.second_prod.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;

public class Second_ProdService {

	private Second_Prod_interface dao;

	public Second_ProdService() {
		dao = new Second_ProdDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Second_ProdDAO_interface) context.getBean("empDAO");
	}
	
	public Second_ProdVO addSecond_Prod(
			String mem_Id,String second_Prod_Title,String second_Prod_Content,java.sql.Timestamp second_Prod_adp_start_date
			,java.sql.Timestamp second_Prod_adp_end_date,java.sql.Timestamp second_Prod_adp_upDate,String second_Prod_adp_city,String second_Prod_Town
			,String second_Prod_Road,Double second_Prod_Lon,Double second_Prod_Lat) {
		Second_ProdVO second_prodVO = new Second_ProdVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		second_prodVO.setMemVO(memVO);
		second_prodVO.setSecond_Prod_Title(second_Prod_Title);
		second_prodVO.setSecond_Prod_Content(second_Prod_Content);
		second_prodVO.setSecond_Prod_adp_start_date(second_Prod_adp_start_date);
		second_prodVO.setSecond_Prod_adp_end_date(second_Prod_adp_end_date);
		second_prodVO.setSecond_Prod_adp_upDate(second_Prod_adp_upDate);
		second_prodVO.setSecond_Prod_adp_city(second_Prod_adp_city);
		second_prodVO.setSecond_Prod_Town(second_Prod_Town);
		second_prodVO.setSecond_Prod_Road(second_Prod_Road);
		second_prodVO.setSecond_Prod_Lon(second_Prod_Lon);
		second_prodVO.setSecond_Prod_Lat(second_Prod_Lat);
		dao.insert(second_prodVO);
		return second_prodVO;
	}
	
	public Second_ProdVO updateSecond_Prod(
			String second_Prod_Id
			,String mem_Id,String second_Prod_Title,String second_Prod_Content,java.sql.Timestamp second_Prod_adp_start_date
			,java.sql.Timestamp second_Prod_adp_end_date,java.sql.Timestamp second_Prod_adp_upDate,String second_Prod_adp_city,String second_Prod_Town
			,String second_Prod_Road,Double second_Prod_Lon,Double second_Prod_Lat) {	
		Second_ProdVO second_prodVO = new Second_ProdVO();
		second_prodVO.setSecond_Prod_Id(second_Prod_Id);
		second_prodVO.setSecond_Prod_Title(second_Prod_Title);
		second_prodVO.setSecond_Prod_Content(second_Prod_Content);
		second_prodVO.setSecond_Prod_adp_start_date(second_Prod_adp_start_date);
		second_prodVO.setSecond_Prod_adp_end_date(second_Prod_adp_end_date);
		second_prodVO.setSecond_Prod_adp_upDate(second_Prod_adp_upDate);
		second_prodVO.setSecond_Prod_adp_city(second_Prod_adp_city);
		second_prodVO.setSecond_Prod_Town(second_Prod_Town);
		second_prodVO.setSecond_Prod_Road(second_Prod_Road);
		second_prodVO.setSecond_Prod_Lon(second_Prod_Lon);
		second_prodVO.setSecond_Prod_Lat(second_Prod_Lat);
		dao.update(second_prodVO);
		return second_prodVO;
	}

	public void deleteSecond_Prod(String second_Prod_Id) {
		dao.delete(second_Prod_Id);
	}

	public Second_ProdVO getOneSecond_Prod(String second_Prod_Id) {
		return dao.findByPrimaryKey(second_Prod_Id);
	}

	public List<Second_ProdVO> getAll() {
		return dao.getAll();
	}

	public List<Second_ProdVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}

	public List<Second_ProdVO> getAll_ver02(Map<String, String[]> map,boolean able_like) {
		return ((Second_ProdDAO)dao).getAll_ver02(map,able_like);
	}	
}

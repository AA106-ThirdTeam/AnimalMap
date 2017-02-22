package heibernate_com.second_prodphotos.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.second_prod.model.Second_ProdVO;

public class Second_ProdPhotosService {

	private Second_ProdPhotos_interface dao;

	public Second_ProdPhotosService() {
		dao = new Second_ProdPhotosDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Second_ProdPhotosDAO_interface) context.getBean("empDAO");
	}
	
	public Second_ProdPhotosVO addSecond_ProdPhotos(
			String second_Prod_Id) {
		Second_ProdPhotosVO second_prodphotosVO = new Second_ProdPhotosVO();
		Second_ProdVO second_prodVO = new Second_ProdVO();
		second_prodVO.setSecond_Prod_Id(second_Prod_Id);
		second_prodphotosVO.setSecond_ProdVO(second_prodVO);
		dao.insert(second_prodphotosVO);
		return second_prodphotosVO;
	}
	
	public Second_ProdPhotosVO updateSecond_ProdPhotos(
			String second_ProdPhotos_Id
			,String second_Prod_Id) {	
		Second_ProdPhotosVO second_prodphotosVO = new Second_ProdPhotosVO();
		second_prodphotosVO.setSecond_ProdPhotos_Id(second_ProdPhotos_Id);
		Second_ProdVO second_prodVO = new Second_ProdVO();
		second_prodVO.setSecond_Prod_Id(second_Prod_Id);
		second_prodphotosVO.setSecond_ProdVO(second_prodVO);
		dao.update(second_prodphotosVO);
		return second_prodphotosVO;
	}

	public void deleteSecond_ProdPhotos(String second_ProdPhotos_Id) {
		dao.delete(second_ProdPhotos_Id);
	}

	public Second_ProdPhotosVO getOneSecond_ProdPhotos(String second_ProdPhotos_Id) {
		return dao.findByPrimaryKey(second_ProdPhotos_Id);
	}

	public List<Second_ProdPhotosVO> getAll() {
		return dao.getAll();
	}
	
}

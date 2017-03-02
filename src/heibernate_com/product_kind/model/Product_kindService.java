package heibernate_com.product_kind.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Product_kindService {

	private Product_kind_interface dao;

	public Product_kindService() {
		dao = new Product_kindDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Product_kindDAO_interface) context.getBean("empDAO");
	}
	
	public Product_kindVO addProduct_kind(
			String product_kind_name) {
		Product_kindVO product_kindVO = new Product_kindVO();
		product_kindVO.setProduct_kind_name(product_kind_name);
		dao.insert(product_kindVO);
		return product_kindVO;
	}
	
	public Product_kindVO updateProduct_kind(
			String product_kind_no
			,String product_kind_name) {	
		Product_kindVO product_kindVO = new Product_kindVO();
		product_kindVO.setProduct_kind_no(product_kind_no);
		product_kindVO.setProduct_kind_name(product_kind_name);
		dao.update(product_kindVO);
		return product_kindVO;
	}

	public void deleteProduct_kind(String product_kind_no) {
		dao.delete(product_kind_no);
	}

	public Product_kindVO getOneProduct_kind(String product_kind_no) {
		return dao.findByPrimaryKey(product_kind_no);
	}

	public List<Product_kindVO> getAll() {
		return dao.getAll();
	}

	public List<Product_kindVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}

	public List<Product_kindVO> getAll_ver02(Map<String, String[]> map,boolean able_like) {
		return ((Product_kindDAO)dao).getAll_ver02(map,able_like);
	}	
}

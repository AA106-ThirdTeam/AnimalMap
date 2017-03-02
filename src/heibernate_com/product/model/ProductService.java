package heibernate_com.product.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductService {

	private Product_interface dao;

	public ProductService() {
		dao = new ProductDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(ProductDAO_interface) context.getBean("empDAO");
	}
	
	public ProductVO addProduct(
			String product_name,String product_introduction,Integer product_price,Integer product_stock
			,String product_picture_large,String product_picture_small,Integer product_status,java.sql.Timestamp product_create_date
			,String product_info,String product_kind_no) {
		ProductVO productVO = new ProductVO();
		productVO.setProduct_name(product_name);
		productVO.setProduct_introduction(product_introduction);
		productVO.setProduct_price(product_price);
		productVO.setProduct_stock(product_stock);
		productVO.setProduct_picture_large(product_picture_large);
		productVO.setProduct_picture_small(product_picture_small);
		productVO.setProduct_status(product_status);
		productVO.setProduct_create_date(product_create_date);
		productVO.setProduct_info(product_info);
		productVO.setProduct_kind_no(product_kind_no);
		dao.insert(productVO);
		return productVO;
	}
	
	public ProductVO updateProduct(
			String product_no
			,String product_name,String product_introduction,Integer product_price,Integer product_stock
			,String product_picture_large,String product_picture_small,Integer product_status,java.sql.Timestamp product_create_date
			,String product_info,String product_kind_no) {	
		ProductVO productVO = new ProductVO();
		productVO.setProduct_no(product_no);
		productVO.setProduct_name(product_name);
		productVO.setProduct_introduction(product_introduction);
		productVO.setProduct_price(product_price);
		productVO.setProduct_stock(product_stock);
		productVO.setProduct_picture_large(product_picture_large);
		productVO.setProduct_picture_small(product_picture_small);
		productVO.setProduct_status(product_status);
		productVO.setProduct_create_date(product_create_date);
		productVO.setProduct_info(product_info);
		productVO.setProduct_kind_no(product_kind_no);
		dao.update(productVO);
		return productVO;
	}

	public void deleteProduct(String product_no) {
		dao.delete(product_no);
	}

	public ProductVO getOneProduct(String product_no) {
		return dao.findByPrimaryKey(product_no);
	}

	public List<ProductVO> getAll() {
		return dao.getAll();
	}

	public List<ProductVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}
}

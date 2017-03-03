package heibernate_com.orders_item.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.orders.model.OrdersVO;
import heibernate_com.product.model.ProductVO;

public class Orders_itemService {

	private Orders_item_interface dao;

	public Orders_itemService() {
		dao = new Orders_itemDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Orders_itemDAO_interface) context.getBean("empDAO");
	}
	
	public Orders_itemVO addOrders_item(
			Integer commodities_amount,Integer selling_price) {
		Orders_itemVO orders_itemVO = new Orders_itemVO();
		orders_itemVO.setCommodities_amount(commodities_amount);
		orders_itemVO.setSelling_price(selling_price);
		dao.insert(orders_itemVO);
		return orders_itemVO;
	}
	
	public Orders_itemVO updateOrders_item(
			String orders_no
			,String product_no,Integer commodities_amount,Integer selling_price) {	
		Orders_itemVO orders_itemVO = new Orders_itemVO();
		orders_itemVO.setCommodities_amount(commodities_amount);
		orders_itemVO.setSelling_price(selling_price);
		dao.update(orders_itemVO);
		return orders_itemVO;
	}

	public void deleteOrders_item(String orders_no) {
		dao.delete(orders_no);
	}

	public Orders_itemVO getOneOrders_item(String orders_no) {
		return dao.findByPrimaryKey(orders_no);
	}

	public List<Orders_itemVO> getAll() {
		return dao.getAll();
	}

	public List<Orders_itemVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}

	public List<Orders_itemVO> getAll_ver02(Map<String, String[]> map,boolean able_like) {
		return ((Orders_itemDAO)dao).getAll_ver02(map,able_like);
	}	
}

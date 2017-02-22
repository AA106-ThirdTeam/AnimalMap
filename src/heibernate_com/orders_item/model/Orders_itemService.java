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
			Integer commodities_amout,Integer selling_price
			) {
		Orders_itemVO orders_itemVO = new Orders_itemVO();
		orders_itemVO.setCommodities_amout(commodities_amout);
		orders_itemVO.setSelling_price(selling_price);
		dao.insert(orders_itemVO);
		return orders_itemVO;
	}
	
	public Orders_itemVO updateOrders_item(
			String orders_item_no
			,String orders_no,String product_no,Integer commodities_amout,Integer selling_price
			) {	
		Orders_itemVO orders_itemVO = new Orders_itemVO();
		orders_itemVO.setOrders_item_no(orders_item_no);
		OrdersVO ordersVO = new OrdersVO();
		ordersVO.setOrders_no(orders_no);
		orders_itemVO.setOrdersVO(ordersVO);
		ProductVO productVO = new ProductVO();
		productVO.setProduct_no(product_no);
		orders_itemVO.setProductVO(productVO);
		orders_itemVO.setCommodities_amout(commodities_amout);
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
	
}

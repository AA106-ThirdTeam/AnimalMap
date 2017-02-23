package heibernate_com.orders.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;

public class OrdersService {

	private Orders_interface dao;

	public OrdersService() {
		dao = new OrdersDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(OrdersDAO_interface) context.getBean("empDAO");
	}
	
	public OrdersVO addOrders(
			String mem_Id,String orders_receiver,String post_no,String post_adp_city
			,String post_town,String post_road,Integer orders_phone,Integer collect_mode_no
			,java.sql.Date orders_date,java.sql.Date orders_ship_date,Integer orders_total,Integer orders_status
			,Integer orders_credit) {
		OrdersVO ordersVO = new OrdersVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		ordersVO.setMemVO(memVO);
		ordersVO.setOrders_receiver(orders_receiver);
		ordersVO.setPost_no(post_no);
		ordersVO.setPost_adp_city(post_adp_city);
		ordersVO.setPost_town(post_town);
		ordersVO.setPost_road(post_road);
		ordersVO.setOrders_phone(orders_phone);
		ordersVO.setCollect_mode_no(collect_mode_no);
		ordersVO.setOrders_date(orders_date);
		ordersVO.setOrders_ship_date(orders_ship_date);
		ordersVO.setOrders_total(orders_total);
		ordersVO.setOrders_status(orders_status);
		ordersVO.setOrders_credit(orders_credit);
		dao.insert(ordersVO);
		return ordersVO;
	}
	
	public OrdersVO updateOrders(
			String orders_no
			,String mem_Id,String orders_receiver,String post_no,String post_adp_city
			,String post_town,String post_road,Integer orders_phone,Integer collect_mode_no
			,java.sql.Date orders_date,java.sql.Date orders_ship_date,Integer orders_total,Integer orders_status
			,Integer orders_credit) {	
		OrdersVO ordersVO = new OrdersVO();
		ordersVO.setOrders_no(orders_no);
		ordersVO.setOrders_receiver(orders_receiver);
		ordersVO.setPost_no(post_no);
		ordersVO.setPost_adp_city(post_adp_city);
		ordersVO.setPost_town(post_town);
		ordersVO.setPost_road(post_road);
		ordersVO.setOrders_phone(orders_phone);
		ordersVO.setCollect_mode_no(collect_mode_no);
		ordersVO.setOrders_date(orders_date);
		ordersVO.setOrders_ship_date(orders_ship_date);
		ordersVO.setOrders_total(orders_total);
		ordersVO.setOrders_status(orders_status);
		ordersVO.setOrders_credit(orders_credit);
		dao.update(ordersVO);
		return ordersVO;
	}

	public void deleteOrders(String orders_no) {
		dao.delete(orders_no);
	}

	public OrdersVO getOneOrders(String orders_no) {
		return dao.findByPrimaryKey(orders_no);
	}

	public List<OrdersVO> getAll() {
		return dao.getAll();
	}
	
}

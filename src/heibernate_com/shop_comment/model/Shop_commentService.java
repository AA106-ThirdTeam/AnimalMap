package heibernate_com.shop_comment.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;
import heibernate_com.petshop.model.PetShopVO;

public class Shop_commentService {

	private Shop_comment_interface dao;

	public Shop_commentService() {
		dao = new Shop_commentDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Shop_commentDAO_interface) context.getBean("empDAO");
	}
	
	public Shop_commentVO addShop_comment(
			String shopComment_MemId,String shopComment_ShopId,String shopComment_content,java.sql.Date shopComment_SendTime
			) {
		Shop_commentVO shop_commentVO = new Shop_commentVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(shopComment_MemId);
		shop_commentVO.setMemVO(memVO);
		PetShopVO petshopVO = new PetShopVO();
		petshopVO.setShop_Id(shopComment_ShopId);
		shop_commentVO.setPetShopVO(petshopVO);
		shop_commentVO.setShopComment_content(shopComment_content);
		shop_commentVO.setShopComment_SendTime(shopComment_SendTime);
		dao.insert(shop_commentVO);
		return shop_commentVO;
	}
	
	public Shop_commentVO updateShop_comment(
			String shopComment_Id
			,String shopComment_MemId,String shopComment_ShopId,String shopComment_content,java.sql.Date shopComment_SendTime
			) {	
		Shop_commentVO shop_commentVO = new Shop_commentVO();
		shop_commentVO.setShopComment_Id(shopComment_Id);
		shop_commentVO.setShopComment_content(shopComment_content);
		shop_commentVO.setShopComment_SendTime(shopComment_SendTime);
		dao.update(shop_commentVO);
		return shop_commentVO;
	}

	public void deleteShop_comment(String shopComment_Id) {
		dao.delete(shopComment_Id);
	}

	public Shop_commentVO getOneShop_comment(String shopComment_Id) {
		return dao.findByPrimaryKey(shopComment_Id);
	}

	public List<Shop_commentVO> getAll() {
		return dao.getAll();
	}
	
}

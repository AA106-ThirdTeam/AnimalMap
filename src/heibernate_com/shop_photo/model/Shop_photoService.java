package heibernate_com.shop_photo.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.petshop.model.PetShopVO;

public class Shop_photoService {

	private Shop_photo_interface dao;

	public Shop_photoService() {
		dao = new Shop_photoDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Shop_photoDAO_interface) context.getBean("empDAO");
	}
	
	public Shop_photoVO addShop_photo(
			String shopPhoto_ShopId,byte[] shopPhoto_photo,String isDisp_shopPhoto,String shopPhoto_name
			,String SHOPPHOTO_EXTENTION) {
		Shop_photoVO shop_photoVO = new Shop_photoVO();
		PetShopVO petshopVO = new PetShopVO();
		petshopVO.setShop_Id(shopPhoto_ShopId);
		shop_photoVO.setPetShopVO(petshopVO);
		shop_photoVO.setShopPhoto_photo(shopPhoto_photo);
		shop_photoVO.setIsDisp_shopPhoto(isDisp_shopPhoto);
		shop_photoVO.setShopPhoto_name(shopPhoto_name);
		shop_photoVO.setSHOPPHOTO_EXTENTION(SHOPPHOTO_EXTENTION);
		dao.insert(shop_photoVO);
		return shop_photoVO;
	}
	
	public Shop_photoVO updateShop_photo(
			String shopPhoto_Id
			,String shopPhoto_ShopId,byte[] shopPhoto_photo,String isDisp_shopPhoto,String shopPhoto_name
			,String SHOPPHOTO_EXTENTION) {	
		Shop_photoVO shop_photoVO = new Shop_photoVO();
		shop_photoVO.setShopPhoto_Id(shopPhoto_Id);
		shop_photoVO.setShopPhoto_photo(shopPhoto_photo);
		shop_photoVO.setIsDisp_shopPhoto(isDisp_shopPhoto);
		shop_photoVO.setShopPhoto_name(shopPhoto_name);
		shop_photoVO.setSHOPPHOTO_EXTENTION(SHOPPHOTO_EXTENTION);
		dao.update(shop_photoVO);
		return shop_photoVO;
	}

	public void deleteShop_photo(String shopPhoto_Id) {
		dao.delete(shopPhoto_Id);
	}

	public Shop_photoVO getOneShop_photo(String shopPhoto_Id) {
		return dao.findByPrimaryKey(shopPhoto_Id);
	}

	public List<Shop_photoVO> getAll() {
		return dao.getAll();
	}

	public List<Shop_photoVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}
}

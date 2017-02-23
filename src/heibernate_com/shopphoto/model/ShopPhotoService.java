package heibernate_com.shopphoto.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.petshop.model.PetShopVO;

public class ShopPhotoService {

	private ShopPhoto_interface dao;

	public ShopPhotoService() {
		dao = new ShopPhotoDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(ShopPhotoDAO_interface) context.getBean("empDAO");
	}
	
	public ShopPhotoVO addShopPhoto(
			String shopPhoto_ShopId,byte[] shopPhoto_photo,String isDisp_shopPhoto,String shopPhoto_name
			,String shopPhoto_extent) {
		ShopPhotoVO shopphotoVO = new ShopPhotoVO();
		PetShopVO petshopVO = new PetShopVO();
		petshopVO.setShop_Id(shopPhoto_ShopId);
		shopphotoVO.setPetShopVO(petshopVO);
		shopphotoVO.setShopPhoto_photo(shopPhoto_photo);
		shopphotoVO.setIsDisp_shopPhoto(isDisp_shopPhoto);
		shopphotoVO.setShopPhoto_name(shopPhoto_name);
		shopphotoVO.setShopPhoto_extent(shopPhoto_extent);
		dao.insert(shopphotoVO);
		return shopphotoVO;
	}
	
	public ShopPhotoVO updateShopPhoto(
			String shopPhoto_Id
			,String shopPhoto_ShopId,byte[] shopPhoto_photo,String isDisp_shopPhoto,String shopPhoto_name
			,String shopPhoto_extent) {	
		ShopPhotoVO shopphotoVO = new ShopPhotoVO();
		shopphotoVO.setShopPhoto_Id(shopPhoto_Id);
		shopphotoVO.setShopPhoto_photo(shopPhoto_photo);
		shopphotoVO.setIsDisp_shopPhoto(isDisp_shopPhoto);
		shopphotoVO.setShopPhoto_name(shopPhoto_name);
		shopphotoVO.setShopPhoto_extent(shopPhoto_extent);
		dao.update(shopphotoVO);
		return shopphotoVO;
	}

	public void deleteShopPhoto(String shopPhoto_Id) {
		dao.delete(shopPhoto_Id);
	}

	public ShopPhotoVO getOneShopPhoto(String shopPhoto_Id) {
		return dao.findByPrimaryKey(shopPhoto_Id);
	}

	public List<ShopPhotoVO> getAll() {
		return dao.getAll();
	}

	public List<ShopPhotoVO> getAll(Map<String, String[]> map) {
		return dao.getAll(map);
	}
}

package heibernate_com.petshop.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;

public class PetShopService {

	private PetShop_interface dao;

	public PetShopService() {
		dao = new PetShopDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(PetShopDAO_interface) context.getBean("empDAO");
	}
	
	public PetShopVO addPetShop(
			String shop_MemId,String shop_name,String shop_city,String shop_town
			,String shop_road,Integer shop_Eval,String shop_URL,String shop_StartTime
			,String shop_EndTime,java.sql.Date shop_CreateTime,String shop_Tel,String shop_Desc
			,Double shop_Long,Double shop_Lat,String shop_visible) {
		PetShopVO petshopVO = new PetShopVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(shop_MemId);
		petshopVO.setMemVO(memVO);
		petshopVO.setShop_name(shop_name);
		petshopVO.setShop_city(shop_city);
		petshopVO.setShop_town(shop_town);
		petshopVO.setShop_road(shop_road);
		petshopVO.setShop_Eval(shop_Eval);
		petshopVO.setShop_URL(shop_URL);
		petshopVO.setShop_StartTime(shop_StartTime);
		petshopVO.setShop_EndTime(shop_EndTime);
		petshopVO.setShop_CreateTime(shop_CreateTime);
		petshopVO.setShop_Tel(shop_Tel);
		petshopVO.setShop_Desc(shop_Desc);
		petshopVO.setShop_Long(shop_Long);
		petshopVO.setShop_Lat(shop_Lat);
		petshopVO.setShop_visible(shop_visible);
		dao.insert(petshopVO);
		return petshopVO;
	}
	
	public PetShopVO updatePetShop(
			String shop_Id
			,String shop_MemId,String shop_name,String shop_city,String shop_town
			,String shop_road,Integer shop_Eval,String shop_URL,String shop_StartTime
			,String shop_EndTime,java.sql.Date shop_CreateTime,String shop_Tel,String shop_Desc
			,Double shop_Long,Double shop_Lat,String shop_visible) {	
		PetShopVO petshopVO = new PetShopVO();
		petshopVO.setShop_Id(shop_Id);
		petshopVO.setShop_name(shop_name);
		petshopVO.setShop_city(shop_city);
		petshopVO.setShop_town(shop_town);
		petshopVO.setShop_road(shop_road);
		petshopVO.setShop_Eval(shop_Eval);
		petshopVO.setShop_URL(shop_URL);
		petshopVO.setShop_StartTime(shop_StartTime);
		petshopVO.setShop_EndTime(shop_EndTime);
		petshopVO.setShop_CreateTime(shop_CreateTime);
		petshopVO.setShop_Tel(shop_Tel);
		petshopVO.setShop_Desc(shop_Desc);
		petshopVO.setShop_Long(shop_Long);
		petshopVO.setShop_Lat(shop_Lat);
		petshopVO.setShop_visible(shop_visible);
		dao.update(petshopVO);
		return petshopVO;
	}

	public void deletePetShop(String shop_Id) {
		dao.delete(shop_Id);
	}

	public PetShopVO getOnePetShop(String shop_Id) {
		return dao.findByPrimaryKey(shop_Id);
	}

	public List<PetShopVO> getAll() {
		return dao.getAll();
	}

	public List<PetShopVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}
}

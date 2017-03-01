package heibernate_com.adpphotos.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.adp.model.AdpVO;

public class AdpPhotosService {

	private AdpPhotos_interface dao;

	public AdpPhotosService() {
		dao = new AdpPhotosDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(AdpPhotosDAO_interface) context.getBean("empDAO");
	}
	
	public AdpPhotosVO addAdpPhotos(
			String adp_Id,String adpPhotosPic) {
		AdpPhotosVO adpphotosVO = new AdpPhotosVO();
		AdpVO adpVO = new AdpVO();
		adpVO.setAdp_Id(adp_Id);
		adpphotosVO.setAdpVO(adpVO);
		adpphotosVO.setAdpPhotosPic(adpPhotosPic);
		dao.insert(adpphotosVO);
		return adpphotosVO;
	}
	
	public AdpPhotosVO updateAdpPhotos(
			String adpPhotos_Id
			,String adp_Id,String adpPhotosPic) {	
		AdpPhotosVO adpphotosVO = new AdpPhotosVO();
		adpphotosVO.setAdpPhotos_Id(adpPhotos_Id);
		adpphotosVO.setAdpPhotosPic(adpPhotosPic);
		dao.update(adpphotosVO);
		return adpphotosVO;
	}

	public void deleteAdpPhotos(String adpPhotos_Id) {
		dao.delete(adpPhotos_Id);
	}

	public AdpPhotosVO getOneAdpPhotos(String adpPhotos_Id) {
		return dao.findByPrimaryKey(adpPhotos_Id);
	}

	public List<AdpPhotosVO> getAll() {
		return dao.getAll();
	}

	public List<AdpPhotosVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}
}

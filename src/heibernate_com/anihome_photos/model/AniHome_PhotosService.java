package heibernate_com.anihome_photos.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.anihome.model.AniHomeVO;

public class AniHome_PhotosService {

	private AniHome_Photos_interface dao;

	public AniHome_PhotosService() {
		dao = new AniHome_PhotosDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(AniHome_PhotosDAO_interface) context.getBean("empDAO");
	}
	
	public AniHome_PhotosVO addAniHome_Photos(
			String aniHome_Id,String aniHome_Photos_pic) {
		AniHome_PhotosVO anihome_photosVO = new AniHome_PhotosVO();
		AniHomeVO anihomeVO = new AniHomeVO();
		anihomeVO.setAniHome_Id(aniHome_Id);
		anihome_photosVO.setAniHomeVO(anihomeVO);
		anihome_photosVO.setAniHome_Photos_pic(aniHome_Photos_pic);
		dao.insert(anihome_photosVO);
		return anihome_photosVO;
	}
	
	public AniHome_PhotosVO updateAniHome_Photos(
			String aniHome_Photos_Id
			,String aniHome_Id,String aniHome_Photos_pic) {	
		AniHome_PhotosVO anihome_photosVO = new AniHome_PhotosVO();
		anihome_photosVO.setAniHome_Photos_Id(aniHome_Photos_Id);
		anihome_photosVO.setAniHome_Photos_pic(aniHome_Photos_pic);
		dao.update(anihome_photosVO);
		return anihome_photosVO;
	}

	public void deleteAniHome_Photos(String aniHome_Photos_Id) {
		dao.delete(aniHome_Photos_Id);
	}

	public AniHome_PhotosVO getOneAniHome_Photos(String aniHome_Photos_Id) {
		return dao.findByPrimaryKey(aniHome_Photos_Id);
	}

	public List<AniHome_PhotosVO> getAll() {
		return dao.getAll();
	}
	
}

package heibernate_com.hosphoto.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.vet_hospital.model.Vet_hospitalVO;

public class HosPhotoService {

	private HosPhoto_interface dao;

	public HosPhotoService() {
		dao = new HosPhotoDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(HosPhotoDAO_interface) context.getBean("empDAO");
	}
	
	public HosPhotoVO addHosPhoto(
			String hosPhoto_HosId,byte[] hosPhoto_photo,String isDisp_HosPhoto,String hosPhoto_name
			,String hosPhoto_extent) {
		HosPhotoVO hosphotoVO = new HosPhotoVO();
		Vet_hospitalVO vet_hospitalVO = new Vet_hospitalVO();
		vet_hospitalVO.setHos_Id(hosPhoto_HosId);
		hosphotoVO.setVet_hospitalVO(vet_hospitalVO);
		hosphotoVO.setHosPhoto_photo(hosPhoto_photo);
		hosphotoVO.setIsDisp_HosPhoto(isDisp_HosPhoto);
		hosphotoVO.setHosPhoto_name(hosPhoto_name);
		hosphotoVO.setHosPhoto_extent(hosPhoto_extent);
		dao.insert(hosphotoVO);
		return hosphotoVO;
	}
	
	public HosPhotoVO updateHosPhoto(
			String hosPhoto_Id
			,String hosPhoto_HosId,byte[] hosPhoto_photo,String isDisp_HosPhoto,String hosPhoto_name
			,String hosPhoto_extent) {	
		HosPhotoVO hosphotoVO = new HosPhotoVO();
		hosphotoVO.setHosPhoto_Id(hosPhoto_Id);
		hosphotoVO.setHosPhoto_photo(hosPhoto_photo);
		hosphotoVO.setIsDisp_HosPhoto(isDisp_HosPhoto);
		hosphotoVO.setHosPhoto_name(hosPhoto_name);
		hosphotoVO.setHosPhoto_extent(hosPhoto_extent);
		dao.update(hosphotoVO);
		return hosphotoVO;
	}

	public void deleteHosPhoto(String hosPhoto_Id) {
		dao.delete(hosPhoto_Id);
	}

	public HosPhotoVO getOneHosPhoto(String hosPhoto_Id) {
		return dao.findByPrimaryKey(hosPhoto_Id);
	}

	public List<HosPhotoVO> getAll() {
		return dao.getAll();
	}

	public List<HosPhotoVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}
}

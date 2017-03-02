package heibernate_com.hos_photo.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.vet_hospital.model.Vet_hospitalVO;

public class Hos_photoService {

	private Hos_photo_interface dao;

	public Hos_photoService() {
		dao = new Hos_photoDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Hos_photoDAO_interface) context.getBean("empDAO");
	}
	
	public Hos_photoVO addHos_photo(
			String hosPhoto_HosId,byte[] hosPhoto_photo,String isDisp_HosPhoto,String hosPhoto_name
			,String HOSPHOTO_EXTENTION) {
		Hos_photoVO hos_photoVO = new Hos_photoVO();
		Vet_hospitalVO vet_hospitalVO = new Vet_hospitalVO();
		vet_hospitalVO.setHos_Id(hosPhoto_HosId);
		hos_photoVO.setVet_hospitalVO(vet_hospitalVO);
		hos_photoVO.setHosPhoto_photo(hosPhoto_photo);
		hos_photoVO.setIsDisp_HosPhoto(isDisp_HosPhoto);
		hos_photoVO.setHosPhoto_name(hosPhoto_name);
		hos_photoVO.setHOSPHOTO_EXTENTION(HOSPHOTO_EXTENTION);
		dao.insert(hos_photoVO);
		return hos_photoVO;
	}
	
	public Hos_photoVO updateHos_photo(
			String hosPhoto_Id
			,String hosPhoto_HosId,byte[] hosPhoto_photo,String isDisp_HosPhoto,String hosPhoto_name
			,String HOSPHOTO_EXTENTION) {	
		Hos_photoVO hos_photoVO = new Hos_photoVO();
		hos_photoVO.setHosPhoto_Id(hosPhoto_Id);
		hos_photoVO.setHosPhoto_photo(hosPhoto_photo);
		hos_photoVO.setIsDisp_HosPhoto(isDisp_HosPhoto);
		hos_photoVO.setHosPhoto_name(hosPhoto_name);
		hos_photoVO.setHOSPHOTO_EXTENTION(HOSPHOTO_EXTENTION);
		dao.update(hos_photoVO);
		return hos_photoVO;
	}

	public void deleteHos_photo(String hosPhoto_Id) {
		dao.delete(hosPhoto_Id);
	}

	public Hos_photoVO getOneHos_photo(String hosPhoto_Id) {
		return dao.findByPrimaryKey(hosPhoto_Id);
	}

	public List<Hos_photoVO> getAll() {
		return dao.getAll();
	}

	public List<Hos_photoVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}

	public List<Hos_photoVO> getAll_ver02(Map<String, String[]> map,boolean able_like) {
		return ((Hos_photoDAO)dao).getAll_ver02(map,able_like);
	}	
}

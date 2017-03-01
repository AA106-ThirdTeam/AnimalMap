package heibernate_com.adoanispo.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.adopt_ani.model.Adopt_AniVO;
import heibernate_com.mem.model.MemVO;

public class AdoAniSpoService {

	private AdoAniSpo_interface dao;

	public AdoAniSpoService() {
		dao = new AdoAniSpoDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(AdoAniSpoDAO_interface) context.getBean("empDAO");
	}
	
	public AdoAniSpoVO addAdoAniSpo(
			String adopt_Ani_Id,String mem_Id,Integer adoAniSpoMoney,String adoAniSpoMat
			) {
		AdoAniSpoVO adoanispoVO = new AdoAniSpoVO();
		Adopt_AniVO adopt_aniVO = new Adopt_AniVO();
		adopt_aniVO.setAdopt_Ani_Id(adopt_Ani_Id);
		adoanispoVO.setAdopt_AniVO(adopt_aniVO);
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		adoanispoVO.setMemVO(memVO);
		adoanispoVO.setAdoAniSpoMoney(adoAniSpoMoney);
		adoanispoVO.setAdoAniSpoMat(adoAniSpoMat);
		dao.insert(adoanispoVO);
		return adoanispoVO;
	}
	
	public AdoAniSpoVO updateAdoAniSpo(
			String adoAniSpoNo
			,String adopt_Ani_Id,String mem_Id,Integer adoAniSpoMoney,String adoAniSpoMat
			) {	
		AdoAniSpoVO adoanispoVO = new AdoAniSpoVO();
		adoanispoVO.setAdoAniSpoNo(adoAniSpoNo);
		adoanispoVO.setAdoAniSpoMoney(adoAniSpoMoney);
		adoanispoVO.setAdoAniSpoMat(adoAniSpoMat);
		dao.update(adoanispoVO);
		return adoanispoVO;
	}

	public void deleteAdoAniSpo(String adoAniSpoNo) {
		dao.delete(adoAniSpoNo);
	}

	public AdoAniSpoVO getOneAdoAniSpo(String adoAniSpoNo) {
		return dao.findByPrimaryKey(adoAniSpoNo);
	}

	public List<AdoAniSpoVO> getAll() {
		return dao.getAll();
	}

	public List<AdoAniSpoVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}
}

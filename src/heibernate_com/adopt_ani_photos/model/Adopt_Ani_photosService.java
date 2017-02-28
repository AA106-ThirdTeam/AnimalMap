package heibernate_com.adopt_ani_photos.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.adopt_ani.model.Adopt_AniVO;
import heibernate_com.mem.model.MemVO;

public class Adopt_Ani_photosService {

	private Adopt_Ani_photos_interface dao;

	public Adopt_Ani_photosService() {
		dao = new Adopt_Ani_photosDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Adopt_Ani_photosDAO_interface) context.getBean("empDAO");
	}
	
	public Adopt_Ani_photosVO addAdopt_Ani_photos(
			String adopt_Ani_Id,String mem_Id,byte[] ado_Ani_Pic,String ado_Pic_name
			,String ado_Pic_nameEX,java.sql.Timestamp ado_Pic_time,String ado_Pic_type) {
		Adopt_Ani_photosVO adopt_ani_photosVO = new Adopt_Ani_photosVO();
		Adopt_AniVO adopt_aniVO = new Adopt_AniVO();
		adopt_aniVO.setAdopt_Ani_Id(adopt_Ani_Id);
		adopt_ani_photosVO.setAdopt_AniVO(adopt_aniVO);
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		adopt_ani_photosVO.setMemVO(memVO);
		adopt_ani_photosVO.setAdo_Ani_Pic(ado_Ani_Pic);
		adopt_ani_photosVO.setAdo_Pic_name(ado_Pic_name);
		adopt_ani_photosVO.setAdo_Pic_nameEX(ado_Pic_nameEX);
		adopt_ani_photosVO.setAdo_Pic_time(ado_Pic_time);
		adopt_ani_photosVO.setAdo_Pic_type(ado_Pic_type);
		dao.insert(adopt_ani_photosVO);
		return adopt_ani_photosVO;
	}
	
	public Adopt_Ani_photosVO updateAdopt_Ani_photos(
			String ado_Ani_Pic_No
			,String adopt_Ani_Id,String mem_Id,byte[] ado_Ani_Pic,String ado_Pic_name
			,String ado_Pic_nameEX,java.sql.Timestamp ado_Pic_time,String ado_Pic_type) {	
		Adopt_Ani_photosVO adopt_ani_photosVO = new Adopt_Ani_photosVO();
		adopt_ani_photosVO.setAdo_Ani_Pic_No(ado_Ani_Pic_No);
		adopt_ani_photosVO.setAdo_Ani_Pic(ado_Ani_Pic);
		adopt_ani_photosVO.setAdo_Pic_name(ado_Pic_name);
		adopt_ani_photosVO.setAdo_Pic_nameEX(ado_Pic_nameEX);
		adopt_ani_photosVO.setAdo_Pic_time(ado_Pic_time);
		adopt_ani_photosVO.setAdo_Pic_type(ado_Pic_type);
		dao.update(adopt_ani_photosVO);
		return adopt_ani_photosVO;
	}

	public void deleteAdopt_Ani_photos(String ado_Ani_Pic_No) {
		dao.delete(ado_Ani_Pic_No);
	}

	public Adopt_Ani_photosVO getOneAdopt_Ani_photos(String ado_Ani_Pic_No) {
		return dao.findByPrimaryKey(ado_Ani_Pic_No);
	}

	public List<Adopt_Ani_photosVO> getAll() {
		return dao.getAll();
	}

	public List<Adopt_Ani_photosVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}
}

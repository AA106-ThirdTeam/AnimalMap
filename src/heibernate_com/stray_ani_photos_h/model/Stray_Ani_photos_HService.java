package heibernate_com.stray_ani_photos_h.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.stray_ani.model.Stray_AniVO;
import heibernate_com.mem.model.MemVO;

public class Stray_Ani_photos_HService {

	private Stray_Ani_photos_H_interface dao;

	public Stray_Ani_photos_HService() {
		dao = new Stray_Ani_photos_HDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Stray_Ani_photos_HDAO_interface) context.getBean("empDAO");
	}
	
	public Stray_Ani_photos_HVO addStray_Ani_photos_H(
			String stray_Ani_Id,String mem_Id,byte[] stray_Ani_Pic,String stray_Pic_name
			,String stray_Pic_extent,java.sql.Date stray_Pic_time,String stray_Pic_type) {
		Stray_Ani_photos_HVO stray_ani_photos_hVO = new Stray_Ani_photos_HVO();
		Stray_AniVO stray_aniVO = new Stray_AniVO();
		stray_aniVO.setStray_Ani_Id(stray_Ani_Id);
		stray_ani_photos_hVO.setStray_AniVO(stray_aniVO);
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		stray_ani_photos_hVO.setMemVO(memVO);
		stray_ani_photos_hVO.setStray_Ani_Pic(stray_Ani_Pic);
		stray_ani_photos_hVO.setStray_Pic_name(stray_Pic_name);
		stray_ani_photos_hVO.setStray_Pic_extent(stray_Pic_extent);
		stray_ani_photos_hVO.setStray_Pic_time(stray_Pic_time);
		stray_ani_photos_hVO.setStray_Pic_type(stray_Pic_type);
		dao.insert(stray_ani_photos_hVO);
		return stray_ani_photos_hVO;
	}
	
	public Stray_Ani_photos_HVO updateStray_Ani_photos_H(
			String str_Ani_Pic_No
			,String stray_Ani_Id,String mem_Id,byte[] stray_Ani_Pic,String stray_Pic_name
			,String stray_Pic_extent,java.sql.Date stray_Pic_time,String stray_Pic_type) {	
		Stray_Ani_photos_HVO stray_ani_photos_hVO = new Stray_Ani_photos_HVO();
		stray_ani_photos_hVO.setStr_Ani_Pic_No(str_Ani_Pic_No);
		Stray_AniVO stray_aniVO = new Stray_AniVO();
		stray_aniVO.setStray_Ani_Id(stray_Ani_Id);
		stray_ani_photos_hVO.setStray_AniVO(stray_aniVO);
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		stray_ani_photos_hVO.setMemVO(memVO);
		stray_ani_photos_hVO.setStray_Ani_Pic(stray_Ani_Pic);
		stray_ani_photos_hVO.setStray_Pic_name(stray_Pic_name);
		stray_ani_photos_hVO.setStray_Pic_extent(stray_Pic_extent);
		stray_ani_photos_hVO.setStray_Pic_time(stray_Pic_time);
		stray_ani_photos_hVO.setStray_Pic_type(stray_Pic_type);
		dao.update(stray_ani_photos_hVO);
		return stray_ani_photos_hVO;
	}

	public void deleteStray_Ani_photos_H(String str_Ani_Pic_No) {
		dao.delete(str_Ani_Pic_No);
	}

	public Stray_Ani_photos_HVO getOneStray_Ani_photos_H(String str_Ani_Pic_No) {
		return dao.findByPrimaryKey(str_Ani_Pic_No);
	}

	public List<Stray_Ani_photos_HVO> getAll() {
		return dao.getAll();
	}
	
}

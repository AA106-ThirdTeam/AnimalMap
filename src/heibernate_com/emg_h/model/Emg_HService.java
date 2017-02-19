package heibernate_com.emg_h.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;

public class Emg_HService {

	private Emg_H_interface dao;

	public Emg_HService() {
		dao = new Emg_HDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Emg_HDAO_interface) context.getBean("empDAO");
	}
	
	public Emg_HVO addEmg_H(
			String mem_Id,java.sql.Date emg_H_start_date,java.sql.Date emg_H_end_date,String emg_H_title
			,String emg_H_content,byte[] emg_H_Pic,String emg_H_Pic_format,String emg_H_city
			,String emg_H_town,String emg_H_road,Double emg_H_Lon,Double emg_H_Lat
			) {
		Emg_HVO emg_hVO = new Emg_HVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		emg_hVO.setMemVO(memVO);
		emg_hVO.setEmg_H_start_date(emg_H_start_date);
		emg_hVO.setEmg_H_end_date(emg_H_end_date);
		emg_hVO.setEmg_H_title(emg_H_title);
		emg_hVO.setEmg_H_content(emg_H_content);
		emg_hVO.setEmg_H_Pic(emg_H_Pic);
		emg_hVO.setEmg_H_Pic_format(emg_H_Pic_format);
		emg_hVO.setEmg_H_city(emg_H_city);
		emg_hVO.setEmg_H_town(emg_H_town);
		emg_hVO.setEmg_H_road(emg_H_road);
		emg_hVO.setEmg_H_Lon(emg_H_Lon);
		emg_hVO.setEmg_H_Lat(emg_H_Lat);
		dao.insert(emg_hVO);
		return emg_hVO;
	}
	
	public Emg_HVO updateEmg_H(
			String emg_H_Id
			,String mem_Id,java.sql.Date emg_H_start_date,java.sql.Date emg_H_end_date,String emg_H_title
			,String emg_H_content,byte[] emg_H_Pic,String emg_H_Pic_format,String emg_H_city
			,String emg_H_town,String emg_H_road,Double emg_H_Lon,Double emg_H_Lat
			) {	
		Emg_HVO emg_hVO = new Emg_HVO();
		emg_hVO.setEmg_H_Id(emg_H_Id);
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		emg_hVO.setMemVO(memVO);
		emg_hVO.setEmg_H_start_date(emg_H_start_date);
		emg_hVO.setEmg_H_end_date(emg_H_end_date);
		emg_hVO.setEmg_H_title(emg_H_title);
		emg_hVO.setEmg_H_content(emg_H_content);
		emg_hVO.setEmg_H_Pic(emg_H_Pic);
		emg_hVO.setEmg_H_Pic_format(emg_H_Pic_format);
		emg_hVO.setEmg_H_city(emg_H_city);
		emg_hVO.setEmg_H_town(emg_H_town);
		emg_hVO.setEmg_H_road(emg_H_road);
		emg_hVO.setEmg_H_Lon(emg_H_Lon);
		emg_hVO.setEmg_H_Lat(emg_H_Lat);
		dao.update(emg_hVO);
		return emg_hVO;
	}

	public void deleteEmg_H(String emg_H_Id) {
		dao.delete(emg_H_Id);
	}

	public Emg_HVO getOneEmg_H(String emg_H_Id) {
		return dao.findByPrimaryKey(emg_H_Id);
	}

	public List<Emg_HVO> getAll() {
		return dao.getAll();
	}
	
}

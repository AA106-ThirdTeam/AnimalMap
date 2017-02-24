package heibernate_com.emg_help.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;

public class Emg_HelpService {

	private Emg_Help_interface dao;

	public Emg_HelpService() {
		dao = new Emg_HelpDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Emg_HelpDAO_interface) context.getBean("empDAO");
	}
	
	public Emg_HelpVO addEmg_Help(
			String mem_Id,java.sql.Date emg_H_start_date,java.sql.Date emg_H_end_date,String emg_H_title
			,String emg_H_content,byte[] emg_H_Pic,String emg_H_Pic_format,String emg_H_city
			,String emg_H_town,String emg_H_road,Double emg_H_Lon,Double emg_H_Lat
			,String emg_H_status) {
		Emg_HelpVO emg_helpVO = new Emg_HelpVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		emg_helpVO.setMemVO(memVO);
		emg_helpVO.setEmg_H_start_date(emg_H_start_date);
		emg_helpVO.setEmg_H_end_date(emg_H_end_date);
		emg_helpVO.setEmg_H_title(emg_H_title);
		emg_helpVO.setEmg_H_content(emg_H_content);
		emg_helpVO.setEmg_H_Pic(emg_H_Pic);
		emg_helpVO.setEmg_H_Pic_format(emg_H_Pic_format);
		emg_helpVO.setEmg_H_city(emg_H_city);
		emg_helpVO.setEmg_H_town(emg_H_town);
		emg_helpVO.setEmg_H_road(emg_H_road);
		emg_helpVO.setEmg_H_Lon(emg_H_Lon);
		emg_helpVO.setEmg_H_Lat(emg_H_Lat);
		emg_helpVO.setEmg_H_status(emg_H_status);
		dao.insert(emg_helpVO);
		return emg_helpVO;
	}
	
	public Emg_HelpVO updateEmg_Help(
			String emg_H_Id
			,String mem_Id,java.sql.Date emg_H_start_date,java.sql.Date emg_H_end_date,String emg_H_title
			,String emg_H_content,byte[] emg_H_Pic,String emg_H_Pic_format,String emg_H_city
			,String emg_H_town,String emg_H_road,Double emg_H_Lon,Double emg_H_Lat
			,String emg_H_status) {	
		Emg_HelpVO emg_helpVO = new Emg_HelpVO();
		emg_helpVO.setEmg_H_Id(emg_H_Id);
		emg_helpVO.setEmg_H_start_date(emg_H_start_date);
		emg_helpVO.setEmg_H_end_date(emg_H_end_date);
		emg_helpVO.setEmg_H_title(emg_H_title);
		emg_helpVO.setEmg_H_content(emg_H_content);
		emg_helpVO.setEmg_H_Pic(emg_H_Pic);
		emg_helpVO.setEmg_H_Pic_format(emg_H_Pic_format);
		emg_helpVO.setEmg_H_city(emg_H_city);
		emg_helpVO.setEmg_H_town(emg_H_town);
		emg_helpVO.setEmg_H_road(emg_H_road);
		emg_helpVO.setEmg_H_Lon(emg_H_Lon);
		emg_helpVO.setEmg_H_Lat(emg_H_Lat);
		emg_helpVO.setEmg_H_status(emg_H_status);
		dao.update(emg_helpVO);
		return emg_helpVO;
	}

	public void deleteEmg_Help(String emg_H_Id) {
		dao.delete(emg_H_Id);
	}

	public Emg_HelpVO getOneEmg_Help(String emg_H_Id) {
		return dao.findByPrimaryKey(emg_H_Id);
	}

	public List<Emg_HelpVO> getAll() {
		return dao.getAll();
	}

	public List<Emg_HelpVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}
}

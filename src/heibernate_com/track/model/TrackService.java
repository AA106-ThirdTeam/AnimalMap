package heibernate_com.track.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;

public class TrackService {

	private Track_interface dao;

	public TrackService() {
		dao = new TrackDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(TrackDAO_interface) context.getBean("empDAO");
	}
	
	public TrackVO addTrack(
			String mem_Id,String track_record_class,String track_record_class_Id) {
		TrackVO trackVO = new TrackVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		trackVO.setMemVO(memVO);
		trackVO.setTrack_record_class(track_record_class);
		trackVO.setTrack_record_class_Id(track_record_class_Id);
		dao.insert(trackVO);
		return trackVO;
	}
	
	public TrackVO updateTrack(
			String track_Id
			,String mem_Id,String track_record_class,String track_record_class_Id) {	
		TrackVO trackVO = new TrackVO();
		trackVO.setTrack_Id(track_Id);
		trackVO.setTrack_record_class(track_record_class);
		trackVO.setTrack_record_class_Id(track_record_class_Id);
		dao.update(trackVO);
		return trackVO;
	}

	public void deleteTrack(String track_Id) {
		dao.delete(track_Id);
	}

	public TrackVO getOneTrack(String track_Id) {
		return dao.findByPrimaryKey(track_Id);
	}

	public List<TrackVO> getAll() {
		return dao.getAll();
	}
	
}

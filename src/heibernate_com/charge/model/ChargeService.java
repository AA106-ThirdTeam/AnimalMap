package heibernate_com.charge.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;

public class ChargeService {

	private Charge_interface dao;

	public ChargeService() {
		dao = new ChargeDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(ChargeDAO_interface) context.getBean("empDAO");
	}
	
	public ChargeVO addCharge(
			String mem_Id,Integer charge_NUMBER,Integer pay,java.sql.Date applytime
			) {
		ChargeVO chargeVO = new ChargeVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		chargeVO.setMemVO(memVO);
		chargeVO.setCharge_NUMBER(charge_NUMBER);
		chargeVO.setPay(pay);
		chargeVO.setApplytime(applytime);
		dao.insert(chargeVO);
		return chargeVO;
	}
	
	public ChargeVO updateCharge(
			String charge_no
			,String mem_Id,Integer charge_NUMBER,Integer pay,java.sql.Date applytime
			) {	
		ChargeVO chargeVO = new ChargeVO();
		chargeVO.setCharge_no(charge_no);
		chargeVO.setCharge_NUMBER(charge_NUMBER);
		chargeVO.setPay(pay);
		chargeVO.setApplytime(applytime);
		dao.update(chargeVO);
		return chargeVO;
	}

	public void deleteCharge(String charge_no) {
		dao.delete(charge_no);
	}

	public ChargeVO getOneCharge(String charge_no) {
		return dao.findByPrimaryKey(charge_no);
	}

	public List<ChargeVO> getAll() {
		return dao.getAll();
	}

	public List<ChargeVO> getAll(Map<String, String[]> map) {
		return dao.getAll(map);
	}
}

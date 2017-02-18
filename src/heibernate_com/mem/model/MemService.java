package heibernate_com.mem.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemService {

	private Mem_interface dao;

	public MemService() {
		dao = new MemDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(MemDAO_interface) context.getBean("empDAO");
	}
	
	public MemVO addMem(
			String mem_email,String mem_account,String mem_Psw,String mem_nick_name
			,String mem_name,String mem_gender,String mem_Tw_Id,java.sql.Date mem_birth_date
			,String mem_phone,String mem_Intro,byte[] mem_profile,String mem_black_list
			,String mem_permission,String mem_setting,Integer mem_balance) {
		MemVO memVO = new MemVO();
		memVO.setMem_email(mem_email);
		memVO.setMem_account(mem_account);
		memVO.setMem_Psw(mem_Psw);
		memVO.setMem_nick_name(mem_nick_name);
		memVO.setMem_name(mem_name);
		memVO.setMem_gender(mem_gender);
		memVO.setMem_Tw_Id(mem_Tw_Id);
		memVO.setMem_birth_date(mem_birth_date);
		memVO.setMem_phone(mem_phone);
		memVO.setMem_Intro(mem_Intro);
		memVO.setMem_profile(mem_profile);
		memVO.setMem_black_list(mem_black_list);
		memVO.setMem_permission(mem_permission);
		memVO.setMem_setting(mem_setting);
		memVO.setMem_balance(mem_balance);
		dao.insert(memVO);
		return memVO;
	}
	
	public MemVO updateMem(
			Integer mem_Id
			,String mem_email,String mem_account,String mem_Psw,String mem_nick_name
			,String mem_name,String mem_gender,String mem_Tw_Id,java.sql.Date mem_birth_date
			,String mem_phone,String mem_Intro,byte[] mem_profile,String mem_black_list
			,String mem_permission,String mem_setting,Integer mem_balance) {	
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		memVO.setMem_email(mem_email);
		memVO.setMem_account(mem_account);
		memVO.setMem_Psw(mem_Psw);
		memVO.setMem_nick_name(mem_nick_name);
		memVO.setMem_name(mem_name);
		memVO.setMem_gender(mem_gender);
		memVO.setMem_Tw_Id(mem_Tw_Id);
		memVO.setMem_birth_date(mem_birth_date);
		memVO.setMem_phone(mem_phone);
		memVO.setMem_Intro(mem_Intro);
		memVO.setMem_profile(mem_profile);
		memVO.setMem_black_list(mem_black_list);
		memVO.setMem_permission(mem_permission);
		memVO.setMem_setting(mem_setting);
		memVO.setMem_balance(mem_balance);
		dao.update(memVO);
		return memVO;
	}

	public void deleteMem(Integer mem_Id) {
		dao.delete(mem_Id);
	}

	public MemVO getOneMem(Integer mem_Id) {
		return dao.findByPrimaryKey(mem_Id);
	}

	public List<MemVO> getAll() {
		return dao.getAll();
	}
	
}

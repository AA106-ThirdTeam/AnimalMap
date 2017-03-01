package heibernate_com.pet_message.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.pet.model.PetVO;
import heibernate_com.mem.model.MemVO;

public class Pet_MessageService {

	private Pet_Message_interface dao;

	public Pet_MessageService() {
		dao = new Pet_MessageDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Pet_MessageDAO_interface) context.getBean("empDAO");
	}
	
	public Pet_MessageVO addPet_Message(
			String pet_Id,String mem_Id,String pet_Mes,java.sql.Timestamp pet_Mes_time
			) {
		Pet_MessageVO pet_messageVO = new Pet_MessageVO();
		PetVO petVO = new PetVO();
		petVO.setPet_Id(pet_Id);
		pet_messageVO.setPetVO(petVO);
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		pet_messageVO.setMemVO(memVO);
		pet_messageVO.setPet_Mes(pet_Mes);
		pet_messageVO.setPet_Mes_time(pet_Mes_time);
		dao.insert(pet_messageVO);
		return pet_messageVO;
	}
	
	public Pet_MessageVO updatePet_Message(
			String pet_Mes_No
			,String pet_Id,String mem_Id,String pet_Mes,java.sql.Timestamp pet_Mes_time
			) {	
		Pet_MessageVO pet_messageVO = new Pet_MessageVO();
		pet_messageVO.setPet_Mes_No(pet_Mes_No);
		pet_messageVO.setPet_Mes(pet_Mes);
		pet_messageVO.setPet_Mes_time(pet_Mes_time);
		dao.update(pet_messageVO);
		return pet_messageVO;
	}

	public void deletePet_Message(String pet_Mes_No) {
		dao.delete(pet_Mes_No);
	}

	public Pet_MessageVO getOnePet_Message(String pet_Mes_No) {
		return dao.findByPrimaryKey(pet_Mes_No);
	}

	public List<Pet_MessageVO> getAll() {
		return dao.getAll();
	}

	public List<Pet_MessageVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}
}

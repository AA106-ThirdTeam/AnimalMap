package heibernate_com.pet.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;

public class PetService {

	private Pet_interface dao;

	public PetService() {
		dao = new PetDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(PetDAO_interface) context.getBean("empDAO");
	}
	
	public PetVO addPet(
			String mem_Id,String pet_name,String pet_type,String pet_gender
			,String pet_heal,String pet_Vac,String pet_color,String pet_body
			,String pet_age,String pet_Neu,String pet_chip,java.sql.Date pet_birth
			,String pet_status,java.sql.Date pet_CreDATE,String pet_city,String pet_town
			,String pet_road,Double pet_FinLat,Double pet_FinLon) {
		PetVO petVO = new PetVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		petVO.setMemVO(memVO);
		petVO.setPet_name(pet_name);
		petVO.setPet_type(pet_type);
		petVO.setPet_gender(pet_gender);
		petVO.setPet_heal(pet_heal);
		petVO.setPet_Vac(pet_Vac);
		petVO.setPet_color(pet_color);
		petVO.setPet_body(pet_body);
		petVO.setPet_age(pet_age);
		petVO.setPet_Neu(pet_Neu);
		petVO.setPet_chip(pet_chip);
		petVO.setPet_birth(pet_birth);
		petVO.setPet_status(pet_status);
		petVO.setPet_CreDATE(pet_CreDATE);
		petVO.setPet_city(pet_city);
		petVO.setPet_town(pet_town);
		petVO.setPet_road(pet_road);
		petVO.setPet_FinLat(pet_FinLat);
		petVO.setPet_FinLon(pet_FinLon);
		dao.insert(petVO);
		return petVO;
	}
	
	public PetVO updatePet(
			String pet_Id
			,String mem_Id,String pet_name,String pet_type,String pet_gender
			,String pet_heal,String pet_Vac,String pet_color,String pet_body
			,String pet_age,String pet_Neu,String pet_chip,java.sql.Date pet_birth
			,String pet_status,java.sql.Date pet_CreDATE,String pet_city,String pet_town
			,String pet_road,Double pet_FinLat,Double pet_FinLon) {	
		PetVO petVO = new PetVO();
		petVO.setPet_Id(pet_Id);
		petVO.setPet_name(pet_name);
		petVO.setPet_type(pet_type);
		petVO.setPet_gender(pet_gender);
		petVO.setPet_heal(pet_heal);
		petVO.setPet_Vac(pet_Vac);
		petVO.setPet_color(pet_color);
		petVO.setPet_body(pet_body);
		petVO.setPet_age(pet_age);
		petVO.setPet_Neu(pet_Neu);
		petVO.setPet_chip(pet_chip);
		petVO.setPet_birth(pet_birth);
		petVO.setPet_status(pet_status);
		petVO.setPet_CreDATE(pet_CreDATE);
		petVO.setPet_city(pet_city);
		petVO.setPet_town(pet_town);
		petVO.setPet_road(pet_road);
		petVO.setPet_FinLat(pet_FinLat);
		petVO.setPet_FinLon(pet_FinLon);
		dao.update(petVO);
		return petVO;
	}

	public void deletePet(String pet_Id) {
		dao.delete(pet_Id);
	}

	public PetVO getOnePet(String pet_Id) {
		return dao.findByPrimaryKey(pet_Id);
	}

	public List<PetVO> getAll() {
		return dao.getAll();
	}

	public List<PetVO> getAll(Map<String, String[]> map) {
		return dao.getAll(map);
	}
}

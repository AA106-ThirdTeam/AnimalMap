package heibernate_com.pet_photos.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.pet.model.PetVO;
import heibernate_com.mem.model.MemVO;

public class Pet_PhotosService {

	private Pet_Photos_interface dao;

	public Pet_PhotosService() {
		dao = new Pet_PhotosDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Pet_PhotosDAO_interface) context.getBean("empDAO");
	}
	
	public Pet_PhotosVO addPet_Photos(
			String pet_Id,String mem_Id,byte[] pet_Pic,String pet_Pic_name
			,String pet_Pic_nameEX,java.sql.Date pet_Pic_time,String pet_Pic_type) {
		Pet_PhotosVO pet_photosVO = new Pet_PhotosVO();
		PetVO petVO = new PetVO();
		petVO.setPet_Id(pet_Id);
		pet_photosVO.setPetVO(petVO);
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		pet_photosVO.setMemVO(memVO);
		pet_photosVO.setPet_Pic(pet_Pic);
		pet_photosVO.setPet_Pic_name(pet_Pic_name);
		pet_photosVO.setPet_Pic_nameEX(pet_Pic_nameEX);
		pet_photosVO.setPet_Pic_time(pet_Pic_time);
		pet_photosVO.setPet_Pic_type(pet_Pic_type);
		dao.insert(pet_photosVO);
		return pet_photosVO;
	}
	
	public Pet_PhotosVO updatePet_Photos(
			String pet_Pic_No
			,String pet_Id,String mem_Id,byte[] pet_Pic,String pet_Pic_name
			,String pet_Pic_nameEX,java.sql.Date pet_Pic_time,String pet_Pic_type) {	
		Pet_PhotosVO pet_photosVO = new Pet_PhotosVO();
		pet_photosVO.setPet_Pic_No(pet_Pic_No);
		pet_photosVO.setPet_Pic(pet_Pic);
		pet_photosVO.setPet_Pic_name(pet_Pic_name);
		pet_photosVO.setPet_Pic_nameEX(pet_Pic_nameEX);
		pet_photosVO.setPet_Pic_time(pet_Pic_time);
		pet_photosVO.setPet_Pic_type(pet_Pic_type);
		dao.update(pet_photosVO);
		return pet_photosVO;
	}

	public void deletePet_Photos(String pet_Pic_No) {
		dao.delete(pet_Pic_No);
	}

	public Pet_PhotosVO getOnePet_Photos(String pet_Pic_No) {
		return dao.findByPrimaryKey(pet_Pic_No);
	}

	public List<Pet_PhotosVO> getAll() {
		return dao.getAll();
	}

	public List<Pet_PhotosVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}
}

package heibernate_com.animal_index.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Animal_indexService {

	private Animal_index_interface dao;

	public Animal_indexService() {
		dao = new Animal_indexDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Animal_indexDAO_interface) context.getBean("empDAO");
	}
	
	public Animal_indexVO addAnimal_index(
			String animal_detail,String animal_class,String animal_class_No) {
		Animal_indexVO animal_indexVO = new Animal_indexVO();
		animal_indexVO.setAnimal_detail(animal_detail);
		animal_indexVO.setAnimal_class(animal_class);
		animal_indexVO.setAnimal_class_No(animal_class_No);
		dao.insert(animal_indexVO);
		return animal_indexVO;
	}
	
	public Animal_indexVO updateAnimal_index(
			String animal_No
			,String animal_detail,String animal_class,String animal_class_No) {	
		Animal_indexVO animal_indexVO = new Animal_indexVO();
		animal_indexVO.setAnimal_No(animal_No);
		animal_indexVO.setAnimal_detail(animal_detail);
		animal_indexVO.setAnimal_class(animal_class);
		animal_indexVO.setAnimal_class_No(animal_class_No);
		dao.update(animal_indexVO);
		return animal_indexVO;
	}

	public void deleteAnimal_index(String animal_No) {
		dao.delete(animal_No);
	}

	public Animal_indexVO getOneAnimal_index(String animal_No) {
		return dao.findByPrimaryKey(animal_No);
	}

	public List<Animal_indexVO> getAll() {
		return dao.getAll();
	}

	public List<Animal_indexVO> getAll(Map<String, String[]> map) {
		return dao.getAll(map);
	}
}

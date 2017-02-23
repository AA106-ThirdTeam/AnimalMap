package heibernate_com.post.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;

public class PostService {

	private Post_interface dao;

	public PostService() {
		dao = new PostDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(PostDAO_interface) context.getBean("empDAO");
	}
	
	public PostVO addPost(
			String mem_Id,String post_class,String post_class_Id,String post_title
			,String post_content,java.sql.Date post_time,java.sql.Date post_upDate,Integer post_resNum
			) {
		PostVO postVO = new PostVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		postVO.setMemVO(memVO);
		postVO.setPost_class(post_class);
		postVO.setPost_class_Id(post_class_Id);
		postVO.setPost_title(post_title);
		postVO.setPost_content(post_content);
		postVO.setPost_time(post_time);
		postVO.setPost_upDate(post_upDate);
		postVO.setPost_resNum(post_resNum);
		dao.insert(postVO);
		return postVO;
	}
	
	public PostVO updatePost(
			String post_Id
			,String mem_Id,String post_class,String post_class_Id,String post_title
			,String post_content,java.sql.Date post_time,java.sql.Date post_upDate,Integer post_resNum
			) {	
		PostVO postVO = new PostVO();
		postVO.setPost_Id(post_Id);
		postVO.setPost_class(post_class);
		postVO.setPost_class_Id(post_class_Id);
		postVO.setPost_title(post_title);
		postVO.setPost_content(post_content);
		postVO.setPost_time(post_time);
		postVO.setPost_upDate(post_upDate);
		postVO.setPost_resNum(post_resNum);
		dao.update(postVO);
		return postVO;
	}

	public void deletePost(String post_Id) {
		dao.delete(post_Id);
	}

	public PostVO getOnePost(String post_Id) {
		return dao.findByPrimaryKey(post_Id);
	}

	public List<PostVO> getAll() {
		return dao.getAll();
	}
	
}

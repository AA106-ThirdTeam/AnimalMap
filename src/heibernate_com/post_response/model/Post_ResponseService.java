package heibernate_com.post_response.model;
import java.util.List;
import java.util.Map;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import heibernate_com.mem.model.MemVO;
import heibernate_com.post.model.PostVO;

public class Post_ResponseService {

	private Post_Response_interface dao;

	public Post_ResponseService() {
		dao = new Post_ResponseDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		//ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		//dao =(Post_ResponseDAO_interface) context.getBean("empDAO");
	}
	
	public Post_ResponseVO addPost_Response(
			String mem_Id,String post_Id,String post_Response_content,java.sql.Date post_time
			,java.sql.Date post_Response_upDate) {
		Post_ResponseVO post_responseVO = new Post_ResponseVO();
		MemVO memVO = new MemVO();
		memVO.setMem_Id(mem_Id);
		post_responseVO.setMemVO(memVO);
		PostVO postVO = new PostVO();
		postVO.setPost_Id(post_Id);
		post_responseVO.setPostVO(postVO);
		post_responseVO.setPost_Response_content(post_Response_content);
		post_responseVO.setPost_time(post_time);
		post_responseVO.setPost_Response_upDate(post_Response_upDate);
		dao.insert(post_responseVO);
		return post_responseVO;
	}
	
	public Post_ResponseVO updatePost_Response(
			String res_Id
			,String mem_Id,String post_Id,String post_Response_content,java.sql.Date post_time
			,java.sql.Date post_Response_upDate) {	
		Post_ResponseVO post_responseVO = new Post_ResponseVO();
		post_responseVO.setRes_Id(res_Id);
		post_responseVO.setPost_Response_content(post_Response_content);
		post_responseVO.setPost_time(post_time);
		post_responseVO.setPost_Response_upDate(post_Response_upDate);
		dao.update(post_responseVO);
		return post_responseVO;
	}

	public void deletePost_Response(String res_Id) {
		dao.delete(res_Id);
	}

	public Post_ResponseVO getOnePost_Response(String res_Id) {
		return dao.findByPrimaryKey(res_Id);
	}

	public List<Post_ResponseVO> getAll() {
		return dao.getAll();
	}

	public List<Post_ResponseVO> getAll(Map<String, String[]> map,boolean able_like) {
		return dao.getAll(map,able_like);
	}
}

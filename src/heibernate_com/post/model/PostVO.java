package heibernate_com.post.model;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.OrderBy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import heibernate_com.mem.model.MemVO;

import heibernate_com.post_response.model.Post_ResponseVO;


/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 討論區 
*	英文: post  
* </pre>
*/   
@Entity
@Table(name = "POST")
public class PostVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String post_Id;
	private MemVO memVO;
	private String post_class;
	private String post_class_Id;
	private String post_title;
	private String post_content;
	private java.sql.Date post_time;
	private java.sql.Date post_upDate;
	private Integer post_resNum;

	private Set<Post_ResponseVO> post_Responses = new HashSet<Post_ResponseVO>();

	public PostVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "POST_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "post_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="post_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getPost_Id() {
		return this.post_Id;
	}
	
	public void setPost_Id(String post_Id) {
		this.post_Id = post_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "POST_CLASS")
	public String getPost_class() {
		return this.post_class;
	}
	
	public void setPost_class(String post_class) {
		this.post_class = post_class;
	}
		
	@Column(name = "POST_CLASS_ID")
	public String getPost_class_Id() {
		return this.post_class_Id;
	}
	
	public void setPost_class_Id(String post_class_Id) {
		this.post_class_Id = post_class_Id;
	}
		
	@Column(name = "POST_TITLE")
	public String getPost_title() {
		return this.post_title;
	}
	
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
		
	@Column(name = "POST_CONTENT")
	public String getPost_content() {
		return this.post_content;
	}
	
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
		
	@Column(name = "POST_TIME")
	public java.sql.Date getPost_time() {
		return this.post_time;
	}
	
	public void setPost_time(java.sql.Date post_time) {
		this.post_time = post_time;
	}
		
	@Column(name = "POST_UPDATE")
	public java.sql.Date getPost_upDate() {
		return this.post_upDate;
	}
	
	public void setPost_upDate(java.sql.Date post_upDate) {
		this.post_upDate = post_upDate;
	}
		
	@Column(name = "POST_RESNUM")
	public Integer getPost_resNum() {
		return this.post_resNum;
	}
	
	public void setPost_resNum(Integer post_resNum) {
		this.post_resNum = post_resNum;
	}
		
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="postVO")
	@OrderBy("post_Id asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Post_ResponseVO> getPost_Responses() {
		return this.post_Responses;
	}

	public void setPost_Responses(Set<Post_ResponseVO> post_responses) {
		this.post_Responses = post_responses;
	}
	
}

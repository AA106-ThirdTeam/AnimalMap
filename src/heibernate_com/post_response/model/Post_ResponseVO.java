package heibernate_com.post_response.model;
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

import heibernate_com.post.model.PostVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 討論區留言 
*	英文: post_Response  
* </pre>
*/   
@Entity
@Table(name = "POST_RESPONSE")
public class Post_ResponseVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String res_Id;
	private MemVO memVO;
	private PostVO postVO;
	private String post_Response_content;
	private java.sql.Timestamp post_time;
	private java.sql.Timestamp post_Response_upDate;


	public Post_ResponseVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "RES_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "post_Response_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="post_Response_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getRes_Id() {
		return this.res_Id;
	}
	
	public void setRes_Id(String res_Id) {
		this.res_Id = res_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "POST_ID")  //指定用來join table的column
	public PostVO getPostVO() {
		return this.postVO;
	}
	
	public void setPostVO(PostVO postVO) {
		this.postVO = postVO;
	}
	@Column(name = "POST_RESPONSE_CONTENT")
	public String getPost_Response_content() {
		return this.post_Response_content;
	}
	
	public void setPost_Response_content(String post_Response_content) {
		this.post_Response_content = post_Response_content;
	}
		
	@Column(name = "POST_TIME")
	public java.sql.Timestamp getPost_time() {
		return this.post_time;
	}
	
	public void setPost_time(java.sql.Timestamp post_time) {
		this.post_time = post_time;
	}
		
	@Column(name = "POST_RESPONSE_UPDATE")
	public java.sql.Timestamp getPost_Response_upDate() {
		return this.post_Response_upDate;
	}
	
	public void setPost_Response_upDate(java.sql.Timestamp post_Response_upDate) {
		this.post_Response_upDate = post_Response_upDate;
	}
		
}

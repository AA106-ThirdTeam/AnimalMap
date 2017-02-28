package heibernate_com.hos_comment.model;
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

import heibernate_com.vet_hospital.model.Vet_hospitalVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 診所留言 
*	英文: hos_comment  
* </pre>
*/   
@Entity
@Table(name = "HOS_COMMENT")
public class Hos_commentVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String hosComment_Id;
	private MemVO memVO;
	private Vet_hospitalVO vet_hospitalVO;
	private String hosComment_content;
	private java.sql.Timestamp hosComment_SendTime;


	public Hos_commentVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "HOSCOMMENT_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "hos_comment_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="hos_comment_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getHosComment_Id() {
		return this.hosComment_Id;
	}
	
	public void setHosComment_Id(String hosComment_Id) {
		this.hosComment_Id = hosComment_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "HOSCOMMENT_MEMID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "HOSCOMMENT_HOSID")  //指定用來join table的column
	public Vet_hospitalVO getVet_hospitalVO() {
		return this.vet_hospitalVO;
	}
	
	public void setVet_hospitalVO(Vet_hospitalVO vet_hospitalVO) {
		this.vet_hospitalVO = vet_hospitalVO;
	}
	@Column(name = "HOSCOMMENT_CONTENT")
	public String getHosComment_content() {
		return this.hosComment_content;
	}
	
	public void setHosComment_content(String hosComment_content) {
		this.hosComment_content = hosComment_content;
	}
		
	@Column(name = "HOSCOMMENT_SENDTIME")
	public java.sql.Timestamp getHosComment_SendTime() {
		return this.hosComment_SendTime;
	}
	
	public void setHosComment_SendTime(java.sql.Timestamp hosComment_SendTime) {
		this.hosComment_SendTime = hosComment_SendTime;
	}
		
}

package heibernate_com.grp_comment.model;
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

import heibernate_com.pet_group.model.Pet_groupVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 揪團留言 
*	英文: grp_comment  
* </pre>
*/   
@Entity
@Table(name = "GRP_COMMENT")
public class Grp_commentVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String grpComment_Id;
	private MemVO memVO;
	private Pet_groupVO pet_groupVO;
	private String grpComment_content;
	private java.sql.Timestamp grpComment_SendTime;


	public Grp_commentVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "GRPCOMMENT_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "grp_comment_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="grp_comment_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getGrpComment_Id() {
		return this.grpComment_Id;
	}
	
	public void setGrpComment_Id(String grpComment_Id) {
		this.grpComment_Id = grpComment_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "GRPCOMMENT_MEMID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "GRPCOMMENT_GRPID")  //指定用來join table的column
	public Pet_groupVO getPet_groupVO() {
		return this.pet_groupVO;
	}
	
	public void setPet_groupVO(Pet_groupVO pet_groupVO) {
		this.pet_groupVO = pet_groupVO;
	}
	@Column(name = "GRPCOMMENT_CONTENT")
	public String getGrpComment_content() {
		return this.grpComment_content;
	}
	
	public void setGrpComment_content(String grpComment_content) {
		this.grpComment_content = grpComment_content;
	}
		
	@Column(name = "GRPCOMMENT_SENDTIME")
	public java.sql.Timestamp getGrpComment_SendTime() {
		return this.grpComment_SendTime;
	}
	
	public void setGrpComment_SendTime(java.sql.Timestamp grpComment_SendTime) {
		this.grpComment_SendTime = grpComment_SendTime;
	}
		
}

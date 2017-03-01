package heibernate_com.offimsg.model;
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

import heibernate_com.emp.model.EmpVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 系統訊息 
*	英文: offiMsg  
* </pre>
*/   
@Entity
@Table(name = "OFFIMSG")
public class OffiMsgVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String offiMsg_Id;
	private EmpVO empVO;
	private String offiMsg_Title;
	private String offiMsg_Content;
	private java.sql.Timestamp offiMsg_Date;


	public OffiMsgVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "OFFIMSG_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "offiMsg_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="offiMsg_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getOffiMsg_Id() {
		return this.offiMsg_Id;
	}
	
	public void setOffiMsg_Id(String offiMsg_Id) {
		this.offiMsg_Id = offiMsg_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "EMP_NO")  //指定用來join table的column
	public EmpVO getEmpVO() {
		return this.empVO;
	}
	
	public void setEmpVO(EmpVO empVO) {
		this.empVO = empVO;
	}
	@Column(name = "OFFIMSG_TITLE")
	public String getOffiMsg_Title() {
		return this.offiMsg_Title;
	}
	
	public void setOffiMsg_Title(String offiMsg_Title) {
		this.offiMsg_Title = offiMsg_Title;
	}
		
	@Column(name = "OFFIMSG_CONTENT")
	public String getOffiMsg_Content() {
		return this.offiMsg_Content;
	}
	
	public void setOffiMsg_Content(String offiMsg_Content) {
		this.offiMsg_Content = offiMsg_Content;
	}
		
	@Column(name = "OFFIMSG_DATE")
	public java.sql.Timestamp getOffiMsg_Date() {
		return this.offiMsg_Date;
	}
	
	public void setOffiMsg_Date(java.sql.Timestamp offiMsg_Date) {
		this.offiMsg_Date = offiMsg_Date;
	}
		
}

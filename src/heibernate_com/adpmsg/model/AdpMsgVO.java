package heibernate_com.adpmsg.model;
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

import heibernate_com.adp.model.AdpVO;

import heibernate_com.mem.model.MemVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 領養活動留言 
*	英文: adpMsg  
* </pre>
*/   
@Entity
@Table(name = "ADPMSG")
public class AdpMsgVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String adpMsg_Id;
	private AdpVO adpVO;
	private MemVO memVO;
	private String msg;
	private java.sql.Timestamp adpMsgDate;
	private java.sql.Timestamp adpMsgadp_upDate;


	public AdpMsgVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "ADPMSG_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "adpMsg_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="adpMsg_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getAdpMsg_Id() {
		return this.adpMsg_Id;
	}
	
	public void setAdpMsg_Id(String adpMsg_Id) {
		this.adpMsg_Id = adpMsg_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "ADP_ID")  //指定用來join table的column
	public AdpVO getAdpVO() {
		return this.adpVO;
	}
	
	public void setAdpVO(AdpVO adpVO) {
		this.adpVO = adpVO;
	}
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "MSG")
	public String getMsg() {
		return this.msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
		
	@Column(name = "ADPMSGDATE")
	public java.sql.Timestamp getAdpMsgDate() {
		return this.adpMsgDate;
	}
	
	public void setAdpMsgDate(java.sql.Timestamp adpMsgDate) {
		this.adpMsgDate = adpMsgDate;
	}
		
	@Column(name = "ADPMSGADP_UPDATE")
	public java.sql.Timestamp getAdpMsgadp_upDate() {
		return this.adpMsgadp_upDate;
	}
	
	public void setAdpMsgadp_upDate(java.sql.Timestamp adpMsgadp_upDate) {
		this.adpMsgadp_upDate = adpMsgadp_upDate;
	}
		
}

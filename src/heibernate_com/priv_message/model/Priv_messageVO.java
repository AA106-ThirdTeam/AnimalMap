package heibernate_com.priv_message.model;
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

import heibernate_com.mem.model.MemVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 私人訊息 
*	英文: priv_message  
* </pre>
*/   
@Entity
@Table(name = "PRIV_MESSAGE")
public class Priv_messageVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String privMsg_Id;
	private MemVO memVO;
	private MemVO memVO_2;
	private String privMsg_content;
	private java.sql.Date privMsg_SendTime;
	private String privMsg_type;


	public Priv_messageVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "PRIVMSG_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "priv_message_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="priv_message_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getPrivMsg_Id() {
		return this.privMsg_Id;
	}
	
	public void setPrivMsg_Id(String privMsg_Id) {
		this.privMsg_Id = privMsg_Id;
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
	@JoinColumn(name = "MEM_ID" , insertable =  false, updatable = false)  //指定用來join table的column
	public MemVO getMemVO_2() {
		return this.memVO;
	}
	
	public void setMemVO_2(MemVO memVO_2) {
		this.memVO_2 = memVO_2;
	}
	
	@Column(name = "PRIVMSG_CONTENT")
	public String getPrivMsg_content() {
		return this.privMsg_content;
	}
	
	public void setPrivMsg_content(String privMsg_content) {
		this.privMsg_content = privMsg_content;
	}
		
	@Column(name = "PRIVMSG_SENDTIME")
	public java.sql.Date getPrivMsg_SendTime() {
		return this.privMsg_SendTime;
	}
	
	public void setPrivMsg_SendTime(java.sql.Date privMsg_SendTime) {
		this.privMsg_SendTime = privMsg_SendTime;
	}
		
	@Column(name = "PRIVMSG_TYPE")
	public String getPrivMsg_type() {
		return this.privMsg_type;
	}
	
	public void setPrivMsg_type(String privMsg_type) {
		this.privMsg_type = privMsg_type;
	}
		
}

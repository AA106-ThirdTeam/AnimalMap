package heibernate_com.anihome_msg.model;
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

import heibernate_com.anihome.model.AniHomeVO;

import heibernate_com.mem.model.MemVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 動物之家留言 
*	英文: aniHome_Msg  
* </pre>
*/   
@Entity
@Table(name = "ANIHOME_MSG")
public class AniHome_MsgVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String aniHome_Msg_Id;
	private AniHomeVO aniHomeVO;
	private MemVO memVO;
	private String aniHome_Msg;
	private java.sql.Timestamp adp_start_date;


	public AniHome_MsgVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "ANIHOME_MSG_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "aniHome_Msg_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="aniHome_Msg_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getAniHome_Msg_Id() {
		return this.aniHome_Msg_Id;
	}
	
	public void setAniHome_Msg_Id(String aniHome_Msg_Id) {
		this.aniHome_Msg_Id = aniHome_Msg_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "ANIHOME_ID")  //指定用來join table的column
	public AniHomeVO getAniHomeVO() {
		return this.aniHomeVO;
	}
	
	public void setAniHomeVO(AniHomeVO aniHomeVO) {
		this.aniHomeVO = aniHomeVO;
	}
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "ANIHOME_MSG")
	public String getAniHome_Msg() {
		return this.aniHome_Msg;
	}
	
	public void setAniHome_Msg(String aniHome_Msg) {
		this.aniHome_Msg = aniHome_Msg;
	}
		
	@Column(name = "ADP_START_DATE")
	public java.sql.Timestamp getAdp_start_date() {
		return this.adp_start_date;
	}
	
	public void setAdp_start_date(java.sql.Timestamp adp_start_date) {
		this.adp_start_date = adp_start_date;
	}
		
}

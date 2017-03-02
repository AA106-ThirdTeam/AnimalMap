package heibernate_com.stray_ani_message.model;
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

import heibernate_com.stray_ani.model.Stray_AniVO;

import heibernate_com.mem.model.MemVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 社區流浪動物留言 
*	英文: stray_Ani_message  
* </pre>
*/   
@Entity
@Table(name = "STRAY_ANI_MESSAGE")
public class Stray_Ani_messageVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String str_Ani_Mes_No;
	private Stray_AniVO stray_AniVO;
	private MemVO memVO;
	private java.sql.Date str_Ani_Mes_time;
	private String str_Ani_Mes;


	public Stray_Ani_messageVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "STR_ANI_MES_NO")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "stray_Ani_message_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="stray_Ani_message_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getStr_Ani_Mes_No() {
		return this.str_Ani_Mes_No;
	}
	
	public void setStr_Ani_Mes_No(String str_Ani_Mes_No) {
		this.str_Ani_Mes_No = str_Ani_Mes_No;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "STRAY_ANI_ID")  //指定用來join table的column
	public Stray_AniVO getStray_AniVO() {
		return this.stray_AniVO;
	}
	
	public void setStray_AniVO(Stray_AniVO stray_AniVO) {
		this.stray_AniVO = stray_AniVO;
	}
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "STR_ANI_MES_TIME")
	public java.sql.Date getStr_Ani_Mes_time() {
		return this.str_Ani_Mes_time;
	}
	
	public void setStr_Ani_Mes_time(java.sql.Date str_Ani_Mes_time) {
		this.str_Ani_Mes_time = str_Ani_Mes_time;
	}
		
	@Column(name = "STR_ANI_MES")
	public String getStr_Ani_Mes() {
		return this.str_Ani_Mes;
	}
	
	public void setStr_Ani_Mes(String str_Ani_Mes) {
		this.str_Ani_Mes = str_Ani_Mes;
	}
		
}

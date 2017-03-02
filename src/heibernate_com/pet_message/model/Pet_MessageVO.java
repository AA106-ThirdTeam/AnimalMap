package heibernate_com.pet_message.model;
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

import heibernate_com.pet.model.PetVO;

import heibernate_com.mem.model.MemVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 自家寵物留言 
*	英文: pet_Message  
* </pre>
*/   
@Entity
@Table(name = "PET_MESSAGE")
public class Pet_MessageVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String pet_Mes_No;
	private PetVO petVO;
	private MemVO memVO;
	private String pet_Mes;
	private java.sql.Date pet_Mes_time;


	public Pet_MessageVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "PET_MES_NO")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "pet_Message_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="pet_Message_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getPet_Mes_No() {
		return this.pet_Mes_No;
	}
	
	public void setPet_Mes_No(String pet_Mes_No) {
		this.pet_Mes_No = pet_Mes_No;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "PET_ID")  //指定用來join table的column
	public PetVO getPetVO() {
		return this.petVO;
	}
	
	public void setPetVO(PetVO petVO) {
		this.petVO = petVO;
	}
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "PET_MES")
	public String getPet_Mes() {
		return this.pet_Mes;
	}
	
	public void setPet_Mes(String pet_Mes) {
		this.pet_Mes = pet_Mes;
	}
		
	@Column(name = "PET_MES_TIME")
	public java.sql.Date getPet_Mes_time() {
		return this.pet_Mes_time;
	}
	
	public void setPet_Mes_time(java.sql.Date pet_Mes_time) {
		this.pet_Mes_time = pet_Mes_time;
	}
		
}

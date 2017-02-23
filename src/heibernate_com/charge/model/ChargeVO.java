package heibernate_com.charge.model;
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



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 儲值 
*	英文: charge  
* </pre>
*/   
@Entity
@Table(name = "CHARGE")
public class ChargeVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String charge_no;
	private MemVO memVO;
	private Integer charge_NUMBER;
	private Integer pay;
	private java.sql.Date applytime;


	public ChargeVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "CHARGE_NO")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "charge_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="charge_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getCharge_no() {
		return this.charge_no;
	}
	
	public void setCharge_no(String charge_no) {
		this.charge_no = charge_no;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "CHARGE_NUMBER")
	public Integer getCharge_NUMBER() {
		return this.charge_NUMBER;
	}
	
	public void setCharge_NUMBER(Integer charge_NUMBER) {
		this.charge_NUMBER = charge_NUMBER;
	}
		
	@Column(name = "PAY")
	public Integer getPay() {
		return this.pay;
	}
	
	public void setPay(Integer pay) {
		this.pay = pay;
	}
		
	@Column(name = "APPLYTIME")
	public java.sql.Date getApplytime() {
		return this.applytime;
	}
	
	public void setApplytime(java.sql.Date applytime) {
		this.applytime = applytime;
	}
		
}

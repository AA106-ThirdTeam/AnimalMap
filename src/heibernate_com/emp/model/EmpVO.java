package heibernate_com.emp.model;
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

import heibernate_com.emp_purview.model.Emp_purviewVO;
import heibernate_com.offimsg.model.OffiMsgVO;
import heibernate_com.park.model.ParkVO;


/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 員工 
*	英文: emp  
* </pre>
*/   
@Entity
@Table(name = "EMP")
public class EmpVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String emp_No;
	private String emp_name;
	private String emp_Pw;
	private String emp_email;
	private String emp_Id;
	private java.sql.Timestamp emp_birthday;
	private String emp_phone;
	private String emp_address;
	private String emp_status;
	private byte[] emp_picture;
	private String emp_Pic_format;
	private java.sql.Timestamp emp_hiredate;
	private java.sql.Timestamp emp_firedate;

	private Set<Emp_purviewVO> emp_purviews = new HashSet<Emp_purviewVO>();
	private Set<OffiMsgVO> offiMsgs = new HashSet<OffiMsgVO>();
	private Set<ParkVO> parks = new HashSet<ParkVO>();

	public EmpVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "EMP_NO")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "emp_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="emp_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getEmp_No() {
		return this.emp_No;
	}
	
	public void setEmp_No(String emp_No) {
		this.emp_No = emp_No;
	}	
	@Column(name = "EMP_NAME")
	public String getEmp_name() {
		return this.emp_name;
	}
	
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
		
	@Column(name = "EMP_PW")
	public String getEmp_Pw() {
		return this.emp_Pw;
	}
	
	public void setEmp_Pw(String emp_Pw) {
		this.emp_Pw = emp_Pw;
	}
		
	@Column(name = "EMP_EMAIL")
	public String getEmp_email() {
		return this.emp_email;
	}
	
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
		
	@Column(name = "EMP_ID")
	public String getEmp_Id() {
		return this.emp_Id;
	}
	
	public void setEmp_Id(String emp_Id) {
		this.emp_Id = emp_Id;
	}
		
	@Column(name = "EMP_BIRTHDAY")
	public java.sql.Timestamp getEmp_birthday() {
		return this.emp_birthday;
	}
	
	public void setEmp_birthday(java.sql.Timestamp emp_birthday) {
		this.emp_birthday = emp_birthday;
	}
		
	@Column(name = "EMP_PHONE")
	public String getEmp_phone() {
		return this.emp_phone;
	}
	
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
		
	@Column(name = "EMP_ADDRESS")
	public String getEmp_address() {
		return this.emp_address;
	}
	
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
		
	@Column(name = "EMP_STATUS")
	public String getEmp_status() {
		return this.emp_status;
	}
	
	public void setEmp_status(String emp_status) {
		this.emp_status = emp_status;
	}
		
	@Column(name = "EMP_PICTURE")
	public byte[] getEmp_picture() {
		return this.emp_picture;
	}
	
	public void setEmp_picture(byte[] emp_picture) {
		this.emp_picture = emp_picture;
	}
		
	@Column(name = "EMP_PIC_FORMAT")
	public String getEmp_Pic_format() {
		return this.emp_Pic_format;
	}
	
	public void setEmp_Pic_format(String emp_Pic_format) {
		this.emp_Pic_format = emp_Pic_format;
	}
		
	@Column(name = "EMP_HIREDATE")
	public java.sql.Timestamp getEmp_hiredate() {
		return this.emp_hiredate;
	}
	
	public void setEmp_hiredate(java.sql.Timestamp emp_hiredate) {
		this.emp_hiredate = emp_hiredate;
	}
		
	@Column(name = "EMP_FIREDATE")
	public java.sql.Timestamp getEmp_firedate() {
		return this.emp_firedate;
	}
	
	public void setEmp_firedate(java.sql.Timestamp emp_firedate) {
		this.emp_firedate = emp_firedate;
	}
		
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="empVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="empVO")
	@OrderBy("emp_No asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Emp_purviewVO> getEmp_purviews() {
		return this.emp_purviews;
	}

	public void setEmp_purviews(Set<Emp_purviewVO> emp_purviews) {
		this.emp_purviews = emp_purviews;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="empVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="empVO")
	@OrderBy("emp_No asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<OffiMsgVO> getOffiMsgs() {
		return this.offiMsgs;
	}

	public void setOffiMsgs(Set<OffiMsgVO> offimsgs) {
		this.offiMsgs = offimsgs;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="empVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="empVO")
	@OrderBy("emp_No asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<ParkVO> getParks() {
		return this.parks;
	}

	public void setParks(Set<ParkVO> parks) {
		this.parks = parks;
	}
	
}

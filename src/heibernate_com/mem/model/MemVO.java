package heibernate_com.mem.model;
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

import heibernate_com.anihome_msg.model.AniHome_MsgVO;
import heibernate_com.anihome.model.AniHomeVO;


/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 一般會員 
*	英文: mem  
* </pre>
*/   
@Entity
@Table(name = "MEM")
public class MemVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private Integer mem_Id;
	private String mem_email;
	private String mem_account;
	private String mem_Psw;
	private String mem_nick_name;
	private String mem_name;
	private String mem_gender;
	private String mem_Tw_Id;
	private java.sql.Date mem_birth_date;
	private String mem_phone;
	private String mem_Intro;
	private byte[] mem_profile;
	private String mem_black_list;
	private String mem_permission;
	private String mem_setting;
	private Integer mem_balance;

	private Set<AniHome_MsgVO> aniHome_Msgs = new HashSet<AniHome_MsgVO>();
	private Set<AniHomeVO> aniHomes = new HashSet<AniHomeVO>();

	public MemVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "MEM_ID")
	@SequenceGenerator(name="xxx", sequenceName="mem_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="xxx")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public Integer getMem_Id() {
		return this.mem_Id;
	}
	
	public void setMem_Id(Integer mem_Id) {
		this.mem_Id = mem_Id;
	}	
	@Column(name = "MEM_EMAIL")
	public String getMem_email() {
		return this.mem_email;
	}
	
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
		
	@Column(name = "MEM_ACCOUNT")
	public String getMem_account() {
		return this.mem_account;
	}
	
	public void setMem_account(String mem_account) {
		this.mem_account = mem_account;
	}
		
	@Column(name = "MEM_PSW")
	public String getMem_Psw() {
		return this.mem_Psw;
	}
	
	public void setMem_Psw(String mem_Psw) {
		this.mem_Psw = mem_Psw;
	}
		
	@Column(name = "MEM_NICK_NAME")
	public String getMem_nick_name() {
		return this.mem_nick_name;
	}
	
	public void setMem_nick_name(String mem_nick_name) {
		this.mem_nick_name = mem_nick_name;
	}
		
	@Column(name = "MEM_NAME")
	public String getMem_name() {
		return this.mem_name;
	}
	
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
		
	@Column(name = "MEM_GENDER")
	public String getMem_gender() {
		return this.mem_gender;
	}
	
	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}
		
	@Column(name = "MEM_TW_ID")
	public String getMem_Tw_Id() {
		return this.mem_Tw_Id;
	}
	
	public void setMem_Tw_Id(String mem_Tw_Id) {
		this.mem_Tw_Id = mem_Tw_Id;
	}
		
	@Column(name = "MEM_BIRTH_DATE")
	public java.sql.Date getMem_birth_date() {
		return this.mem_birth_date;
	}
	
	public void setMem_birth_date(java.sql.Date mem_birth_date) {
		this.mem_birth_date = mem_birth_date;
	}
		
	@Column(name = "MEM_PHONE")
	public String getMem_phone() {
		return this.mem_phone;
	}
	
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
		
	@Column(name = "MEM_INTRO")
	public String getMem_Intro() {
		return this.mem_Intro;
	}
	
	public void setMem_Intro(String mem_Intro) {
		this.mem_Intro = mem_Intro;
	}
		
	@Column(name = "MEM_PROFILE")
	public byte[] getMem_profile() {
		return this.mem_profile;
	}
	
	public void setMem_profile(byte[] mem_profile) {
		this.mem_profile = mem_profile;
	}
		
	@Column(name = "MEM_BLACK_LIST")
	public String getMem_black_list() {
		return this.mem_black_list;
	}
	
	public void setMem_black_list(String mem_black_list) {
		this.mem_black_list = mem_black_list;
	}
		
	@Column(name = "MEM_PERMISSION")
	public String getMem_permission() {
		return this.mem_permission;
	}
	
	public void setMem_permission(String mem_permission) {
		this.mem_permission = mem_permission;
	}
		
	@Column(name = "MEM_SETTING")
	public String getMem_setting() {
		return this.mem_setting;
	}
	
	public void setMem_setting(String mem_setting) {
		this.mem_setting = mem_setting;
	}
		
	@Column(name = "MEM_BALANCE")
	public Integer getMem_balance() {
		return this.mem_balance;
	}
	
	public void setMem_balance(Integer mem_balance) {
		this.mem_balance = mem_balance;
	}
		
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OrderBy("mem_Id asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<AniHome_MsgVO> getAniHome_Msgs() {
		return this.aniHome_Msgs;
	}

	public void setAniHome_Msgs(Set<AniHome_MsgVO> anihome_msgs) {
		this.aniHome_Msgs = anihome_msgs;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OrderBy("mem_Id asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<AniHomeVO> getAniHomes() {
		return this.aniHomes;
	}

	public void setAniHomes(Set<AniHomeVO> anihomes) {
		this.aniHomes = anihomes;
	}
	
}

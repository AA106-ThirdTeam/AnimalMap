package heibernate_com.adopt_ani.model;
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

import heibernate_com.adopt_ani_photos.model.Adopt_Ani_photosVO;
import heibernate_com.adopt_ani_message.model.Adopt_Ani_messageVO;
import heibernate_com.adopt_ani_sponsor.model.Adopt_Ani_sponsorVO;
import heibernate_com.adoanispo.model.AdoAniSpoVO;


/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 送養動物 
*	英文: adopt_Ani  
* </pre>
*/   
@Entity
@Table(name = "ADOPT_ANI")
public class Adopt_AniVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String adopt_Ani_Id;
	private MemVO memVO;
	private String adopt_Ani_name;
	private String adopt_Ani_type;
	private String adopt_Ani_gender;
	private String adopt_Ani_heal;
	private String adopt_Ani_Vac;
	private String adopt_Ani_color;
	private String adopt_Ani_body;
	private String adopt_Ani_age;
	private String adopt_Ani_Neu;
	private String adopt_Ani_chip;
	private java.sql.Date adopt_Ani_date;
	private String adopt_Ani_status;
	private java.sql.Date adopt_Ani_CreDate;
	private Double adopt_Ani_FinLat;
	private Double adopt_Ani_FinLon;
	private String adopt_Ani_city;
	private String adopt_Ani_town;
	private String adopt_Ani_road;
	private Integer adopt_Ani_like;

	private Set<Adopt_Ani_photosVO> adopt_Ani_photoss = new HashSet<Adopt_Ani_photosVO>();
	private Set<Adopt_Ani_messageVO> adopt_Ani_messages = new HashSet<Adopt_Ani_messageVO>();
	private Set<Adopt_Ani_sponsorVO> adopt_Ani_sponsors = new HashSet<Adopt_Ani_sponsorVO>();
	private Set<AdoAniSpoVO> adoAniSpos = new HashSet<AdoAniSpoVO>();

	public Adopt_AniVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "ADOPT_ANI_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "adopt_Ani_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="adopt_Ani_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getAdopt_Ani_Id() {
		return this.adopt_Ani_Id;
	}
	
	public void setAdopt_Ani_Id(String adopt_Ani_Id) {
		this.adopt_Ani_Id = adopt_Ani_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "ADOPT_ANI_NAME")
	public String getAdopt_Ani_name() {
		return this.adopt_Ani_name;
	}
	
	public void setAdopt_Ani_name(String adopt_Ani_name) {
		this.adopt_Ani_name = adopt_Ani_name;
	}
		
	@Column(name = "ADOPT_ANI_TYPE")
	public String getAdopt_Ani_type() {
		return this.adopt_Ani_type;
	}
	
	public void setAdopt_Ani_type(String adopt_Ani_type) {
		this.adopt_Ani_type = adopt_Ani_type;
	}
		
	@Column(name = "ADOPT_ANI_GENDER")
	public String getAdopt_Ani_gender() {
		return this.adopt_Ani_gender;
	}
	
	public void setAdopt_Ani_gender(String adopt_Ani_gender) {
		this.adopt_Ani_gender = adopt_Ani_gender;
	}
		
	@Column(name = "ADOPT_ANI_HEAL")
	public String getAdopt_Ani_heal() {
		return this.adopt_Ani_heal;
	}
	
	public void setAdopt_Ani_heal(String adopt_Ani_heal) {
		this.adopt_Ani_heal = adopt_Ani_heal;
	}
		
	@Column(name = "ADOPT_ANI_VAC")
	public String getAdopt_Ani_Vac() {
		return this.adopt_Ani_Vac;
	}
	
	public void setAdopt_Ani_Vac(String adopt_Ani_Vac) {
		this.adopt_Ani_Vac = adopt_Ani_Vac;
	}
		
	@Column(name = "ADOPT_ANI_COLOR")
	public String getAdopt_Ani_color() {
		return this.adopt_Ani_color;
	}
	
	public void setAdopt_Ani_color(String adopt_Ani_color) {
		this.adopt_Ani_color = adopt_Ani_color;
	}
		
	@Column(name = "ADOPT_ANI_BODY")
	public String getAdopt_Ani_body() {
		return this.adopt_Ani_body;
	}
	
	public void setAdopt_Ani_body(String adopt_Ani_body) {
		this.adopt_Ani_body = adopt_Ani_body;
	}
		
	@Column(name = "ADOPT_ANI_AGE")
	public String getAdopt_Ani_age() {
		return this.adopt_Ani_age;
	}
	
	public void setAdopt_Ani_age(String adopt_Ani_age) {
		this.adopt_Ani_age = adopt_Ani_age;
	}
		
	@Column(name = "ADOPT_ANI_NEU")
	public String getAdopt_Ani_Neu() {
		return this.adopt_Ani_Neu;
	}
	
	public void setAdopt_Ani_Neu(String adopt_Ani_Neu) {
		this.adopt_Ani_Neu = adopt_Ani_Neu;
	}
		
	@Column(name = "ADOPT_ANI_CHIP")
	public String getAdopt_Ani_chip() {
		return this.adopt_Ani_chip;
	}
	
	public void setAdopt_Ani_chip(String adopt_Ani_chip) {
		this.adopt_Ani_chip = adopt_Ani_chip;
	}
		
	@Column(name = "ADOPT_ANI_DATE")
	public java.sql.Date getAdopt_Ani_date() {
		return this.adopt_Ani_date;
	}
	
	public void setAdopt_Ani_date(java.sql.Date adopt_Ani_date) {
		this.adopt_Ani_date = adopt_Ani_date;
	}
		
	@Column(name = "ADOPT_ANI_STATUS")
	public String getAdopt_Ani_status() {
		return this.adopt_Ani_status;
	}
	
	public void setAdopt_Ani_status(String adopt_Ani_status) {
		this.adopt_Ani_status = adopt_Ani_status;
	}
		
	@Column(name = "ADOPT_ANI_CREDATE")
	public java.sql.Date getAdopt_Ani_CreDate() {
		return this.adopt_Ani_CreDate;
	}
	
	public void setAdopt_Ani_CreDate(java.sql.Date adopt_Ani_CreDate) {
		this.adopt_Ani_CreDate = adopt_Ani_CreDate;
	}
		
	@Column(name = "ADOPT_ANI_FINLAT")
	public Double getAdopt_Ani_FinLat() {
		return this.adopt_Ani_FinLat;
	}
	
	public void setAdopt_Ani_FinLat(Double adopt_Ani_FinLat) {
		this.adopt_Ani_FinLat = adopt_Ani_FinLat;
	}
		
	@Column(name = "ADOPT_ANI_FINLON")
	public Double getAdopt_Ani_FinLon() {
		return this.adopt_Ani_FinLon;
	}
	
	public void setAdopt_Ani_FinLon(Double adopt_Ani_FinLon) {
		this.adopt_Ani_FinLon = adopt_Ani_FinLon;
	}
		
	@Column(name = "ADOPT_ANI_CITY")
	public String getAdopt_Ani_city() {
		return this.adopt_Ani_city;
	}
	
	public void setAdopt_Ani_city(String adopt_Ani_city) {
		this.adopt_Ani_city = adopt_Ani_city;
	}
		
	@Column(name = "ADOPT_ANI_TOWN")
	public String getAdopt_Ani_town() {
		return this.adopt_Ani_town;
	}
	
	public void setAdopt_Ani_town(String adopt_Ani_town) {
		this.adopt_Ani_town = adopt_Ani_town;
	}
		
	@Column(name = "ADOPT_ANI_ROAD")
	public String getAdopt_Ani_road() {
		return this.adopt_Ani_road;
	}
	
	public void setAdopt_Ani_road(String adopt_Ani_road) {
		this.adopt_Ani_road = adopt_Ani_road;
	}
		
	@Column(name = "ADOPT_ANI_LIKE")
	public Integer getAdopt_Ani_like() {
		return this.adopt_Ani_like;
	}
	
	public void setAdopt_Ani_like(Integer adopt_Ani_like) {
		this.adopt_Ani_like = adopt_Ani_like;
	}
		
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="adopt_AniVO")
	@OrderBy("adopt_Ani_Id asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Adopt_Ani_photosVO> getAdopt_Ani_photoss() {
		return this.adopt_Ani_photoss;
	}

	public void setAdopt_Ani_photoss(Set<Adopt_Ani_photosVO> adopt_ani_photoss) {
		this.adopt_Ani_photoss = adopt_ani_photoss;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="adopt_AniVO")
	@OrderBy("adopt_Ani_Id asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Adopt_Ani_messageVO> getAdopt_Ani_messages() {
		return this.adopt_Ani_messages;
	}

	public void setAdopt_Ani_messages(Set<Adopt_Ani_messageVO> adopt_ani_messages) {
		this.adopt_Ani_messages = adopt_ani_messages;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="adopt_AniVO")
	@OrderBy("adopt_Ani_Id asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Adopt_Ani_sponsorVO> getAdopt_Ani_sponsors() {
		return this.adopt_Ani_sponsors;
	}

	public void setAdopt_Ani_sponsors(Set<Adopt_Ani_sponsorVO> adopt_ani_sponsors) {
		this.adopt_Ani_sponsors = adopt_ani_sponsors;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="adopt_AniVO")
	@OrderBy("adoAniSpoAniId asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<AdoAniSpoVO> getAdoAniSpos() {
		return this.adoAniSpos;
	}

	public void setAdoAniSpos(Set<AdoAniSpoVO> adoanispos) {
		this.adoAniSpos = adoanispos;
	}
	
}

package heibernate_com.pet.model;
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

import heibernate_com.pet_photos.model.Pet_PhotosVO;
import heibernate_com.pet_message.model.Pet_MessageVO;


/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 自家寵物 
*	英文: pet  
* </pre>
*/   
@Entity
@Table(name = "PET")
public class PetVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String pet_Id;
	private MemVO memVO;
	private String pet_name;
	private String pet_type;
	private String pet_gender;
	private String pet_heal;
	private String pet_Vac;
	private String pet_color;
	private String pet_body;
	private String pet_age;
	private String pet_Neu;
	private String pet_chip;
	private java.sql.Timestamp pet_birth;
	private String pet_status;
	private java.sql.Timestamp pet_CreDATE;
	private String pet_city;
	private String pet_town;
	private String pet_road;
	private Double pet_FinLat;
	private Double pet_FinLon;
	private Integer pet_like;

	private Set<Pet_PhotosVO> pet_Photoss = new HashSet<Pet_PhotosVO>();
	private Set<Pet_MessageVO> pet_Messages = new HashSet<Pet_MessageVO>();

	public PetVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "PET_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "pet_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="pet_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getPet_Id() {
		return this.pet_Id;
	}
	
	public void setPet_Id(String pet_Id) {
		this.pet_Id = pet_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "PET_NAME")
	public String getPet_name() {
		return this.pet_name;
	}
	
	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}
		
	@Column(name = "PET_TYPE")
	public String getPet_type() {
		return this.pet_type;
	}
	
	public void setPet_type(String pet_type) {
		this.pet_type = pet_type;
	}
		
	@Column(name = "PET_GENDER")
	public String getPet_gender() {
		return this.pet_gender;
	}
	
	public void setPet_gender(String pet_gender) {
		this.pet_gender = pet_gender;
	}
		
	@Column(name = "PET_HEAL")
	public String getPet_heal() {
		return this.pet_heal;
	}
	
	public void setPet_heal(String pet_heal) {
		this.pet_heal = pet_heal;
	}
		
	@Column(name = "PET_VAC")
	public String getPet_Vac() {
		return this.pet_Vac;
	}
	
	public void setPet_Vac(String pet_Vac) {
		this.pet_Vac = pet_Vac;
	}
		
	@Column(name = "PET_COLOR")
	public String getPet_color() {
		return this.pet_color;
	}
	
	public void setPet_color(String pet_color) {
		this.pet_color = pet_color;
	}
		
	@Column(name = "PET_BODY")
	public String getPet_body() {
		return this.pet_body;
	}
	
	public void setPet_body(String pet_body) {
		this.pet_body = pet_body;
	}
		
	@Column(name = "PET_AGE")
	public String getPet_age() {
		return this.pet_age;
	}
	
	public void setPet_age(String pet_age) {
		this.pet_age = pet_age;
	}
		
	@Column(name = "PET_NEU")
	public String getPet_Neu() {
		return this.pet_Neu;
	}
	
	public void setPet_Neu(String pet_Neu) {
		this.pet_Neu = pet_Neu;
	}
		
	@Column(name = "PET_CHIP")
	public String getPet_chip() {
		return this.pet_chip;
	}
	
	public void setPet_chip(String pet_chip) {
		this.pet_chip = pet_chip;
	}
		
	@Column(name = "PET_BIRTH")
	public java.sql.Timestamp getPet_birth() {
		return this.pet_birth;
	}
	
	public void setPet_birth(java.sql.Timestamp pet_birth) {
		this.pet_birth = pet_birth;
	}
		
	@Column(name = "PET_STATUS")
	public String getPet_status() {
		return this.pet_status;
	}
	
	public void setPet_status(String pet_status) {
		this.pet_status = pet_status;
	}
		
	@Column(name = "PET_CREDATE")
	public java.sql.Timestamp getPet_CreDATE() {
		return this.pet_CreDATE;
	}
	
	public void setPet_CreDATE(java.sql.Timestamp pet_CreDATE) {
		this.pet_CreDATE = pet_CreDATE;
	}
		
	@Column(name = "PET_CITY")
	public String getPet_city() {
		return this.pet_city;
	}
	
	public void setPet_city(String pet_city) {
		this.pet_city = pet_city;
	}
		
	@Column(name = "PET_TOWN")
	public String getPet_town() {
		return this.pet_town;
	}
	
	public void setPet_town(String pet_town) {
		this.pet_town = pet_town;
	}
		
	@Column(name = "PET_ROAD")
	public String getPet_road() {
		return this.pet_road;
	}
	
	public void setPet_road(String pet_road) {
		this.pet_road = pet_road;
	}
		
	@Column(name = "PET_FINLAT")
	public Double getPet_FinLat() {
		return this.pet_FinLat;
	}
	
	public void setPet_FinLat(Double pet_FinLat) {
		this.pet_FinLat = pet_FinLat;
	}
		
	@Column(name = "PET_FINLON")
	public Double getPet_FinLon() {
		return this.pet_FinLon;
	}
	
	public void setPet_FinLon(Double pet_FinLon) {
		this.pet_FinLon = pet_FinLon;
	}
		
	@Column(name = "PET_LIKE")
	public Integer getPet_like() {
		return this.pet_like;
	}
	
	public void setPet_like(Integer pet_like) {
		this.pet_like = pet_like;
	}
		
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="petVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="petVO")
	@OrderBy("pet_Id asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Pet_PhotosVO> getPet_Photoss() {
		return this.pet_Photoss;
	}

	public void setPet_Photoss(Set<Pet_PhotosVO> pet_photoss) {
		this.pet_Photoss = pet_photoss;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="petVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="petVO")
	@OrderBy("pet_Id asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Pet_MessageVO> getPet_Messages() {
		return this.pet_Messages;
	}

	public void setPet_Messages(Set<Pet_MessageVO> pet_messages) {
		this.pet_Messages = pet_messages;
	}
	
}

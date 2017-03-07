package heibernate_com.vet_hospital.model;
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

import heibernate_com.hos_photo.model.Hos_photoVO;
import heibernate_com.hos_comment.model.Hos_commentVO;


/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 診所 
*	英文: vet_hospital  
* </pre>
*/   
@Entity
@Table(name = "VET_HOSPITAL")
public class Vet_hospitalVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String hos_Id;
	private MemVO memVO;
	private String hos_name;
	private String hos_city;
	private String hos_town;
	private String hos_road;
	private Integer hos_Eval;
	private String hos_URL;
	private String hos_StartTime;
	private String hos_EndTime;
	private java.sql.Timestamp hos_CreateTime;
	private String hos_Tel;
	private String hos_Desc;
	private Double hos_Long;
	private Double hos_Lat;
	private String hos_visible;

	private Set<Hos_photoVO> hos_photos = new HashSet<Hos_photoVO>();
	private Set<Hos_commentVO> hos_comments = new HashSet<Hos_commentVO>();

	public Vet_hospitalVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "HOS_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "vet_hospital_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="vet_hospital_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getHos_Id() {
		return this.hos_Id;
	}
	
	public void setHos_Id(String hos_Id) {
		this.hos_Id = hos_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "HOS_MEMID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "HOS_NAME")
	public String getHos_name() {
		return this.hos_name;
	}
	
	public void setHos_name(String hos_name) {
		this.hos_name = hos_name;
	}
		
	@Column(name = "HOS_CITY")
	public String getHos_city() {
		return this.hos_city;
	}
	
	public void setHos_city(String hos_city) {
		this.hos_city = hos_city;
	}
		
	@Column(name = "HOS_TOWN")
	public String getHos_town() {
		return this.hos_town;
	}
	
	public void setHos_town(String hos_town) {
		this.hos_town = hos_town;
	}
		
	@Column(name = "HOS_ROAD")
	public String getHos_road() {
		return this.hos_road;
	}
	
	public void setHos_road(String hos_road) {
		this.hos_road = hos_road;
	}
		
	@Column(name = "HOS_EVAL")
	public Integer getHos_Eval() {
		return this.hos_Eval;
	}
	
	public void setHos_Eval(Integer hos_Eval) {
		this.hos_Eval = hos_Eval;
	}
		
	@Column(name = "HOS_URL")
	public String getHos_URL() {
		return this.hos_URL;
	}
	
	public void setHos_URL(String hos_URL) {
		this.hos_URL = hos_URL;
	}
		
	@Column(name = "HOS_STARTTIME")
	public String getHos_StartTime() {
		return this.hos_StartTime;
	}
	
	public void setHos_StartTime(String hos_StartTime) {
		this.hos_StartTime = hos_StartTime;
	}
		
	@Column(name = "HOS_ENDTIME")
	public String getHos_EndTime() {
		return this.hos_EndTime;
	}
	
	public void setHos_EndTime(String hos_EndTime) {
		this.hos_EndTime = hos_EndTime;
	}
		
	@Column(name = "HOS_CREATETIME")
	public java.sql.Timestamp getHos_CreateTime() {
		return this.hos_CreateTime;
	}
	
	public void setHos_CreateTime(java.sql.Timestamp hos_CreateTime) {
		this.hos_CreateTime = hos_CreateTime;
	}
		
	@Column(name = "HOS_TEL")
	public String getHos_Tel() {
		return this.hos_Tel;
	}
	
	public void setHos_Tel(String hos_Tel) {
		this.hos_Tel = hos_Tel;
	}
		
	@Column(name = "HOS_DESC")
	public String getHos_Desc() {
		return this.hos_Desc;
	}
	
	public void setHos_Desc(String hos_Desc) {
		this.hos_Desc = hos_Desc;
	}
		
	@Column(name = "HOS_LONG")
	public Double getHos_Long() {
		return this.hos_Long;
	}
	
	public void setHos_Long(Double hos_Long) {
		this.hos_Long = hos_Long;
	}
		
	@Column(name = "HOS_LAT")
	public Double getHos_Lat() {
		return this.hos_Lat;
	}
	
	public void setHos_Lat(Double hos_Lat) {
		this.hos_Lat = hos_Lat;
	}
		
	@Column(name = "HOS_VISIBLE")
	public String getHos_visible() {
		return this.hos_visible;
	}
	
	public void setHos_visible(String hos_visible) {
		this.hos_visible = hos_visible;
	}
		
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="vet_hospitalVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="vet_hospitalVO")
	@OrderBy("hosPhoto_HosId DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Hos_photoVO> getHos_photos() {
		return this.hos_photos;
	}

	public void setHos_photos(Set<Hos_photoVO> hos_photos) {
		this.hos_photos = hos_photos;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="vet_hospitalVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="vet_hospitalVO")
	@OrderBy("hosComment_HosId DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Hos_commentVO> getHos_comments() {
		return this.hos_comments;
	}

	public void setHos_comments(Set<Hos_commentVO> hos_comments) {
		this.hos_comments = hos_comments;
	}
	
}

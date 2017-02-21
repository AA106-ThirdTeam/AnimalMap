package heibernate_com.anihome.model;
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

import heibernate_com.anihome_photos.model.AniHome_PhotosVO;
import heibernate_com.anihome_msg.model.AniHome_MsgVO;


/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 動物之家 
*	英文: aniHome  
* </pre>
*/   
@Entity
@Table(name = "ANIHOME")
public class AniHomeVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String aniHome_Id;
	private MemVO memVO;
	private String aniHome_title;
	private String aniHome_content;
	private java.sql.Date aniHome_start_date;
	private java.sql.Date aniHome_upDate;
	private String aniHome_city;
	private String aniHome_town;
	private String aniHome_road;
	private String aniHome_addr;
	private Double aniHome_lon;
	private Double aniHome_lat;
	private String aniHome_pic;

	private Set<AniHome_PhotosVO> aniHome_Photoss = new HashSet<AniHome_PhotosVO>();
	private Set<AniHome_MsgVO> aniHome_Msgs = new HashSet<AniHome_MsgVO>();

	public AniHomeVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "ANIHOME_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "aniHome_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="aniHome_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getAniHome_Id() {
		return this.aniHome_Id;
	}
	
	public void setAniHome_Id(String aniHome_Id) {
		this.aniHome_Id = aniHome_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "ANIHOME_TITLE")
	public String getAniHome_title() {
		return this.aniHome_title;
	}
	
	public void setAniHome_title(String aniHome_title) {
		this.aniHome_title = aniHome_title;
	}
		
	@Column(name = "ANIHOME_CONTENT")
	public String getAniHome_content() {
		return this.aniHome_content;
	}
	
	public void setAniHome_content(String aniHome_content) {
		this.aniHome_content = aniHome_content;
	}
		
	@Column(name = "ANIHOME_START_DATE")
	public java.sql.Date getAniHome_start_date() {
		return this.aniHome_start_date;
	}
	
	public void setAniHome_start_date(java.sql.Date aniHome_start_date) {
		this.aniHome_start_date = aniHome_start_date;
	}
		
	@Column(name = "ANIHOME_UPDATE")
	public java.sql.Date getAniHome_upDate() {
		return this.aniHome_upDate;
	}
	
	public void setAniHome_upDate(java.sql.Date aniHome_upDate) {
		this.aniHome_upDate = aniHome_upDate;
	}
		
	@Column(name = "ANIHOME_CITY")
	public String getAniHome_city() {
		return this.aniHome_city;
	}
	
	public void setAniHome_city(String aniHome_city) {
		this.aniHome_city = aniHome_city;
	}
		
	@Column(name = "ANIHOME_TOWN")
	public String getAniHome_town() {
		return this.aniHome_town;
	}
	
	public void setAniHome_town(String aniHome_town) {
		this.aniHome_town = aniHome_town;
	}
		
	@Column(name = "ANIHOME_ROAD")
	public String getAniHome_road() {
		return this.aniHome_road;
	}
	
	public void setAniHome_road(String aniHome_road) {
		this.aniHome_road = aniHome_road;
	}
		
	@Column(name = "ANIHOME_ADDR")
	public String getAniHome_addr() {
		return this.aniHome_addr;
	}
	
	public void setAniHome_addr(String aniHome_addr) {
		this.aniHome_addr = aniHome_addr;
	}
		
	@Column(name = "ANIHOME_LON")
	public Double getAniHome_lon() {
		return this.aniHome_lon;
	}
	
	public void setAniHome_lon(Double aniHome_lon) {
		this.aniHome_lon = aniHome_lon;
	}
		
	@Column(name = "ANIHOME_LAT")
	public Double getAniHome_lat() {
		return this.aniHome_lat;
	}
	
	public void setAniHome_lat(Double aniHome_lat) {
		this.aniHome_lat = aniHome_lat;
	}
		
	@Column(name = "ANIHOME_PIC")
	public String getAniHome_pic() {
		return this.aniHome_pic;
	}
	
	public void setAniHome_pic(String aniHome_pic) {
		this.aniHome_pic = aniHome_pic;
	}
		
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="aniHomeVO")
	@OrderBy("aniHome_Id asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<AniHome_PhotosVO> getAniHome_Photoss() {
		return this.aniHome_Photoss;
	}

	public void setAniHome_Photoss(Set<AniHome_PhotosVO> anihome_photoss) {
		this.aniHome_Photoss = anihome_photoss;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="aniHomeVO")
	@OrderBy("aniHome_Id asc")
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
	
}

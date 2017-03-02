package heibernate_com.adp.model;
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

import heibernate_com.adpphotos.model.AdpPhotosVO;
import heibernate_com.adpmsg.model.AdpMsgVO;


/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 領養活動 
*	英文: adp  
* </pre>
*/   
@Entity
@Table(name = "ADP")
public class AdpVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String adp_Id;
	private MemVO memVO;
	private String adp_title;
	private String adp_adp_content;
	private java.sql.Date adp_start_date;
	private java.sql.Date adp_end_date;
	private java.sql.Date adp_upDate;
	private String adp_city;
	private String adp_town;
	private String adp_road;
	private String adp_addr;
	private Double adp_lon;
	private Double adp_lat;
	private String adp_adp_pic;

	private Set<AdpPhotosVO> adpPhotoss = new HashSet<AdpPhotosVO>();
	private Set<AdpMsgVO> adpMsgs = new HashSet<AdpMsgVO>();

	public AdpVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "ADP_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "adp_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="adp_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getAdp_Id() {
		return this.adp_Id;
	}
	
	public void setAdp_Id(String adp_Id) {
		this.adp_Id = adp_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "ADP_TITLE")
	public String getAdp_title() {
		return this.adp_title;
	}
	
	public void setAdp_title(String adp_title) {
		this.adp_title = adp_title;
	}
		
	@Column(name = "ADP_ADP_CONTENT")
	public String getAdp_adp_content() {
		return this.adp_adp_content;
	}
	
	public void setAdp_adp_content(String adp_adp_content) {
		this.adp_adp_content = adp_adp_content;
	}
		
	@Column(name = "ADP_START_DATE")
	public java.sql.Date getAdp_start_date() {
		return this.adp_start_date;
	}
	
	public void setAdp_start_date(java.sql.Date adp_start_date) {
		this.adp_start_date = adp_start_date;
	}
		
	@Column(name = "ADP_END_DATE")
	public java.sql.Date getAdp_end_date() {
		return this.adp_end_date;
	}
	
	public void setAdp_end_date(java.sql.Date adp_end_date) {
		this.adp_end_date = adp_end_date;
	}
		
	@Column(name = "ADP_UPDATE")
	public java.sql.Date getAdp_upDate() {
		return this.adp_upDate;
	}
	
	public void setAdp_upDate(java.sql.Date adp_upDate) {
		this.adp_upDate = adp_upDate;
	}
		
	@Column(name = "ADP_CITY")
	public String getAdp_city() {
		return this.adp_city;
	}
	
	public void setAdp_city(String adp_city) {
		this.adp_city = adp_city;
	}
		
	@Column(name = "ADP_TOWN")
	public String getAdp_town() {
		return this.adp_town;
	}
	
	public void setAdp_town(String adp_town) {
		this.adp_town = adp_town;
	}
		
	@Column(name = "ADP_ROAD")
	public String getAdp_road() {
		return this.adp_road;
	}
	
	public void setAdp_road(String adp_road) {
		this.adp_road = adp_road;
	}
		
	@Column(name = "ADP_ADDR")
	public String getAdp_addr() {
		return this.adp_addr;
	}
	
	public void setAdp_addr(String adp_addr) {
		this.adp_addr = adp_addr;
	}
		
	@Column(name = "ADP_LON")
	public Double getAdp_lon() {
		return this.adp_lon;
	}
	
	public void setAdp_lon(Double adp_lon) {
		this.adp_lon = adp_lon;
	}
		
	@Column(name = "ADP_LAT")
	public Double getAdp_lat() {
		return this.adp_lat;
	}
	
	public void setAdp_lat(Double adp_lat) {
		this.adp_lat = adp_lat;
	}
		
	@Column(name = "ADP_ADP_PIC")
	public String getAdp_adp_pic() {
		return this.adp_adp_pic;
	}
	
	public void setAdp_adp_pic(String adp_adp_pic) {
		this.adp_adp_pic = adp_adp_pic;
	}
		
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="adpVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="adpVO")
	@OrderBy("adp_Id asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<AdpPhotosVO> getAdpPhotoss() {
		return this.adpPhotoss;
	}

	public void setAdpPhotoss(Set<AdpPhotosVO> adpphotoss) {
		this.adpPhotoss = adpphotoss;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="adpVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="adpVO")
	@OrderBy("adp_Id asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<AdpMsgVO> getAdpMsgs() {
		return this.adpMsgs;
	}

	public void setAdpMsgs(Set<AdpMsgVO> adpmsgs) {
		this.adpMsgs = adpmsgs;
	}
	
}

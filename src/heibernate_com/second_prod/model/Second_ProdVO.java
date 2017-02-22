package heibernate_com.second_prod.model;
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

import heibernate_com.second_prodphotos.model.Second_ProdPhotosVO;
import heibernate_com.second_prodmsg.model.Second_ProdMsgVO;


/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 二手商品 
*	英文: second_Prod  
* </pre>
*/   
@Entity
@Table(name = "SECOND_PROD")
public class Second_ProdVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String second_Prod_Id;
	private MemVO memVO;
	private String second_Prod_Title;
	private String second_Prod_Content;
	private java.sql.Date second_Prod_adp_start_date;
	private java.sql.Date second_Prod_adp_end_date;
	private java.sql.Date second_Prod_adp_upDate;
	private String second_Prod_adp_city;
	private String second_Prod_Town;
	private String second_Prod_Road;
	private Double second_Prod_Lon;
	private Double second_Prod_Lat;

	private Set<Second_ProdPhotosVO> second_ProdPhotoss = new HashSet<Second_ProdPhotosVO>();
	private Set<Second_ProdMsgVO> second_ProdMsgs = new HashSet<Second_ProdMsgVO>();

	public Second_ProdVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "SECOND_PROD_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "second_Prod_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="second_Prod_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getSecond_Prod_Id() {
		return this.second_Prod_Id;
	}
	
	public void setSecond_Prod_Id(String second_Prod_Id) {
		this.second_Prod_Id = second_Prod_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "SECOND_PROD_TITLE")
	public String getSecond_Prod_Title() {
		return this.second_Prod_Title;
	}
	
	public void setSecond_Prod_Title(String second_Prod_Title) {
		this.second_Prod_Title = second_Prod_Title;
	}
		
	@Column(name = "SECOND_PROD_CONTENT")
	public String getSecond_Prod_Content() {
		return this.second_Prod_Content;
	}
	
	public void setSecond_Prod_Content(String second_Prod_Content) {
		this.second_Prod_Content = second_Prod_Content;
	}
		
	@Column(name = "SECOND_PROD_ADP_START_DATE")
	public java.sql.Date getSecond_Prod_adp_start_date() {
		return this.second_Prod_adp_start_date;
	}
	
	public void setSecond_Prod_adp_start_date(java.sql.Date second_Prod_adp_start_date) {
		this.second_Prod_adp_start_date = second_Prod_adp_start_date;
	}
		
	@Column(name = "SECOND_PROD_ADP_END_DATE")
	public java.sql.Date getSecond_Prod_adp_end_date() {
		return this.second_Prod_adp_end_date;
	}
	
	public void setSecond_Prod_adp_end_date(java.sql.Date second_Prod_adp_end_date) {
		this.second_Prod_adp_end_date = second_Prod_adp_end_date;
	}
		
	@Column(name = "SECOND_PROD_ADP_UPDATE")
	public java.sql.Date getSecond_Prod_adp_upDate() {
		return this.second_Prod_adp_upDate;
	}
	
	public void setSecond_Prod_adp_upDate(java.sql.Date second_Prod_adp_upDate) {
		this.second_Prod_adp_upDate = second_Prod_adp_upDate;
	}
		
	@Column(name = "SECOND_PROD_ADP_CITY")
	public String getSecond_Prod_adp_city() {
		return this.second_Prod_adp_city;
	}
	
	public void setSecond_Prod_adp_city(String second_Prod_adp_city) {
		this.second_Prod_adp_city = second_Prod_adp_city;
	}
		
	@Column(name = "SECOND_PROD_TOWN")
	public String getSecond_Prod_Town() {
		return this.second_Prod_Town;
	}
	
	public void setSecond_Prod_Town(String second_Prod_Town) {
		this.second_Prod_Town = second_Prod_Town;
	}
		
	@Column(name = "SECOND_PROD_ROAD")
	public String getSecond_Prod_Road() {
		return this.second_Prod_Road;
	}
	
	public void setSecond_Prod_Road(String second_Prod_Road) {
		this.second_Prod_Road = second_Prod_Road;
	}
		
	@Column(name = "SECOND_PROD_LON")
	public Double getSecond_Prod_Lon() {
		return this.second_Prod_Lon;
	}
	
	public void setSecond_Prod_Lon(Double second_Prod_Lon) {
		this.second_Prod_Lon = second_Prod_Lon;
	}
		
	@Column(name = "SECOND_PROD_LAT")
	public Double getSecond_Prod_Lat() {
		return this.second_Prod_Lat;
	}
	
	public void setSecond_Prod_Lat(Double second_Prod_Lat) {
		this.second_Prod_Lat = second_Prod_Lat;
	}
		
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="second_ProdVO")
	@OrderBy("second_Prod_Id asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Second_ProdPhotosVO> getSecond_ProdPhotoss() {
		return this.second_ProdPhotoss;
	}

	public void setSecond_ProdPhotoss(Set<Second_ProdPhotosVO> second_prodphotoss) {
		this.second_ProdPhotoss = second_prodphotoss;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="second_ProdVO")
	@OrderBy("second_Prod_Id asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Second_ProdMsgVO> getSecond_ProdMsgs() {
		return this.second_ProdMsgs;
	}

	public void setSecond_ProdMsgs(Set<Second_ProdMsgVO> second_prodmsgs) {
		this.second_ProdMsgs = second_prodmsgs;
	}
	
}

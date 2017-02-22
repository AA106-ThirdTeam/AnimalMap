package heibernate_com.pet_group.model;
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

import heibernate_com.grp_comment.model.Grp_commentVO;
import heibernate_com.joinlist.model.JoinListVO;


/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 揪團 
*	英文: pet_group  
* </pre>
*/   
@Entity
@Table(name = "PET_GROUP")
public class Pet_groupVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String grp_Id;
	private MemVO memVO;
	private String grp_name;
	private String grp_city;
	private String grp_Addr;
	private String grp_road;
	private String grp_StartTime;
	private String grp_EndTime;
	private String grp_Desc;
	private Double grp_Long;
	private Double grp_Lat;
	private java.sql.Date grp_CreateTime;
	private String grp_visible;
	private byte[] grp_photo;

	private Set<Grp_commentVO> grp_comments = new HashSet<Grp_commentVO>();
	private Set<JoinListVO> JoinLists = new HashSet<JoinListVO>();

	public Pet_groupVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "GRP_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "pet_group_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="pet_group_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getGrp_Id() {
		return this.grp_Id;
	}
	
	public void setGrp_Id(String grp_Id) {
		this.grp_Id = grp_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "GRP_NAME")
	public String getGrp_name() {
		return this.grp_name;
	}
	
	public void setGrp_name(String grp_name) {
		this.grp_name = grp_name;
	}
		
	@Column(name = "GRP_CITY")
	public String getGrp_city() {
		return this.grp_city;
	}
	
	public void setGrp_city(String grp_city) {
		this.grp_city = grp_city;
	}
		
	@Column(name = "GRP_ADDR")
	public String getGrp_Addr() {
		return this.grp_Addr;
	}
	
	public void setGrp_Addr(String grp_Addr) {
		this.grp_Addr = grp_Addr;
	}
		
	@Column(name = "GRP_ROAD")
	public String getGrp_road() {
		return this.grp_road;
	}
	
	public void setGrp_road(String grp_road) {
		this.grp_road = grp_road;
	}
		
	@Column(name = "GRP_STARTTIME")
	public String getGrp_StartTime() {
		return this.grp_StartTime;
	}
	
	public void setGrp_StartTime(String grp_StartTime) {
		this.grp_StartTime = grp_StartTime;
	}
		
	@Column(name = "GRP_ENDTIME")
	public String getGrp_EndTime() {
		return this.grp_EndTime;
	}
	
	public void setGrp_EndTime(String grp_EndTime) {
		this.grp_EndTime = grp_EndTime;
	}
		
	@Column(name = "GRP_DESC")
	public String getGrp_Desc() {
		return this.grp_Desc;
	}
	
	public void setGrp_Desc(String grp_Desc) {
		this.grp_Desc = grp_Desc;
	}
		
	@Column(name = "GRP_LONG")
	public Double getGrp_Long() {
		return this.grp_Long;
	}
	
	public void setGrp_Long(Double grp_Long) {
		this.grp_Long = grp_Long;
	}
		
	@Column(name = "GRP_LAT")
	public Double getGrp_Lat() {
		return this.grp_Lat;
	}
	
	public void setGrp_Lat(Double grp_Lat) {
		this.grp_Lat = grp_Lat;
	}
		
	@Column(name = "GRP_CREATETIME")
	public java.sql.Date getGrp_CreateTime() {
		return this.grp_CreateTime;
	}
	
	public void setGrp_CreateTime(java.sql.Date grp_CreateTime) {
		this.grp_CreateTime = grp_CreateTime;
	}
		
	@Column(name = "GRP_VISIBLE")
	public String getGrp_visible() {
		return this.grp_visible;
	}
	
	public void setGrp_visible(String grp_visible) {
		this.grp_visible = grp_visible;
	}
		
	@Column(name = "GRP_PHOTO")
	public byte[] getGrp_photo() {
		return this.grp_photo;
	}
	
	public void setGrp_photo(byte[] grp_photo) {
		this.grp_photo = grp_photo;
	}
		
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="pet_groupVO")
	@OrderBy("grpComment_GrpId asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Grp_commentVO> getGrp_comments() {
		return this.grp_comments;
	}

	public void setGrp_comments(Set<Grp_commentVO> grp_comments) {
		this.grp_comments = grp_comments;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="pet_groupVO")
	@OrderBy("joinList_GrpId asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<JoinListVO> getJoinLists() {
		return this.JoinLists;
	}

	public void setJoinLists(Set<JoinListVO> joinlists) {
		this.JoinLists = joinlists;
	}
	
}

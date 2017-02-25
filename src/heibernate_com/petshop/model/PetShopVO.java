package heibernate_com.petshop.model;
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

import heibernate_com.shop_comment.model.Shop_commentVO;
import heibernate_com.shopphoto.model.ShopPhotoVO;


/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 寵物商店 
*	英文: petShop  
* </pre>
*/   
@Entity
@Table(name = "PETSHOP")
public class PetShopVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String shop_Id;
	private MemVO memVO;
	private String shop_name;
	private String shop_city;
	private String shop_town;
	private String shop_road;
	private Integer shop_Eval;
	private String shop_URL;
	private String shop_StartTime;
	private String shop_EndTime;
	private String shop_Tel;
	private String shop_Desc;
	private Double shop_Long;
	private Double shop_Lat;
	private java.sql.Date shop_CreateTime;
	private String shop_visible;

	private Set<Shop_commentVO> shop_comments = new HashSet<Shop_commentVO>();
	private Set<ShopPhotoVO> shopPhotos = new HashSet<ShopPhotoVO>();

	public PetShopVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "SHOP_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "petShop_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="petShop_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getShop_Id() {
		return this.shop_Id;
	}
	
	public void setShop_Id(String shop_Id) {
		this.shop_Id = shop_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "SHOP_MEMID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "SHOP_NAME")
	public String getShop_name() {
		return this.shop_name;
	}
	
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
		
	@Column(name = "SHOP_CITY")
	public String getShop_city() {
		return this.shop_city;
	}
	
	public void setShop_city(String shop_city) {
		this.shop_city = shop_city;
	}
		
	@Column(name = "SHOP_TOWN")
	public String getShop_town() {
		return this.shop_town;
	}
	
	public void setShop_town(String shop_town) {
		this.shop_town = shop_town;
	}
		
	@Column(name = "SHOP_ROAD")
	public String getShop_road() {
		return this.shop_road;
	}
	
	public void setShop_road(String shop_road) {
		this.shop_road = shop_road;
	}
		
	@Column(name = "SHOP_EVAL")
	public Integer getShop_Eval() {
		return this.shop_Eval;
	}
	
	public void setShop_Eval(Integer shop_Eval) {
		this.shop_Eval = shop_Eval;
	}
		
	@Column(name = "SHOP_URL")
	public String getShop_URL() {
		return this.shop_URL;
	}
	
	public void setShop_URL(String shop_URL) {
		this.shop_URL = shop_URL;
	}
		
	@Column(name = "SHOP_STARTTIME")
	public String getShop_StartTime() {
		return this.shop_StartTime;
	}
	
	public void setShop_StartTime(String shop_StartTime) {
		this.shop_StartTime = shop_StartTime;
	}
		
	@Column(name = "SHOP_ENDTIME")
	public String getShop_EndTime() {
		return this.shop_EndTime;
	}
	
	public void setShop_EndTime(String shop_EndTime) {
		this.shop_EndTime = shop_EndTime;
	}
		
	@Column(name = "SHOP_TEL")
	public String getShop_Tel() {
		return this.shop_Tel;
	}
	
	public void setShop_Tel(String shop_Tel) {
		this.shop_Tel = shop_Tel;
	}
		
	@Column(name = "SHOP_DESC")
	public String getShop_Desc() {
		return this.shop_Desc;
	}
	
	public void setShop_Desc(String shop_Desc) {
		this.shop_Desc = shop_Desc;
	}
		
	@Column(name = "SHOP_LONG")
	public Double getShop_Long() {
		return this.shop_Long;
	}
	
	public void setShop_Long(Double shop_Long) {
		this.shop_Long = shop_Long;
	}
		
	@Column(name = "SHOP_LAT")
	public Double getShop_Lat() {
		return this.shop_Lat;
	}
	
	public void setShop_Lat(Double shop_Lat) {
		this.shop_Lat = shop_Lat;
	}
		
	@Column(name = "SHOP_CREATETIME")
	public java.sql.Date getShop_CreateTime() {
		return this.shop_CreateTime;
	}
	
	public void setShop_CreateTime(java.sql.Date shop_CreateTime) {
		this.shop_CreateTime = shop_CreateTime;
	}
		
	@Column(name = "SHOP_VISIBLE")
	public String getShop_visible() {
		return this.shop_visible;
	}
	
	public void setShop_visible(String shop_visible) {
		this.shop_visible = shop_visible;
	}
		
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="petShopVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="petShopVO")
	@OrderBy("shopComment_ShopId asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Shop_commentVO> getShop_comments() {
		return this.shop_comments;
	}

	public void setShop_comments(Set<Shop_commentVO> shop_comments) {
		this.shop_comments = shop_comments;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="petShopVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="petShopVO")
	@OrderBy("shopPhoto_ShopId asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<ShopPhotoVO> getShopPhotos() {
		return this.shopPhotos;
	}

	public void setShopPhotos(Set<ShopPhotoVO> shopphotos) {
		this.shopPhotos = shopphotos;
	}
	
}

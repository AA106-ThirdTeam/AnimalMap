package heibernate_com.product.model;
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

import heibernate_com.orders_item.model.Orders_itemVO;


/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 商品 
*	英文: product  
* </pre>
*/   
@Entity
@Table(name = "PRODUCT")
public class ProductVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String product_no;
	private String product_name;
	private String product_introduction;
	private Integer product_price;
	private Integer product_stock;
	private String product_picture_large;
	private String product_picture_small;
	private Integer product_status;
	private java.sql.Timestamp product_create_date;
	private String product_info;
	private String product_kind_no;

	private Set<Orders_itemVO> orders_items = new HashSet<Orders_itemVO>();

	public ProductVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "PRODUCT_NO")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "product_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="product_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getProduct_no() {
		return this.product_no;
	}
	
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}	
	@Column(name = "PRODUCT_NAME")
	public String getProduct_name() {
		return this.product_name;
	}
	
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
		
	@Column(name = "PRODUCT_INTRODUCTION")
	public String getProduct_introduction() {
		return this.product_introduction;
	}
	
	public void setProduct_introduction(String product_introduction) {
		this.product_introduction = product_introduction;
	}
		
	@Column(name = "PRODUCT_PRICE")
	public Integer getProduct_price() {
		return this.product_price;
	}
	
	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}
		
	@Column(name = "PRODUCT_STOCK")
	public Integer getProduct_stock() {
		return this.product_stock;
	}
	
	public void setProduct_stock(Integer product_stock) {
		this.product_stock = product_stock;
	}
		
	@Column(name = "PRODUCT_PICTURE_LARGE")
	public String getProduct_picture_large() {
		return this.product_picture_large;
	}
	
	public void setProduct_picture_large(String product_picture_large) {
		this.product_picture_large = product_picture_large;
	}
		
	@Column(name = "PRODUCT_PICTURE_SMALL")
	public String getProduct_picture_small() {
		return this.product_picture_small;
	}
	
	public void setProduct_picture_small(String product_picture_small) {
		this.product_picture_small = product_picture_small;
	}
		
	@Column(name = "PRODUCT_STATUS")
	public Integer getProduct_status() {
		return this.product_status;
	}
	
	public void setProduct_status(Integer product_status) {
		this.product_status = product_status;
	}
		
	@Column(name = "PRODUCT_CREATE_DATE")
	public java.sql.Timestamp getProduct_create_date() {
		return this.product_create_date;
	}
	
	public void setProduct_create_date(java.sql.Timestamp product_create_date) {
		this.product_create_date = product_create_date;
	}
		
	@Column(name = "PRODUCT_INFO")
	public String getProduct_info() {
		return this.product_info;
	}
	
	public void setProduct_info(String product_info) {
		this.product_info = product_info;
	}
		
	@Column(name = "PRODUCT_KIND_NO")
	public String getProduct_kind_no() {
		return this.product_kind_no;
	}
	
	public void setProduct_kind_no(String product_kind_no) {
		this.product_kind_no = product_kind_no;
	}
		
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="productVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="productVO")
	@OrderBy("product_no asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Orders_itemVO> getOrders_items() {
		return this.orders_items;
	}

	public void setOrders_items(Set<Orders_itemVO> orders_items) {
		this.orders_items = orders_items;
	}
	
}

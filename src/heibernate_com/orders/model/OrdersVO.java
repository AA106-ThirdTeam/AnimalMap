package heibernate_com.orders.model;
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

import heibernate_com.orders_item.model.Orders_itemVO;


/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 訂單 
*	英文: orders  
* </pre>
*/   
@Entity
@Table(name = "ORDERS")
public class OrdersVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String orders_no;
	private MemVO memVO;
	private String orders_receiver;
	private String post_no;
	private String post_adp_city;
	private String post_town;
	private String post_road;
	private Integer orders_phone;
	private Integer collect_mode_no;
	private java.sql.Date orders_date;
	private java.sql.Date orders_ship_date;
	private Integer orders_total;
	private Integer orders_status;
	private Integer orders_credit;

	private Set<Orders_itemVO> orders_items = new HashSet<Orders_itemVO>();

	public OrdersVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "ORDERS_NO")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "orders_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="orders_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getOrders_no() {
		return this.orders_no;
	}
	
	public void setOrders_no(String orders_no) {
		this.orders_no = orders_no;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "ORDERS_RECEIVER")
	public String getOrders_receiver() {
		return this.orders_receiver;
	}
	
	public void setOrders_receiver(String orders_receiver) {
		this.orders_receiver = orders_receiver;
	}
		
	@Column(name = "POST_NO")
	public String getPost_no() {
		return this.post_no;
	}
	
	public void setPost_no(String post_no) {
		this.post_no = post_no;
	}
		
	@Column(name = "POST_ADP_CITY")
	public String getPost_adp_city() {
		return this.post_adp_city;
	}
	
	public void setPost_adp_city(String post_adp_city) {
		this.post_adp_city = post_adp_city;
	}
		
	@Column(name = "POST_TOWN")
	public String getPost_town() {
		return this.post_town;
	}
	
	public void setPost_town(String post_town) {
		this.post_town = post_town;
	}
		
	@Column(name = "POST_ROAD")
	public String getPost_road() {
		return this.post_road;
	}
	
	public void setPost_road(String post_road) {
		this.post_road = post_road;
	}
		
	@Column(name = "ORDERS_PHONE")
	public Integer getOrders_phone() {
		return this.orders_phone;
	}
	
	public void setOrders_phone(Integer orders_phone) {
		this.orders_phone = orders_phone;
	}
		
	@Column(name = "COLLECT_MODE_NO")
	public Integer getCollect_mode_no() {
		return this.collect_mode_no;
	}
	
	public void setCollect_mode_no(Integer collect_mode_no) {
		this.collect_mode_no = collect_mode_no;
	}
		
	@Column(name = "ORDERS_DATE")
	public java.sql.Date getOrders_date() {
		return this.orders_date;
	}
	
	public void setOrders_date(java.sql.Date orders_date) {
		this.orders_date = orders_date;
	}
		
	@Column(name = "ORDERS_SHIP_DATE")
	public java.sql.Date getOrders_ship_date() {
		return this.orders_ship_date;
	}
	
	public void setOrders_ship_date(java.sql.Date orders_ship_date) {
		this.orders_ship_date = orders_ship_date;
	}
		
	@Column(name = "ORDERS_TOTAL")
	public Integer getOrders_total() {
		return this.orders_total;
	}
	
	public void setOrders_total(Integer orders_total) {
		this.orders_total = orders_total;
	}
		
	@Column(name = "ORDERS_STATUS")
	public Integer getOrders_status() {
		return this.orders_status;
	}
	
	public void setOrders_status(Integer orders_status) {
		this.orders_status = orders_status;
	}
		
	@Column(name = "ORDERS_CREDIT")
	public Integer getOrders_credit() {
		return this.orders_credit;
	}
	
	public void setOrders_credit(Integer orders_credit) {
		this.orders_credit = orders_credit;
	}
		
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="ordersVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="ordersVO")
	@OrderBy("orders_no asc")
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

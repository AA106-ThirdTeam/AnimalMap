package heibernate_com.orders_item.model;
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

import heibernate_com.orders.model.OrdersVO;

import heibernate_com.product.model.ProductVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 訂單明細 
*	英文: orders_item  
* </pre>
*/   
@Entity
@Table(name = "ORDERS_ITEM")
public class Orders_itemVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private OrdersVO ordersVO;
	private ProductVO productVO;
	private Integer commodities_amout;
	private Integer selling_price;


	public Orders_itemVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "ORDERS_NO")  //指定用來join table的column
	public OrdersVO getOrdersVO() {
		return this.ordersVO;
	}
	
	public void setOrdersVO(OrdersVO ordersVO) {
		this.ordersVO = ordersVO;
	}
	@Id
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "PRODUCT_NO")  //指定用來join table的column
	public ProductVO getProductVO() {
		return this.productVO;
	}
	
	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}
	@Column(name = "COMMODITIES_AMOUT")
	public Integer getCommodities_amout() {
		return this.commodities_amout;
	}
	
	public void setCommodities_amout(Integer commodities_amout) {
		this.commodities_amout = commodities_amout;
	}
		
	@Column(name = "SELLING_PRICE")
	public Integer getSelling_price() {
		return this.selling_price;
	}
	
	public void setSelling_price(Integer selling_price) {
		this.selling_price = selling_price;
	}
		
}

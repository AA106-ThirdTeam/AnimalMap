package heibernate_com.product_kind.model;
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



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 商品類別 
*	英文: product_kind  
* </pre>
*/   
@Entity
@Table(name = "PRODUCT_KIND")
public class Product_kindVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String product_kind_no;
	private String product_kind_name;


	public Product_kindVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "PRODUCT_KIND_NO")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "product_kind_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="product_kind_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getProduct_kind_no() {
		return this.product_kind_no;
	}
	
	public void setProduct_kind_no(String product_kind_no) {
		this.product_kind_no = product_kind_no;
	}	
	@Column(name = "PRODUCT_KIND_NAME")
	public String getProduct_kind_name() {
		return this.product_kind_name;
	}
	
	public void setProduct_kind_name(String product_kind_name) {
		this.product_kind_name = product_kind_name;
	}
		
}

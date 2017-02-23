package heibernate_com.shop_comment.model;
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

import heibernate_com.petshop.model.PetShopVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 商家留言 
*	英文: shop_comment  
* </pre>
*/   
@Entity
@Table(name = "SHOP_COMMENT")
public class Shop_commentVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String shopComment_Id;
	private MemVO memVO;
	private PetShopVO petShopVO;
	private String shopComment_content;
	private java.sql.Date shopComment_SendTime;


	public Shop_commentVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "SHOPCOMMENT_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "shop_comment_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="shop_comment_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getShopComment_Id() {
		return this.shopComment_Id;
	}
	
	public void setShopComment_Id(String shopComment_Id) {
		this.shopComment_Id = shopComment_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "SHOP_ID")  //指定用來join table的column
	public PetShopVO getPetShopVO() {
		return this.petShopVO;
	}
	
	public void setPetShopVO(PetShopVO petShopVO) {
		this.petShopVO = petShopVO;
	}
	@Column(name = "SHOPCOMMENT_CONTENT")
	public String getShopComment_content() {
		return this.shopComment_content;
	}
	
	public void setShopComment_content(String shopComment_content) {
		this.shopComment_content = shopComment_content;
	}
		
	@Column(name = "SHOPCOMMENT_SENDTIME")
	public java.sql.Date getShopComment_SendTime() {
		return this.shopComment_SendTime;
	}
	
	public void setShopComment_SendTime(java.sql.Date shopComment_SendTime) {
		this.shopComment_SendTime = shopComment_SendTime;
	}
		
}

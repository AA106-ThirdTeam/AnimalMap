package heibernate_com.shopphoto.model;
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

import heibernate_com.petshop.model.PetShopVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 商家相片 
*	英文: shopPhoto  
* </pre>
*/   
@Entity
@Table(name = "SHOPPHOTO")
public class ShopPhotoVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String shopPhoto_Id;
	private PetShopVO petShopVO;
	private byte[] shopPhoto_photo;
	private String isDisp_shopPhoto;
	private String shopPhoto_name;
	private String shopPhoto_extent;


	public ShopPhotoVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "SHOPPHOTO_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "shopPhoto_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="shopPhoto_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getShopPhoto_Id() {
		return this.shopPhoto_Id;
	}
	
	public void setShopPhoto_Id(String shopPhoto_Id) {
		this.shopPhoto_Id = shopPhoto_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "SHOPPHOTO_SHOPID")  //指定用來join table的column
	public PetShopVO getPetShopVO() {
		return this.petShopVO;
	}
	
	public void setPetShopVO(PetShopVO petShopVO) {
		this.petShopVO = petShopVO;
	}
	@Column(name = "SHOPPHOTO_PHOTO")
	public byte[] getShopPhoto_photo() {
		return this.shopPhoto_photo;
	}
	
	public void setShopPhoto_photo(byte[] shopPhoto_photo) {
		this.shopPhoto_photo = shopPhoto_photo;
	}
		
	@Column(name = "ISDISP_SHOPPHOTO")
	public String getIsDisp_shopPhoto() {
		return this.isDisp_shopPhoto;
	}
	
	public void setIsDisp_shopPhoto(String isDisp_shopPhoto) {
		this.isDisp_shopPhoto = isDisp_shopPhoto;
	}
		
	@Column(name = "SHOPPHOTO_NAME")
	public String getShopPhoto_name() {
		return this.shopPhoto_name;
	}
	
	public void setShopPhoto_name(String shopPhoto_name) {
		this.shopPhoto_name = shopPhoto_name;
	}
		
	@Column(name = "SHOPPHOTO_EXTENT")
	public String getShopPhoto_extent() {
		return this.shopPhoto_extent;
	}
	
	public void setShopPhoto_extent(String shopPhoto_extent) {
		this.shopPhoto_extent = shopPhoto_extent;
	}
		
}

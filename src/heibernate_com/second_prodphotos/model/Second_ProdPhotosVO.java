package heibernate_com.second_prodphotos.model;
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

import heibernate_com.second_prod.model.Second_ProdVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 二手商品相簿 
*	英文: second_ProdPhotos  
* </pre>
*/   
@Entity
@Table(name = "SECOND_PRODPHOTOS")
public class Second_ProdPhotosVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String second_ProdPhotos_Id;
	private Second_ProdVO second_ProdVO;


	public Second_ProdPhotosVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "SECOND_PRODPHOTOS_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "second_ProdPhotos_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="second_ProdPhotos_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getSecond_ProdPhotos_Id() {
		return this.second_ProdPhotos_Id;
	}
	
	public void setSecond_ProdPhotos_Id(String second_ProdPhotos_Id) {
		this.second_ProdPhotos_Id = second_ProdPhotos_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "SECOND_PROD_ID")  //指定用來join table的column
	public Second_ProdVO getSecond_ProdVO() {
		return this.second_ProdVO;
	}
	
	public void setSecond_ProdVO(Second_ProdVO second_ProdVO) {
		this.second_ProdVO = second_ProdVO;
	}
}

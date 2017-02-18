package heibernate_com.anihome_photos.model;
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

import heibernate_com.anihome.model.AniHomeVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 動物之家相簿 
*	英文: aniHome_Photos  
* </pre>
*/   
@Entity
@Table(name = "ANIHOME_PHOTOS")
public class AniHome_PhotosVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String aniHome_Photos_Id;
	private AniHomeVO aniHomeVO;
	private byte[] aniHome_Photos_pic;


	public AniHome_PhotosVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "ANIHOME_PHOTOS_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "aniHome_Photos_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="aniHome_Photos_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getAniHome_Photos_Id() {
		return this.aniHome_Photos_Id;
	}
	
	public void setAniHome_Photos_Id(String aniHome_Photos_Id) {
		this.aniHome_Photos_Id = aniHome_Photos_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "ANIHOME_ID")  //指定用來join table的column
	public AniHomeVO getAniHomeVO() {
		return this.aniHomeVO;
	}
	
	public void setAniHomeVO(AniHomeVO aniHomeVO) {
		this.aniHomeVO = aniHomeVO;
	}
	@Column(name = "ANIHOME_PHOTOS_PIC")
	public byte[] getAniHome_Photos_pic() {
		return this.aniHome_Photos_pic;
	}
	
	public void setAniHome_Photos_pic(byte[] aniHome_Photos_pic) {
		this.aniHome_Photos_pic = aniHome_Photos_pic;
	}
		
}

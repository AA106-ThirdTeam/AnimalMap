package heibernate_com.adopt_ani_photos.model;
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

import heibernate_com.adopt_ani.model.Adopt_AniVO;

import heibernate_com.mem.model.MemVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 送養動物相簿 
*	英文: adopt_Ani_photos  
* </pre>
*/   
@Entity
@Table(name = "ADOPT_ANI_PHOTOS")
public class Adopt_Ani_photosVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String ado_Ani_Pic_No;
	private Adopt_AniVO adopt_AniVO;
	private MemVO memVO;
	private byte[] ado_Ani_Pic;
	private String ado_Pic_name;
	private String ado_Pic_extent;
	private java.sql.Date ado_Pic_time;
	private String ado_Pic_type;


	public Adopt_Ani_photosVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "ADO_ANI_PIC_NO")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "adopt_Ani_photos_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="adopt_Ani_photos_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getAdo_Ani_Pic_No() {
		return this.ado_Ani_Pic_No;
	}
	
	public void setAdo_Ani_Pic_No(String ado_Ani_Pic_No) {
		this.ado_Ani_Pic_No = ado_Ani_Pic_No;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "ADOPT_ANI_ID")  //指定用來join table的column
	public Adopt_AniVO getAdopt_AniVO() {
		return this.adopt_AniVO;
	}
	
	public void setAdopt_AniVO(Adopt_AniVO adopt_AniVO) {
		this.adopt_AniVO = adopt_AniVO;
	}
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "ADO_ANI_PIC")
	public byte[] getAdo_Ani_Pic() {
		return this.ado_Ani_Pic;
	}
	
	public void setAdo_Ani_Pic(byte[] ado_Ani_Pic) {
		this.ado_Ani_Pic = ado_Ani_Pic;
	}
		
	@Column(name = "ADO_PIC_NAME")
	public String getAdo_Pic_name() {
		return this.ado_Pic_name;
	}
	
	public void setAdo_Pic_name(String ado_Pic_name) {
		this.ado_Pic_name = ado_Pic_name;
	}
		
	@Column(name = "ADO_PIC_EXTENT")
	public String getAdo_Pic_extent() {
		return this.ado_Pic_extent;
	}
	
	public void setAdo_Pic_extent(String ado_Pic_extent) {
		this.ado_Pic_extent = ado_Pic_extent;
	}
		
	@Column(name = "ADO_PIC_TIME")
	public java.sql.Date getAdo_Pic_time() {
		return this.ado_Pic_time;
	}
	
	public void setAdo_Pic_time(java.sql.Date ado_Pic_time) {
		this.ado_Pic_time = ado_Pic_time;
	}
		
	@Column(name = "ADO_PIC_TYPE")
	public String getAdo_Pic_type() {
		return this.ado_Pic_type;
	}
	
	public void setAdo_Pic_type(String ado_Pic_type) {
		this.ado_Pic_type = ado_Pic_type;
	}
		
}

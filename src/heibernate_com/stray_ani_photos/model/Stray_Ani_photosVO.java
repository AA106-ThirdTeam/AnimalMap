package heibernate_com.stray_ani_photos.model;
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

import heibernate_com.stray_ani.model.Stray_AniVO;

import heibernate_com.mem.model.MemVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 社區流浪動物相簿 
*	英文: stray_Ani_photos  
* </pre>
*/   
@Entity
@Table(name = "STRAY_ANI_PHOTOS")
public class Stray_Ani_photosVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String str_Ani_Pic_No;
	private Stray_AniVO stray_AniVO;
	private MemVO memVO;
	private byte[] stray_Ani_Pic;
	private String stray_Pic_name;
	private String stray_Pic_nameEX;
	private java.sql.Timestamp stray_Pic_time;
	private String stray_Pic_type;


	public Stray_Ani_photosVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "STR_ANI_PIC_NO")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "stray_Ani_photos_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="stray_Ani_photos_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getStr_Ani_Pic_No() {
		return this.str_Ani_Pic_No;
	}
	
	public void setStr_Ani_Pic_No(String str_Ani_Pic_No) {
		this.str_Ani_Pic_No = str_Ani_Pic_No;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "STRAY_ANI_ID")  //指定用來join table的column
	public Stray_AniVO getStray_AniVO() {
		return this.stray_AniVO;
	}
	
	public void setStray_AniVO(Stray_AniVO stray_AniVO) {
		this.stray_AniVO = stray_AniVO;
	}
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "STRAY_ANI_PIC")
	public byte[] getStray_Ani_Pic() {
		return this.stray_Ani_Pic;
	}
	
	public void setStray_Ani_Pic(byte[] stray_Ani_Pic) {
		this.stray_Ani_Pic = stray_Ani_Pic;
	}
		
	@Column(name = "STRAY_PIC_NAME")
	public String getStray_Pic_name() {
		return this.stray_Pic_name;
	}
	
	public void setStray_Pic_name(String stray_Pic_name) {
		this.stray_Pic_name = stray_Pic_name;
	}
		
	@Column(name = "STRAY_PIC_NAMEEX")
	public String getStray_Pic_nameEX() {
		return this.stray_Pic_nameEX;
	}
	
	public void setStray_Pic_nameEX(String stray_Pic_nameEX) {
		this.stray_Pic_nameEX = stray_Pic_nameEX;
	}
		
	@Column(name = "STRAY_PIC_TIME")
	public java.sql.Timestamp getStray_Pic_time() {
		return this.stray_Pic_time;
	}
	
	public void setStray_Pic_time(java.sql.Timestamp stray_Pic_time) {
		this.stray_Pic_time = stray_Pic_time;
	}
		
	@Column(name = "STRAY_PIC_TYPE")
	public String getStray_Pic_type() {
		return this.stray_Pic_type;
	}
	
	public void setStray_Pic_type(String stray_Pic_type) {
		this.stray_Pic_type = stray_Pic_type;
	}
		
}

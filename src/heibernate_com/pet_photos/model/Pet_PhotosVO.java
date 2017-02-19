package heibernate_com.pet_photos.model;
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

import heibernate_com.pet.model.PetVO;

import heibernate_com.mem.model.MemVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 自家寵物相簿 
*	英文: pet_Photos  
* </pre>
*/   
@Entity
@Table(name = "PET_PHOTOS")
public class Pet_PhotosVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String pet_Pic_No;
	private PetVO petVO;
	private MemVO memVO;
	private byte[] pet_Pic;
	private String pet_Pic_name;
	private String pet_Pic_extent;
	private java.sql.Date pet_Pic_time;
	private String pet_Pic_type;


	public Pet_PhotosVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "PET_PIC_NO")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "pet_Photos_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="pet_Photos_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getPet_Pic_No() {
		return this.pet_Pic_No;
	}
	
	public void setPet_Pic_No(String pet_Pic_No) {
		this.pet_Pic_No = pet_Pic_No;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "PET_ID")  //指定用來join table的column
	public PetVO getPetVO() {
		return this.petVO;
	}
	
	public void setPetVO(PetVO petVO) {
		this.petVO = petVO;
	}
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "PET_PIC")
	public byte[] getPet_Pic() {
		return this.pet_Pic;
	}
	
	public void setPet_Pic(byte[] pet_Pic) {
		this.pet_Pic = pet_Pic;
	}
		
	@Column(name = "PET_PIC_NAME")
	public String getPet_Pic_name() {
		return this.pet_Pic_name;
	}
	
	public void setPet_Pic_name(String pet_Pic_name) {
		this.pet_Pic_name = pet_Pic_name;
	}
		
	@Column(name = "PET_PIC_EXTENT")
	public String getPet_Pic_extent() {
		return this.pet_Pic_extent;
	}
	
	public void setPet_Pic_extent(String pet_Pic_extent) {
		this.pet_Pic_extent = pet_Pic_extent;
	}
		
	@Column(name = "PET_PIC_TIME")
	public java.sql.Date getPet_Pic_time() {
		return this.pet_Pic_time;
	}
	
	public void setPet_Pic_time(java.sql.Date pet_Pic_time) {
		this.pet_Pic_time = pet_Pic_time;
	}
		
	@Column(name = "PET_PIC_TYPE")
	public String getPet_Pic_type() {
		return this.pet_Pic_type;
	}
	
	public void setPet_Pic_type(String pet_Pic_type) {
		this.pet_Pic_type = pet_Pic_type;
	}
		
}

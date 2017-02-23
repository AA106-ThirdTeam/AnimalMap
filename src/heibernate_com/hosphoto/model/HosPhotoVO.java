package heibernate_com.hosphoto.model;
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

import heibernate_com.vet_hospital.model.Vet_hospitalVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 診所相片 
*	英文: hosPhoto  
* </pre>
*/   
@Entity
@Table(name = "HOSPHOTO")
public class HosPhotoVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String hosPhoto_Id;
	private Vet_hospitalVO vet_hospitalVO;
	private byte[] hosPhoto_photo;
	private String isDisp_HosPhoto;
	private String hosPhoto_name;
	private String hosPhoto_extent;


	public HosPhotoVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "HOSPHOTO_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "hosPhoto_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="hosPhoto_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getHosPhoto_Id() {
		return this.hosPhoto_Id;
	}
	
	public void setHosPhoto_Id(String hosPhoto_Id) {
		this.hosPhoto_Id = hosPhoto_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "HOSPHOTO_HOSID")  //指定用來join table的column
	public Vet_hospitalVO getVet_hospitalVO() {
		return this.vet_hospitalVO;
	}
	
	public void setVet_hospitalVO(Vet_hospitalVO vet_hospitalVO) {
		this.vet_hospitalVO = vet_hospitalVO;
	}
	@Column(name = "HOSPHOTO_PHOTO")
	public byte[] getHosPhoto_photo() {
		return this.hosPhoto_photo;
	}
	
	public void setHosPhoto_photo(byte[] hosPhoto_photo) {
		this.hosPhoto_photo = hosPhoto_photo;
	}
		
	@Column(name = "ISDISP_HOSPHOTO")
	public String getIsDisp_HosPhoto() {
		return this.isDisp_HosPhoto;
	}
	
	public void setIsDisp_HosPhoto(String isDisp_HosPhoto) {
		this.isDisp_HosPhoto = isDisp_HosPhoto;
	}
		
	@Column(name = "HOSPHOTO_NAME")
	public String getHosPhoto_name() {
		return this.hosPhoto_name;
	}
	
	public void setHosPhoto_name(String hosPhoto_name) {
		this.hosPhoto_name = hosPhoto_name;
	}
		
	@Column(name = "HOSPHOTO_EXTENT")
	public String getHosPhoto_extent() {
		return this.hosPhoto_extent;
	}
	
	public void setHosPhoto_extent(String hosPhoto_extent) {
		this.hosPhoto_extent = hosPhoto_extent;
	}
		
}

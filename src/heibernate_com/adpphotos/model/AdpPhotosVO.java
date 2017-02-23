package heibernate_com.adpphotos.model;
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

import heibernate_com.adp.model.AdpVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 領養活動相簿 
*	英文: adpPhotos  
* </pre>
*/   
@Entity
@Table(name = "ADPPHOTOS")
public class AdpPhotosVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String adpPhotos_Id;
	private AdpVO adpVO;
	private byte[] adpPhotosPic;


	public AdpPhotosVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "ADPPHOTOS_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "adpPhotos_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="adpPhotos_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getAdpPhotos_Id() {
		return this.adpPhotos_Id;
	}
	
	public void setAdpPhotos_Id(String adpPhotos_Id) {
		this.adpPhotos_Id = adpPhotos_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "ADP_ID")  //指定用來join table的column
	public AdpVO getAdpVO() {
		return this.adpVO;
	}
	
	public void setAdpVO(AdpVO adpVO) {
		this.adpVO = adpVO;
	}
	@Column(name = "ADPPHOTOSPIC")
	public byte[] getAdpPhotosPic() {
		return this.adpPhotosPic;
	}
	
	public void setAdpPhotosPic(byte[] adpPhotosPic) {
		this.adpPhotosPic = adpPhotosPic;
	}
		
}

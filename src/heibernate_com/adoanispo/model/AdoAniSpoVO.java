package heibernate_com.adoanispo.model;
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
*	中文: 送養動物領養人 
*	英文: adoAniSpo  
* </pre>
*/   
@Entity
@Table(name = "ADOANISPO")
public class AdoAniSpoVO implements java.io.Serializable{  
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adoAniSpoMat == null) ? 0 : adoAniSpoMat.hashCode());
		result = prime * result + ((adoAniSpoMoney == null) ? 0 : adoAniSpoMoney.hashCode());
		result = prime * result + ((adoAniSpoNo == null) ? 0 : adoAniSpoNo.hashCode());
		result = prime * result + ((adopt_AniVO == null) ? 0 : adopt_AniVO.hashCode());
		result = prime * result + ((memVO == null) ? 0 : memVO.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdoAniSpoVO other = (AdoAniSpoVO) obj;
		if (adoAniSpoMat == null) {
			if (other.adoAniSpoMat != null)
				return false;
		} else if (!adoAniSpoMat.equals(other.adoAniSpoMat))
			return false;
		if (adoAniSpoMoney == null) {
			if (other.adoAniSpoMoney != null)
				return false;
		} else if (!adoAniSpoMoney.equals(other.adoAniSpoMoney))
			return false;
		if (adoAniSpoNo == null) {
			if (other.adoAniSpoNo != null)
				return false;
		} else if (!adoAniSpoNo.equals(other.adoAniSpoNo))
			return false;
		if (adopt_AniVO == null) {
			if (other.adopt_AniVO != null)
				return false;
		} else if (!adopt_AniVO.equals(other.adopt_AniVO))
			return false;
		if (memVO == null) {
			if (other.memVO != null)
				return false;
		} else if (!memVO.equals(other.memVO))
			return false;
		return true;
	}

	private static final long serialVersionUID = 1L; ;
	private String adoAniSpoNo;
	private Adopt_AniVO adopt_AniVO;
	private MemVO memVO;
	private Integer adoAniSpoMoney;
	private String adoAniSpoMat;


	public AdoAniSpoVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "ADOANISPONO")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "adoAniSpo_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="adoAniSpo_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getAdoAniSpoNo() {
		return this.adoAniSpoNo;
	}
	
	public void setAdoAniSpoNo(String adoAniSpoNo) {
		this.adoAniSpoNo = adoAniSpoNo;
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
	@Column(name = "ADOANISPOMONEY")
	public Integer getAdoAniSpoMoney() {
		return this.adoAniSpoMoney;
	}
	
	public void setAdoAniSpoMoney(Integer adoAniSpoMoney) {
		this.adoAniSpoMoney = adoAniSpoMoney;
	}
		
	@Column(name = "ADOANISPOMAT")
	public String getAdoAniSpoMat() {
		return this.adoAniSpoMat;
	}
	
	public void setAdoAniSpoMat(String adoAniSpoMat) {
		this.adoAniSpoMat = adoAniSpoMat;
	}
		
}

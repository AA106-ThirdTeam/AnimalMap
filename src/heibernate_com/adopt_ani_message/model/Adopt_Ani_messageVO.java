package heibernate_com.adopt_ani_message.model;
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
*	中文: 送養動物留言 
*	英文: adopt_Ani_message  
* </pre>
*/   
@Entity
@Table(name = "ADOPT_ANI_MESSAGE")
public class Adopt_Ani_messageVO implements java.io.Serializable{  
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ado_Ani_Mes == null) ? 0 : ado_Ani_Mes.hashCode());
		result = prime * result + ((ado_Ani_Mes_No == null) ? 0 : ado_Ani_Mes_No.hashCode());
		result = prime * result + ((ado_Ani_Mes_time == null) ? 0 : ado_Ani_Mes_time.hashCode());
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
		Adopt_Ani_messageVO other = (Adopt_Ani_messageVO) obj;
		if (ado_Ani_Mes == null) {
			if (other.ado_Ani_Mes != null)
				return false;
		} else if (!ado_Ani_Mes.equals(other.ado_Ani_Mes))
			return false;
		if (ado_Ani_Mes_No == null) {
			if (other.ado_Ani_Mes_No != null)
				return false;
		} else if (!ado_Ani_Mes_No.equals(other.ado_Ani_Mes_No))
			return false;
		if (ado_Ani_Mes_time == null) {
			if (other.ado_Ani_Mes_time != null)
				return false;
		} else if (!ado_Ani_Mes_time.equals(other.ado_Ani_Mes_time))
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
	private String ado_Ani_Mes_No;
	private Adopt_AniVO adopt_AniVO;
	private MemVO memVO;
	private String ado_Ani_Mes;
	private java.sql.Timestamp ado_Ani_Mes_time;


	public Adopt_Ani_messageVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "ADO_ANI_MES_NO")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "adopt_Ani_message_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="adopt_Ani_message_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getAdo_Ani_Mes_No() {
		return this.ado_Ani_Mes_No;
	}
	
	public void setAdo_Ani_Mes_No(String ado_Ani_Mes_No) {
		this.ado_Ani_Mes_No = ado_Ani_Mes_No;
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
	@Column(name = "ADO_ANI_MES")
	public String getAdo_Ani_Mes() {
		return this.ado_Ani_Mes;
	}
	
	public void setAdo_Ani_Mes(String ado_Ani_Mes) {
		this.ado_Ani_Mes = ado_Ani_Mes;
	}
		
	@Column(name = "ADO_ANI_MES_TIME")
	public java.sql.Timestamp getAdo_Ani_Mes_time() {
		return this.ado_Ani_Mes_time;
	}
	
	public void setAdo_Ani_Mes_time(java.sql.Timestamp ado_Ani_Mes_time) {
		this.ado_Ani_Mes_time = ado_Ani_Mes_time;
	}
		
}

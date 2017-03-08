package heibernate_com.stray_ani.model;
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

import heibernate_com.mem.model.MemVO;

import heibernate_com.stray_ani_photos.model.Stray_Ani_photosVO;
import heibernate_com.stray_ani_message.model.Stray_Ani_messageVO;
import heibernate_com.stray_ani_loc.model.Stray_Ani_LocVO;


/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 社區流浪動物 
*	英文: stray_Ani  
* </pre>
*/   
@Entity
@Table(name = "STRAY_ANI")
public class Stray_AniVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memVO == null) ? 0 : memVO.hashCode());
		result = prime * result + ((stray_Ani_CreDate == null) ? 0 : stray_Ani_CreDate.hashCode());
		result = prime * result + ((stray_Ani_FinLat == null) ? 0 : stray_Ani_FinLat.hashCode());
		result = prime * result + ((stray_Ani_FinLon == null) ? 0 : stray_Ani_FinLon.hashCode());
		result = prime * result + ((stray_Ani_Id == null) ? 0 : stray_Ani_Id.hashCode());
		result = prime * result + ((stray_Ani_Locs == null) ? 0 : stray_Ani_Locs.hashCode());
		result = prime * result + ((stray_Ani_Neu == null) ? 0 : stray_Ani_Neu.hashCode());
		result = prime * result + ((stray_Ani_Vac == null) ? 0 : stray_Ani_Vac.hashCode());
		result = prime * result + ((stray_Ani_age == null) ? 0 : stray_Ani_age.hashCode());
		result = prime * result + ((stray_Ani_body == null) ? 0 : stray_Ani_body.hashCode());
		result = prime * result + ((stray_Ani_chip == null) ? 0 : stray_Ani_chip.hashCode());
		result = prime * result + ((stray_Ani_city == null) ? 0 : stray_Ani_city.hashCode());
		result = prime * result + ((stray_Ani_color == null) ? 0 : stray_Ani_color.hashCode());
		result = prime * result + ((stray_Ani_date == null) ? 0 : stray_Ani_date.hashCode());
		result = prime * result + ((stray_Ani_gender == null) ? 0 : stray_Ani_gender.hashCode());
		result = prime * result + ((stray_Ani_heal == null) ? 0 : stray_Ani_heal.hashCode());
		result = prime * result + ((stray_Ani_like == null) ? 0 : stray_Ani_like.hashCode());
		result = prime * result + ((stray_Ani_messages == null) ? 0 : stray_Ani_messages.hashCode());
		result = prime * result + ((stray_Ani_name == null) ? 0 : stray_Ani_name.hashCode());
		result = prime * result + ((stray_Ani_photoss == null) ? 0 : stray_Ani_photoss.hashCode());
		result = prime * result + ((stray_Ani_road == null) ? 0 : stray_Ani_road.hashCode());
		result = prime * result + ((stray_Ani_status == null) ? 0 : stray_Ani_status.hashCode());
		result = prime * result + ((stray_Ani_town == null) ? 0 : stray_Ani_town.hashCode());
		result = prime * result + ((stray_Ani_type == null) ? 0 : stray_Ani_type.hashCode());
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
		Stray_AniVO other = (Stray_AniVO) obj;
		if (memVO == null) {
			if (other.memVO != null)
				return false;
		} else if (!memVO.equals(other.memVO))
			return false;
		if (stray_Ani_CreDate == null) {
			if (other.stray_Ani_CreDate != null)
				return false;
		} else if (!stray_Ani_CreDate.equals(other.stray_Ani_CreDate))
			return false;
		if (stray_Ani_FinLat == null) {
			if (other.stray_Ani_FinLat != null)
				return false;
		} else if (!stray_Ani_FinLat.equals(other.stray_Ani_FinLat))
			return false;
		if (stray_Ani_FinLon == null) {
			if (other.stray_Ani_FinLon != null)
				return false;
		} else if (!stray_Ani_FinLon.equals(other.stray_Ani_FinLon))
			return false;
		if (stray_Ani_Id == null) {
			if (other.stray_Ani_Id != null)
				return false;
		} else if (!stray_Ani_Id.equals(other.stray_Ani_Id))
			return false;
		if (stray_Ani_Locs == null) {
			if (other.stray_Ani_Locs != null)
				return false;
		} else if (!stray_Ani_Locs.equals(other.stray_Ani_Locs))
			return false;
		if (stray_Ani_Neu == null) {
			if (other.stray_Ani_Neu != null)
				return false;
		} else if (!stray_Ani_Neu.equals(other.stray_Ani_Neu))
			return false;
		if (stray_Ani_Vac == null) {
			if (other.stray_Ani_Vac != null)
				return false;
		} else if (!stray_Ani_Vac.equals(other.stray_Ani_Vac))
			return false;
		if (stray_Ani_age == null) {
			if (other.stray_Ani_age != null)
				return false;
		} else if (!stray_Ani_age.equals(other.stray_Ani_age))
			return false;
		if (stray_Ani_body == null) {
			if (other.stray_Ani_body != null)
				return false;
		} else if (!stray_Ani_body.equals(other.stray_Ani_body))
			return false;
		if (stray_Ani_chip == null) {
			if (other.stray_Ani_chip != null)
				return false;
		} else if (!stray_Ani_chip.equals(other.stray_Ani_chip))
			return false;
		if (stray_Ani_city == null) {
			if (other.stray_Ani_city != null)
				return false;
		} else if (!stray_Ani_city.equals(other.stray_Ani_city))
			return false;
		if (stray_Ani_color == null) {
			if (other.stray_Ani_color != null)
				return false;
		} else if (!stray_Ani_color.equals(other.stray_Ani_color))
			return false;
		if (stray_Ani_date == null) {
			if (other.stray_Ani_date != null)
				return false;
		} else if (!stray_Ani_date.equals(other.stray_Ani_date))
			return false;
		if (stray_Ani_gender == null) {
			if (other.stray_Ani_gender != null)
				return false;
		} else if (!stray_Ani_gender.equals(other.stray_Ani_gender))
			return false;
		if (stray_Ani_heal == null) {
			if (other.stray_Ani_heal != null)
				return false;
		} else if (!stray_Ani_heal.equals(other.stray_Ani_heal))
			return false;
		if (stray_Ani_like == null) {
			if (other.stray_Ani_like != null)
				return false;
		} else if (!stray_Ani_like.equals(other.stray_Ani_like))
			return false;
		if (stray_Ani_messages == null) {
			if (other.stray_Ani_messages != null)
				return false;
		} else if (!stray_Ani_messages.equals(other.stray_Ani_messages))
			return false;
		if (stray_Ani_name == null) {
			if (other.stray_Ani_name != null)
				return false;
		} else if (!stray_Ani_name.equals(other.stray_Ani_name))
			return false;
		if (stray_Ani_photoss == null) {
			if (other.stray_Ani_photoss != null)
				return false;
		} else if (!stray_Ani_photoss.equals(other.stray_Ani_photoss))
			return false;
		if (stray_Ani_road == null) {
			if (other.stray_Ani_road != null)
				return false;
		} else if (!stray_Ani_road.equals(other.stray_Ani_road))
			return false;
		if (stray_Ani_status == null) {
			if (other.stray_Ani_status != null)
				return false;
		} else if (!stray_Ani_status.equals(other.stray_Ani_status))
			return false;
		if (stray_Ani_town == null) {
			if (other.stray_Ani_town != null)
				return false;
		} else if (!stray_Ani_town.equals(other.stray_Ani_town))
			return false;
		if (stray_Ani_type == null) {
			if (other.stray_Ani_type != null)
				return false;
		} else if (!stray_Ani_type.equals(other.stray_Ani_type))
			return false;
		return true;
	}

	private String stray_Ani_Id;
	private MemVO memVO;
	private String stray_Ani_name;
	private String stray_Ani_type;
	private String stray_Ani_gender;
	private String stray_Ani_heal;
	private String stray_Ani_Vac;
	private String stray_Ani_color;
	private String stray_Ani_body;
	private String stray_Ani_age;
	private String stray_Ani_Neu;
	private String stray_Ani_chip;
	private java.sql.Timestamp stray_Ani_date;
	private String stray_Ani_status;
	private java.sql.Timestamp stray_Ani_CreDate;
	private Double stray_Ani_FinLat;
	private Double stray_Ani_FinLon;
	private String stray_Ani_city;
	private String stray_Ani_town;
	private String stray_Ani_road;
	private Integer stray_Ani_like;

	private Set<Stray_Ani_photosVO> stray_Ani_photoss = new HashSet<Stray_Ani_photosVO>();
	private Set<Stray_Ani_messageVO> stray_Ani_messages = new HashSet<Stray_Ani_messageVO>();
	private Set<Stray_Ani_LocVO> stray_Ani_Locs = new HashSet<Stray_Ani_LocVO>();

	public Stray_AniVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "STRAY_ANI_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "stray_Ani_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="stray_Ani_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getStray_Ani_Id() {
		return this.stray_Ani_Id;
	}
	
	public void setStray_Ani_Id(String stray_Ani_Id) {
		this.stray_Ani_Id = stray_Ani_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "STRAY_ANI_NAME")
	public String getStray_Ani_name() {
		return this.stray_Ani_name;
	}
	
	public void setStray_Ani_name(String stray_Ani_name) {
		this.stray_Ani_name = stray_Ani_name;
	}
		
	@Column(name = "STRAY_ANI_TYPE")
	public String getStray_Ani_type() {
		return this.stray_Ani_type;
	}
	
	public void setStray_Ani_type(String stray_Ani_type) {
		this.stray_Ani_type = stray_Ani_type;
	}
		
	@Column(name = "STRAY_ANI_GENDER")
	public String getStray_Ani_gender() {
		return this.stray_Ani_gender;
	}
	
	public void setStray_Ani_gender(String stray_Ani_gender) {
		this.stray_Ani_gender = stray_Ani_gender;
	}
		
	@Column(name = "STRAY_ANI_HEAL")
	public String getStray_Ani_heal() {
		return this.stray_Ani_heal;
	}
	
	public void setStray_Ani_heal(String stray_Ani_heal) {
		this.stray_Ani_heal = stray_Ani_heal;
	}
		
	@Column(name = "STRAY_ANI_VAC")
	public String getStray_Ani_Vac() {
		return this.stray_Ani_Vac;
	}
	
	public void setStray_Ani_Vac(String stray_Ani_Vac) {
		this.stray_Ani_Vac = stray_Ani_Vac;
	}
		
	@Column(name = "STRAY_ANI_COLOR")
	public String getStray_Ani_color() {
		return this.stray_Ani_color;
	}
	
	public void setStray_Ani_color(String stray_Ani_color) {
		this.stray_Ani_color = stray_Ani_color;
	}
		
	@Column(name = "STRAY_ANI_BODY")
	public String getStray_Ani_body() {
		return this.stray_Ani_body;
	}
	
	public void setStray_Ani_body(String stray_Ani_body) {
		this.stray_Ani_body = stray_Ani_body;
	}
		
	@Column(name = "STRAY_ANI_AGE")
	public String getStray_Ani_age() {
		return this.stray_Ani_age;
	}
	
	public void setStray_Ani_age(String stray_Ani_age) {
		this.stray_Ani_age = stray_Ani_age;
	}
		
	@Column(name = "STRAY_ANI_NEU")
	public String getStray_Ani_Neu() {
		return this.stray_Ani_Neu;
	}
	
	public void setStray_Ani_Neu(String stray_Ani_Neu) {
		this.stray_Ani_Neu = stray_Ani_Neu;
	}
		
	@Column(name = "STRAY_ANI_CHIP")
	public String getStray_Ani_chip() {
		return this.stray_Ani_chip;
	}
	
	public void setStray_Ani_chip(String stray_Ani_chip) {
		this.stray_Ani_chip = stray_Ani_chip;
	}
		
	@Column(name = "STRAY_ANI_DATE")
	public java.sql.Timestamp getStray_Ani_date() {
		return this.stray_Ani_date;
	}
	
	public void setStray_Ani_date(java.sql.Timestamp stray_Ani_date) {
		this.stray_Ani_date = stray_Ani_date;
	}
		
	@Column(name = "STRAY_ANI_STATUS")
	public String getStray_Ani_status() {
		return this.stray_Ani_status;
	}
	
	public void setStray_Ani_status(String stray_Ani_status) {
		this.stray_Ani_status = stray_Ani_status;
	}
		
	@Column(name = "STRAY_ANI_CREDATE")
	public java.sql.Timestamp getStray_Ani_CreDate() {
		return this.stray_Ani_CreDate;
	}
	
	public void setStray_Ani_CreDate(java.sql.Timestamp stray_Ani_CreDate) {
		this.stray_Ani_CreDate = stray_Ani_CreDate;
	}
		
	@Column(name = "STRAY_ANI_FINLAT")
	public Double getStray_Ani_FinLat() {
		return this.stray_Ani_FinLat;
	}
	
	public void setStray_Ani_FinLat(Double stray_Ani_FinLat) {
		this.stray_Ani_FinLat = stray_Ani_FinLat;
	}
		
	@Column(name = "STRAY_ANI_FINLON")
	public Double getStray_Ani_FinLon() {
		return this.stray_Ani_FinLon;
	}
	
	public void setStray_Ani_FinLon(Double stray_Ani_FinLon) {
		this.stray_Ani_FinLon = stray_Ani_FinLon;
	}
		
	@Column(name = "STRAY_ANI_CITY")
	public String getStray_Ani_city() {
		return this.stray_Ani_city;
	}
	
	public void setStray_Ani_city(String stray_Ani_city) {
		this.stray_Ani_city = stray_Ani_city;
	}
		
	@Column(name = "STRAY_ANI_TOWN")
	public String getStray_Ani_town() {
		return this.stray_Ani_town;
	}
	
	public void setStray_Ani_town(String stray_Ani_town) {
		this.stray_Ani_town = stray_Ani_town;
	}
		
	@Column(name = "STRAY_ANI_ROAD")
	public String getStray_Ani_road() {
		return this.stray_Ani_road;
	}
	
	public void setStray_Ani_road(String stray_Ani_road) {
		this.stray_Ani_road = stray_Ani_road;
	}
		
	@Column(name = "STRAY_ANI_LIKE")
	public Integer getStray_Ani_like() {
		return this.stray_Ani_like;
	}
	
	public void setStray_Ani_like(Integer stray_Ani_like) {
		this.stray_Ani_like = stray_Ani_like;
	}
		
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="stray_AniVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="stray_AniVO")
	@OrderBy("stray_Ani_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Stray_Ani_photosVO> getStray_Ani_photoss() {
		return this.stray_Ani_photoss;
	}

	public void setStray_Ani_photoss(Set<Stray_Ani_photosVO> stray_ani_photoss) {
		this.stray_Ani_photoss = stray_ani_photoss;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="stray_AniVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="stray_AniVO")
	@OrderBy("stray_Ani_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Stray_Ani_messageVO> getStray_Ani_messages() {
		return this.stray_Ani_messages;
	}

	public void setStray_Ani_messages(Set<Stray_Ani_messageVO> stray_ani_messages) {
		this.stray_Ani_messages = stray_ani_messages;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="stray_AniVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="stray_AniVO")
	@OrderBy("stray_Ani_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Stray_Ani_LocVO> getStray_Ani_Locs() {
		return this.stray_Ani_Locs;
	}

	public void setStray_Ani_Locs(Set<Stray_Ani_LocVO> stray_ani_locs) {
		this.stray_Ani_Locs = stray_ani_locs;
	}
	
}

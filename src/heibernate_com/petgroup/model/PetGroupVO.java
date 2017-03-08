package heibernate_com.petgroup.model;
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

import heibernate_com.grp_comment.model.Grp_commentVO;
import heibernate_com.joinlist.model.JoinListVO;


/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 揪團 
*	英文: petGroup  
* </pre>
*/   
@Entity
@Table(name = "PETGROUP")
public class PetGroupVO implements java.io.Serializable{  
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(GRP_PHOTO);
		result = prime * result + ((GRP_TOWN == null) ? 0 : GRP_TOWN.hashCode());
		result = prime * result + ((JoinLists == null) ? 0 : JoinLists.hashCode());
		result = prime * result + ((grp_CreateTime == null) ? 0 : grp_CreateTime.hashCode());
		result = prime * result + ((grp_Desc == null) ? 0 : grp_Desc.hashCode());
		result = prime * result + ((grp_EndTime == null) ? 0 : grp_EndTime.hashCode());
		result = prime * result + ((grp_Id == null) ? 0 : grp_Id.hashCode());
		result = prime * result + ((grp_Lat == null) ? 0 : grp_Lat.hashCode());
		result = prime * result + ((grp_Long == null) ? 0 : grp_Long.hashCode());
		result = prime * result + ((grp_StartTime == null) ? 0 : grp_StartTime.hashCode());
		result = prime * result + ((grp_city == null) ? 0 : grp_city.hashCode());
		result = prime * result + ((grp_comments == null) ? 0 : grp_comments.hashCode());
		result = prime * result + ((grp_name == null) ? 0 : grp_name.hashCode());
		result = prime * result + ((grp_road == null) ? 0 : grp_road.hashCode());
		result = prime * result + ((grp_visible == null) ? 0 : grp_visible.hashCode());
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
		PetGroupVO other = (PetGroupVO) obj;
		if (!Arrays.equals(GRP_PHOTO, other.GRP_PHOTO))
			return false;
		if (GRP_TOWN == null) {
			if (other.GRP_TOWN != null)
				return false;
		} else if (!GRP_TOWN.equals(other.GRP_TOWN))
			return false;
		if (JoinLists == null) {
			if (other.JoinLists != null)
				return false;
		} else if (!JoinLists.equals(other.JoinLists))
			return false;
		if (grp_CreateTime == null) {
			if (other.grp_CreateTime != null)
				return false;
		} else if (!grp_CreateTime.equals(other.grp_CreateTime))
			return false;
		if (grp_Desc == null) {
			if (other.grp_Desc != null)
				return false;
		} else if (!grp_Desc.equals(other.grp_Desc))
			return false;
		if (grp_EndTime == null) {
			if (other.grp_EndTime != null)
				return false;
		} else if (!grp_EndTime.equals(other.grp_EndTime))
			return false;
		if (grp_Id == null) {
			if (other.grp_Id != null)
				return false;
		} else if (!grp_Id.equals(other.grp_Id))
			return false;
		if (grp_Lat == null) {
			if (other.grp_Lat != null)
				return false;
		} else if (!grp_Lat.equals(other.grp_Lat))
			return false;
		if (grp_Long == null) {
			if (other.grp_Long != null)
				return false;
		} else if (!grp_Long.equals(other.grp_Long))
			return false;
		if (grp_StartTime == null) {
			if (other.grp_StartTime != null)
				return false;
		} else if (!grp_StartTime.equals(other.grp_StartTime))
			return false;
		if (grp_city == null) {
			if (other.grp_city != null)
				return false;
		} else if (!grp_city.equals(other.grp_city))
			return false;
		if (grp_comments == null) {
			if (other.grp_comments != null)
				return false;
		} else if (!grp_comments.equals(other.grp_comments))
			return false;
		if (grp_name == null) {
			if (other.grp_name != null)
				return false;
		} else if (!grp_name.equals(other.grp_name))
			return false;
		if (grp_road == null) {
			if (other.grp_road != null)
				return false;
		} else if (!grp_road.equals(other.grp_road))
			return false;
		if (grp_visible == null) {
			if (other.grp_visible != null)
				return false;
		} else if (!grp_visible.equals(other.grp_visible))
			return false;
		if (memVO == null) {
			if (other.memVO != null)
				return false;
		} else if (!memVO.equals(other.memVO))
			return false;
		return true;
	}

	private static final long serialVersionUID = 1L; ;
	private String grp_Id;
	private MemVO memVO;
	private String grp_name;
	private String grp_city;
	private String GRP_TOWN;
	private String grp_road;
	private java.sql.Timestamp grp_EndTime;
	private java.sql.Timestamp grp_StartTime;
	private java.sql.Timestamp grp_CreateTime;
	private String grp_Desc;
	private Double grp_Long;
	private Double grp_Lat;
	private String grp_visible;
	private byte[] GRP_PHOTO;

	private Set<Grp_commentVO> grp_comments = new HashSet<Grp_commentVO>();
	private Set<JoinListVO> JoinLists = new HashSet<JoinListVO>();

	public PetGroupVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "GRP_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "petGroup_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="petGroup_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getGrp_Id() {
		return this.grp_Id;
	}
	
	public void setGrp_Id(String grp_Id) {
		this.grp_Id = grp_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "GRP_MEMID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "GRP_NAME")
	public String getGrp_name() {
		return this.grp_name;
	}
	
	public void setGrp_name(String grp_name) {
		this.grp_name = grp_name;
	}
		
	@Column(name = "GRP_CITY")
	public String getGrp_city() {
		return this.grp_city;
	}
	
	public void setGrp_city(String grp_city) {
		this.grp_city = grp_city;
	}
		
	@Column(name = "GRP_TOWN")
	public String getGRP_TOWN() {
		return this.GRP_TOWN;
	}
	
	public void setGRP_TOWN(String GRP_TOWN) {
		this.GRP_TOWN = GRP_TOWN;
	}
		
	@Column(name = "GRP_ROAD")
	public String getGrp_road() {
		return this.grp_road;
	}
	
	public void setGrp_road(String grp_road) {
		this.grp_road = grp_road;
	}
		
	@Column(name = "GRP_ENDTIME")
	public java.sql.Timestamp getGrp_EndTime() {
		return this.grp_EndTime;
	}
	
	public void setGrp_EndTime(java.sql.Timestamp grp_EndTime) {
		this.grp_EndTime = grp_EndTime;
	}
		
	@Column(name = "GRP_STARTTIME")
	public java.sql.Timestamp getGrp_StartTime() {
		return this.grp_StartTime;
	}
	
	public void setGrp_StartTime(java.sql.Timestamp grp_StartTime) {
		this.grp_StartTime = grp_StartTime;
	}
		
	@Column(name = "GRP_CREATETIME")
	public java.sql.Timestamp getGrp_CreateTime() {
		return this.grp_CreateTime;
	}
	
	public void setGrp_CreateTime(java.sql.Timestamp grp_CreateTime) {
		this.grp_CreateTime = grp_CreateTime;
	}
		
	@Column(name = "GRP_DESC")
	public String getGrp_Desc() {
		return this.grp_Desc;
	}
	
	public void setGrp_Desc(String grp_Desc) {
		this.grp_Desc = grp_Desc;
	}
		
	@Column(name = "GRP_LONG")
	public Double getGrp_Long() {
		return this.grp_Long;
	}
	
	public void setGrp_Long(Double grp_Long) {
		this.grp_Long = grp_Long;
	}
		
	@Column(name = "GRP_LAT")
	public Double getGrp_Lat() {
		return this.grp_Lat;
	}
	
	public void setGrp_Lat(Double grp_Lat) {
		this.grp_Lat = grp_Lat;
	}
		
	@Column(name = "GRP_VISIBLE")
	public String getGrp_visible() {
		return this.grp_visible;
	}
	
	public void setGrp_visible(String grp_visible) {
		this.grp_visible = grp_visible;
	}
		
	@Column(name = "GRP_PHOTO")
	public byte[] getGRP_PHOTO() {
		return this.GRP_PHOTO;
	}
	
	public void setGRP_PHOTO(byte[] GRP_PHOTO) {
		this.GRP_PHOTO = GRP_PHOTO;
	}
		
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="petGroupVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="petGroupVO")
	@OrderBy("grpComment_GrpId DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Grp_commentVO> getGrp_comments() {
		return this.grp_comments;
	}

	public void setGrp_comments(Set<Grp_commentVO> grp_comments) {
		this.grp_comments = grp_comments;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="petGroupVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="petGroupVO")
	@OrderBy("joinList_GrpId DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<JoinListVO> getJoinLists() {
		return this.JoinLists;
	}

	public void setJoinLists(Set<JoinListVO> joinlists) {
		this.JoinLists = joinlists;
	}
	
}

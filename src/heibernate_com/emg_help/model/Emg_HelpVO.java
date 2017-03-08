package heibernate_com.emg_help.model;
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

import heibernate_com.emg_h_msg.model.Emg_H_MsgVO;


/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 緊急求救 
*	英文: emg_Help  
* </pre>
*/   
@Entity
@Table(name = "EMG_HELP")
public class Emg_HelpVO implements java.io.Serializable{  
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emg_H_Id == null) ? 0 : emg_H_Id.hashCode());
		result = prime * result + ((emg_H_Lat == null) ? 0 : emg_H_Lat.hashCode());
		result = prime * result + ((emg_H_Lon == null) ? 0 : emg_H_Lon.hashCode());
		result = prime * result + ((emg_H_Msgs == null) ? 0 : emg_H_Msgs.hashCode());
		result = prime * result + Arrays.hashCode(emg_H_Pic);
		result = prime * result + ((emg_H_Pic_format == null) ? 0 : emg_H_Pic_format.hashCode());
		result = prime * result + ((emg_H_city == null) ? 0 : emg_H_city.hashCode());
		result = prime * result + ((emg_H_content == null) ? 0 : emg_H_content.hashCode());
		result = prime * result + ((emg_H_end_date == null) ? 0 : emg_H_end_date.hashCode());
		result = prime * result + ((emg_H_road == null) ? 0 : emg_H_road.hashCode());
		result = prime * result + ((emg_H_start_date == null) ? 0 : emg_H_start_date.hashCode());
		result = prime * result + ((emg_H_status == null) ? 0 : emg_H_status.hashCode());
		result = prime * result + ((emg_H_title == null) ? 0 : emg_H_title.hashCode());
		result = prime * result + ((emg_H_town == null) ? 0 : emg_H_town.hashCode());
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
		Emg_HelpVO other = (Emg_HelpVO) obj;
		if (emg_H_Id == null) {
			if (other.emg_H_Id != null)
				return false;
		} else if (!emg_H_Id.equals(other.emg_H_Id))
			return false;
		if (emg_H_Lat == null) {
			if (other.emg_H_Lat != null)
				return false;
		} else if (!emg_H_Lat.equals(other.emg_H_Lat))
			return false;
		if (emg_H_Lon == null) {
			if (other.emg_H_Lon != null)
				return false;
		} else if (!emg_H_Lon.equals(other.emg_H_Lon))
			return false;
		if (emg_H_Msgs == null) {
			if (other.emg_H_Msgs != null)
				return false;
		} else if (!emg_H_Msgs.equals(other.emg_H_Msgs))
			return false;
		if (!Arrays.equals(emg_H_Pic, other.emg_H_Pic))
			return false;
		if (emg_H_Pic_format == null) {
			if (other.emg_H_Pic_format != null)
				return false;
		} else if (!emg_H_Pic_format.equals(other.emg_H_Pic_format))
			return false;
		if (emg_H_city == null) {
			if (other.emg_H_city != null)
				return false;
		} else if (!emg_H_city.equals(other.emg_H_city))
			return false;
		if (emg_H_content == null) {
			if (other.emg_H_content != null)
				return false;
		} else if (!emg_H_content.equals(other.emg_H_content))
			return false;
		if (emg_H_end_date == null) {
			if (other.emg_H_end_date != null)
				return false;
		} else if (!emg_H_end_date.equals(other.emg_H_end_date))
			return false;
		if (emg_H_road == null) {
			if (other.emg_H_road != null)
				return false;
		} else if (!emg_H_road.equals(other.emg_H_road))
			return false;
		if (emg_H_start_date == null) {
			if (other.emg_H_start_date != null)
				return false;
		} else if (!emg_H_start_date.equals(other.emg_H_start_date))
			return false;
		if (emg_H_status == null) {
			if (other.emg_H_status != null)
				return false;
		} else if (!emg_H_status.equals(other.emg_H_status))
			return false;
		if (emg_H_title == null) {
			if (other.emg_H_title != null)
				return false;
		} else if (!emg_H_title.equals(other.emg_H_title))
			return false;
		if (emg_H_town == null) {
			if (other.emg_H_town != null)
				return false;
		} else if (!emg_H_town.equals(other.emg_H_town))
			return false;
		if (memVO == null) {
			if (other.memVO != null)
				return false;
		} else if (!memVO.equals(other.memVO))
			return false;
		return true;
	}

	private static final long serialVersionUID = 1L; ;
	private String emg_H_Id;
	private MemVO memVO;
	private java.sql.Timestamp emg_H_start_date;
	private java.sql.Timestamp emg_H_end_date;
	private String emg_H_title;
	private String emg_H_content;
	private byte[] emg_H_Pic;
	private String emg_H_Pic_format;
	private String emg_H_city;
	private String emg_H_town;
	private String emg_H_road;
	private Double emg_H_Lon;
	private Double emg_H_Lat;
	private String emg_H_status;

	private Set<Emg_H_MsgVO> emg_H_Msgs = new HashSet<Emg_H_MsgVO>();

	public Emg_HelpVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "EMG_H_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "emg_Help_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="emg_Help_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getEmg_H_Id() {
		return this.emg_H_Id;
	}
	
	public void setEmg_H_Id(String emg_H_Id) {
		this.emg_H_Id = emg_H_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "EMG_H_START_DATE")
	public java.sql.Timestamp getEmg_H_start_date() {
		return this.emg_H_start_date;
	}
	
	public void setEmg_H_start_date(java.sql.Timestamp emg_H_start_date) {
		this.emg_H_start_date = emg_H_start_date;
	}
		
	@Column(name = "EMG_H_END_DATE")
	public java.sql.Timestamp getEmg_H_end_date() {
		return this.emg_H_end_date;
	}
	
	public void setEmg_H_end_date(java.sql.Timestamp emg_H_end_date) {
		this.emg_H_end_date = emg_H_end_date;
	}
		
	@Column(name = "EMG_H_TITLE")
	public String getEmg_H_title() {
		return this.emg_H_title;
	}
	
	public void setEmg_H_title(String emg_H_title) {
		this.emg_H_title = emg_H_title;
	}
		
	@Column(name = "EMG_H_CONTENT")
	public String getEmg_H_content() {
		return this.emg_H_content;
	}
	
	public void setEmg_H_content(String emg_H_content) {
		this.emg_H_content = emg_H_content;
	}
		
	@Column(name = "EMG_H_PIC")
	public byte[] getEmg_H_Pic() {
		return this.emg_H_Pic;
	}
	
	public void setEmg_H_Pic(byte[] emg_H_Pic) {
		this.emg_H_Pic = emg_H_Pic;
	}
		
	@Column(name = "EMG_H_PIC_FORMAT")
	public String getEmg_H_Pic_format() {
		return this.emg_H_Pic_format;
	}
	
	public void setEmg_H_Pic_format(String emg_H_Pic_format) {
		this.emg_H_Pic_format = emg_H_Pic_format;
	}
		
	@Column(name = "EMG_H_CITY")
	public String getEmg_H_city() {
		return this.emg_H_city;
	}
	
	public void setEmg_H_city(String emg_H_city) {
		this.emg_H_city = emg_H_city;
	}
		
	@Column(name = "EMG_H_TOWN")
	public String getEmg_H_town() {
		return this.emg_H_town;
	}
	
	public void setEmg_H_town(String emg_H_town) {
		this.emg_H_town = emg_H_town;
	}
		
	@Column(name = "EMG_H_ROAD")
	public String getEmg_H_road() {
		return this.emg_H_road;
	}
	
	public void setEmg_H_road(String emg_H_road) {
		this.emg_H_road = emg_H_road;
	}
		
	@Column(name = "EMG_H_LON")
	public Double getEmg_H_Lon() {
		return this.emg_H_Lon;
	}
	
	public void setEmg_H_Lon(Double emg_H_Lon) {
		this.emg_H_Lon = emg_H_Lon;
	}
		
	@Column(name = "EMG_H_LAT")
	public Double getEmg_H_Lat() {
		return this.emg_H_Lat;
	}
	
	public void setEmg_H_Lat(Double emg_H_Lat) {
		this.emg_H_Lat = emg_H_Lat;
	}
		
	@Column(name = "EMG_H_STATUS")
	public String getEmg_H_status() {
		return this.emg_H_status;
	}
	
	public void setEmg_H_status(String emg_H_status) {
		this.emg_H_status = emg_H_status;
	}
		
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="emg_HelpVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="emg_HelpVO")
	@OrderBy("emg_H_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Emg_H_MsgVO> getEmg_H_Msgs() {
		return this.emg_H_Msgs;
	}

	public void setEmg_H_Msgs(Set<Emg_H_MsgVO> emg_h_msgs) {
		this.emg_H_Msgs = emg_h_msgs;
	}
	
}

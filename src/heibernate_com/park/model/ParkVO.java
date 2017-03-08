package heibernate_com.park.model;
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

import heibernate_com.emp.model.EmpVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 公園 
*	英文: park  
* </pre>
*/   
@Entity
@Table(name = "PARK")
public class ParkVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String park_Id;
	private EmpVO empVO;
	private String park_title;
	private String park_content;
	private String park_pic;
	private java.sql.Timestamp park_start_date;
	private java.sql.Timestamp park_upDate;
	private String park_city;
	private String park_town;
	private String park_road;
	private Double park_lon;
	private Double park_lat;


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empVO == null) ? 0 : empVO.hashCode());
		result = prime * result + ((park_Id == null) ? 0 : park_Id.hashCode());
		result = prime * result + ((park_city == null) ? 0 : park_city.hashCode());
		result = prime * result + ((park_content == null) ? 0 : park_content.hashCode());
		result = prime * result + ((park_lat == null) ? 0 : park_lat.hashCode());
		result = prime * result + ((park_lon == null) ? 0 : park_lon.hashCode());
		result = prime * result + ((park_pic == null) ? 0 : park_pic.hashCode());
		result = prime * result + ((park_road == null) ? 0 : park_road.hashCode());
		result = prime * result + ((park_start_date == null) ? 0 : park_start_date.hashCode());
		result = prime * result + ((park_title == null) ? 0 : park_title.hashCode());
		result = prime * result + ((park_town == null) ? 0 : park_town.hashCode());
		result = prime * result + ((park_upDate == null) ? 0 : park_upDate.hashCode());
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
		ParkVO other = (ParkVO) obj;
		if (empVO == null) {
			if (other.empVO != null)
				return false;
		} else if (!empVO.equals(other.empVO))
			return false;
		if (park_Id == null) {
			if (other.park_Id != null)
				return false;
		} else if (!park_Id.equals(other.park_Id))
			return false;
		if (park_city == null) {
			if (other.park_city != null)
				return false;
		} else if (!park_city.equals(other.park_city))
			return false;
		if (park_content == null) {
			if (other.park_content != null)
				return false;
		} else if (!park_content.equals(other.park_content))
			return false;
		if (park_lat == null) {
			if (other.park_lat != null)
				return false;
		} else if (!park_lat.equals(other.park_lat))
			return false;
		if (park_lon == null) {
			if (other.park_lon != null)
				return false;
		} else if (!park_lon.equals(other.park_lon))
			return false;
		if (park_pic == null) {
			if (other.park_pic != null)
				return false;
		} else if (!park_pic.equals(other.park_pic))
			return false;
		if (park_road == null) {
			if (other.park_road != null)
				return false;
		} else if (!park_road.equals(other.park_road))
			return false;
		if (park_start_date == null) {
			if (other.park_start_date != null)
				return false;
		} else if (!park_start_date.equals(other.park_start_date))
			return false;
		if (park_title == null) {
			if (other.park_title != null)
				return false;
		} else if (!park_title.equals(other.park_title))
			return false;
		if (park_town == null) {
			if (other.park_town != null)
				return false;
		} else if (!park_town.equals(other.park_town))
			return false;
		if (park_upDate == null) {
			if (other.park_upDate != null)
				return false;
		} else if (!park_upDate.equals(other.park_upDate))
			return false;
		return true;
	}

	public ParkVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "PARK_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "park_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="park_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getPark_Id() {
		return this.park_Id;
	}
	
	public void setPark_Id(String park_Id) {
		this.park_Id = park_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "EMP_NO")  //指定用來join table的column
	public EmpVO getEmpVO() {
		return this.empVO;
	}
	
	public void setEmpVO(EmpVO empVO) {
		this.empVO = empVO;
	}
	@Column(name = "PARK_TITLE")
	public String getPark_title() {
		return this.park_title;
	}
	
	public void setPark_title(String park_title) {
		this.park_title = park_title;
	}
		
	@Column(name = "PARK_CONTENT")
	public String getPark_content() {
		return this.park_content;
	}
	
	public void setPark_content(String park_content) {
		this.park_content = park_content;
	}
		
	@Column(name = "PARK_PIC")
	public String getPark_pic() {
		return this.park_pic;
	}
	
	public void setPark_pic(String park_pic) {
		this.park_pic = park_pic;
	}
		
	@Column(name = "PARK_START_DATE")
	public java.sql.Timestamp getPark_start_date() {
		return this.park_start_date;
	}
	
	public void setPark_start_date(java.sql.Timestamp park_start_date) {
		this.park_start_date = park_start_date;
	}
		
	@Column(name = "PARK_UPDATE")
	public java.sql.Timestamp getPark_upDate() {
		return this.park_upDate;
	}
	
	public void setPark_upDate(java.sql.Timestamp park_upDate) {
		this.park_upDate = park_upDate;
	}
		
	@Column(name = "PARK_CITY")
	public String getPark_city() {
		return this.park_city;
	}
	
	public void setPark_city(String park_city) {
		this.park_city = park_city;
	}
		
	@Column(name = "PARK_TOWN")
	public String getPark_town() {
		return this.park_town;
	}
	
	public void setPark_town(String park_town) {
		this.park_town = park_town;
	}
		
	@Column(name = "PARK_ROAD")
	public String getPark_road() {
		return this.park_road;
	}
	
	public void setPark_road(String park_road) {
		this.park_road = park_road;
	}
		
	@Column(name = "PARK_LON")
	public Double getPark_lon() {
		return this.park_lon;
	}
	
	public void setPark_lon(Double park_lon) {
		this.park_lon = park_lon;
	}
		
	@Column(name = "PARK_LAT")
	public Double getPark_lat() {
		return this.park_lat;
	}
	
	public void setPark_lat(Double park_lat) {
		this.park_lat = park_lat;
	}
		
}

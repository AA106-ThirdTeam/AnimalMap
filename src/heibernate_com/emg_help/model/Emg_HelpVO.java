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
	private static final long serialVersionUID = 1L; ;
	private String emg_H_Id;
	private MemVO memVO;
	private java.sql.Date emg_H_start_date;
	private java.sql.Date emg_H_end_date;
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
	public java.sql.Date getEmg_H_start_date() {
		return this.emg_H_start_date;
	}
	
	public void setEmg_H_start_date(java.sql.Date emg_H_start_date) {
		this.emg_H_start_date = emg_H_start_date;
	}
		
	@Column(name = "EMG_H_END_DATE")
	public java.sql.Date getEmg_H_end_date() {
		return this.emg_H_end_date;
	}
	
	public void setEmg_H_end_date(java.sql.Date emg_H_end_date) {
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
		
}

package heibernate_com.track.model;
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
*	中文: 追蹤收藏 
*	英文: track  
* </pre>
*/   
@Entity
@Table(name = "TRACK")
public class TrackVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String track_Id;
	private MemVO memVO;
	private String track_record_class;
	private String track_record_class_Id;


	public TrackVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "TRACK_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "track_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="track_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getTrack_Id() {
		return this.track_Id;
	}
	
	public void setTrack_Id(String track_Id) {
		this.track_Id = track_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "TRACK_RECORD_CLASS")
	public String getTrack_record_class() {
		return this.track_record_class;
	}
	
	public void setTrack_record_class(String track_record_class) {
		this.track_record_class = track_record_class;
	}
		
	@Column(name = "TRACK_RECORD_CLASS_ID")
	public String getTrack_record_class_Id() {
		return this.track_record_class_Id;
	}
	
	public void setTrack_record_class_Id(String track_record_class_Id) {
		this.track_record_class_Id = track_record_class_Id;
	}
		
}

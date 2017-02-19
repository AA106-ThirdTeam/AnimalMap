package heibernate_com.stray_ani_loc.model;
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

import heibernate_com.stray_ani.model.Stray_AniVO;

import heibernate_com.mem.model.MemVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 社區流浪動物出沒範圍 
*	英文: stray_Ani_Loc  
* </pre>
*/   
@Entity
@Table(name = "STRAY_ANI_LOC")
public class Stray_Ani_LocVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String str_Ani_Loc_No;
	private Stray_AniVO stray_AniVO;
	private MemVO memVO;
	private Double str_Ani_LocLat;
	private Double str_Ani_LocLon;


	public Stray_Ani_LocVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "STR_ANI_LOC_NO")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "stray_Ani_Loc_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="stray_Ani_Loc_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getStr_Ani_Loc_No() {
		return this.str_Ani_Loc_No;
	}
	
	public void setStr_Ani_Loc_No(String str_Ani_Loc_No) {
		this.str_Ani_Loc_No = str_Ani_Loc_No;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "STRAY_ANI_ID")  //指定用來join table的column
	public Stray_AniVO getStray_AniVO() {
		return this.stray_AniVO;
	}
	
	public void setStray_AniVO(Stray_AniVO stray_AniVO) {
		this.stray_AniVO = stray_AniVO;
	}
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Column(name = "STR_ANI_LOCLAT")
	public Double getStr_Ani_LocLat() {
		return this.str_Ani_LocLat;
	}
	
	public void setStr_Ani_LocLat(Double str_Ani_LocLat) {
		this.str_Ani_LocLat = str_Ani_LocLat;
	}
		
	@Column(name = "STR_ANI_LOCLON")
	public Double getStr_Ani_LocLon() {
		return this.str_Ani_LocLon;
	}
	
	public void setStr_Ani_LocLon(Double str_Ani_LocLon) {
		this.str_Ani_LocLon = str_Ani_LocLon;
	}
		
}

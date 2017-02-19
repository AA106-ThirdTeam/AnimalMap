package heibernate_com.emg_h_msg.model;
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

import heibernate_com.emg_h.model.Emg_HVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 緊急求救留言 
*	英文: emg_H_Msg  
* </pre>
*/   
@Entity
@Table(name = "EMG_H_MSG")
public class Emg_H_MsgVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String emg_H_Msg_Id;
	private MemVO memVO;
	private Emg_HVO emg_HVO;
	private java.sql.Date emg_H_Msg_start;
	private String emg_H_Msg_content;


	public Emg_H_MsgVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "EMG_H_MSG_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "emg_H_Msg_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="emg_H_Msg_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getEmg_H_Msg_Id() {
		return this.emg_H_Msg_Id;
	}
	
	public void setEmg_H_Msg_Id(String emg_H_Msg_Id) {
		this.emg_H_Msg_Id = emg_H_Msg_Id;
	}	
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "EMG_H_ID")  //指定用來join table的column
	public Emg_HVO getEmg_HVO() {
		return this.emg_HVO;
	}
	
	public void setEmg_HVO(Emg_HVO emg_HVO) {
		this.emg_HVO = emg_HVO;
	}
	@Column(name = "EMG_H_MSG_START")
	public java.sql.Date getEmg_H_Msg_start() {
		return this.emg_H_Msg_start;
	}
	
	public void setEmg_H_Msg_start(java.sql.Date emg_H_Msg_start) {
		this.emg_H_Msg_start = emg_H_Msg_start;
	}
		
	@Column(name = "EMG_H_MSG_CONTENT")
	public String getEmg_H_Msg_content() {
		return this.emg_H_Msg_content;
	}
	
	public void setEmg_H_Msg_content(String emg_H_Msg_content) {
		this.emg_H_Msg_content = emg_H_Msg_content;
	}
		
}

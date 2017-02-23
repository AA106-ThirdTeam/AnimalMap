package heibernate_com.report.model;
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



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 檢舉 
*	英文: report  
* </pre>
*/   
@Entity
@Table(name = "REPORT")
public class ReportVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String report_No;
	private String report_name;
	private String report_class;
	private String report_class_No;
	private String report_class_No_value;
	private String report_content;
	private String report_status;
	private String mem_Id_active;
	private String mem_Id_passive;
	private java.sql.Date report_time;
	private String report_class_status;


	public ReportVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "REPORT_NO")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "report_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="report_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getReport_No() {
		return this.report_No;
	}
	
	public void setReport_No(String report_No) {
		this.report_No = report_No;
	}	
	@Column(name = "REPORT_NAME")
	public String getReport_name() {
		return this.report_name;
	}
	
	public void setReport_name(String report_name) {
		this.report_name = report_name;
	}
		
	@Column(name = "REPORT_CLASS")
	public String getReport_class() {
		return this.report_class;
	}
	
	public void setReport_class(String report_class) {
		this.report_class = report_class;
	}
		
	@Column(name = "REPORT_CLASS_NO")
	public String getReport_class_No() {
		return this.report_class_No;
	}
	
	public void setReport_class_No(String report_class_No) {
		this.report_class_No = report_class_No;
	}
		
	@Column(name = "REPORT_CLASS_NO_VALUE")
	public String getReport_class_No_value() {
		return this.report_class_No_value;
	}
	
	public void setReport_class_No_value(String report_class_No_value) {
		this.report_class_No_value = report_class_No_value;
	}
		
	@Column(name = "REPORT_CONTENT")
	public String getReport_content() {
		return this.report_content;
	}
	
	public void setReport_content(String report_content) {
		this.report_content = report_content;
	}
		
	@Column(name = "REPORT_STATUS")
	public String getReport_status() {
		return this.report_status;
	}
	
	public void setReport_status(String report_status) {
		this.report_status = report_status;
	}
		
	@Column(name = "MEM_ID_ACTIVE")
	public String getMem_Id_active() {
		return this.mem_Id_active;
	}
	
	public void setMem_Id_active(String mem_Id_active) {
		this.mem_Id_active = mem_Id_active;
	}
		
	@Column(name = "MEM_ID_PASSIVE")
	public String getMem_Id_passive() {
		return this.mem_Id_passive;
	}
	
	public void setMem_Id_passive(String mem_Id_passive) {
		this.mem_Id_passive = mem_Id_passive;
	}
		
	@Column(name = "REPORT_TIME")
	public java.sql.Date getReport_time() {
		return this.report_time;
	}
	
	public void setReport_time(java.sql.Date report_time) {
		this.report_time = report_time;
	}
		
	@Column(name = "REPORT_CLASS_STATUS")
	public String getReport_class_status() {
		return this.report_class_status;
	}
	
	public void setReport_class_status(String report_class_status) {
		this.report_class_status = report_class_status;
	}
		
}

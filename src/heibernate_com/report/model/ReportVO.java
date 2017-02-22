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
		
}

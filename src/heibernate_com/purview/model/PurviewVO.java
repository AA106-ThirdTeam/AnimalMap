package heibernate_com.purview.model;
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

import heibernate_com.emp_purview.model.Emp_purviewVO;


/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 權限 
*	英文: purview  
* </pre>
*/   
@Entity
@Table(name = "PURVIEW")
public class PurviewVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String purview_No;
	private String purview_name;

	private Set<Emp_purviewVO> emp_purviews = new HashSet<Emp_purviewVO>();

	public PurviewVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "PURVIEW_NO")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "purview_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="purview_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getPurview_No() {
		return this.purview_No;
	}
	
	public void setPurview_No(String purview_No) {
		this.purview_No = purview_No;
	}	
	@Column(name = "PURVIEW_NAME")
	public String getPurview_name() {
		return this.purview_name;
	}
	
	public void setPurview_name(String purview_name) {
		this.purview_name = purview_name;
	}
		
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="purviewVO")
	@OrderBy("purview_No asc")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Emp_purviewVO> getEmp_purviews() {
		return this.emp_purviews;
	}

	public void setEmp_purviews(Set<Emp_purviewVO> emp_purviews) {
		this.emp_purviews = emp_purviews;
	}
	
}

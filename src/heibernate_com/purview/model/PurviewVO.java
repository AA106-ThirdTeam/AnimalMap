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
	private String pruview_name;


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
	@Column(name = "PRUVIEW_NAME")
	public String getPruview_name() {
		return this.pruview_name;
	}
	
	public void setPruview_name(String pruview_name) {
		this.pruview_name = pruview_name;
	}
		
}

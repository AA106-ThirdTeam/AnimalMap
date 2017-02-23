package heibernate_com.animal_index.model;
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
*	中文: 動物圖鑑 
*	英文: animal_index  
* </pre>
*/   
@Entity
@Table(name = "ANIMAL_INDEX")
public class Animal_indexVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String animal_No;
	private String animal_detail;
	private String animal_class;
	private String animal_class_No;


	public Animal_indexVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "ANIMAL_NO")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "animal_index_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="animal_index_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getAnimal_No() {
		return this.animal_No;
	}
	
	public void setAnimal_No(String animal_No) {
		this.animal_No = animal_No;
	}	
	@Column(name = "ANIMAL_DETAIL")
	public String getAnimal_detail() {
		return this.animal_detail;
	}
	
	public void setAnimal_detail(String animal_detail) {
		this.animal_detail = animal_detail;
	}
		
	@Column(name = "ANIMAL_CLASS")
	public String getAnimal_class() {
		return this.animal_class;
	}
	
	public void setAnimal_class(String animal_class) {
		this.animal_class = animal_class;
	}
		
	@Column(name = "ANIMAL_CLASS_NO")
	public String getAnimal_class_No() {
		return this.animal_class_No;
	}
	
	public void setAnimal_class_No(String animal_class_No) {
		this.animal_class_No = animal_class_No;
	}
		
}

package heibernate_com.emp_purview.model;
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

import heibernate_com.purview.model.PurviewVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 員工權限 
*	英文: emp_purview  
* </pre>
*/   
@Entity
@Table(name = "EMP_PURVIEW")
public class Emp_purviewVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private EmpVO empVO;
	private PurviewVO purviewVO;


	public Emp_purviewVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "EMP_NO")  //指定用來join table的column
	public EmpVO getEmpVO() {
		return this.empVO;
	}
	
	public void setEmpVO(EmpVO empVO) {
		this.empVO = empVO;
	}
	@Id
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "PURVIEW_NO")  //指定用來join table的column
	public PurviewVO getPurviewVO() {
		return this.purviewVO;
	}
	
	public void setPurviewVO(PurviewVO purviewVO) {
		this.purviewVO = purviewVO;
	}
}

package heibernate_com.joinlist.model;
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

import heibernate_com.pet_group.model.Pet_groupVO;

import heibernate_com.mem.model.MemVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 揪團參加名單 
*	英文: JoinList  
* </pre>
*/   
@Entity
@Table(name = "JOINLIST")
public class JoinListVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private Pet_groupVO pet_groupVO;
	private MemVO memVO;


	public JoinListVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "GRP_ID")  //指定用來join table的column
	public Pet_groupVO getPet_groupVO() {
		return this.pet_groupVO;
	}
	
	public void setPet_groupVO(Pet_groupVO pet_groupVO) {
		this.pet_groupVO = pet_groupVO;
	}
	@Id
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
}

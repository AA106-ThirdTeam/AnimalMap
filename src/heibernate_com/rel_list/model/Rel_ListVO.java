package heibernate_com.rel_list.model;
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

import heibernate_com.mem.model.MemVO;



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 關係名單 
*	英文: rel_List  
* </pre>
*/   
@Entity
@Table(name = "REL_LIST")
public class Rel_ListVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private MemVO memVO;
	private MemVO memVO_2;
	private String isBlackList;
	private String isInvited;


	public Rel_ListVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO() {
		return this.memVO;
	}
	
	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}
	@Id
	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "MEM_ID")  //指定用來join table的column
	public MemVO getMemVO_2() {
		return this.memVO_2;
	}
	
	public void setMemVO_2(MemVO memVO_2) {
		this.memVO = memVO_2;
	}
	@Column(name = "ISBLACKLIST")
	public String getIsBlackList() {
		return this.isBlackList;
	}
	
	public void setIsBlackList(String isBlackList) {
		this.isBlackList = isBlackList;
	}
		
	@Column(name = "ISINVITED")
	public String getIsInvited() {
		return this.isInvited;
	}
	
	public void setIsInvited(String isInvited) {
		this.isInvited = isInvited;
	}
		
}

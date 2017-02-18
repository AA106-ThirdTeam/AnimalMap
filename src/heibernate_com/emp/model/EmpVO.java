package heibernate_com.emp.model;
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



/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 員工 
*	英文: emp  
* </pre>
*/   
@Entity
@Table(name = "EMP")
public class EmpVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private Integer emp_No;
	private String emp_name;
	private String emp_Pw;
	private String emp_email;
	private String emp_Id;
	private java.sql.Date emp_birthday;
	private String emp_phone;
	private String emp_address;
	private String emp_status;
	private byte[] emp_picture;
	private String emp_Pic_format;
	private java.sql.Date emp_hiredate;
	private java.sql.Date emp_firedate;


	public EmpVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "EMP_NO")
	@SequenceGenerator(name="xxx", sequenceName="emp_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="xxx")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public Integer getEmp_No() {
		return this.emp_No;
	}
	
	public void setEmp_No(Integer emp_No) {
		this.emp_No = emp_No;
	}	
	@Column(name = "EMP_NAME")
	public String getEmp_name() {
		return this.emp_name;
	}
	
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
		
	@Column(name = "EMP_PW")
	public String getEmp_Pw() {
		return this.emp_Pw;
	}
	
	public void setEmp_Pw(String emp_Pw) {
		this.emp_Pw = emp_Pw;
	}
		
	@Column(name = "EMP_EMAIL")
	public String getEmp_email() {
		return this.emp_email;
	}
	
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
		
	@Column(name = "EMP_ID")
	public String getEmp_Id() {
		return this.emp_Id;
	}
	
	public void setEmp_Id(String emp_Id) {
		this.emp_Id = emp_Id;
	}
		
	@Column(name = "EMP_BIRTHDAY")
	public java.sql.Date getEmp_birthday() {
		return this.emp_birthday;
	}
	
	public void setEmp_birthday(java.sql.Date emp_birthday) {
		this.emp_birthday = emp_birthday;
	}
		
	@Column(name = "EMP_PHONE")
	public String getEmp_phone() {
		return this.emp_phone;
	}
	
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
		
	@Column(name = "EMP_ADDRESS")
	public String getEmp_address() {
		return this.emp_address;
	}
	
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
		
	@Column(name = "EMP_STATUS")
	public String getEmp_status() {
		return this.emp_status;
	}
	
	public void setEmp_status(String emp_status) {
		this.emp_status = emp_status;
	}
		
	@Column(name = "EMP_PICTURE")
	public byte[] getEmp_picture() {
		return this.emp_picture;
	}
	
	public void setEmp_picture(byte[] emp_picture) {
		this.emp_picture = emp_picture;
	}
		
	@Column(name = "EMP_PIC_FORMAT")
	public String getEmp_Pic_format() {
		return this.emp_Pic_format;
	}
	
	public void setEmp_Pic_format(String emp_Pic_format) {
		this.emp_Pic_format = emp_Pic_format;
	}
		
	@Column(name = "EMP_HIREDATE")
	public java.sql.Date getEmp_hiredate() {
		return this.emp_hiredate;
	}
	
	public void setEmp_hiredate(java.sql.Date emp_hiredate) {
		this.emp_hiredate = emp_hiredate;
	}
		
	@Column(name = "EMP_FIREDATE")
	public java.sql.Date getEmp_firedate() {
		return this.emp_firedate;
	}
	
	public void setEmp_firedate(java.sql.Date emp_firedate) {
		this.emp_firedate = emp_firedate;
	}
		
}

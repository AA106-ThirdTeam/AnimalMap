package heibernate_com.mem.model;
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

import heibernate_com.charge.model.ChargeVO;
import heibernate_com.second_prodmsg.model.Second_ProdMsgVO;
import heibernate_com.second_prod.model.Second_ProdVO;
import heibernate_com.orders.model.OrdersVO;
import heibernate_com.emg_h_msg.model.Emg_H_MsgVO;
import heibernate_com.emg_help.model.Emg_HelpVO;
import heibernate_com.report.model.ReportVO;
import heibernate_com.report.model.ReportVO;
import heibernate_com.rel_list.model.Rel_ListVO;
import heibernate_com.rel_list.model.Rel_ListVO;
import heibernate_com.priv_message.model.Priv_messageVO;
import heibernate_com.priv_message.model.Priv_messageVO;
import heibernate_com.shop_comment.model.Shop_commentVO;
import heibernate_com.petshop.model.PetShopVO;
import heibernate_com.grp_comment.model.Grp_commentVO;
import heibernate_com.joinlist.model.JoinListVO;
import heibernate_com.petgroup.model.PetGroupVO;
import heibernate_com.hos_comment.model.Hos_commentVO;
import heibernate_com.vet_hospital.model.Vet_hospitalVO;
import heibernate_com.stray_ani_photos.model.Stray_Ani_photosVO;
import heibernate_com.stray_ani_message.model.Stray_Ani_messageVO;
import heibernate_com.stray_ani_loc.model.Stray_Ani_LocVO;
import heibernate_com.stray_ani.model.Stray_AniVO;
import heibernate_com.pet_photos.model.Pet_PhotosVO;
import heibernate_com.pet_message.model.Pet_MessageVO;
import heibernate_com.pet.model.PetVO;
import heibernate_com.adopt_ani_photos.model.Adopt_Ani_photosVO;
import heibernate_com.adopt_ani_message.model.Adopt_Ani_messageVO;
import heibernate_com.adopt_ani_sponsor.model.Adopt_Ani_sponsorVO;
import heibernate_com.adoanispo.model.AdoAniSpoVO;
import heibernate_com.adopt_ani.model.Adopt_AniVO;
import heibernate_com.post_response.model.Post_ResponseVO;
import heibernate_com.post.model.PostVO;
import heibernate_com.track.model.TrackVO;
import heibernate_com.adpmsg.model.AdpMsgVO;
import heibernate_com.adp.model.AdpVO;
import heibernate_com.anihome_msg.model.AniHome_MsgVO;
import heibernate_com.anihome.model.AniHomeVO;


/** 
* @TableDeclaration 類別說明:
* <pre>
* 表格名稱 : 
*	中文: 一般會員 
*	英文: mem  
* </pre>
*/   
@Entity
@Table(name = "MEM")
public class MemVO implements java.io.Serializable{  
	private static final long serialVersionUID = 1L; ;
	private String mem_Id;
	private String mem_account;
	private String mem_email;
	private String mem_Psw;
	private String mem_nick_name;
	private String mem_name;
	private String mem_gender;
	private String mem_Tw_Id;
	private java.sql.Timestamp mem_birth_date;
	private String mem_phone;
	private String mem_Intro;
	private String mem_profile;
	private String mem_black_list;
	private String mem_permission;
	private String mem_setting;
	private Integer mem_balance;

	private Set<ChargeVO> charges = new HashSet<ChargeVO>();
	private Set<Second_ProdMsgVO> second_ProdMsgs = new HashSet<Second_ProdMsgVO>();
	private Set<Second_ProdVO> second_Prods = new HashSet<Second_ProdVO>();
	private Set<OrdersVO> orderss = new HashSet<OrdersVO>();
	private Set<Emg_H_MsgVO> emg_H_Msgs = new HashSet<Emg_H_MsgVO>();
	private Set<Emg_HelpVO> emg_Helps = new HashSet<Emg_HelpVO>();
	private Set<ReportVO> reports = new HashSet<ReportVO>();
	private Set<ReportVO> reports_2 = new HashSet<ReportVO>();
	private Set<Rel_ListVO> rel_Lists = new HashSet<Rel_ListVO>();
	private Set<Rel_ListVO> rel_Lists_2 = new HashSet<Rel_ListVO>();
	private Set<Priv_messageVO> priv_messages = new HashSet<Priv_messageVO>();
	private Set<Priv_messageVO> priv_messages_2 = new HashSet<Priv_messageVO>();
	private Set<Shop_commentVO> shop_comments = new HashSet<Shop_commentVO>();
	private Set<PetShopVO> petShops = new HashSet<PetShopVO>();
	private Set<Grp_commentVO> grp_comments = new HashSet<Grp_commentVO>();
	private Set<JoinListVO> JoinLists = new HashSet<JoinListVO>();
	private Set<PetGroupVO> petGroups = new HashSet<PetGroupVO>();
	private Set<Hos_commentVO> hos_comments = new HashSet<Hos_commentVO>();
	private Set<Vet_hospitalVO> vet_hospitals = new HashSet<Vet_hospitalVO>();
	private Set<Stray_Ani_photosVO> stray_Ani_photoss = new HashSet<Stray_Ani_photosVO>();
	private Set<Stray_Ani_messageVO> stray_Ani_messages = new HashSet<Stray_Ani_messageVO>();
	private Set<Stray_Ani_LocVO> stray_Ani_Locs = new HashSet<Stray_Ani_LocVO>();
	private Set<Stray_AniVO> stray_Anis = new HashSet<Stray_AniVO>();
	private Set<Pet_PhotosVO> pet_Photoss = new HashSet<Pet_PhotosVO>();
	private Set<Pet_MessageVO> pet_Messages = new HashSet<Pet_MessageVO>();
	private Set<PetVO> pets = new HashSet<PetVO>();
	private Set<Adopt_Ani_photosVO> adopt_Ani_photoss = new HashSet<Adopt_Ani_photosVO>();
	private Set<Adopt_Ani_messageVO> adopt_Ani_messages = new HashSet<Adopt_Ani_messageVO>();
	private Set<Adopt_Ani_sponsorVO> adopt_Ani_sponsors = new HashSet<Adopt_Ani_sponsorVO>();
	private Set<AdoAniSpoVO> adoAniSpos = new HashSet<AdoAniSpoVO>();
	private Set<Adopt_AniVO> adopt_Anis = new HashSet<Adopt_AniVO>();
	private Set<Post_ResponseVO> post_Responses = new HashSet<Post_ResponseVO>();
	private Set<PostVO> posts = new HashSet<PostVO>();
	private Set<TrackVO> tracks = new HashSet<TrackVO>();
	private Set<AdpMsgVO> adpMsgs = new HashSet<AdpMsgVO>();
	private Set<AdpVO> adps = new HashSet<AdpVO>();
	private Set<AniHome_MsgVO> aniHome_Msgs = new HashSet<AniHome_MsgVO>();
	private Set<AniHomeVO> aniHomes = new HashSet<AniHomeVO>();

	public MemVO() {} //必需有一個不傳參數建構子(JavaBean基本知識)
	
	@Id
	@Column(name = "MEM_ID")
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "mem_seq1") })
	//@SequenceGenerator(name="xxx", sequenceName="mem_seq1", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STRING_SEQUENCE_GENERATOR")       //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public String getMem_Id() {
		return this.mem_Id;
	}
	
	public void setMem_Id(String mem_Id) {
		this.mem_Id = mem_Id;
	}	
	@Column(name = "MEM_ACCOUNT")
	public String getMem_account() {
		return this.mem_account;
	}
	
	public void setMem_account(String mem_account) {
		this.mem_account = mem_account;
	}
		
	@Column(name = "MEM_EMAIL")
	public String getMem_email() {
		return this.mem_email;
	}
	
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
		
	@Column(name = "MEM_PSW")
	public String getMem_Psw() {
		return this.mem_Psw;
	}
	
	public void setMem_Psw(String mem_Psw) {
		this.mem_Psw = mem_Psw;
	}
		
	@Column(name = "MEM_NICK_NAME")
	public String getMem_nick_name() {
		return this.mem_nick_name;
	}
	
	public void setMem_nick_name(String mem_nick_name) {
		this.mem_nick_name = mem_nick_name;
	}
		
	@Column(name = "MEM_NAME")
	public String getMem_name() {
		return this.mem_name;
	}
	
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
		
	@Column(name = "MEM_GENDER")
	public String getMem_gender() {
		return this.mem_gender;
	}
	
	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}
		
	@Column(name = "MEM_TW_ID")
	public String getMem_Tw_Id() {
		return this.mem_Tw_Id;
	}
	
	public void setMem_Tw_Id(String mem_Tw_Id) {
		this.mem_Tw_Id = mem_Tw_Id;
	}
		
	@Column(name = "MEM_BIRTH_DATE")
	public java.sql.Timestamp getMem_birth_date() {
		return this.mem_birth_date;
	}
	
	public void setMem_birth_date(java.sql.Timestamp mem_birth_date) {
		this.mem_birth_date = mem_birth_date;
	}
		
	@Column(name = "MEM_PHONE")
	public String getMem_phone() {
		return this.mem_phone;
	}
	
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
		
	@Column(name = "MEM_INTRO")
	public String getMem_Intro() {
		return this.mem_Intro;
	}
	
	public void setMem_Intro(String mem_Intro) {
		this.mem_Intro = mem_Intro;
	}
		
	@Column(name = "MEM_PROFILE")
	public String getMem_profile() {
		return this.mem_profile;
	}
	
	public void setMem_profile(String mem_profile) {
		this.mem_profile = mem_profile;
	}
		
	@Column(name = "MEM_BLACK_LIST")
	public String getMem_black_list() {
		return this.mem_black_list;
	}
	
	public void setMem_black_list(String mem_black_list) {
		this.mem_black_list = mem_black_list;
	}
		
	@Column(name = "MEM_PERMISSION")
	public String getMem_permission() {
		return this.mem_permission;
	}
	
	public void setMem_permission(String mem_permission) {
		this.mem_permission = mem_permission;
	}
		
	@Column(name = "MEM_SETTING")
	public String getMem_setting() {
		return this.mem_setting;
	}
	
	public void setMem_setting(String mem_setting) {
		this.mem_setting = mem_setting;
	}
		
	@Column(name = "MEM_BALANCE")
	public Integer getMem_balance() {
		return this.mem_balance;
	}
	
	public void setMem_balance(Integer mem_balance) {
		this.mem_balance = mem_balance;
	}
		
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<ChargeVO> getCharges() {
		return this.charges;
	}

	public void setCharges(Set<ChargeVO> charges) {
		this.charges = charges;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Second_ProdMsgVO> getSecond_ProdMsgs() {
		return this.second_ProdMsgs;
	}

	public void setSecond_ProdMsgs(Set<Second_ProdMsgVO> second_prodmsgs) {
		this.second_ProdMsgs = second_prodmsgs;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Second_ProdVO> getSecond_Prods() {
		return this.second_Prods;
	}

	public void setSecond_Prods(Set<Second_ProdVO> second_prods) {
		this.second_Prods = second_prods;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<OrdersVO> getOrderss() {
		return this.orderss;
	}

	public void setOrderss(Set<OrdersVO> orderss) {
		this.orderss = orderss;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Emg_H_MsgVO> getEmg_H_Msgs() {
		return this.emg_H_Msgs;
	}

	public void setEmg_H_Msgs(Set<Emg_H_MsgVO> emg_h_msgs) {
		this.emg_H_Msgs = emg_h_msgs;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Emg_HelpVO> getEmg_Helps() {
		return this.emg_Helps;
	}

	public void setEmg_Helps(Set<Emg_HelpVO> emg_helps) {
		this.emg_Helps = emg_helps;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id_active DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<ReportVO> getReports() {
		return this.reports;
	}

	public void setReports(Set<ReportVO> reports) {
		this.reports = reports;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO_2")
	@OneToMany(fetch=FetchType.LAZY, mappedBy="memVO_2")
	@OrderBy("mem_Id_passive DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<ReportVO> getReports_2() {
		return this.reports_2;
	}

	public void setReports_2(Set<ReportVO> reports_2) {
		this.reports_2 = reports_2;
	}
		
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("rel_MemId DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Rel_ListVO> getRel_Lists() {
		return this.rel_Lists;
	}

	public void setRel_Lists(Set<Rel_ListVO> rel_lists) {
		this.rel_Lists = rel_lists;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO_2")
	@OneToMany(fetch=FetchType.LAZY, mappedBy="memVO_2")
	@OrderBy("added_MemId DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Rel_ListVO> getRel_Lists_2() {
		return this.rel_Lists_2;
	}

	public void setRel_Lists_2(Set<Rel_ListVO> rel_lists_2) {
		this.rel_Lists_2 = rel_lists_2;
	}
		
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("privMsgSend_MemId DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Priv_messageVO> getPriv_messages() {
		return this.priv_messages;
	}

	public void setPriv_messages(Set<Priv_messageVO> priv_messages) {
		this.priv_messages = priv_messages;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO_2")
	@OneToMany(fetch=FetchType.LAZY, mappedBy="memVO_2")
	@OrderBy("privMsgRec_MemId DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Priv_messageVO> getPriv_messages_2() {
		return this.priv_messages_2;
	}

	public void setPriv_messages_2(Set<Priv_messageVO> priv_messages_2) {
		this.priv_messages_2 = priv_messages_2;
	}
		
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("shopComment_MemId DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Shop_commentVO> getShop_comments() {
		return this.shop_comments;
	}

	public void setShop_comments(Set<Shop_commentVO> shop_comments) {
		this.shop_comments = shop_comments;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("shop_MemId DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<PetShopVO> getPetShops() {
		return this.petShops;
	}

	public void setPetShops(Set<PetShopVO> petshops) {
		this.petShops = petshops;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("grpComment_MemId DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Grp_commentVO> getGrp_comments() {
		return this.grp_comments;
	}

	public void setGrp_comments(Set<Grp_commentVO> grp_comments) {
		this.grp_comments = grp_comments;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("joinList_MemId DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<JoinListVO> getJoinLists() {
		return this.JoinLists;
	}

	public void setJoinLists(Set<JoinListVO> joinlists) {
		this.JoinLists = joinlists;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("grp_MemId DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<PetGroupVO> getPetGroups() {
		return this.petGroups;
	}

	public void setPetGroups(Set<PetGroupVO> petgroups) {
		this.petGroups = petgroups;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("hosComment_MemId DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Hos_commentVO> getHos_comments() {
		return this.hos_comments;
	}

	public void setHos_comments(Set<Hos_commentVO> hos_comments) {
		this.hos_comments = hos_comments;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("hos_MemId DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Vet_hospitalVO> getVet_hospitals() {
		return this.vet_hospitals;
	}

	public void setVet_hospitals(Set<Vet_hospitalVO> vet_hospitals) {
		this.vet_hospitals = vet_hospitals;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Stray_Ani_photosVO> getStray_Ani_photoss() {
		return this.stray_Ani_photoss;
	}

	public void setStray_Ani_photoss(Set<Stray_Ani_photosVO> stray_ani_photoss) {
		this.stray_Ani_photoss = stray_ani_photoss;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Stray_Ani_messageVO> getStray_Ani_messages() {
		return this.stray_Ani_messages;
	}

	public void setStray_Ani_messages(Set<Stray_Ani_messageVO> stray_ani_messages) {
		this.stray_Ani_messages = stray_ani_messages;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Stray_Ani_LocVO> getStray_Ani_Locs() {
		return this.stray_Ani_Locs;
	}

	public void setStray_Ani_Locs(Set<Stray_Ani_LocVO> stray_ani_locs) {
		this.stray_Ani_Locs = stray_ani_locs;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Stray_AniVO> getStray_Anis() {
		return this.stray_Anis;
	}

	public void setStray_Anis(Set<Stray_AniVO> stray_anis) {
		this.stray_Anis = stray_anis;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Pet_PhotosVO> getPet_Photoss() {
		return this.pet_Photoss;
	}

	public void setPet_Photoss(Set<Pet_PhotosVO> pet_photoss) {
		this.pet_Photoss = pet_photoss;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Pet_MessageVO> getPet_Messages() {
		return this.pet_Messages;
	}

	public void setPet_Messages(Set<Pet_MessageVO> pet_messages) {
		this.pet_Messages = pet_messages;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<PetVO> getPets() {
		return this.pets;
	}

	public void setPets(Set<PetVO> pets) {
		this.pets = pets;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Adopt_Ani_photosVO> getAdopt_Ani_photoss() {
		return this.adopt_Ani_photoss;
	}

	public void setAdopt_Ani_photoss(Set<Adopt_Ani_photosVO> adopt_ani_photoss) {
		this.adopt_Ani_photoss = adopt_ani_photoss;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Adopt_Ani_messageVO> getAdopt_Ani_messages() {
		return this.adopt_Ani_messages;
	}

	public void setAdopt_Ani_messages(Set<Adopt_Ani_messageVO> adopt_ani_messages) {
		this.adopt_Ani_messages = adopt_ani_messages;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Adopt_Ani_sponsorVO> getAdopt_Ani_sponsors() {
		return this.adopt_Ani_sponsors;
	}

	public void setAdopt_Ani_sponsors(Set<Adopt_Ani_sponsorVO> adopt_ani_sponsors) {
		this.adopt_Ani_sponsors = adopt_ani_sponsors;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<AdoAniSpoVO> getAdoAniSpos() {
		return this.adoAniSpos;
	}

	public void setAdoAniSpos(Set<AdoAniSpoVO> adoanispos) {
		this.adoAniSpos = adoanispos;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Adopt_AniVO> getAdopt_Anis() {
		return this.adopt_Anis;
	}

	public void setAdopt_Anis(Set<Adopt_AniVO> adopt_anis) {
		this.adopt_Anis = adopt_anis;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<Post_ResponseVO> getPost_Responses() {
		return this.post_Responses;
	}

	public void setPost_Responses(Set<Post_ResponseVO> post_responses) {
		this.post_Responses = post_responses;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<PostVO> getPosts() {
		return this.posts;
	}

	public void setPosts(Set<PostVO> posts) {
		this.posts = posts;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<TrackVO> getTracks() {
		return this.tracks;
	}

	public void setTracks(Set<TrackVO> tracks) {
		this.tracks = tracks;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<AdpMsgVO> getAdpMsgs() {
		return this.adpMsgs;
	}

	public void setAdpMsgs(Set<AdpMsgVO> adpmsgs) {
		this.adpMsgs = adpmsgs;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<AdpVO> getAdps() {
		return this.adps;
	}

	public void setAdps(Set<AdpVO> adps) {
		this.adps = adps;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<AniHome_MsgVO> getAniHome_Msgs() {
		return this.aniHome_Msgs;
	}

	public void setAniHome_Msgs(Set<AniHome_MsgVO> anihome_msgs) {
		this.aniHome_Msgs = anihome_msgs;
	}
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="memVO")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memVO")
	@OrderBy("mem_Id DESC")
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<AniHomeVO> getAniHomes() {
		return this.aniHomes;
	}

	public void setAniHomes(Set<AniHomeVO> anihomes) {
		this.aniHomes = anihomes;
	}
	
}

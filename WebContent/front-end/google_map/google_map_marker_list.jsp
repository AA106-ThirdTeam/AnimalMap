		<%@page import="heibernate_com.anihome.model.*"%>
		<%@page import="heibernate_com.park.model.*"%>
		<%@page import="heibernate_com.adp.model.*"%>
		<%@page import="heibernate_com.stray_ani.model.*"%>
		<%@page import="heibernate_com.pet.model.*"%>
		<%@page import="heibernate_com.adopt_ani.model.*"%>
		<%@page import="heibernate_com.petshop.model.*"%>
		<%@page import="heibernate_com.petgroup.model.*"%>
		<%@page import="heibernate_com.vet_hospital.model.*"%>
		<%@page import="heibernate_com.emg_help.model.*"%>
		<%@page import="heibernate_com.second_prod.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="util.compareVO.CompareVO"%>
<%
	String CompositeQuery = request.getParameter("CompositeQuery");
	System.out.println("CompositeQuery : " + CompositeQuery);
	List<CompareVO> total_list = new ArrayList<CompareVO>();
	session.setAttribute("total_list", null);	
	session.setAttribute("total_list", total_list);		
	int tem_index = 0;
	if(CompositeQuery!=null){
		//CompositeQuery = new String(  request.getParameter("CompositeQuery").getBytes("ISO-8859-1"),"UTF-8" ) ;
		System.out.println("CompositeQuery : " + CompositeQuery);
		{
			//==== ====
		    AniHomeService aniHomeSvc = new AniHomeService();
		    Map tem_map = new HashMap();
		    tem_map.put("aniHome_title", new String[]{CompositeQuery});
		    List<AniHomeVO> list_aniHome = aniHomeSvc
		    .getAll(tem_map, true);
		    System.err.println("list_aniHome : " + list_aniHome.size());
		    session.setAttribute("list_aniHome",list_aniHome);
		    for(AniHomeVO vo:list_aniHome){
				CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getAniHome_start_date()
				,vo.getAniHome_Id());
				((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
		    }
	    }
		{
			//==== ====
		    ParkService parkSvc = new ParkService();
		    Map tem_map = new HashMap();
		    tem_map.put("park_title", new String[]{CompositeQuery});
		    List<ParkVO> list_park = parkSvc
		    .getAll(tem_map, true);
		    System.err.println("list_park : " + list_park.size());
		    session.setAttribute("list_park",list_park);
		    for(ParkVO vo:list_park){
				CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getPark_start_date()
				,vo.getPark_Id());
				((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
		    }
	    }
		{
			//==== ====
		    AdpService adpSvc = new AdpService();
		    Map tem_map = new HashMap();
		    tem_map.put("adp_title", new String[]{CompositeQuery});
		    List<AdpVO> list_adp = adpSvc
		    .getAll(tem_map, true);
		    System.err.println("list_adp : " + list_adp.size());
		    session.setAttribute("list_adp",list_adp);
		    for(AdpVO vo:list_adp){
				CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getAdp_start_date()
				,vo.getAdp_Id());
				((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
		    }
	    }
		{
			//==== ====
		    Stray_AniService stray_AniSvc = new Stray_AniService();
		    Map tem_map = new HashMap();
		    tem_map.put("stray_Ani_name", new String[]{CompositeQuery});
		    List<Stray_AniVO> list_stray_Ani = stray_AniSvc
		    .getAll(tem_map, true);
		    System.err.println("list_stray_Ani : " + list_stray_Ani.size());
		    session.setAttribute("list_stray_Ani",list_stray_Ani);
		    for(Stray_AniVO vo:list_stray_Ani){
				CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getStray_Ani_CreDate()
				,vo.getStray_Ani_Id());
				((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
		    }
	    }
		{
			//==== ====
		    PetService petSvc = new PetService();
		    Map tem_map = new HashMap();
		    tem_map.put("pet_name", new String[]{CompositeQuery});
		    List<PetVO> list_pet = petSvc
		    .getAll(tem_map, true);
		    System.err.println("list_pet : " + list_pet.size());
		    session.setAttribute("list_pet",list_pet);
		    for(PetVO vo:list_pet){
				CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getPet_CreDATE()
				,vo.getPet_Id());
				((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
		    }
	    }
		{
			//==== ====
		    Adopt_AniService adopt_AniSvc = new Adopt_AniService();
		    Map tem_map = new HashMap();
		    tem_map.put("adopt_Ani_name", new String[]{CompositeQuery});
		    List<Adopt_AniVO> list_adopt_Ani = adopt_AniSvc
		    .getAll(tem_map, true);
		    System.err.println("list_adopt_Ani : " + list_adopt_Ani.size());
		    session.setAttribute("list_adopt_Ani",list_adopt_Ani);
		    for(Adopt_AniVO vo:list_adopt_Ani){
				CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getAdopt_Ani_CreDate()
				,vo.getAdopt_Ani_Id());
				((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
		    }
	    }
		{
			//==== ====
		    PetShopService petShopSvc = new PetShopService();
		    Map tem_map = new HashMap();
		    tem_map.put("shop_name", new String[]{CompositeQuery});
		    List<PetShopVO> list_petShop = petShopSvc
		    .getAll(tem_map, true);
		    System.err.println("list_petShop : " + list_petShop.size());
		    session.setAttribute("list_petShop",list_petShop);
		    for(PetShopVO vo:list_petShop){
				CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getShop_CreateTime()
				,vo.getShop_Id());
				((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
		    }
	    }
		{
			//==== ====
		    PetGroupService petGroupSvc = new PetGroupService();
		    Map tem_map = new HashMap();
		    tem_map.put("grp_name", new String[]{CompositeQuery});
		    List<PetGroupVO> list_petGroup = petGroupSvc
		    .getAll(tem_map, true);
		    System.err.println("list_petGroup : " + list_petGroup.size());
		    session.setAttribute("list_petGroup",list_petGroup);
		    for(PetGroupVO vo:list_petGroup){
				CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getGrp_CreateTime()
				,vo.getGrp_Id());
				((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
		    }
	    }
		{
			//==== ====
		    Vet_hospitalService vet_hospitalSvc = new Vet_hospitalService();
		    Map tem_map = new HashMap();
		    tem_map.put("hos_name", new String[]{CompositeQuery});
		    List<Vet_hospitalVO> list_vet_hospital = vet_hospitalSvc
		    .getAll(tem_map, true);
		    System.err.println("list_vet_hospital : " + list_vet_hospital.size());
		    session.setAttribute("list_vet_hospital",list_vet_hospital);
		    for(Vet_hospitalVO vo:list_vet_hospital){
				CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getHos_CreateTime()
				,vo.getHos_Id());
				((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
		    }
	    }
		{
			//==== ====
		    Emg_HelpService emg_HelpSvc = new Emg_HelpService();
		    Map tem_map = new HashMap();
		    tem_map.put("emg_H_title", new String[]{CompositeQuery});
		    List<Emg_HelpVO> list_emg_Help = emg_HelpSvc
		    .getAll(tem_map, true);
		    System.err.println("list_emg_Help : " + list_emg_Help.size());
		    session.setAttribute("list_emg_Help",list_emg_Help);
		    for(Emg_HelpVO vo:list_emg_Help){
				CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getEmg_H_start_date()
				,vo.getEmg_H_Id());
				((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
		    }
	    }
		{
			//==== ====
		    Second_ProdService second_ProdSvc = new Second_ProdService();
		    Map tem_map = new HashMap();
		    tem_map.put("second_Prod_Title", new String[]{CompositeQuery});
		    List<Second_ProdVO> list_second_Prod = second_ProdSvc
		    .getAll(tem_map, true);
		    System.err.println("list_second_Prod : " + list_second_Prod.size());
		    session.setAttribute("list_second_Prod",list_second_Prod);
		    for(Second_ProdVO vo:list_second_Prod){
				CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getSecond_Prod_adp_start_date()
				,vo.getSecond_Prod_Id());
				((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
		    }
	    }
	}else{
		//==== ====
	    AniHomeService aniHomeSvc = new AniHomeService();
	    List<AniHomeVO> list_aniHome = aniHomeSvc.getAll();
	    session.setAttribute("list_aniHome",list_aniHome);
	    for(AniHomeVO vo:list_aniHome){
			CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getAniHome_start_date()
			,vo.getAniHome_Id());
			((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
	    }
		//==== ====
	    ParkService parkSvc = new ParkService();
	    List<ParkVO> list_park = parkSvc.getAll();
	    session.setAttribute("list_park",list_park);
	    for(ParkVO vo:list_park){
			CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getPark_start_date()
			,vo.getPark_Id());
			((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
	    }
		//==== ====
	    AdpService adpSvc = new AdpService();
	    List<AdpVO> list_adp = adpSvc.getAll();
	    session.setAttribute("list_adp",list_adp);
	    for(AdpVO vo:list_adp){
			CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getAdp_start_date()
			,vo.getAdp_Id());
			((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
	    }
		//==== ====
	    Stray_AniService stray_AniSvc = new Stray_AniService();
	    List<Stray_AniVO> list_stray_Ani = stray_AniSvc.getAll();
	    session.setAttribute("list_stray_Ani",list_stray_Ani);
	    for(Stray_AniVO vo:list_stray_Ani){
			CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getStray_Ani_CreDate()
			,vo.getStray_Ani_Id());
			((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
	    }
		//==== ====
	    PetService petSvc = new PetService();
	    List<PetVO> list_pet = petSvc.getAll();
	    session.setAttribute("list_pet",list_pet);
	    for(PetVO vo:list_pet){
			CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getPet_CreDATE()
			,vo.getPet_Id());
			((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
	    }
		//==== ====
	    Adopt_AniService adopt_AniSvc = new Adopt_AniService();
	    List<Adopt_AniVO> list_adopt_Ani = adopt_AniSvc.getAll();
	    session.setAttribute("list_adopt_Ani",list_adopt_Ani);
	    for(Adopt_AniVO vo:list_adopt_Ani){
			CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getAdopt_Ani_CreDate()
			,vo.getAdopt_Ani_Id());
			((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
	    }
		//==== ====
	    PetShopService petShopSvc = new PetShopService();
	    List<PetShopVO> list_petShop = petShopSvc.getAll();
	    session.setAttribute("list_petShop",list_petShop);
	    for(PetShopVO vo:list_petShop){
			CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getShop_CreateTime()
			,vo.getShop_Id());
			((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
	    }
		//==== ====
	    PetGroupService petGroupSvc = new PetGroupService();
	    List<PetGroupVO> list_petGroup = petGroupSvc.getAll();
	    session.setAttribute("list_petGroup",list_petGroup);
	    for(PetGroupVO vo:list_petGroup){
			CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getGrp_CreateTime()
			,vo.getGrp_Id());
			((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
	    }
		//==== ====
	    Vet_hospitalService vet_hospitalSvc = new Vet_hospitalService();
	    List<Vet_hospitalVO> list_vet_hospital = vet_hospitalSvc.getAll();
	    session.setAttribute("list_vet_hospital",list_vet_hospital);
	    for(Vet_hospitalVO vo:list_vet_hospital){
			CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getHos_CreateTime()
			,vo.getHos_Id());
			((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
	    }
		//==== ====
	    Emg_HelpService emg_HelpSvc = new Emg_HelpService();
	    List<Emg_HelpVO> list_emg_Help = emg_HelpSvc.getAll();
	    session.setAttribute("list_emg_Help",list_emg_Help);
	    for(Emg_HelpVO vo:list_emg_Help){
			CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getEmg_H_start_date()
			,vo.getEmg_H_Id());
			((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
	    }
		//==== ====
	    Second_ProdService second_ProdSvc = new Second_ProdService();
	    List<Second_ProdVO> list_second_Prod = second_ProdSvc.getAll();
	    session.setAttribute("list_second_Prod",list_second_Prod);
	    for(Second_ProdVO vo:list_second_Prod){
			CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getSecond_Prod_adp_start_date()
			,vo.getSecond_Prod_Id());
			((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
	    }
	}
	// clone list
	List<CompareVO> total_list_sort_by_date = new ArrayList<CompareVO>(total_list.size());
    for (CompareVO item : total_list) {
    	total_list_sort_by_date.add((CompareVO)item.clone());
    }
    Collections.sort(total_list_sort_by_date);
    session.setAttribute("total_list_sort_by_date", null);
	session.setAttribute("total_list_sort_by_date", total_list_sort_by_date);	
%>

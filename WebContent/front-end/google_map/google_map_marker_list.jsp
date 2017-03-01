<%@page import="heibernate_com.vet_hospital.model.Vet_hospitalVO"%>
<%@page import="heibernate_com.vet_hospital.model.Vet_hospitalService"%>
<%@page import="heibernate_com.adopt_ani.model.Adopt_AniService"%>
<%@page import="heibernate_com.adopt_ani.model.Adopt_AniVO"%>
<%@page import="heibernate_com.emg_help.model.Emg_HelpVO"%>
<%@page import="heibernate_com.emg_help.model.Emg_HelpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>    
<%@ page import="heibernate_com.park.model.*"%>	
<%@page import="util.compareVO.CompareVO"%>
<%@ page import="heibernate_com.anihome.model.*"%>
<%@ page import="heibernate_com.adp.model.*"%>	

<%
{
	//==== ====
	int tem_index = 0;
	
	//==== ====
	List<CompareVO> total_list = new ArrayList<CompareVO>();
	session.setAttribute("total_list", total_list);
	
    ParkService parkSvc = new ParkService();
    List<ParkVO> list_park = parkSvc.getAll();
    pageContext.setAttribute("list_park",list_park);
    tem_index = 0;
    for(ParkVO vo:list_park){
    	tem_index ++;
		CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getPark_start_date(),String.valueOf(tem_index));
		((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
    }
    
    
	AniHomeService anihomeSvc = new AniHomeService();
	List<AniHomeVO> list_anihome = anihomeSvc.getAll();
	pageContext.setAttribute("list_anihome",list_anihome);
	tem_index = 0;
	for(AniHomeVO vo:list_anihome){
		tem_index ++;
		CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getAniHome_start_date(),String.valueOf(tem_index));
		((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
    }
	
	
	AdpService adpSvc = new AdpService();
	List<AdpVO> list_adp = adpSvc.getAll();
	pageContext.setAttribute("list_adp",list_adp);
	tem_index = 0;
	for(AdpVO vo:list_adp){
		tem_index ++;
		CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getAdp_start_date(),String.valueOf(tem_index));
		((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
    }
	
	{
		Emg_HelpService svc = new Emg_HelpService();
		List<Emg_HelpVO> list = svc.getAll();
		tem_index = 0;
		for(Emg_HelpVO vo:list){
			tem_index ++;
			CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getEmg_H_start_date(),String.valueOf(tem_index));
			((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
	    }	
	}
	
// 	{
// 		Adopt_AniService svc = new Adopt_AniService();
// 		List<Adopt_AniVO> list = svc.getAll();
// 		tem_index = 0;
// 		for(Adopt_AniVO vo:list){
// 			tem_index ++;
// 			System.out.println(vo.getAdopt_Ani_CreDate());
// // 			CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),vo.getAdopt_Ani_CreDate(),String.valueOf(tem_index));
// // 			((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
// 	    }	
// 	}

// 	{
// 		Vet_hospitalService svc = new Vet_hospitalService();
// 		List<Vet_hospitalVO> list = svc.getAll();
// 		tem_index = 0;
// 		for(Vet_hospitalVO vo:list){
// 			tem_index ++;
// 			CompareVO cvo = new CompareVO(vo,vo.getClass().getName(),null,String.valueOf(tem_index));
// 			((List<CompareVO>)session.getAttribute("total_list")).add(cvo);	
// 	    }	
// 	}	
	
	// clone list
	List<CompareVO> total_list_sort_by_date = new ArrayList<CompareVO>(total_list.size());
    for (CompareVO item : total_list) {
    	total_list_sort_by_date.add((CompareVO)item.clone());
    }
	
    Collections.sort(total_list_sort_by_date);
	session.setAttribute("total_list_sort_by_date", total_list_sort_by_date);
}
%>
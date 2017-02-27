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
	
	// clone list
	List<CompareVO> total_list_sort_by_date = new ArrayList<CompareVO>(total_list.size());
    for (CompareVO item : total_list) {
    	total_list_sort_by_date.add((CompareVO)item.clone());
    }
	
    Collections.sort(total_list_sort_by_date);
	session.setAttribute("total_list_sort_by_date", total_list_sort_by_date);
}
%>
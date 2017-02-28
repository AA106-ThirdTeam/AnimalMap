<%@page import="heibernate_com.anihome_photos.controller.AniHome_PhotosServlet"%>
<%@page import="heibernate_com.anihome_photos.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%
	AniHome_PhotosServlet servlet = new AniHome_PhotosServlet();
	servlet.front_end_list_ByCompositeQuery(request, response, true);
	List<AniHome_PhotosVO> list = (List) request.getAttribute("listAniHome_Photoss_ByCompositeQuery");
    pageContext.setAttribute("list",list);  //如果沒有setAttribute，JLTS的for each就沒辦法跑。
%>

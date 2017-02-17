<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String btnName = request.getParameter("btnName");
	String path = "login/ecommerce_product_detail.html";
	
	if("AM_MapInfo".equals(btnName)){
		path = "AM_MapInfo.jsp";
	}
	if("AM_Mem".equals(btnName)){
		path = "AM_Mem.jsp";
	}
	if("AM_Friend".equals(btnName)){
		path = "Friend/AM_Friend.html";
	}	
	if("AM_btn_Member".equals(btnName)){
		path = "login/login_status.jsp";
	}
%>
<%=path%>		
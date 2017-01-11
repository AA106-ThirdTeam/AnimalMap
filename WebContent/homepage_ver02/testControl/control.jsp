<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String btnName = request.getParameter("btnName");
	String path = "";
	if("AM_MapInfo".equals(btnName)){
		path = "AM_MapInfo.jsp";
	}
	if("AM_Mem".equals(btnName)){
		path = "AM_Mem.jsp";
	}
	if("AM_Friend".equals(btnName)){
		path = "AM_Friend.jsp";
	}	
%>
<%=path%>		
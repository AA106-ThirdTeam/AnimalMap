<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String city = request.getParameter("city");
	System.out.println("HI");
// 	String path = "C:\\Users\\Administrator\\Desktop\\bsProject\\untitled-4.html";	
	String path = "../homepage_ver02/index.jsp";	
%>
<%-- <%=name%> --%>
<%-- <%=city%> --%>
<%=path%>
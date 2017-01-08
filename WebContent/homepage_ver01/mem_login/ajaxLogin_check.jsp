<%@page import="com.mem.model.MemJDBCDAO"%>
<%@page import="com.mem.model.MemDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.json.JSONObject"%>
<%
	//簡單版:判斷帳號密碼正不正確。
	String[] str = {"1","t"};
	MemJDBCDAO.main(str);
%>  

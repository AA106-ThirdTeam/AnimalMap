<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.json.JSONObject"%>
<%
//取得前端送來的資料 
String memId = request.getParameter("memId");
String memPsw = request.getParameter("memPsw");

//載入JDBC驅動程式類別 
//Class.forName("oracle.jdbc.driver.OracleDriver");
//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr", "123456"); 
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sample","root", "root");   
  
//建立PreparedStatement物件 
PreparedStatement stmt = conn.prepareStatement("select * from member_table where memId=? and memPsw=?");

//代入資料    
stmt.setString(1, memId);
stmt.setString(2, memPsw);

//執行PreparedStatement
ResultSet rs=stmt.executeQuery();
  
//取回一筆資料
rs.next();

// session.setAttribute("memId" , memId);
out.print(rs.getString("memName"));
rs.close();
stmt.close();
conn.close();
%>  

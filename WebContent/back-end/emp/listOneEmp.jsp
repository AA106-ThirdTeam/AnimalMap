<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.emp.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller EmpServlet.java已存入request的EmpVO物件--%>
<%EmpVO empVO = (EmpVO) request.getAttribute("empVO");%>
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
    <font color='red'>請修正以下錯誤:
    <ul>
        <c:forEach var="message" items="${errorMsgs}">
            <li>${message}</li>
        </c:forEach>
    </ul>
    </font>
</c:if>
<html>
<head>
<title>員工資料 - listOneEmp.jsp</title>
	<!-- 共用HEAD -->
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>員工資料 - ListOneEmp.jsp</h3>
        <a href="<%=request.getContextPath()%>/back-end/emp/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>員工編號</b></td>		<td><b>員工姓名</b></td>		<td><b>員工密碼</b></td>		<td><b>員工信箱</b></td>		<td><b>員工身分證</b></td>		<td><b>員工出生年月日</b></td>		<td><b>員工電話</b></td>		<td><b>員工地址</b></td>		<td><b>員工狀態</b></td>		<td><b>員工照片</b></td>		<td><b>員工照片副檔名</b></td>		<td><b>雇用日期</b></td>		<td><b>離職日期</b></td>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${empVO.emp_No}</td>			<td>${empVO.emp_name}</td>			<td>${empVO.emp_Pw}</td>			<td>${empVO.emp_email}</td>			<td>${empVO.emp_Id}</td>			<td>${empVO.emp_birthday}</td>			<td>${empVO.emp_phone}</td>			<td>${empVO.emp_address}</td>			<td>${empVO.emp_status}</td>			<td>${empVO.emp_picture}</td>			<td>${empVO.emp_Pic_format}</td>			<td>${empVO.emp_hiredate}</td>			<td>${empVO.emp_firedate}</td>
    </tr>
</table>
</body>
</html>        

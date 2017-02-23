<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.report.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller ReportServlet.java已存入request的ReportVO物件--%>
<%ReportVO reportVO = (ReportVO) request.getAttribute("reportVO");%>
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
<title>檢舉資料 - listOneReport.jsp</title>
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
        <h3>檢舉資料 - ListOneReport.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/report/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>檢舉編號</b></td>		<td><b>檢舉名稱</b></td>		<td><b>檢舉類別</b></td>		<td><b>檢舉類別編號</b></td>		<td><b>檢舉類別編號值</b></td>		<td><b>檢舉內容</b></td>		<td><b>檢舉狀態</b></td>		<td><b>檢舉人ID</b></td>		<td><b>被檢舉人ID</b></td>		<td><b>檢舉時間</b></td>		<td><b>檢舉類別的狀態</b></td>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${reportVO.report_No}</td>			<td>${reportVO.report_name}</td>			<td>${reportVO.report_class}</td>			<td>${reportVO.report_class_No}</td>			<td>${reportVO.report_class_No_value}</td>			<td>${reportVO.report_content}</td>			<td>${reportVO.report_status}</td>	
	<td>
		<font color=orange>${reportVO.memVO.mem_Id}</font>
	</td>
	<td>
		<font color=orange>${reportVO.memVO.mem_Id}</font>
	</td>
			<td>${reportVO.report_time}</td>			<td>${reportVO.report_class_status}</td>
    </tr>
</table>
</body>
</html>        

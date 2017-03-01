<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.hos_comment.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller Hos_commentServlet.java已存入request的Hos_commentVO物件--%>
<%Hos_commentVO hos_commentVO = (Hos_commentVO) request.getAttribute("hos_commentVO");%>
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
<title>診所留言資料 - listOneHos_comment.jsp</title>
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
        <h3>診所留言資料 - ListOneHos_comment.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/hos_comment/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>診所留言編號</b></td>		<td><b>發送會員</b></td>		<td><b>診所</b></td>		<td><b>發送內容</b></td>		<td><b>發送時間</b></td>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${hos_commentVO.hosComment_Id}</td>	
	<td>
		<font color=orange>${hos_commentVO.memVO.mem_Id}</font>
	</td>
	<td>
		<font color=orange>${hos_commentVO.vet_hospitalVO.hos_Id}</font>
	</td>
			<td>${hos_commentVO.hosComment_content}</td>			<td>${hos_commentVO.hosComment_SendTime}</td>
    </tr>
</table>
</body>
</html>        

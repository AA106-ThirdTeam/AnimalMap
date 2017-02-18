<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.adpmsg.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller AdpMsgServlet.java已存入request的AdpMsgVO物件--%>
<%AdpMsgVO adpmsgVO = (AdpMsgVO) request.getAttribute("adpmsgVO");%>
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
<title>領養活動留言資料 - listOneAdpMsg.jsp</title>
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
        <h3>領養活動留言資料 - ListOneAdpMsg.jsp</h3>
        <a href="<%=request.getContextPath()%>/back-end/adpmsg/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>領養活動留言編號</b></td>		<td><b>領養活動</b></td>		<td><b>留言會員</b></td>		<td><b>領養活動留言</b></td>		<td><b>留言發布日期</b></td>		<td><b>留言更新日期</b></td>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${adpmsgVO.adpMsg_Id}</td>	
	<td>
		<font color=orange>${adpmsgVO.adpVO.adp_Id}</font>
	</td>
	<td>
		<font color=orange>${adpmsgVO.memVO.mem_Id}</font>
	</td>
			<td>${adpmsgVO.msg}</td>			<td>${adpmsgVO.adpMsgDate}</td>			<td>${adpmsgVO.adpMsgadp_upDate}</td>
    </tr>
</table>
</body>
</html>        

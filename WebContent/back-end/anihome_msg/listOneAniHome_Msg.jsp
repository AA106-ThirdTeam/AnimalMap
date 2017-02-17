<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.anihome_msg.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller AniHome_MsgServlet.java已存入request的AniHome_MsgVO物件--%>
<%AniHome_MsgVO anihome_msgVO = (AniHome_MsgVO) request.getAttribute("anihome_msgVO");%>
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
<title>動物之家留言資料 - listOneAniHome_Msg.jsp</title>
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
        <h3>動物之家留言資料 - ListOneAniHome_Msg.jsp</h3>
        <a href="<%=request.getContextPath()%>/back-end/anihome_msg/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>動物之家留言編號</b></td>		<td><b>動物之家</b></td>		<td><b>留言會員</b></td>		<td><b>動物之家留言</b></td>		<td><b>留言發布日期</b></td>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${anihome_msgVO.aniHome_Msg_Id}</td>
		<td>
【<font color=orange>${anihome_msgVO.aniHomeVO.aniHome_title}</font>】	
		</td>	
		<td>
【<font color=orange>${anihome_msgVO.memVO.mem_name}</font>-<font color=black>${anihome_msgVO.memVO.mem_nick_name}</font>】	
		</td>	
			<td>${anihome_msgVO.aniHome_Msg}</td>			<td>${anihome_msgVO.adp_start_date}</td>
    </tr>
</table>
</body>
</html>        

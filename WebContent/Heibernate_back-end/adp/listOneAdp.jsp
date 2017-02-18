<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.adp.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller AdpServlet.java已存入request的AdpVO物件--%>
<%AdpVO adpVO = (AdpVO) request.getAttribute("adpVO");%>
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
<title>領養活動資料 - listOneAdp.jsp</title>
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
        <h3>領養活動資料 - ListOneAdp.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/adp/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>領養活動編號</b></td>		<td><b>發布會員</b></td>		<td><b>領養活動標題</b></td>		<td><b>領養活動內容</b></td>		<td><b>領養活動發布時間</b></td>		<td><b>領養活動到期時間</b></td>		<td><b>領養活動更新時間</b></td>		<td><b>縣市</b></td>		<td><b>鄉鎮市區</b></td>		<td><b>道路街名村里</b></td>		<td><b>領養活動經度座標</b></td>		<td><b>緯度座標緯度座標</b></td>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${adpVO.adp_Id}</td>	
	<td>
		<font color=orange>${adpVO.memVO.mem_Id}</font>
	</td>
			<td>${adpVO.adp_title}</td>			<td>${adpVO.adp_adp_content}</td>			<td>${adpVO.adp_start_date}</td>			<td>${adpVO.adp_end_date}</td>			<td>${adpVO.adp_upDate}</td>			<td>${adpVO.adp_city}</td>			<td>${adpVO.adp_town}</td>			<td>${adpVO.adp_road}</td>			<td>${adpVO.adp_lon}</td>			<td>${adpVO.adp_lat}</td>
    </tr>
</table>
</body>
</html>        

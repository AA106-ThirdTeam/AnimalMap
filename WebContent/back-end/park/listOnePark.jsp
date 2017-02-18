<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.park.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller ParkServlet.java已存入request的ParkVO物件--%>
<%ParkVO parkVO = (ParkVO) request.getAttribute("parkVO");%>
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
<title>公園資料 - listOnePark.jsp</title>
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
        <h3>公園資料 - ListOnePark.jsp</h3>
        <a href="<%=request.getContextPath()%>/back-end/park/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>公園編號</b></td>		<td><b>員工</b></td>		<td><b>公園標題</b></td>		<td><b>公園內容</b></td>		<td><b>公園照片</b></td>		<td><b>公園發布時間</b></td>		<td><b>公園更新時間</b></td>		<td><b>縣市</b></td>		<td><b>鄉鎮市區</b></td>		<td><b>道路街名村里</b></td>		<td><b>公園經度座標</b></td>		<td><b>緯度座標緯度座標</b></td>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${parkVO.park_Id}</td>
		<td>
【<font color=orange>${parkVO.empVO.mem_name}</font>-<font color=black>${parkVO.empVO.mem_nick_name}</font>】	
		</td>	
			<td>${parkVO.park_title}</td>			<td>${parkVO.park_content}</td>			<td>${parkVO.park_pic}</td>			<td>${parkVO.adp_start_date}</td>			<td>${parkVO.adp_upDate}</td>			<td>${parkVO.adp_city}</td>			<td>${parkVO.park_town}</td>			<td>${parkVO.park_road}</td>			<td>${parkVO.park_lon}</td>			<td>${parkVO.park_lat}</td>
    </tr>
</table>
</body>
</html>        

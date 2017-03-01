<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.stray_ani.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller Stray_AniServlet.java已存入request的Stray_AniVO物件--%>
<%Stray_AniVO stray_aniVO = (Stray_AniVO) request.getAttribute("stray_aniVO");%>
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
<title>社區流浪動物資料 - listOneStray_Ani.jsp</title>
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
        <h3>社區流浪動物資料 - ListOneStray_Ani.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/stray_ani/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>社區動物編號</b></td>		<td><b>發布者會員</b></td>		<td><b>流浪動物名字</b></td>		<td><b>流浪動物種類</b></td>		<td><b>流浪性別</b></td>		<td><b>流浪動物健康狀況</b></td>		<td><b>流浪動物疫苗接踵</b></td>		<td><b>流浪動物毛色</b></td>		<td><b>流浪動物體型</b></td>		<td><b>流浪動物年齡</b></td>		<td><b>流浪動物節育</b></td>		<td><b>流浪動物晶片編號</b></td>		<td><b>流浪動物發現時間</b></td>		<td><b>流浪動物物件狀態</b></td>		<td><b>流浪動物建立時間</b></td>		<td><b>流浪出沒地點經度</b></td>		<td><b>流浪出沒地點緯度</b></td>		<td><b>縣/市</b></td>		<td><b>鄉鎮市區</b></td>		<td><b>道路街名村里</b></td>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${stray_aniVO.stray_Ani_Id}</td>	
	<td>
		<font color=orange>${stray_aniVO.memVO.mem_Id}</font>
	</td>
			<td>${stray_aniVO.stray_Ani_name}</td>			<td>${stray_aniVO.stray_Ani_type}</td>			<td>${stray_aniVO.stray_Ani_gender}</td>			<td>${stray_aniVO.stray_Ani_heal}</td>			<td>${stray_aniVO.stray_Ani_Vac}</td>			<td>${stray_aniVO.stray_Ani_color}</td>			<td>${stray_aniVO.stray_Ani_body}</td>			<td>${stray_aniVO.stray_Ani_age}</td>			<td>${stray_aniVO.stray_Ani_Neu}</td>			<td>${stray_aniVO.stray_Ani_chip}</td>			<td>${stray_aniVO.stray_Ani_date}</td>			<td>${stray_aniVO.stray_Ani_status}</td>			<td>${stray_aniVO.stray_Ani_CreDate}</td>			<td>${stray_aniVO.stray_Ani_FinLat}</td>			<td>${stray_aniVO.stray_Ani_FinLon}</td>			<td>${stray_aniVO.stray_Ani_city}</td>			<td>${stray_aniVO.stray_Ani_town}</td>			<td>${stray_aniVO.stray_Ani_road}</td>
    </tr>
</table>
</body>
</html>        

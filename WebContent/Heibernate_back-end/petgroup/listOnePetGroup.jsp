<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.petgroup.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller PetGroupServlet.java已存入request的PetGroupVO物件--%>
<%PetGroupVO petgroupVO = (PetGroupVO) request.getAttribute("petgroupVO");%>
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
<title>揪團資料 - listOnePetGroup.jsp</title>
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
        <h3>揪團資料 - ListOnePetGroup.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/petgroup/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>活動編號</b></td>		<td><b>會員(負責人)</b></td>		<td><b>名稱</b></td>		<td><b>縣/市</b></td>		<td><b>鄉鎮市區道路</b></td>		<td><b>道路街名村里</b></td>		<td><b>結束時間</b></td>		<td><b>開始時間</b></td>		<td><b>建立時間</b></td>		<td><b>揪團敘述</b></td>		<td><b>商家經度座標</b></td>		<td><b>商家緯度座標</b></td>		<td><b>物件顯示狀態</b></td>		<td><b>揪團照片</b></td>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${petgroupVO.grp_Id}</td>	
	<td>
		<font color=orange>${petgroupVO.memVO.mem_Id}</font>
	</td>
			<td>${petgroupVO.grp_name}</td>			<td>${petgroupVO.grp_city}</td>			<td>${petgroupVO.GRP_TOWN}</td>			<td>${petgroupVO.grp_road}</td>			<td>${petgroupVO.grp_EndTime}</td>			<td>${petgroupVO.grp_StartTime}</td>			<td>${petgroupVO.grp_CreateTime}</td>			<td>${petgroupVO.grp_Desc}</td>			<td>${petgroupVO.grp_Long}</td>			<td>${petgroupVO.grp_Lat}</td>			<td>${petgroupVO.grp_visible}</td>			<td>${petgroupVO.GRP_PHOTO}</td>
    </tr>
</table>
</body>
</html>        

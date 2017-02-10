	
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pet_group.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Pet_groupServlet.java已存入request的Pet_groupVO物件--%>
<%Pet_groupVO pet_groupVO = (Pet_groupVO) request.getAttribute("pet_groupVO");%>


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
<title>揪團資料 - listOnePet_group.jsp</title>

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
        <h3>揪團資料 - ListOnePet_group.jsp</h3>
        <a href="<%=request.getContextPath()%>/back-end/pet_group/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>活動編號</th>		<th>會員編號(負責人)</th>		<th>名稱</th>		<th>縣/市</th>		<th>鄉鎮市區道路</th>		<th>道路街名村里</th>		<th>開始時間</th>		<th>結束時間</th>		<th>揪團敘述</th>		<th>商家經度座標</th>		<th>商家緯度座標</th>		<th>建立時間</th>		<th>物件顯示狀態</th>		<th></th>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${pet_groupVO.grp_Id}</td>			<td>${pet_groupVO.grp_MemId}</td>			<td>${pet_groupVO.grp_name}</td>			<td>${pet_groupVO.grp_city}</td>			<td>${pet_groupVO.grp_Addr}</td>			<td>${pet_groupVO.grp_road}</td>			<td>${pet_groupVO.grp_StartTime}</td>			<td>${pet_groupVO.grp_EndTime}</td>			<td>${pet_groupVO.grp_Desc}</td>			<td>${pet_groupVO.grp_Long}</td>			<td>${pet_groupVO.grp_Lat}</td>			<td>${pet_groupVO.grp_CreateTime}</td>			<td>${pet_groupVO.grp_visible}</td>			<td>${pet_groupVO.grp_photo}</td> 
    </tr>
</table>

</body>
</html>        

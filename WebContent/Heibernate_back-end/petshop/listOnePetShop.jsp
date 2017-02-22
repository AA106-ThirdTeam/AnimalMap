<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.petshop.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller PetShopServlet.java已存入request的PetShopVO物件--%>
<%PetShopVO petshopVO = (PetShopVO) request.getAttribute("petshopVO");%>
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
<title>寵物商店資料 - listOnePetShop.jsp</title>
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
        <h3>寵物商店資料 - ListOnePetShop.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/petshop/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>商家編號</b></td>		<td><b>會員(負責人)</b></td>		<td><b>商家名稱</b></td>		<td><b>縣/市</b></td>		<td><b>鄉鎮市區</b></td>		<td><b>道路街名村里</b></td>		<td><b>評價</b></td>		<td><b>URL</b></td>		<td><b>開始營業時間</b></td>		<td><b>結束營業時間</b></td>		<td><b>電話</b></td>		<td><b>商家敘述</b></td>		<td><b>商家經度座標</b></td>		<td><b>商家緯度座標</b></td>		<td><b>建立時間</b></td>		<td><b>物件顯示狀態</b></td>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${petshopVO.shop_Id}</td>	
	<td>
		<font color=orange>${petshopVO.memVO.mem_Id}</font>
	</td>
			<td>${petshopVO.shop_name}</td>			<td>${petshopVO.shop_city}</td>			<td>${petshopVO.shop_town}</td>			<td>${petshopVO.shop_road}</td>			<td>${petshopVO.shop_Eval}</td>			<td>${petshopVO.shop_URL}</td>			<td>${petshopVO.shop_StartTime}</td>			<td>${petshopVO.shop_EndTime}</td>			<td>${petshopVO.shop_Tel}</td>			<td>${petshopVO.shop_Desc}</td>			<td>${petshopVO.shop_Long}</td>			<td>${petshopVO.shop_Lat}</td>			<td>${petshopVO.shop_CreateTime}</td>			<td>${petshopVO.shop_visible}</td>
    </tr>
</table>
</body>
</html>        

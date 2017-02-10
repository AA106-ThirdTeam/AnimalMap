	
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.second_prod.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Second_ProdServlet.java已存入request的Second_ProdVO物件--%>
<%Second_ProdVO second_prodVO = (Second_ProdVO) request.getAttribute("second_prodVO");%>


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
<title>二手商品資料 - listOneSecond_Prod.jsp</title>

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
        <h3>二手商品資料 - ListOneSecond_Prod.jsp</h3>
        <a href="<%=request.getContextPath()%>/back-end/second_prod/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>二手商品編號</th>		<th>發布會員編號</th>		<th>二手商品標題</th>		<th>二手商品內容</th>		<th>二手商品發布時間</th>		<th>二手商品截止時間</th>		<th>二手商品更新時間</th>		<th>縣市</th>		<th>鄉鎮市區</th>		<th>道路街名村里</th>		<th>二手商品經度座標</th>		<th>緯度座標緯度座標</th>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${second_prodVO.second_Prod_Id}</td>			<td>${second_prodVO.mem_Id}</td>			<td>${second_prodVO.second_Prod_Title}</td>			<td>${second_prodVO.second_Prod_Content}</td>			<td>${second_prodVO.second_Prod_adp_start_date}</td>			<td>${second_prodVO.second_Prod_adp_end_date}</td>			<td>${second_prodVO.second_Prod_adp_upDate}</td>			<td>${second_prodVO.second_Prod_adp_city}</td>			<td>${second_prodVO.second_Prod_Town}</td>			<td>${second_prodVO.second_Prod_Road}</td>			<td>${second_prodVO.second_Prod_Lon}</td>			<td>${second_prodVO.second_Prod_Lat}</td> 
    </tr>
</table>

</body>
</html>        

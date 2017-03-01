<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.orders.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller OrdersServlet.java已存入request的OrdersVO物件--%>
<%OrdersVO ordersVO = (OrdersVO) request.getAttribute("ordersVO");%>
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
<title>訂單資料 - listOneOrders.jsp</title>
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
        <h3>訂單資料 - ListOneOrders.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/orders/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>訂單編號</b></td>		<td><b>會員</b></td>		<td><b>收件人</b></td>		<td><b>郵遞區號</b></td>		<td><b>縣市</b></td>		<td><b>鄉鎮</b></td>		<td><b>路</b></td>		<td><b>收件人電話</b></td>		<td><b>付款方式</b></td>		<td><b>下單日期</b></td>		<td><b>出貨日期</b></td>		<td><b>總金額</b></td>		<td><b>處理狀態</b></td>		<td><b>信用卡卡號</b></td>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${ordersVO.orders_no}</td>	
	<td>
		<font color=orange>${ordersVO.memVO.mem_Id}</font>
	</td>
			<td>${ordersVO.orders_receiver}</td>			<td>${ordersVO.post_no}</td>			<td>${ordersVO.post_adp_city}</td>			<td>${ordersVO.post_town}</td>			<td>${ordersVO.post_road}</td>			<td>${ordersVO.orders_phone}</td>			<td>${ordersVO.collect_mode_no}</td>			<td>${ordersVO.orders_date}</td>			<td>${ordersVO.orders_ship_date}</td>			<td>${ordersVO.orders_total}</td>			<td>${ordersVO.orders_status}</td>			<td>${ordersVO.orders_credit}</td>
    </tr>
</table>
</body>
</html>        

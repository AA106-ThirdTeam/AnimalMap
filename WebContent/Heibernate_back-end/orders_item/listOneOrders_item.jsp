<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.orders_item.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller Orders_itemServlet.java已存入request的Orders_itemVO物件--%>
<%Orders_itemVO orders_itemVO = (Orders_itemVO) request.getAttribute("orders_itemVO");%>
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
<title>訂單明細資料 - listOneOrders_item.jsp</title>
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
        <h3>訂單明細資料 - ListOneOrders_item.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/orders_item/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>訂單</b></td>		<td><b>商品</b></td>		<td><b>訂購數量</b></td>		<td><b>商品售價</b></td>
    </tr>
    <tr align='center' valign='middle'>    
	<td>
		<font color=orange>${orders_itemVO.ordersVO.orders_no}</font>
	</td>
	<td>
		<font color=orange>${orders_itemVO.productVO.product_no}</font>
	</td>
			<td>${orders_itemVO.commodities_amount}</td>			<td>${orders_itemVO.selling_price}</td>
    </tr>
</table>
</body>
</html>        

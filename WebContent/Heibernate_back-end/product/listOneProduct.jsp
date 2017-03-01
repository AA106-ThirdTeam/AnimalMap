<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.product.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>
<%-- 取出 Concroller ProductServlet.java已存入request的ProductVO物件--%>
<%ProductVO productVO = (ProductVO) request.getAttribute("productVO");%>
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
<title>商品資料 - listOneProduct.jsp</title>
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
        <h3>商品資料 - ListOneProduct.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/product/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr align='center' valign='middle'>
		<td><b>商品編號</b></td>		<td><b>商品名稱</b></td>		<td><b>商品簡介</b></td>		<td><b>商品價格</b></td>		<td><b>商品庫存量</b></td>		<td><b>商品圖片</b></td>		<td><b>商品圖片（縮圖）</b></td>		<td><b>商品上下架狀態</b></td>		<td><b>商品建立日期</b></td>		<td><b>商品資訊</b></td>		<td><b>商品類別編號</b></td>
    </tr>
    <tr align='center' valign='middle'>    
			<td>${productVO.product_no}</td>			<td>${productVO.product_name}</td>			<td>${productVO.product_introduction}</td>			<td>${productVO.product_price}</td>			<td>${productVO.product_stock}</td>			<td>${productVO.product_picture_large}</td>			<td>${productVO.product_picture_small}</td>			<td>${productVO.product_status}</td>			<td>${productVO.product_create_date}</td>			<td>${productVO.product_info}</td>			<td>${productVO.product_kind_no}</td>
    </tr>
</table>
</body>
</html>        

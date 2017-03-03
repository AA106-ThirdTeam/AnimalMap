<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.orders_item.model.*"%>
<%
Orders_itemVO orders_itemVO = (Orders_itemVO) request.getAttribute("orders_itemVO");
%>
<html>
<head>
<title>訂單明細新增 - addOrders_item.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<!-- 共用HEAD -->
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
</head>
<body bgcolor='white'>
<!--  -->
<div id="popupcalendar" class="text"></div>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>訂單明細新增 - addOrders_item.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/Heibernate_back-end/orders_item/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>
<h3>訂單明細:</h3>
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
<FORM METHOD="post" ACTION="orders_item.do" name="form1">
<table border="0">
	<jsp:useBean id="ordersSvc" scope="page" class="heibernate_com.orders.model.OrdersService" />
	<tr>
		<td>訂單編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="orders_no">
			<c:forEach var="ordersVO" items="${ordersSvc.all}">
				<option value="${ordersVO.orders_no}" ${(orders_itemVO.ordersVO.orders_no==ordersVO.orders_no)? 'selected':'' } >${ordersVO.orders_no}
			</c:forEach>
		</select></td>
	</tr>
	<jsp:useBean id="productSvc" scope="page" class="heibernate_com.product.model.ProductService" />
	<tr>
		<td>商品編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="product_no">
			<c:forEach var="productVO" items="${productSvc.all}">
				<option value="${productVO.product_no}" ${(orders_itemVO.productVO.product_no==productVO.product_no)? 'selected':'' } >${productVO.product_no}
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td>訂購數量:</td>
		<td><input type="TEXT" name="commodities_amount" size="45"
			value="<%= (orders_itemVO==null)? "1" : orders_itemVO.getCommodities_amount()%>" /></td>
	</tr>	
	<tr>
		<td>商品售價:</td>
		<td><input type="TEXT" name="selling_price" size="45"
			value="<%= (orders_itemVO==null)? "1" : orders_itemVO.getSelling_price()%>" /></td>
	</tr>	
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>
</html>

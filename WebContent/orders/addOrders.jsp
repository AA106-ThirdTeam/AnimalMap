<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.orders.model.*"%>
<%
OrdersVO ordersVO = (OrdersVO) request.getAttribute("ordersVO");
%>

<html>
<head>
<title>訂單新增 - addOrders.jsp</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>

<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>訂單新增 - addOrders.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/orders/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>訂單:</h3>
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

<FORM METHOD="post" ACTION="orders.do" name="form1">
<table border="0">
	<tr>
		<td>會員編號:</td>
		<td><input type="TEXT" name="mem_Id" size="45"
			value="<%= (ordersVO==null)? "1" : ordersVO.getMem_Id()%>" /></td>
	</tr>
	<tr>
		<td>收件人:</td>
		<td><input type="TEXT" name="orders_receiver" size="45"
			value="<%= (ordersVO==null)? "1" : ordersVO.getOrders_receiver()%>" /></td>
	</tr>
	<tr>
		<td>郵遞區號:</td>
		<td><input type="TEXT" name="post_no" size="45"
			value="<%= (ordersVO==null)? "1" : ordersVO.getPost_no()%>" /></td>
	</tr>
	<tr>
		<td>縣市:</td>
		<td><input type="TEXT" name="post_adp_city" size="45"
			value="<%= (ordersVO==null)? "1" : ordersVO.getPost_adp_city()%>" /></td>
	</tr>
	<tr>
		<td>鄉鎮:</td>
		<td><input type="TEXT" name="post_town" size="45"
			value="<%= (ordersVO==null)? "1" : ordersVO.getPost_town()%>" /></td>
	</tr>
	<tr>
		<td>路:</td>
		<td><input type="TEXT" name="post_road" size="45"
			value="<%= (ordersVO==null)? "1" : ordersVO.getPost_road()%>" /></td>
	</tr>
	<tr>
		<td>收件人電話:</td>
		<td><input type="TEXT" name="orders_phone" size="45"
			value="<%= (ordersVO==null)? "1" : ordersVO.getOrders_phone()%>" /></td>
	</tr>
	<tr>
		<td>付款方式:</td>
		<td><input type="TEXT" name="collect_mode_no" size="45"
			value="<%= (ordersVO==null)? "1" : ordersVO.getCollect_mode_no()%>" /></td>
	</tr>
	<tr>
		<%java.sql.Date date_orders_date = new java.sql.Date(System.currentTimeMillis());%>
		<td>下單日期:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="orders_date" value="<%= (ordersVO==null)? date_orders_date : ordersVO.getOrders_date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','orders_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="下單日期"></a>
		</td>
	</tr>
	<tr>
		<%java.sql.Date date_orders_ship_date = new java.sql.Date(System.currentTimeMillis());%>
		<td>出貨日期:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="orders_ship_date" value="<%= (ordersVO==null)? date_orders_ship_date : ordersVO.getOrders_ship_date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','orders_ship_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="出貨日期"></a>
		</td>
	</tr>
	<tr>
		<td>總金額:</td>
		<td><input type="TEXT" name="orders_total" size="45"
			value="<%= (ordersVO==null)? "1" : ordersVO.getOrders_total()%>" /></td>
	</tr>
	<tr>
		<td>處理狀態:</td>
		<td><input type="TEXT" name="orders_status" size="45"
			value="<%= (ordersVO==null)? "1" : ordersVO.getOrders_status()%>" /></td>
	</tr>
	<tr>
		<td>信用卡卡號:</td>
		<td><input type="TEXT" name="orders_credit" size="45"
			value="<%= (ordersVO==null)? "1" : ordersVO.getOrders_credit()%>" /></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>

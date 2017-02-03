<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shop_comment.model.*"%>
<%
Shop_commentVO shop_commentVO = (Shop_commentVO) request.getAttribute("shop_commentVO");
%>

<html>
<head>
<title>商家留言新增 - addShop_comment.jsp</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>

<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>商家留言新增 - addShop_comment.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/shop_comment/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>商家留言:</h3>
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

<FORM METHOD="post" ACTION="shop_comment.do" name="form1">
<table border="0">
	<tr>
		<td>發送會員編號:</td>
		<td><input type="TEXT" name="shopComm_MemId" size="45"
			value="<%= (shop_commentVO==null)? "1" : shop_commentVO.getShopComm_MemId()%>" /></td>
	</tr>
	<tr>
		<td>商店編號:</td>
		<td><input type="TEXT" name="shopComm_ShopId" size="45"
			value="<%= (shop_commentVO==null)? "1" : shop_commentVO.getShopComm_ShopId()%>" /></td>
	</tr>
	<tr>
		<td>發送內容:</td>
		<td><input type="TEXT" name="shopComm_content" size="45"
			value="<%= (shop_commentVO==null)? "1" : shop_commentVO.getShopComm_content()%>" /></td>
	</tr>
	<tr>
		<%java.sql.Date date_shopComm_SendTime = new java.sql.Date(System.currentTimeMillis());%>
		<td>發送時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="shopComm_SendTime" value="<%= (shop_commentVO==null)? date_shopComm_SendTime : shop_commentVO.getShopComm_SendTime()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','shopComm_SendTime','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="發送時間"></a>
		</td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product_kind.model.*"%>
<%
Product_kindVO product_kindVO = (Product_kindVO) request.getAttribute("product_kindVO");
%>

<html>
<head>
<title>商品類別新增 - addProduct_kind.jsp</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>

<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>商品類別新增 - addProduct_kind.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/product_kind/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>商品類別:</h3>
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

<FORM METHOD="post" ACTION="product_kind.do" name="form1">
<table border="0">
	<tr>
		<td>商品類別名稱:</td>
		<td><input type="TEXT" name="product_kind_name" size="45"
			value="<%= (product_kindVO==null)? "1" : product_kindVO.getProduct_kind_name()%>" /></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>

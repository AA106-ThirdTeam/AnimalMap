	
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.second_prodphotos.model.*"%>
<%
Second_ProdPhotosVO second_prodphotosVO = (Second_ProdPhotosVO) request.getAttribute("second_prodphotosVO");
%>

<html>
<head>
<title>二手商品相簿新增 - addSecond_ProdPhotos.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back-end/css/calendar.css">
<%@include file="/back-end/js/calendarcode.jsp"%>

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
		<h3>二手商品相簿新增 - addSecond_ProdPhotos.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/back-end/second_prodphotos/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>二手商品相簿:</h3>
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

<FORM METHOD="post" ACTION="second_prodphotos.do" name="form1">
<table border="0">


	<tr>
		<td>二手商品編號:</td>
		<td><input type="TEXT" name="second_Prod_Id" size="45"
			value="<%= (second_prodphotosVO==null)? "1" : second_prodphotosVO.getSecond_Prod_Id()%>" /></td>
	</tr>	


</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.animal_index.model.*"%>
<%
Animal_indexVO animal_indexVO = (Animal_indexVO) request.getAttribute("animal_indexVO");
%>
<html>
<head>
<title>動物圖鑑新增 - addAnimal_index.jsp</title>
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
		<h3>動物圖鑑新增 - addAnimal_index.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/Heibernate_back-end/animal_index/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>
<h3>動物圖鑑:</h3>
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
<FORM METHOD="post" ACTION="animal_index.do" name="form1">
<table border="0">
	<tr>
		<td>圖鑑敘述:</td>
		<td><input type="TEXT" name="animal_detail" size="45"
			value="<%= (animal_indexVO==null)? "1" : animal_indexVO.getAnimal_detail()%>" /></td>
	</tr>	
	<tr>
		<td>圖鑑類別:</td>
		<td><input type="TEXT" name="animal_class" size="45"
			value="<%= (animal_indexVO==null)? "1" : animal_indexVO.getAnimal_class()%>" /></td>
	</tr>	
	<tr>
		<td>圖鑑類別照片編號:</td>
		<td><input type="TEXT" name="animal_class_No" size="45"
			value="<%= (animal_indexVO==null)? "1" : animal_indexVO.getAnimal_class_No()%>" /></td>
	</tr>	
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>
</html>

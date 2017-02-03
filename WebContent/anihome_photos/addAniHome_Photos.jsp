<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.anihome_photos.model.*"%>
<%
AniHome_PhotosVO anihome_photosVO = (AniHome_PhotosVO) request.getAttribute("anihome_photosVO");
%>

<html>
<head>
<title>動物之家相簿新增 - addAniHome_Photos.jsp</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>

<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>動物之家相簿新增 - addAniHome_Photos.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/anihome_photos/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>動物之家相簿:</h3>
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

<FORM METHOD="post" ACTION="anihome_photos.do" name="form1">
<table border="0">
	<tr>
		<td>動物之家編號:</td>
		<td><input type="TEXT" name="aniHome_Id" size="45"
			value="<%= (anihome_photosVO==null)? "1" : anihome_photosVO.getAniHome_Id()%>" /></td>
	</tr>
	<tr>
		<td>動物之家照片:</td>
		<td><input type="file" name="aniHome_Photos_pic" size=45></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>

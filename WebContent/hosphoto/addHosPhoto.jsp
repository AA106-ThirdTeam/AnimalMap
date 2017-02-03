<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.hosphoto.model.*"%>
<%
HosPhotoVO hosphotoVO = (HosPhotoVO) request.getAttribute("hosphotoVO");
%>

<html>
<head>
<title>診所相片新增 - addHosPhoto.jsp</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>

<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>診所相片新增 - addHosPhoto.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/hosphoto/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>診所相片:</h3>
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

<FORM METHOD="post" ACTION="hosphoto.do" name="form1">
<table border="0">
	<tr>
		<td>診所編號(相片擁有診所):</td>
		<td><input type="TEXT" name="hosPhoto_HosId" size="45"
			value="<%= (hosphotoVO==null)? "1" : hosphotoVO.getHosPhoto_HosId()%>" /></td>
	</tr>
	<tr>
		<td>相片:</td>
		<td><input type="file" name="hosPhoto_photo" size=45></td>
	</tr>
	<tr>
		<td>是否為大頭貼相片:</td>
		<td><input type="TEXT" name="isDisp_HosPhoto" size="45"
			value="<%= (hosphotoVO==null)? "1" : hosphotoVO.getIsDisp_HosPhoto()%>" /></td>
	</tr>
	<tr>
		<td>相片名稱:</td>
		<td><input type="TEXT" name="hosPhoto_name" size="45"
			value="<%= (hosphotoVO==null)? "1" : hosphotoVO.getHosPhoto_name()%>" /></td>
	</tr>
	<tr>
		<td>相片副檔名:</td>
		<td><input type="TEXT" name="hosPhoto_extent" size="45"
			value="<%= (hosphotoVO==null)? "1" : hosphotoVO.getHosPhoto_extent()%>" /></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>

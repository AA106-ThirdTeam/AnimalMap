<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.adoanispo.model.*"%>
<%
AdoAniSpoVO adoanispoVO = (AdoAniSpoVO) request.getAttribute("adoanispoVO");
%>

<html>
<head>
<title>送養動物領養人新增 - addAdoAniSpo.jsp</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>

<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>送養動物領養人新增 - addAdoAniSpo.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/adoanispo/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>送養動物領養人:</h3>
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

<FORM METHOD="post" ACTION="adoanispo.do" name="form1">
<table border="0">
	<tr>
		<td>送養動物編號:</td>
		<td><input type="TEXT" name="adoAniSpoAniId" size="45"
			value="<%= (adoanispoVO==null)? "1" : adoanispoVO.getAdoAniSpoAniId()%>" /></td>
	</tr>
	<tr>
		<td>贊助者會員編號:</td>
		<td><input type="TEXT" name="adoAniSpomem_Id" size="45"
			value="<%= (adoanispoVO==null)? "1" : adoanispoVO.getAdoAniSpomem_Id()%>" /></td>
	</tr>
	<tr>
		<td>贊助送養動物金額:</td>
		<td><input type="TEXT" name="adoAniSpoMoney" size="45"
			value="<%= (adoanispoVO==null)? "1" : adoanispoVO.getAdoAniSpoMoney()%>" /></td>
	</tr>
	<tr>
		<td>贊助送養動物物資:</td>
		<td><input type="TEXT" name="adoAniSpoMat" size="45"
			value="<%= (adoanispoVO==null)? "1" : adoanispoVO.getAdoAniSpoMat()%>" /></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>

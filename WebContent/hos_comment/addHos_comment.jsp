<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.hos_comment.model.*"%>
<%
Hos_commentVO hos_commentVO = (Hos_commentVO) request.getAttribute("hos_commentVO");
%>

<html>
<head>
<title>診所留言新增 - addHos_comment.jsp</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>

<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>診所留言新增 - addHos_comment.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/hos_comment/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>診所留言:</h3>
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

<FORM METHOD="post" ACTION="hos_comment.do" name="form1">
<table border="0">
	<tr>
		<td>發送會員編號:</td>
		<td><input type="TEXT" name="hosComm_MemId" size="45"
			value="<%= (hos_commentVO==null)? "1" : hos_commentVO.getHosComm_MemId()%>" /></td>
	</tr>
	<tr>
		<td>診所編號:</td>
		<td><input type="TEXT" name="hosComm_HosId" size="45"
			value="<%= (hos_commentVO==null)? "1" : hos_commentVO.getHosComm_HosId()%>" /></td>
	</tr>
	<tr>
		<td>發送內容:</td>
		<td><input type="TEXT" name="hosComm_content" size="45"
			value="<%= (hos_commentVO==null)? "1" : hos_commentVO.getHosComm_content()%>" /></td>
	</tr>
	<tr>
		<%java.sql.Date date_hosComm_SendTime = new java.sql.Date(System.currentTimeMillis());%>
		<td>發送時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="hosComm_SendTime" value="<%= (hos_commentVO==null)? date_hosComm_SendTime : hos_commentVO.getHosComm_SendTime()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','hosComm_SendTime','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="發送時間"></a>
		</td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.adpmsg.model.*"%>
<%
AdpMsgVO adpmsgVO = (AdpMsgVO) request.getAttribute("adpmsgVO");
%>

<html>
<head>
<title>領養活動留言新增 - addAdpMsg.jsp</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>

<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>領養活動留言新增 - addAdpMsg.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/adpmsg/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>領養活動留言:</h3>
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

<FORM METHOD="post" ACTION="adpmsg.do" name="form1">
<table border="0">
	<tr>
		<td>領養活動編號:</td>
		<td><input type="TEXT" name="adp_Id" size="45"
			value="<%= (adpmsgVO==null)? "1" : adpmsgVO.getAdp_Id()%>" /></td>
	</tr>
	<tr>
		<td>留言會員編號:</td>
		<td><input type="TEXT" name="mem_Id" size="45"
			value="<%= (adpmsgVO==null)? "1" : adpmsgVO.getMem_Id()%>" /></td>
	</tr>
	<tr>
		<td>領養活動留言:</td>
		<td><input type="TEXT" name="msg" size="45"
			value="<%= (adpmsgVO==null)? "1" : adpmsgVO.getMsg()%>" /></td>
	</tr>
	<tr>
		<%java.sql.Date date_adpMsgDate = new java.sql.Date(System.currentTimeMillis());%>
		<td>留言發布日期:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="adpMsgDate" value="<%= (adpmsgVO==null)? date_adpMsgDate : adpmsgVO.getAdpMsgDate()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','adpMsgDate','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="留言發布日期"></a>
		</td>
	</tr>
	<tr>
		<%java.sql.Date date_adpMsgadp_upDate = new java.sql.Date(System.currentTimeMillis());%>
		<td>留言更新日期:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="adpMsgadp_upDate" value="<%= (adpmsgVO==null)? date_adpMsgadp_upDate : adpmsgVO.getAdpMsgadp_upDate()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','adpMsgadp_upDate','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="留言更新日期"></a>
		</td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>
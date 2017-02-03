<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.anihome_msg.model.*"%>
<%
AniHome_MsgVO anihome_msgVO = (AniHome_MsgVO) request.getAttribute("anihome_msgVO");
%>

<html>
<head>
<title>動物之家留言新增 - addAniHome_Msg.jsp</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>

<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>動物之家留言新增 - addAniHome_Msg.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/anihome_msg/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>動物之家留言:</h3>
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

<FORM METHOD="post" ACTION="anihome_msg.do" name="form1">
<table border="0">
	<tr>
		<td>動物之家編號:</td>
		<td><input type="TEXT" name="aniHome_Id" size="45"
			value="<%= (anihome_msgVO==null)? "1" : anihome_msgVO.getAniHome_Id()%>" /></td>
	</tr>
	<tr>
		<td>留言會員編號:</td>
		<td><input type="TEXT" name="mem_Id" size="45"
			value="<%= (anihome_msgVO==null)? "1" : anihome_msgVO.getMem_Id()%>" /></td>
	</tr>
	<tr>
		<td>動物之家留言:</td>
		<td><input type="TEXT" name="aniHome_Msg" size="45"
			value="<%= (anihome_msgVO==null)? "1" : anihome_msgVO.getAniHome_Msg()%>" /></td>
	</tr>
	<tr>
		<%java.sql.Date date_adp_start_date = new java.sql.Date(System.currentTimeMillis());%>
		<td>留言發布日期:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="adp_start_date" value="<%= (anihome_msgVO==null)? date_adp_start_date : anihome_msgVO.getAdp_start_date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','adp_start_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="留言發布日期"></a>
		</td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>

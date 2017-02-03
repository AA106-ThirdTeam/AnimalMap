<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.res_ponse.model.*"%>
<%
Res_ponseVO res_ponseVO = (Res_ponseVO) request.getAttribute("res_ponseVO");
%>

<html>
<head>
<title>討論區留言新增 - addRes_ponse.jsp</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>

<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>討論區留言新增 - addRes_ponse.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/res_ponse/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>討論區留言:</h3>
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

<FORM METHOD="post" ACTION="res_ponse.do" name="form1">
<table border="0">
	<tr>
		<td>會員編號(發文者):</td>
		<td><input type="TEXT" name="mem_Id" size="45"
			value="<%= (res_ponseVO==null)? "1" : res_ponseVO.getMem_Id()%>" /></td>
	</tr>
	<tr>
		<td>文章編號:</td>
		<td><input type="TEXT" name="post_Id" size="45"
			value="<%= (res_ponseVO==null)? "1" : res_ponseVO.getPost_Id()%>" /></td>
	</tr>
	<tr>
		<td>文章留言內容:</td>
		<td><input type="TEXT" name="res_ponse_content" size="45"
			value="<%= (res_ponseVO==null)? "1" : res_ponseVO.getRes_ponse_content()%>" /></td>
	</tr>
	<tr>
		<%java.sql.Date date_post_time = new java.sql.Date(System.currentTimeMillis());%>
		<td>發佈時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="post_time" value="<%= (res_ponseVO==null)? date_post_time : res_ponseVO.getPost_time()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','post_time','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="發佈時間"></a>
		</td>
	</tr>
	<tr>
		<%java.sql.Date date_res_ponse_upDate = new java.sql.Date(System.currentTimeMillis());%>
		<td>修改時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="res_ponse_upDate" value="<%= (res_ponseVO==null)? date_res_ponse_upDate : res_ponseVO.getRes_ponse_upDate()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','res_ponse_upDate','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="修改時間"></a>
		</td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>

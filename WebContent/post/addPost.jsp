<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.post.model.*"%>
<%
PostVO postVO = (PostVO) request.getAttribute("postVO");
%>

<html>
<head>
<title>討論區新增 - addPost.jsp</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>

<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>討論區新增 - addPost.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/post/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>討論區:</h3>
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

<FORM METHOD="post" ACTION="post.do" name="form1">
<table border="0">
	<tr>
		<td>會員編號(發文者):</td>
		<td><input type="TEXT" name="mem_Id" size="45"
			value="<%= (postVO==null)? "1" : postVO.getMem_Id()%>" /></td>
	</tr>
	<tr>
		<td>文章分類:</td>
		<td><input type="TEXT" name="post_class" size="45"
			value="<%= (postVO==null)? "1" : postVO.getPost_class()%>" /></td>
	</tr>
	<tr>
		<td>文章分類編號:</td>
		<td><input type="TEXT" name="post_class_Id" size="45"
			value="<%= (postVO==null)? "1" : postVO.getPost_class_Id()%>" /></td>
	</tr>
	<tr>
		<td>文章標題:</td>
		<td><input type="TEXT" name="post_title" size="45"
			value="<%= (postVO==null)? "1" : postVO.getPost_title()%>" /></td>
	</tr>
	<tr>
		<td>文章內容:</td>
		<td><input type="TEXT" name="post_content" size="45"
			value="<%= (postVO==null)? "1" : postVO.getPost_content()%>" /></td>
	</tr>
	<tr>
		<%java.sql.Date date_post_time = new java.sql.Date(System.currentTimeMillis());%>
		<td>發佈時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="post_time" value="<%= (postVO==null)? date_post_time : postVO.getPost_time()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','post_time','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="發佈時間"></a>
		</td>
	</tr>
	<tr>
		<%java.sql.Date date_post_upDate = new java.sql.Date(System.currentTimeMillis());%>
		<td>修改時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="post_upDate" value="<%= (postVO==null)? date_post_upDate : postVO.getPost_upDate()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','post_upDate','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="修改時間"></a>
		</td>
	</tr>
	<tr>
		<td>回覆數量:</td>
		<td><input type="TEXT" name="post_resNum" size="45"
			value="<%= (postVO==null)? "1" : postVO.getPost_resNum()%>" /></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>

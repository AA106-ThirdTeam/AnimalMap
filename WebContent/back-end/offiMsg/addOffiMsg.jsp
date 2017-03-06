<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.offiMsg.model.*" %>
<%
OffiMsgVO offiMsgVO = (OffiMsgVO) request.getAttribute("OffiMsgVO");
%>

<html>
<head>
<title>訊息新增 - addOffiMsg.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>訊息新增 - addOffiMsg.jsp</h3>
		</td>
		<td>
				<a href="<%=request.getContextPath()%>/back-end/offiMsg/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
		
	    </td>
	</tr>
</table>

<h3>訊息資料:</h3>
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

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/offiMsg/offiMsg.do" name="form1">
<table border="0">

 <jsp:useBean id="offiMsgSvc" scope="page" class="com.offiMsg.model.OffiMsgService" />
	
	<tr>
		<td>發布員工編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="offiMsg_empId">
			<c:forEach var="offiMsgVO" items="${offiMsgSvc.all}">
				<option value="${offiMsgVO.offiMsg_empId}">${offiMsgVO.offiMsg_empId}
			</c:forEach>
		</select></td>
			</tr>
	
	<tr>
		<td>訊息標題:</td>
		<td>
			<input type="TEXT" name="offiMsg_Title" size="45" 
			onfocus="if(value =='請輸入訊息標題'){value=''}"
			onblur="if(value ==''){value='請輸入訊息標題'}"
			value="<%=(offiMsgVO == null) ? "請輸入訊息標題" : offiMsgVO.getOffiMsg_Title() %>" />
		</td>
	</tr>
	<tr>
		<td>文章內容</td>
		<td><textarea rows="10" name="offiMsg_Content" class="content"
			value="<%=(offiMsgVO == null) ? "" : offiMsgVO.getOffiMsg_Content()%>"></textarea></td>
	</tr>
	<tr>
		<%
		java.sql.Date date_SQL = new java.sql.Date(System.currentTimeMillis());
		%>
		<td>訊息發布時間:</td>
		<td><input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text"
			name="offiMsg_Date"
			value="<%= (offiMsgVO == null) ? date_SQL : offiMsgVO.getOffiMsg_Date()%>">
			<a class="so-BtnLink" href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','offiMsg_Date','BTN_date');return false;">
			</a></td>
	</tr>
	

</table>
<br>
<br> <input type="hidden" name="offiMsg_Date" value="<%=date_SQL%>">
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>

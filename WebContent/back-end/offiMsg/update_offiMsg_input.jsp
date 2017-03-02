<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.offiMsg.model.*" %>
<%
OffiMsgVO offiMsgVO = (OffiMsgVO) request.getAttribute("offiMsgVO"); //OffiMsgServlet.java (Concroller), 存入req的OffiMsgVO物件 (包括幫忙取出的OffiMsgVO, 也包括輸入資料錯誤時的OffiMsgVO物件)
%>
<html>
<head>
<title>訊息資料修改 - update_offiMsg_input.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>訊息資料修改 - update_offiMsg_input.jsp</h3>
		<a href="<%=request.getContextPath()%>/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></td>
	</tr>
</table>

<h3>訊息資料修改:</h3>
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
	<tr>
		<td>訊息編號:<font color=red><b>*</b></font></td>
		<td><%=offiMsgVO.getOffiMsg_Id()%></td>
	</tr>
	<tr>
		<td>發布員工編號:<font color=red><b>*</b></font></td>
		<td><%=offiMsgVO.getOffiMsg_empId()%></td>
	</tr>
	<tr>
		<td>訊息標題:</td>
		<td><input type="TEXT" name="offiMsg_Title" size="45"	value="<%=offiMsgVO.getOffiMsg_Title()%>" /></td>
	</tr>
	
	<tr>
		<td>訊息內容:</td>
		<td><input type="TEXT" name="offiMsg_Content" size="45"	value="<%=offiMsgVO.getOffiMsg_Content()%>" /></td>
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
<input type="hidden" name="action" value="update">
<input type="hidden" name="offiMsg_Id" value="<%=offiMsgVO.getOffiMsg_Id()%>">
<input type="hidden" name="offiMsg_empId" value="<%=offiMsgVO.getOffiMsg_empId()%>">

<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
<input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--只用於:istAll.jsp-->
<input type="submit" value="送出修改"></FORM>

<br>送出修改的來源網頁路徑:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
   <font color=blue>request.getParameter("whichPage"):</font> <%= request.getParameter("whichPage")%> (此範例目前只用於:istAllEmp.jsp))</b>
</body>
</html>

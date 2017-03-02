<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.offimsg.model.*"%>
<%
OffiMsgVO offimsgVO = (OffiMsgVO) request.getAttribute("offimsgVO");
%>
<html>
<head>
<title>系統訊息新增 - addOffiMsg.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<!-- 共用HEAD -->
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
</head>
<body bgcolor='white'>
<!--  -->
<div id="popupcalendar" class="text"></div>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>系統訊息新增 - addOffiMsg.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/Heibernate_back-end/offimsg/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>
<h3>系統訊息:</h3>
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
<FORM METHOD="post" ACTION="offimsg.do" name="form1">
<table border="0">
	<jsp:useBean id="empSvc" scope="page" class="heibernate_com.emp.model.EmpService" />
	<tr>
		<td>發布員工編號:<font color=red><b>*</b></font></td>
		<td><select size="1" name="emp_No">
			<c:forEach var="empVO" items="${empSvc.all}">
				<option value="${empVO.emp_No}" ${(offimsgVO.empVO.emp_No==empVO.emp_No)? 'selected':'' } >${empVO.emp_No}
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td>訊息標題:</td>
		<td><input type="TEXT" name="offiMsg_Title" size="45"
			value="<%= (offimsgVO==null)? "1" : offimsgVO.getOffiMsg_Title()%>" /></td>
	</tr>	
	<tr>
		<td>訊息內容:</td>
		<td><input type="TEXT" name="offiMsg_Content" size="45"
			value="<%= (offimsgVO==null)? "1" : offimsgVO.getOffiMsg_Content()%>" /></td>
	</tr>	
	<tr>
		<%java.sql.Date date_offiMsg_Date = new java.sql.Date(System.currentTimeMillis());%>
		<td>訊息發布時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="offiMsg_Date" value="<%= (offimsgVO==null)? date_offiMsg_Date : offimsgVO.getOffiMsg_Date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','offiMsg_Date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="/Excel2MVC/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="訊息發布時間"></a>
		</td>
	</tr>
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>
</html>

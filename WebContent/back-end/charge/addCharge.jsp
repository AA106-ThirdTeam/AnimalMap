	
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.charge.model.*"%>
<%
ChargeVO chargeVO = (ChargeVO) request.getAttribute("chargeVO");
%>

<html>
<head>
<title>儲值新增 - addCharge.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back-end/css/calendar.css">
<%@include file="/back-end/js/calendarcode.jsp"%>

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
		<h3>儲值新增 - addCharge.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/back-end/charge/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>儲值:</h3>
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

<FORM METHOD="post" ACTION="charge.do" name="form1">
<table border="0">


	<tr>
		<td>會員編號:</td>
		<td><input type="TEXT" name="mem_Id" size="45"
			value="<%= (chargeVO==null)? "1" : chargeVO.getMem_Id()%>" /></td>
	</tr>	


	<tr>
		<td>儲值金額:</td>
		<td><input type="TEXT" name="charge_NUMBER" size="45"
			value="<%= (chargeVO==null)? "1" : chargeVO.getCharge_NUMBER()%>" /></td>
	</tr>	


	<tr>
		<td>付款方式:</td>
		<td><input type="TEXT" name="pay" size="45"
			value="<%= (chargeVO==null)? "1" : chargeVO.getPay()%>" /></td>
	</tr>	

	
	<tr>
		<%java.sql.Date date_applytime = new java.sql.Date(System.currentTimeMillis());%>
		<td>儲值時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="applytime" value="<%= (chargeVO==null)? date_applytime : chargeVO.getApplytime()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','applytime','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="/Excel2MVC/back-end/images/btn_date_up.gif" width="22" height="17" alt="儲值時間"></a>
		</td>
	</tr>


</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>

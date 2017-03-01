<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.charge.model.*"%>
<%
	ChargeVO chargeVO = (ChargeVO) request.getAttribute("chargeVO");
%>

<html>
<head>
<title>資料新增</title>
</head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<div id="popupcalendar" class="text"></div>
<body>
	<h1>addCharge.jsp</h1>
	<table border='1' cellpadding='5' cellspacing='0' width='800'>
		<tr bgcolor='#ccccff' align='center' valign='middle' height='20'>
			<td>
				<h3>資料新增 - addCharge</h3>
			</td>
			<td><a href="<%=request.getContextPath()%>/back-end/select_page.jsp"><img
					src="<%=request.getContextPath()%>/back-end/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
			</td>
		</tr>
	</table>
	<h3>資料</h3>
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
			<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
			<tr>
				<!--會員編號 -->
				<td>會員編號<font color=red><b>*</b></font></td>
				<td><select size="1" name="mem_Id">
				<c:forEach var="memVO" items="${memSvc.all}">
					<option value="${memVO.mem_Id}"
					${(chargeVO.mem_Id==memVO.mem_Id)? 'selected':'' }>${memVO.mem_Id}
				</c:forEach></select></td>
			</tr>
			<tr>
				<!-- 儲值金額 -->
				<td>儲值金額</td>
				<td><input type="TEXT" name="charge_number" size="45"
					value="<%=(chargeVO == null) ? "500" : chargeVO.getCharge_number()%>" />
				</td>
			</tr>
			<tr>
				<!-- 付款方式 -->
				<td>付款方式</td>
				<td><select name="pay">
						<option value="<%=(chargeVO == null) ? "1" : chargeVO.getPay()%>">1-ATM</option>>
						<option value="<%=(chargeVO == null) ? "2" : chargeVO.getPay()%>">2-超商</option>>
					</select>
				</td>
			</tr>
			<tr>
				<%
					java.sql.Date date_SQL = new java.sql.Date(System.currentTimeMillis());
				%>
				<!-- 儲值時間 -->
				<td>儲值時間：</td>
				<td bgcolor="#CCCCFF"><input class="cal-TextBox"
					onFocus="this.blur()" size="9" readonly type="text"
					name="applytime" value="<%=(chargeVO == null) ? date_SQL : chargeVO.getApplytime()%>"	>
					<a class="so-BtnLink" href="javascript:calClick();return false;"
					onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
					onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
					onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','applytime','BTN_date');return false;">
						<img align="middle" border="0" name="BTN_date"
						src="images/btn_date_up.gif" width="22" height="17" alt="開始日期">
				</a>
				</td>
			</tr>		
		</table>
		<input type="hidden" name="action" value="insert">
		<input type="submit" value="送出新增">
	</FORM>
</body>
</html>
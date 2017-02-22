<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emp.model.*"%>
<%
EmpVO empVO = (EmpVO) request.getAttribute("empVO");
%>

<html>
<head>
<title>員工資料新增 - addEmp.jsp</title>
</head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
				<h3>員工資料新增 - addEmp.jsp</h3>
			</td>
			<td><a href="<%=request.getContextPath() %>/back-end/emp/select_page.jsp"><img src="images/tomcat.gif"
					width="100" height="100" border="1">回首頁</a></td>
		</tr>
	</table>

	<h3>資料員工:</h3>
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

	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/emp/emp.do" name="form1"
		enctype="multipart/form-data">
		<table border="0">

			<tr>
				<td>上傳頭像:</td>
				<td><input type="file" name="emp_picture" /></td>

			</tr>


			<tr>
				<td>員工姓名:</td>
				<td><input type="TEXT" name="emp_name" size="45"
					value="<%= (empVO==null)? "吳永志" : empVO.getEmp_name()%>" /></td>
			</tr>

			<tr>
				<td>員工信箱:</td>
				<td><input type="TEXT" name="emp_email" size="45"
					value="<%= (empVO==null)? "justlovedance@gmail.com" : empVO.getEmp_email()%>" /></td>
			</tr>
			<tr>
				<td>員工ID:</td>
				<td><input type="TEXT" name="emp_Id" size="45"
					value="<%= (empVO==null)? "test123" : empVO.getEmp_Id()%>" /></td>
			</tr>
			<tr>
				<%java.sql.Date date_SQL = new java.sql.Date(System.currentTimeMillis());%>
				<td>出生日期:</td>
				<td bgcolor="#CCCCFF"><input class="cal-TextBox"
					onFocus="this.blur()" size="9" readonly type="text"
					name="emp_birthday"
					value="<%= (empVO==null)? date_SQL : empVO.getEmp_birthday()%>">
					<a class="so-BtnLink" href="javascript:calClick();return false;"
					onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
					onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
					onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','emp_birthday','BTN_date');return false;">
						<img align="middle" border="0" name="BTN_date"
						src="images/btn_date_up.gif" width="22" height="17" alt="開始日期">
				</a></td>
			</tr>
			<tr>
				<td>電話:</td>
				<td><input type="TEXT" name="emp_phone" size="45"
					value="<%= (empVO==null)? "0123456789" : empVO.getEmp_phone()%>" /></td>
			</tr>
			<tr>
				<td>住址:</td>
				<td><input type="TEXT" name="emp_address" size="45"
					value="<%= (empVO==null)? "台北市" : empVO.getEmp_address()%>" /></td>
			</tr>



			<tr>
				<td>員工狀態:<font color=red><b>*</b></font></td>
				<td>在職 <input type="radio" name="emp_status" value="1"
					${(empVO==null)?'checked':'chrcked'} /></td>


			</tr>
			<tr>
				<%java.sql.Date date_SQL2 = new java.sql.Date(System.currentTimeMillis());%>
				<td>雇用日期:</td>


				<td><input type="date" name="emp_hiredate"
					value="<%= (empVO==null)? date_SQL2 : empVO.getEmp_hiredate()%>"></td>


			</tr>


		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="送出新增">
	</FORM>
</body>

</html>

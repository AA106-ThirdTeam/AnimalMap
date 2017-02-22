<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.emp.model.*"%>
<%
    EmpVO empVO = (EmpVO) request.getAttribute("empVO"); //EmpServlet.java (Concroller), 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>
<!--  -->
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
<html>
<head>
	<!-- 共用HEAD -->
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
	<title>員工資料修改 - update_emp_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>員工資料 - ListOneEmp.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/emp/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<h3>資料修改:</h3>
<FORM METHOD="post" ACTION="emp.do" name="form1">
    <table border="0">
    <!--  -->
    <tr>
        <td>員工編號編號:<font color=red><b>*</b></font></td>
        <td><%=empVO.getEmp_No()%></td>
    </tr>
    <tr>
        <td>員工姓名:</td>
        <td><input type="TEXT" name="emp_name" size="45" value="<%=empVO.getEmp_name()%>" /></td>
    </tr>
    <tr>
        <td>員工密碼:</td>
        <td><input type="TEXT" name="emp_Pw" size="45" value="<%=empVO.getEmp_Pw()%>" /></td>
    </tr>
    <tr>
        <td>員工信箱:</td>
        <td><input type="TEXT" name="emp_email" size="45" value="<%=empVO.getEmp_email()%>" /></td>
    </tr>
    <tr>
        <td>員工身分證:</td>
        <td><input type="TEXT" name="emp_Id" size="45" value="<%=empVO.getEmp_Id()%>" /></td>
    </tr>
	<tr>
		<td>員工出生年月日:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="emp_birthday" value="<%=empVO.getEmp_birthday()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','emp_birthday','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="員工出生年月日"></a>
		</td>
	</tr>
    <tr>
        <td>員工電話:</td>
        <td><input type="TEXT" name="emp_phone" size="45" value="<%=empVO.getEmp_phone()%>" /></td>
    </tr>
    <tr>
        <td>員工地址:</td>
        <td><input type="TEXT" name="emp_address" size="45" value="<%=empVO.getEmp_address()%>" /></td>
    </tr>
    <tr>
        <td>員工狀態:</td>
        <td><input type="TEXT" name="emp_status" size="45" value="<%=empVO.getEmp_status()%>" /></td>
    </tr>
    <tr>
        <td>員工照片:</td>
        <td><input type="TEXT" name="emp_picture" size="45" value="<%=empVO.getEmp_picture()%>" /></td>
    </tr>
    <tr>
        <td>員工照片副檔名:</td>
        <td><input type="TEXT" name="emp_Pic_format" size="45" value="<%=empVO.getEmp_Pic_format()%>" /></td>
    </tr>
	<tr>
		<td>雇用日期:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="emp_hiredate" value="<%=empVO.getEmp_hiredate()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','emp_hiredate','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="雇用日期"></a>
		</td>
	</tr>
	<tr>
		<td>離職日期:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="emp_firedate" value="<%=empVO.getEmp_firedate()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','emp_firedate','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="離職日期"></a>
		</td>
	</tr>
    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
			<input type="hidden" name="emp_No" value="<%=empVO.getEmp_No()%>">	
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁path後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllEmp.jsp 與 複合查詢 listEmps_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>
<br>送出修改的來源網頁path:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>

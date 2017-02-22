<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.report.model.*"%>
<%
    ReportVO reportVO = (ReportVO) request.getAttribute("reportVO"); //ReportServlet.java (Concroller), 存入req的reportVO物件 (包括幫忙取出的reportVO, 也包括輸入資料錯誤時的reportVO物件)
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
	<title>檢舉資料修改 - update_report_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>檢舉資料 - ListOneReport.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/report/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<h3>資料修改:</h3>
<FORM METHOD="post" ACTION="report.do" name="form1">
    <table border="0">
    <!--  -->
    <tr>
        <td>檢舉編號編號:<font color=red><b>*</b></font></td>
        <td><%=reportVO.getReport_No()%></td>
    </tr>
    <tr>
        <td>檢舉名稱:</td>
        <td><input type="TEXT" name="report_name" size="45" value="<%=reportVO.getReport_name()%>" /></td>
    </tr>
    <tr>
        <td>檢舉類別:</td>
        <td><input type="TEXT" name="report_class" size="45" value="<%=reportVO.getReport_class()%>" /></td>
    </tr>
    <tr>
        <td>檢舉類別編號:</td>
        <td><input type="TEXT" name="report_class_No" size="45" value="<%=reportVO.getReport_class_No()%>" /></td>
    </tr>
    <tr>
        <td>檢舉類別編號值:</td>
        <td><input type="TEXT" name="report_class_No_value" size="45" value="<%=reportVO.getReport_class_No_value()%>" /></td>
    </tr>
    <tr>
        <td>檢舉內容:</td>
        <td><input type="TEXT" name="report_content" size="45" value="<%=reportVO.getReport_content()%>" /></td>
    </tr>
    <tr>
        <td>檢舉狀態:</td>
        <td><input type="TEXT" name="report_status" size="45" value="<%=reportVO.getReport_status()%>" /></td>
    </tr>
<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
	<tr>
		<td>檢舉人ID:<font color=red><b>*</b></font></td>
		<td>
	       <select size="1" name="mem_Id_active">
	         <c:forEach var="memVO" items="${memSvc.all}" > 
				<option value="${memVO.mem_Id}" ${(reportVO.memVO.mem_Id==memVO.mem_Id)?'selected':'' } >
${memVO.mem_Id}				
	         </c:forEach>   
	       </select>			
		</td>
	</tr>
	<tr>
		<td>被檢舉人ID:<font color=red><b>*</b></font></td>
		<td>
	       <select size="1" name="mem_Id_passive">
	         <c:forEach var="memVO" items="${memSvc.all}" > 
				<option value="${memVO.mem_Id}" ${(reportVO.memVO.mem_Id==memVO.mem_Id)?'selected':'' } >
${memVO.mem_Id}				
	         </c:forEach>   
	       </select>			
		</td>
	</tr>
	<tr>
		<td>檢舉時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="report_time" value="<%=reportVO.getReport_time()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','report_time','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="檢舉時間"></a>
		</td>
	</tr>
    <tr>
        <td>檢舉類別的狀態:</td>
        <td><input type="TEXT" name="report_class_status" size="45" value="<%=reportVO.getReport_class_status()%>" /></td>
    </tr>
    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
			<input type="hidden" name="report_No" value="<%=reportVO.getReport_No()%>">	
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁path後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllReport.jsp 與 複合查詢 listReports_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>
<br>送出修改的來源網頁path:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>

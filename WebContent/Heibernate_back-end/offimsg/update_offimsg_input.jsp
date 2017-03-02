<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.offimsg.model.*"%>
<%
    OffiMsgVO offimsgVO = (OffiMsgVO) request.getAttribute("offimsgVO"); //OffiMsgServlet.java (Concroller), 存入req的offimsgVO物件 (包括幫忙取出的offimsgVO, 也包括輸入資料錯誤時的offimsgVO物件)
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
	<title>系統訊息資料修改 - update_offimsg_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>系統訊息資料 - ListOneOffiMsg.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/offimsg/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<h3>資料修改:</h3>
<FORM METHOD="post" ACTION="offimsg.do" name="form1">
    <table border="0">
    <!--  -->
    <tr>
        <td>訊息編號編號:<font color=red><b>*</b></font></td>
        <td><%=offimsgVO.getOffiMsg_Id()%></td>
    </tr>
<jsp:useBean id="empSvc" scope="page" class="heibernate_com.emp.model.EmpService" />
	<tr>
		<td>發布員工編號:<font color=red><b>*</b></font></td>
		<td>
	       <select size="1" name="offiMsg_empId">
	         <c:forEach var="empVO" items="${empSvc.all}" > 
				<option value="${empVO.emp_No}" ${(offimsgVO.empVO.emp_No==empVO.emp_No)?'selected':'' } >
${empVO.emp_No}				
	         </c:forEach>   
	       </select>			
		</td>
	</tr>
    <tr>
        <td>訊息標題:</td>
        <td><input type="TEXT" name="offiMsg_Title" size="45" value="<%=offimsgVO.getOffiMsg_Title()%>" /></td>
    </tr>
    <tr>
        <td>訊息內容:</td>
        <td><input type="TEXT" name="offiMsg_Content" size="45" value="<%=offimsgVO.getOffiMsg_Content()%>" /></td>
    </tr>
	<tr>
		<td>訊息發布時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="offiMsg_Date" value="<%=offimsgVO.getOffiMsg_Date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','offiMsg_Date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="訊息發布時間"></a>
		</td>
	</tr>
    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
			<input type="hidden" name="offiMsg_Id" value="<%=offimsgVO.getOffiMsg_Id()%>">	
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁path後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllOffiMsg.jsp 與 複合查詢 listOffiMsgs_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>
<br>送出修改的來源網頁path:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>

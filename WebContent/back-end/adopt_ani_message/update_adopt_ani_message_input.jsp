	
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.adopt_ani_message.model.*"%>
<%
    Adopt_Ani_messageVO adopt_ani_messageVO = (Adopt_Ani_messageVO) request.getAttribute("adopt_ani_messageVO"); //Adopt_Ani_messageServlet.java (Concroller), 存入req的adopt_ani_messageVO物件 (包括幫忙取出的adopt_ani_messageVO, 也包括輸入資料錯誤時的adopt_ani_messageVO物件)
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

	<title>送養動物留言資料修改 - update_adopt_ani_message_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back-end/css/calendar.css">
	<%@include file="/back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>送養動物留言資料 - ListOneAdopt_Ani_message.jsp</h3>
        <a href="<%=request.getContextPath()%>/back-end/adopt_ani_message/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>

<h3>資料修改:</h3>

<FORM METHOD="post" ACTION="adopt_ani_message.do" name="form1">
    <table border="0">

    <!--  -->
	
    <tr>
        <td>送養動物留言編號編號:<font color=red><b>*</b></font></td>
        <td><%=adopt_ani_messageVO.getAdo_Ani_Mes_No()%></td>
    </tr>
	
    <tr>
        <td>社區動物編號:</td>
        <td><input type="TEXT" name="adopt_Ani_Id" size="45" value="<%=adopt_ani_messageVO.getAdopt_Ani_Id()%>" /></td>
    </tr>
	
    <tr>
        <td>送養動物會員編號:</td>
        <td><input type="TEXT" name="mem_Id" size="45" value="<%=adopt_ani_messageVO.getMem_Id()%>" /></td>
    </tr>
	
    <tr>
        <td>送養動物留言:</td>
        <td><input type="TEXT" name="ado_Ani_Mes" size="45" value="<%=adopt_ani_messageVO.getAdo_Ani_Mes()%>" /></td>
    </tr>
	
	<tr>
		<td>發布時間:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="ado_Ani_Mes_time" value="<%=adopt_ani_messageVO.getAdo_Ani_Mes_time()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','ado_Ani_Mes_time','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/back-end/images/btn_date_up.gif" width="22" height="17" alt="發布時間"></a>
		</td>
	</tr>


    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="ado_Ani_Mes_No" value="<%=adopt_ani_messageVO.getAdo_Ani_Mes_No()%>">
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllAdopt_Ani_message.jsp 與 複合查詢 listAdopt_Ani_messages_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>

<br>送出修改的來源網頁路徑:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>

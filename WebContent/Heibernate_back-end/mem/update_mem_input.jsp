<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.mem.model.*"%>
<%
    MemVO memVO = (MemVO) request.getAttribute("memVO"); //MemServlet.java (Concroller), 存入req的memVO物件 (包括幫忙取出的memVO, 也包括輸入資料錯誤時的memVO物件)
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
	<title>一般會員資料修改 - update_mem_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>一般會員資料 - ListOneMem.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/mem/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<h3>資料修改:</h3>
<FORM METHOD="post" ACTION="mem.do" name="form1">
    <table border="0">
    <!--  -->
    <tr>
        <td>會員編號編號:<font color=red><b>*</b></font></td>
        <td><%=memVO.getMem_Id()%></td>
    </tr>
    <tr>
        <td>帳號:</td>
        <td><input type="TEXT" name="mem_account" size="45" value="<%=memVO.getMem_account()%>" /></td>
    </tr>
    <tr>
        <td>信箱:</td>
        <td><input type="TEXT" name="mem_email" size="45" value="<%=memVO.getMem_email()%>" /></td>
    </tr>
    <tr>
        <td>密碼:</td>
        <td><input type="TEXT" name="mem_Psw" size="45" value="<%=memVO.getMem_Psw()%>" /></td>
    </tr>
    <tr>
        <td>會員暱稱:</td>
        <td><input type="TEXT" name="mem_nick_name" size="45" value="<%=memVO.getMem_nick_name()%>" /></td>
    </tr>
    <tr>
        <td>姓名:</td>
        <td><input type="TEXT" name="mem_name" size="45" value="<%=memVO.getMem_name()%>" /></td>
    </tr>
    <tr>
        <td>性別:</td>
        <td><input type="TEXT" name="mem_gender" size="45" value="<%=memVO.getMem_gender()%>" /></td>
    </tr>
    <tr>
        <td>身份證字號:</td>
        <td><input type="TEXT" name="mem_Tw_Id" size="45" value="<%=memVO.getMem_Tw_Id()%>" /></td>
    </tr>
	<tr>
		<td>出生年月日:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="mem_birth_date" value="<%=memVO.getMem_birth_date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','mem_birth_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="出生年月日"></a>
		</td>
	</tr>
    <tr>
        <td>手機:</td>
        <td><input type="TEXT" name="mem_phone" size="45" value="<%=memVO.getMem_phone()%>" /></td>
    </tr>
    <tr>
        <td>個人簡介:</td>
        <td><input type="TEXT" name="mem_Intro" size="45" value="<%=memVO.getMem_Intro()%>" /></td>
    </tr>
	<tr>
		<td>大頭照:</td>
		<td><input type="file" name="mem_profile" size=45></td>
	</tr>	
    <tr>
        <td>黑名單:</td>
        <td><input type="TEXT" name="mem_black_list" size="45" value="<%=memVO.getMem_black_list()%>" /></td>
    </tr>
    <tr>
        <td>權限:</td>
        <td><input type="TEXT" name="mem_permission" size="45" value="<%=memVO.getMem_permission()%>" /></td>
    </tr>
    <tr>
        <td>偏好設定:</td>
        <td><input type="TEXT" name="mem_setting" size="45" value="<%=memVO.getMem_setting()%>" /></td>
    </tr>
    <tr>
        <td>餘額:</td>
        <td><input type="TEXT" name="mem_balance" size="45" value="<%=memVO.getMem_balance()%>" /></td>
    </tr>	
    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="mem_Id" value="<%=memVO.getMem_Id()%>">
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁path後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllMem.jsp 與 複合查詢 listMems_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>
<br>送出修改的來源網頁path:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>

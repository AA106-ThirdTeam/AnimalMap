<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.mem.model.*"%>
<%
MemVO memVO = (MemVO) request.getAttribute("memVO");
%>

<html>
<head>
<title>一般會員新增 - addMem.jsp</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="js/calendarcode.jsp"%>

<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>一般會員新增 - addMem.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/mem/select_page.jsp"><img src="<%=request.getContextPath()%>/images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>一般會員:</h3>
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

<FORM METHOD="post" ACTION="mem.do" name="form1">
<table border="0">
	<tr>
		<td>帳號:</td>
		<td><input type="TEXT" name="mem_account" size="45"
			value="<%= (memVO==null)? "1" : memVO.getMem_account()%>" /></td>
	</tr>
	<tr>
		<td>密碼:</td>
		<td><input type="TEXT" name="mem_Psw" size="45"
			value="<%= (memVO==null)? "1" : memVO.getMem_Psw()%>" /></td>
	</tr>
	<tr>
		<td>會員暱稱:</td>
		<td><input type="TEXT" name="mem_nick_name" size="45"
			value="<%= (memVO==null)? "1" : memVO.getMem_nick_name()%>" /></td>
	</tr>
	<tr>
		<td>姓名:</td>
		<td><input type="TEXT" name="mem_name" size="45"
			value="<%= (memVO==null)? "1" : memVO.getMem_name()%>" /></td>
	</tr>
	<tr>
		<td>性別:</td>
		<td><input type="TEXT" name="mem_gender" size="45"
			value="<%= (memVO==null)? "1" : memVO.getMem_gender()%>" /></td>
	</tr>
	<tr>
		<td>身份證字號:</td>
		<td><input type="TEXT" name="mem_Tw_Id" size="45"
			value="<%= (memVO==null)? "1" : memVO.getMem_Tw_Id()%>" /></td>
	</tr>
	<tr>
		<%java.sql.Date date_mem_birth_date = new java.sql.Date(System.currentTimeMillis());%>
		<td>出生年月日:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="mem_birth_date" value="<%= (memVO==null)? date_mem_birth_date : memVO.getMem_birth_date()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','mem_birth_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="<%=request.getContextPath()%>/images/btn_date_up.gif" width="22" height="17" alt="出生年月日"></a>
		</td>
	</tr>
	<tr>
		<td>手機:</td>
		<td><input type="TEXT" name="mem_phone" size="45"
			value="<%= (memVO==null)? "1" : memVO.getMem_phone()%>" /></td>
	</tr>
	<tr>
		<td>個人簡介:</td>
		<td><input type="TEXT" name="mem_Intro" size="45"
			value="<%= (memVO==null)? "1" : memVO.getMem_Intro()%>" /></td>
	</tr>
	<tr>
		<td>大頭照:</td>
		<td><input type="file" name="mem_profile" size=45></td>
	</tr>
	<tr>
		<td>黑名單:</td>
		<td><input type="TEXT" name="mem_black_list" size="45"
			value="<%= (memVO==null)? "1" : memVO.getMem_black_list()%>" /></td>
	</tr>
	<tr>
		<td>權限:</td>
		<td><input type="TEXT" name="mem_permission" size="45"
			value="<%= (memVO==null)? "1" : memVO.getMem_permission()%>" /></td>
	</tr>
	<tr>
		<td>偏好設定:</td>
		<td><input type="TEXT" name="mem_setting" size="45"
			value="<%= (memVO==null)? "1" : memVO.getMem_setting()%>" /></td>
	</tr>
	<tr>
		<td>餘額:</td>
		<td><input type="TEXT" name="mem_balance" size="45"
			value="<%= (memVO==null)? "1" : memVO.getMem_balance()%>" /></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>
